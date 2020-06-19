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

/**
 * Servlet implementation class UserHomeController
 */

@WebServlet(urlPatterns = {"/trang-chu"})
public class UserHomeController extends HttpServlet {
	
	@Inject 
	private ICategoryService categoryService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryModel categoryList = new CategoryModel();
		categoryList.setListResult(categoryService.findAll());
		request.setAttribute("categoryList", categoryList);	
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/home.jsp");
		rd.forward(request, response);
	}

}
