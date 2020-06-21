package tokyoboyband.service.implement;

import java.util.ArrayList;

import javax.inject.Inject;

import tokyoboyband.dao.ICollectionStoryDao;
import tokyoboyband.dao.IStoryDao;
import tokyoboyband.model.StoryModel;
import tokyoboyband.service.IStoryService;

public class StoryService implements IStoryService {
	@Inject
	public IStoryDao storyDao;
	@Inject
	public ICollectionStoryDao collectionstoryDao;
	
	public ArrayList<StoryModel> findAllStoryByCategory(Long id) {
		return storyDao.findAllStoryByCategory(id);
	}

	@Override
	public StoryModel findOneStoryById(Long id) {
		return storyDao.findOneStoryById(id).get(0);
	}

	@Override
	public ArrayList<StoryModel> findAllStoryByUsername(String username) {
		return storyDao.findAllStoryByUsername(username);
	}

	@Override
	public StoryModel updateStory(StoryModel storyModel) {
		return storyDao.updateStory(storyModel);
	}

	@Override
	public StoryModel addNewStory(StoryModel storyModel) {
		return storyDao.addNewStory(storyModel);
	}

	@Override
	public int DeleteStory(Long idStory) {
		int delcol = collectionstoryDao.DeleteCollectionStory(idStory);
		int delsto = storyDao.DeleteStory(idStory);
		if(delcol == 1 && delsto == 1)
			return 1;
		else
			return -1;
	}

}
