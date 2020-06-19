package tokyoboyband.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import tokyoboyband.model.StoryModel;

public class StoryMapper implements IRowMapper<StoryModel> {

	public StoryModel mapRow(ResultSet resultSet) {
		StoryModel storyModel = new StoryModel();
		try {
			storyModel.setIdCategory(resultSet.getLong("idcategory"));
			storyModel.setIdStory(resultSet.getLong("idstory"));
			storyModel.setIntroduceStory(resultSet.getString("introducestory"));
			storyModel.setNameStory(resultSet.getString("namestory"));
			storyModel.setCreatedBy(resultSet.getString("createdby"));
			storyModel.setModifiedBy(resultSet.getString("modifiedby"));
			storyModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			storyModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			storyModel.setImageStory(resultSet.getString("imagestory"));
			return storyModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
