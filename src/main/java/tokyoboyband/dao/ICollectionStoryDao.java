package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.model.CollectionStoryModel;
import tokyoboyband.model.StoryModel;

public interface ICollectionStoryDao extends IGenericDao<CollectionStoryModel> {
	ArrayList<CollectionStoryModel> findAllStoryByStory(Long id);
	ArrayList<CollectionStoryModel> findOneCollectionStoryByStoryAndCollectionStory(Long idStory, Long idCollectionStory);
	int DeleteCollectionStory(Long idStory);
	CollectionStoryModel addNewCollectionStory(CollectionStoryModel storyModel); 
	CollectionStoryModel updateCollectionStory(CollectionStoryModel storyModel);
	int DeleteOneCollectionStory(Long idStory, Long idCollectionStory);
}
