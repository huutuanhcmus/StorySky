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
import tokyoboyband.service.ICollectionStoryService;
import tokyoboyband.utils.FormUtil;

/**
 * Servlet implementation class UserUpdatedCollectionStory
 */
@WebServlet(urlPatterns = {"/chinh-sua-tap-truyen"})
public class UserUpdatedCollectionStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ICollectionStoryService collectionStoryService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatedCollectionStory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollectionStoryModel model = FormUtil.toModel(CollectionStoryModel.class, request);
		CollectionStoryModel modelResult = collectionStoryService.findOneCollectionStoryByStoryAndCollectionStory(model.getIdStory(), model.getIdCollectionStory());
		request.setAttribute("collectionstory", modelResult);	
		request.setAttribute("action", "PUT");
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/updatecollectionstory.jsp");
		rd.forward(request, response);
	}

}
