package tokyoboyband.service.implement;

import java.util.ArrayList;

import javax.inject.Inject;

import tokyoboyband.dao.IUserDao;
import tokyoboyband.model.UserModel;
import tokyoboyband.service.IUserService;

public class UserService implements IUserService {
	@Inject
	public IUserDao userDao;
	
	@Override
	public UserModel findUserByUsernameAndPassWord(String username, String password) {
		ArrayList<UserModel> user = userDao.findUserByUsernameAndPassWord(username, password);
		if(user.size() >= 1)
			return user.get(0);
		return null;
	}

}
