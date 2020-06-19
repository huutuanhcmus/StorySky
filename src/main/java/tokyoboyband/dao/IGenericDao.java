package tokyoboyband.dao;

import java.util.ArrayList;

import tokyoboyband.mapper.IRowMapper;


public interface IGenericDao<T> {
	ArrayList<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
}
