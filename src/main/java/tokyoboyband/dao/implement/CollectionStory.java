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

}
