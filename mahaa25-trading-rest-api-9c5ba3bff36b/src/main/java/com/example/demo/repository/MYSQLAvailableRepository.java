package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AvailableEntities;

@Repository
public class MYSQLAvailableRepository implements AvailableRepository {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<AvailableEntities> availableStocks() {
		String sql = "SELECT * FROM available_stocks";
		return template.query(sql, new AvailableRowMapper());
	}

	// RowMapper class
	class AvailableRowMapper implements RowMapper<AvailableEntities> {

		public AvailableEntities mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new AvailableEntities(rs.getString("stockTicker"), rs.getDouble("price"));
		}
	}

}
