package tokyoboyband.controller.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = { "/dang-ky-tai-khoang"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = FormUtil.toModel(UserModel.class, request);
		model.setCreatedBy(model.getUsername());
		Date date = new Date();
		model.setCreatedDate(new Timestamp(date.getTime()));
		model.setRoleid(1l);
		model.setStatus(1);
		UserModel result = userService.newUser(model);
		Message message = new Message();
		if(result != null) {
			message.success("Đăng ký tài khoảng mới thành công");
		}
		else {
			message.danger("Đăng ký tài khoảng mới thất bại");
		}
		request.setAttribute("message", message);	
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		rd.forward(request, response);
		
	}

}
