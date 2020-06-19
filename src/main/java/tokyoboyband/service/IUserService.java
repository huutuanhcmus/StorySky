package tokyoboyband.service;

import tokyoboyband.model.UserModel;

public interface IUserService {
	UserModel findUserByUsernameAndPassWord(String username, String password);
}
