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
import tokyoboyband.model.Message;
import tokyoboyband.model.StoryModel;
import tokyoboyband.model.UserModel;
import tokyoboyband.service.ICollectionStoryService;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;
import tokyoboyband.utils.SessionUtil;

/**
 * Servlet implementation class UserColectionStoryshelf
 */

@WebServlet(urlPatterns = { "/danh-sach-tap-truyen" })
public class UserColectionStoryshelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ICollectionStoryService collectionStoryService;
	@Inject 
	private IStoryService storyService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserColectionStoryshelf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoryModel story = FormUtil.toModel(StoryModel.class, request);
		Message message = FormUtil.toModel(Message.class, request);
		CollectionStoryModel colectionStoryModel = new CollectionStoryModel();
		colectionStoryModel.setListResult(collectionStoryService.findAllStoryByCategory(story.getIdStory()));
		StoryModel storyfind = storyService.findOneStoryById(story.getIdStory());
		request.setAttribute("collectionStory", colectionStoryModel);	
		request.setAttribute("message", message);
		request.setAttribute("story", storyfind);
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/usercollectionbookshelf.jsp");
		rd.forward(request, response);
	}

}
