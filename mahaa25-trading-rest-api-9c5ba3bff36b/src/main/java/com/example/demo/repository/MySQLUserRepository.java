package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserEntities;

@Repository
public class MySQLUserRepository implements UserRepository {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<UserEntities> getUserProfile() {
		String sql = "SELECT * FROM trade_information";
		return template.query(sql, new UserRowMapper());
	}

	// RowMapper class
	class UserRowMapper implements RowMapper<UserEntities> {
		public UserEntities mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new UserEntities(rs.getString("stockTicker"), rs.getDouble("price"),
					rs.getInt("volume"), rs.getTimestamp("Date_Time"));
		}
	}
}
