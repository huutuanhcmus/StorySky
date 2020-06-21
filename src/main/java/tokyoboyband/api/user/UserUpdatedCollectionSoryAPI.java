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

import tokyoboyband.model.CollectionStoryModel;
import tokyoboyband.model.Message;
import tokyoboyband.model.StoryModel;
import tokyoboyband.model.UserModel;
import tokyoboyband.service.ICollectionStoryService;
import tokyoboyband.service.IStoryService;
import tokyoboyband.utils.FormUtil;
import tokyoboyband.utils.HttpUtil;
import tokyoboyband.utils.SessionUtil;

/**
 * Servlet implementation class UserUpdatedCollectionSoryAPI
 */
@WebServlet(urlPatterns = {"/api-updatecollectionstory", "/them-tap-truyen", "/xoa-tap-truyen"})
public class UserUpdatedCollectionSoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ICollectionStoryService collectionStoryService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatedCollectionSoryAPI() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoryModel story = FormUtil.toModel(StoryModel.class, request);
		request.setAttribute("action", "POST");
		request.setAttribute("story", story);
		CollectionStoryModel collectionStory = new CollectionStoryModel();
		collectionStory.setIdCollectionStory(-1l);
		collectionStory.setIdStory(story.getIdStory());
		request.setAttribute("collectionstory", collectionStory);
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/updatecollectionstory.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CollectionStoryModel updateCollectionStory =  HttpUtil.of(request.getReader()).toModel(CollectionStoryModel.class);
		updateCollectionStory.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		Date date = new Date();
		updateCollectionStory.setCreatedDate(new Timestamp(date.getTime()));
		CollectionStoryModel result = collectionStoryService.addNewCollectionStory(updateCollectionStory);
		Message message = new Message();
		if(result != null) {
			message.success("Thêm tập truyện mới thành công");
		}
		else {
			message.danger("Thêm tập truyện mới thất bại");
		}
		message.setIdStory(updateCollectionStory.getIdStory());
		mapper.writeValue(response.getOutputStream(), message);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CollectionStoryModel updateCollectionStory =  HttpUtil.of(request.getReader()).toModel(CollectionStoryModel.class);
		updateCollectionStory.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		Date date = new Date();
		updateCollectionStory.setModifiedDate(new Timestamp(date.getTime()));
		CollectionStoryModel result = collectionStoryService.updateCollectionStoryStory(updateCollectionStory);
		Message message = new Message();
		message.setIdStory(updateCollectionStory.getIdStory());
		if(result != null) {
			message.success("Cập nhật tập truyện thành công");
		}
		else {
			message.danger("Cập nhật tập truyện thất bại");
		}
		mapper.writeValue(response.getOutputStream(), message);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CollectionStoryModel collectionStory =  HttpUtil.of(request.getReader()).toModel(CollectionStoryModel.class);
		int delStory = collectionStoryService.DeleteOneCollectionStory(collectionStory.getIdStory(), collectionStory.getIdCollectionStory());
		Message message = new Message();
		message.setIdStory(collectionStory.getIdStory());
		if(delStory == 1) {
			message.success("Xóa truyện thành công");
		}
		else {
			message.danger("Xóa thất bại");
		}
		mapper.writeValue(response.getOutputStream(), message);
	}
}
