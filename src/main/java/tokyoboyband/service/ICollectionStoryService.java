package tokyoboyband.service;

import java.util.ArrayList;

import tokyoboyband.model.CollectionStoryModel;
import tokyoboyband.model.StoryModel;

public interface ICollectionStoryService {
	ArrayList<CollectionStoryModel> findAllStoryByCategory(Long id);
	CollectionStoryModel findOneCollectionStoryByStoryAndCollectionStory(Long idStory, Long idCollectionStory);
	CollectionStoryModel addNewCollectionStory(CollectionStoryModel storyModel);
	CollectionStoryModel updateCollectionStoryStory(CollectionStoryModel storyModel);
	int DeleteOneCollectionStory(Long idStory, Long idCollectionStory);
}
