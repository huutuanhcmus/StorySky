package tokyoboyband.service;

import java.util.ArrayList;

import tokyoboyband.model.StoryModel;

public interface IStoryService {
	ArrayList<StoryModel> findAllStoryByCategory(Long id);
}
