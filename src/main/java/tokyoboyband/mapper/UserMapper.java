package tokyoboyband.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import tokyoboyband.model.StoryModel;
import tokyoboyband.model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(resultSet.getLong("id"));
			userModel.setUsername(resultSet.getString("username"));
			userModel.setPassword(resultSet.getString("password"));
			userModel.setFullname(resultSet.getString("fullname"));
			userModel.setStatus(resultSet.getInt("status"));
			userModel.setRoleid(resultSet.getLong("roleid"));
			userModel.setCreatedBy(resultSet.getString("createdby"));
			userModel.setModifiedBy(resultSet.getString("modifiedby"));
			userModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			userModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
