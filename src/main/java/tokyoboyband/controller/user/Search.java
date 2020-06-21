package tokyoboyband.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tokyoboyband.model.Message;
import tokyoboyband.model.StoryModel;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;

/**
 * Servlet implementation class Search
 */
@WebServlet(urlPatterns = { "/tim-kiem"} )
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IStoryService storyService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoryModel story = FormUtil.toModel(StoryModel.class, request);
		story.setListResult(storyService.findAllStoryByName(story.getSearch()));
		request.setAttribute("story", story);	
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/searchstory.jsp");
		rd.forward(request, response);
	}

}
