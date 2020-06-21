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

	@Override
	public CollectionStoryModel findOneCollectionStoryByStoryAndCollectionStory(Long idStory, Long idCollectionStory) {
		return collectionStoryDao.findOneCollectionStoryByStoryAndCollectionStory(idStory, idCollectionStory).get(0);
	}

	@Override
	public CollectionStoryModel addNewCollectionStory(CollectionStoryModel storyModel) {
		return collectionStoryDao.addNewCollectionStory(storyModel);
	}

	@Override
	public CollectionStoryModel updateCollectionStoryStory(CollectionStoryModel storyModel) {
		return collectionStoryDao.updateCollectionStory(storyModel);
	}

	@Override
	public int DeleteOneCollectionStory(Long idStory, Long idCollectionStory) {
		if(collectionStoryDao.DeleteOneCollectionStory(idStory, idCollectionStory) == 1) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
