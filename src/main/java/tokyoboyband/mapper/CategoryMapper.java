package tokyoboyband.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import tokyoboyband.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setIdCategory(resultSet.getLong("idcategory"));
			categoryModel.setNameCategory(resultSet.getString("namecategory"));
			categoryModel.setCodeCategory(resultSet.getString("codecategory"));
			categoryModel.setIdCategory(resultSet.getLong("idcategory"));
			categoryModel.setCreatedBy(resultSet.getString("createdby"));
			categoryModel.setModifiedBy(resultSet.getString("modifiedby"));
			categoryModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			categoryModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}
	

}
