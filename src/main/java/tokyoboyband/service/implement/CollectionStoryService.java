package tokyoboyband.service.implement;

import java.util.ArrayList;

import javax.inject.Inject;

import tokyoboyband.dao.ICollectionStoryDao;
import tokyoboyband.model.CollectionStoryModel;
import tokyoboyband.service.ICollectionStoryService;

public class CollectionStoryService implements ICollectionStoryService {
	@Inject
	public ICollectionStoryDao collectionStoryDao;
	
	@Override
	public ArrayList<CollectionStoryModel> findAllStoryByCategory(Long id) {
		return collectionStoryDao.findAllStoryByStory(id);
	}

}
