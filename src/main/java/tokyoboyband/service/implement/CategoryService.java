package tokyoboyband.service.implement;

import java.util.ArrayList;

import javax.inject.Inject;

import tokyoboyband.dao.ICategoryDao;
import tokyoboyband.model.CategoryModel;
import tokyoboyband.service.ICategoryService;
import tokyoboyband.service.IStoryService;

public class CategoryService implements ICategoryService {
	@Inject
	public ICategoryDao categoryDao;
	@Inject
	private IStoryService storyService;
	public ArrayList<CategoryModel> findAll() {
		ArrayList<CategoryModel> listCategory = categoryDao.findAll();
		for (CategoryModel categoryModel : listCategory) {
			categoryModel.setListStory(storyService.findAllStoryByCategory(categoryModel.getIdCategory()));
		}
		return listCategory;
	}
}
