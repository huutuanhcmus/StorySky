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
import tokyoboyband.model.UserModel;
import tokyoboyband.service.IUserService;
import tokyoboyband.utils.FormUtil;
import tokyoboyband.utils.SessionUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/dang-nhap", "/dang-xuat", "/admin" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			UserModel user = userService.findUserByUsernameAndPassWord(model.getUsername(), model.getPassword());
			if (user != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", user);
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			} else {
				Message message = new Message();
				message.danger("Tài khoảng hoặc mật khẩu không đúng");
				request.setAttribute("message", message);
				// response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
	}

}
