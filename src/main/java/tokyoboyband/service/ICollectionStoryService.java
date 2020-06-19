package tokyoboyband.service;

import java.util.ArrayList;

import tokyoboyband.model.CollectionStoryModel;

public interface ICollectionStoryService {
	ArrayList<CollectionStoryModel> findAllStoryByCategory(Long id);
	CollectionStoryModel findOneCollectionStoryByStoryAndCollectionStory(Long idStory, Long idCollectionStory);
}
