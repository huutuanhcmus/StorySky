package tokyoboyband.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import tokyoboyband.model.CollectionStoryModel;

public class CollectionStoryMapper implements IRowMapper<CollectionStoryModel> {

	@Override
	public CollectionStoryModel mapRow(ResultSet resultSet) {
		CollectionStoryModel collectionStoryModel = new CollectionStoryModel();
		try {
			collectionStoryModel.setIdStory(resultSet.getLong("idstory"));
			collectionStoryModel.setIdCollectionStory(resultSet.getLong("idcollectionstory"));
			collectionStoryModel.setNameCollectionStory(resultSet.getString("namecollectionstory"));
			collectionStoryModel.setContentCollectionStory(resultSet.getString("contentcollectionstory"));
			collectionStoryModel.setCreatedBy(resultSet.getString("createdby"));
			collectionStoryModel.setModifiedBy(resultSet.getString("modifiedby"));
			collectionStoryModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			collectionStoryModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			return collectionStoryModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
