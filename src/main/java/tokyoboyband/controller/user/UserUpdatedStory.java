package tokyoboyband.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tokyoboyband.model.CategoryModel;
import tokyoboyband.model.StoryModel;
import tokyoboyband.service.ICategoryService;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;

/**
 * Servlet implementation class UserUpdatedStory
 */
@WebServlet(urlPatterns = {"/chinh-sua"})
public class UserUpdatedStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IStoryService storyService;
	@Inject 
	private ICategoryService categoryService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatedStory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoryModel model = FormUtil.toModel(StoryModel.class, request);
		StoryModel modelResult = storyService.findOneStoryById(model.getIdStory());
		CategoryModel category = new CategoryModel();
		category.setListResult(categoryService.findAll()); 
		request.setAttribute("story", modelResult);	
		request.setAttribute("category", category);
		request.setAttribute("action", "PUT");
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/updatestory.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
