package tokyoboyband.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tokyoboyband.dao.IGenericDao;
import tokyoboyband.mapper.IRowMapper;

public abstract class AbstractDAO<T> implements IGenericDao<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/storysky";
			String user = "root";
			String password = "091215";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			return null;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public int updatedQuery(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		connection = getConnection();
		try {
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			System.out.print(statement.getResultSetType());
			statement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			return 0;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
		ArrayList<T> results = new ArrayList<T>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = getConnection();
		try {
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			System.out.print(statement.getResultSetType());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				}
				else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}
				else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				}
				else if(parameter instanceof java.sql.Timestamp) {
					statement.setTimestamp(index, (java.sql.Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
