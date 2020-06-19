package tokyoboyband.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tokyoboyband.model.CollectionStoryModel;
import tokyoboyband.model.StoryModel;
import tokyoboyband.service.ICollectionStoryService;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;

/**
 * Servlet implementation class UserCollectionStoryController
 */
@WebServlet(urlPatterns = {"/truyen"})
public class UserCollectionStoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject 
	private ICollectionStoryService collectionStoryService;
	@Inject 
	private IStoryService storyService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCollectionStoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollectionStoryModel model = FormUtil.toModel(CollectionStoryModel.class, request);
		StoryModel storyModel = new StoryModel();
		storyModel = storyService.findOneStoryById(model.getIdStory());
		CollectionStoryModel collectionStoryModel = new CollectionStoryModel();
		collectionStoryModel.setListResult(collectionStoryService.findAllStoryByCategory(model.getIdStory()));
		request.setAttribute("colectionStoryList", collectionStoryModel);	
		request.setAttribute("story", storyModel);	
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/collectionstory.jsp");
		rd.forward(request, response);
	}

}
