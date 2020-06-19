package tokyoboyband.service;

import java.util.ArrayList;

import tokyoboyband.model.CollectionStoryModel;

public interface ICollectionStoryService {
	ArrayList<CollectionStoryModel> findAllStoryByCategory(Long id);
}
