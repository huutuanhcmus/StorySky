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

}
