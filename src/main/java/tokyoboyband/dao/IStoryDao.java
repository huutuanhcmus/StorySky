package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.model.StoryModel;

public interface IStoryDao extends IGenericDao<StoryModel> {
	ArrayList<StoryModel> findAllStoryByCategory(Long id);
	ArrayList<StoryModel> findOneStoryById(Long id);
}
