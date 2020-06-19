package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.model.CategoryModel;

public interface ICategoryDao extends IGenericDao<CategoryModel> {
	ArrayList<CategoryModel> findAll();
}
