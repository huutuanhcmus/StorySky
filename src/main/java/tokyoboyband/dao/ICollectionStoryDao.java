package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.model.CollectionStoryModel;

public interface ICollectionStoryDao extends IGenericDao<CollectionStoryModel> {
	ArrayList<CollectionStoryModel> findAllStoryByStory(Long id);
}
