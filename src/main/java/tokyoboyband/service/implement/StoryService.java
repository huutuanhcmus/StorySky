package tokyoboyband.service.implement;

import java.util.ArrayList;

import javax.inject.Inject;

import tokyoboyband.dao.IStoryDao;
import tokyoboyband.model.StoryModel;
import tokyoboyband.service.IStoryService;

public class StoryService implements IStoryService {
	@Inject
	public IStoryDao storyDao;
	
	public ArrayList<StoryModel> findAllStoryByCategory(Long id) {
		return storyDao.findAllStoryByCategory(id);
	}

}
