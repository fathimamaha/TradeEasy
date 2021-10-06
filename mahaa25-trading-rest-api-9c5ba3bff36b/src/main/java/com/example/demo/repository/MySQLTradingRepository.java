package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TradingEntities;

@Repository
public class MySQLTradingRepository implements TradingRepository {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<TradingEntities> getAllTrades() {
		String sql = "SELECT * FROM order_history";
		return template.query(sql, new TradeRowMapper());
	}

	// RowMapper class
	class TradeRowMapper implements RowMapper<TradingEntities> {

		public TradingEntities mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new TradingEntities(rs.getString("stockTicker"), rs.getDouble("price"),
					rs.getInt("statusCode"), rs.getString("buyOrSell"), rs.getInt("volume"),
					rs.getTimestamp("Date_Time"));
		}
	}

}
