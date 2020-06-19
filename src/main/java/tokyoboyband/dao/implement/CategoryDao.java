package tokyoboyband.dao.implement;

import java.util.ArrayList;



import tokyoboyband.dao.ICategoryDao;
import tokyoboyband.mapper.CategoryMapper;
import tokyoboyband.model.CategoryModel;

public class CategoryDao extends AbstractDAO<CategoryModel> implements ICategoryDao{

	
	public ArrayList<CategoryModel> findAll() {
		String sql = "select * from category;";
		return query(sql, new CategoryMapper());
	}

}
