package tokyoboyband.api.user;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import tokyoboyband.model.CategoryModel;
import tokyoboyband.model.Message;
import tokyoboyband.model.StoryModel;
import tokyoboyband.model.UserModel;
import tokyoboyband.service.ICategoryService;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.HttpUtil;
import tokyoboyband.utils.SessionUtil;

/**
 * Servlet implementation class UserUpdatedStoryAPI
 */

@WebServlet(urlPatterns = {"/api-updateStory", "/them-truyen", "/xoa-truyen"})
public class UserUpdatedStoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IStoryService storyService;
	@Inject 
	private ICategoryService categoryService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatedStoryAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		category.setListResult(categoryService.findAll()); 
		request.setAttribute("category", category);
		request.setAttribute("action", "POST");
		StoryModel nw = new StoryModel();
		nw.setIdStory(-1l);
		request.setAttribute("story", nw);
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/updatestory.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		StoryModel updateStory =  HttpUtil.of(request.getReader()).toModel(StoryModel.class);
		updateStory.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		Date date = new Date();
		updateStory.setCreatedDate(new Timestamp(date.getTime()));
		StoryModel result = storyService.addNewStory(updateStory);
		Message message = new Message();
		if(result != null) {
			message.success("Thêm truyện mới thành công");
		}
		else {
			message.danger("Thêm truyện mới thất bại");
		}
		mapper.writeValue(response.getOutputStream(), message);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		StoryModel updateStory =  HttpUtil.of(request.getReader()).toModel(StoryModel.class);
		updateStory.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		Date date = new Date();
		updateStory.setModifiedDate(new Timestamp(date.getTime()));
		StoryModel result = storyService.updateStory(updateStory);
		Message message = new Message();
		if(result != null) {
			message.success("Cập nhật truyện thành công");
		}
		else {
			message.danger("Cập nhật thất bại");
		}
		mapper.writeValue(response.getOutputStream(), message);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		StoryModel story =  HttpUtil.of(request.getReader()).toModel(StoryModel.class);
		int delStory = storyService.DeleteStory(story.getIdStory());
		Message message = new Message();
		if(delStory == 1) {
			message.success("Xóa truyện thành công");
		}
		else {
			message.danger("Xóa thất bại");
		}
		mapper.writeValue(response.getOutputStream(), message);
	}

}
