package tokyoboyband.dao.implement;

import java.util.ArrayList;

import tokyoboyband.dao.ICollectionStoryDao;
import tokyoboyband.mapper.CollectionStoryMapper;
import tokyoboyband.model.CollectionStoryModel;

public class CollectionStory extends AbstractDAO<CollectionStoryModel> implements ICollectionStoryDao {

	@Override
	public ArrayList<CollectionStoryModel> findAllStoryByStory(Long id) {
		String sql = "select * from collectionstory where idstory = ?;";
		return query(sql, new CollectionStoryMapper(), id);
	}

	@Override
	public ArrayList<CollectionStoryModel> findOneCollectionStoryByStoryAndCollectionStory(Long idStory, Long idCollectionStory) {
		String sql = "select * from collectionstory where idstory = ? and idcollectionstory = ?";
		return query(sql, new CollectionStoryMapper(), idStory, idCollectionStory);
	}

	@Override
	public int DeleteCollectionStory(Long idStory) {
		String sql = "DELETE FROM collectionstory WHERE (idstory = ?);";
		return updatedQuery(sql, idStory);
	}

	@Override
	public CollectionStoryModel addNewCollectionStory(CollectionStoryModel storyModel) {
		String sql = "INSERT INTO collectionstory (idstory, namecollectionstory, contentcollectionstory, createddate, createdby) VALUES (?, ?, ?, ?, ?);";
		if(updatedQuery(sql, storyModel.getIdStory(), storyModel.getNameCollectionStory(), storyModel.getContentCollectionStory(), storyModel.getCreatedDate(), storyModel.getCreatedBy())==1)
			return storyModel;
		else
			return null;
	}

	@Override
	public CollectionStoryModel updateCollectionStory(CollectionStoryModel storyModel) {
		String sql = "UPDATE collectionstory SET namecollectionstory = ?, contentcollectionstory = ?, modifieddate = ?, modifiedby = ? WHERE (idcollectionstory = ?) and (idstory = ?);";
		if(updatedQuery(sql, storyModel.getNameCollectionStory(), storyModel.getContentCollectionStory(), storyModel.getModifiedDate(), storyModel.getModifiedBy(), storyModel.getIdCollectionStory(), storyModel.getIdStory())==1)
			return storyModel;
		else
			return null;
	}

	@Override
	public int DeleteOneCollectionStory(Long idStory, Long idCollectionStory) {
		String sql = "DELETE FROM collectionstory WHERE (idcollectionstory = ?) and (idstory = ?);";
		if (updatedQuery(sql, idCollectionStory, idStory) == 1)
			return 1;
		else
			return -1;
	}

}
