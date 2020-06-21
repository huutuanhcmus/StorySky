package tokyoboyband.service;

import java.util.ArrayList;

import tokyoboyband.model.StoryModel;

public interface IStoryService {
	ArrayList<StoryModel> findAllStoryByCategory(Long id);
	StoryModel findOneStoryById(Long id);
	ArrayList<StoryModel> findAllStoryByUsername(String username);
	StoryModel updateStory(StoryModel storyModel);
	StoryModel addNewStory(StoryModel storyModel);
	int DeleteStory(Long idStory);
}
