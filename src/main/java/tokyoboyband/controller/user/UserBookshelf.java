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
import tokyoboyband.model.UserModel;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;
import tokyoboyband.utils.SessionUtil;

/**
 * Servlet implementation class UserBookshelf
 */
@WebServlet(urlPatterns = { "/ke-sach" })
public class UserBookshelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IStoryService storyService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBookshelf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user = (UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL");
		Message message = FormUtil.toModel(Message.class, request);
		StoryModel storyModel = new StoryModel();
		storyModel.setListResult(storyService.findAllStoryByUsername(user.getUsername()));
		request.setAttribute("story", storyModel);	
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/userbookshelf.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
