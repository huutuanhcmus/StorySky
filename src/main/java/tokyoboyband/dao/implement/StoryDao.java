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
}
