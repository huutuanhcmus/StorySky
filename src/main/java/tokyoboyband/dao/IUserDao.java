package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.model.UserModel;

public interface IUserDao extends IGenericDao<UserModel> {
	ArrayList<UserModel> findUserByUsernameAndPassWord(String username, String password);
}
