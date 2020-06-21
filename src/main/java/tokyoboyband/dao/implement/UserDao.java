package tokyoboyband.dao.implement;

import java.util.ArrayList;

import tokyoboyband.dao.IUserDao;
import tokyoboyband.mapper.UserMapper;
import tokyoboyband.model.UserModel;

public class UserDao extends AbstractDAO<UserModel> implements IUserDao {

	@Override
	public ArrayList<UserModel> findUserByUsernameAndPassWord(String username, String password) {
		String sql = "select * from user where username = ? and password = ?;";
		return query(sql, new UserMapper(), username, password);
	}

	@Override
	public UserModel newUser(UserModel user) {
		String sql = "INSERT INTO user (username, password, fullname, status, roleid, createddate, createdby) VALUES (?, ?, ?, ?, ?, ?, ?);";
		if(updatedQuery(sql, user.getUsername(), user.getPassword(), user.getFullname(), user.getStatus(), user.getRoleid(),user.getCreatedDate(), user.getCreatedBy())==1)
			return user;
		return null;
	}

}
