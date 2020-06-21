package tokyoboyband.dao.implement;

import java.util.ArrayList;

import tokyoboyband.dao.IStoryDao;
import tokyoboyband.mapper.StoryMapper;
import tokyoboyband.model.StoryModel;

public class StoryDao extends AbstractDAO<StoryModel> implements IStoryDao {

	public ArrayList<StoryModel> findAllStoryByCategory(Long id) {
		String sql = "select * from story where idcategory = ?;";
		return query(sql, new StoryMapper(), id);
	}

	@Override
	public ArrayList<StoryModel> findOneStoryById(Long id) {
		String sql = "select * from story where idstory = ?;";
		return query(sql, new StoryMapper(), id);
	}

	@Override
	public ArrayList<StoryModel> findAllStoryByUsername(String username) {
		String sql = "select * from story where createdby = ?;";
		return query(sql, new StoryMapper(), username);
	}

	@Override
	public StoryModel updateStory(StoryModel storyModel) {
		String sql = "UPDATE story SET idcategory = ?, namestory = ?, introducestory = ?, modifieddate = ?, modifiedby = ?, imagestory = ? WHERE (idstory = ?);";
		if (updatedQuery(sql, storyModel.getIdCategory(), storyModel.getNameStory(), storyModel.getIntroduceStory(), storyModel.getModifiedDate(), storyModel.getModifiedBy(), storyModel.getImageStory(), storyModel.getIdStory()) == 1)
			return storyModel;
		else
			return null;
	}

	@Override
	public StoryModel addNewStory(StoryModel storyModel) {
		String sql = "INSERT INTO story (idcategory, namestory, introducestory, createddate, createdby, imagestory) VALUES (?, ?, ?, ?, ?, ?);";
		if (updatedQuery(sql, storyModel.getIdCategory(), storyModel.getNameStory(), storyModel.getIntroduceStory(), storyModel.getCreatedDate(), storyModel.getCreatedBy(), storyModel.getImageStory()) == 1)
			return storyModel;
		else
			return null;
	}

	@Override
	public int DeleteStory(Long idStory) {
		String sql = "DELETE FROM story WHERE (idstory = ?);";
		if (updatedQuery(sql, idStory) == 1)
			return 1;
		else
			return -1;
	}
}
