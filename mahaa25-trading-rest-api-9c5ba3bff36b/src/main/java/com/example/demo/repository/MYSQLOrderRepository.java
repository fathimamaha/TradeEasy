package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TradingEntities;


@Repository
public class MYSQLOrderRepository implements OrderRepository {

	@Autowired
	JdbcTemplate template;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}
	/*
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	*/
	@Override
	public String orderStock(String stockTicker, Double price, int volume, String buyOrSell, int statusCode,
			Timestamp Date_Time) {

		String insertQuery = "INSERT INTO order_history(stockTicker,price,volume,buyOrSell,statusCode,Date_Time)Values(?,?,?,?,?,?)";
		template.update(insertQuery, stockTicker, price, volume, buyOrSell, statusCode, Date_Time);

		
		//timer to update user information in trade_information table
		//TimeUnit.SECONDS.sleep(1);
		//TimeUtils.sleepFor(1, TimeUnit.SECONDS);
		//wait(1000);
		
		// When it is buy add the record to trade-information as well.
		if (buyOrSell.equals("buy")) {

			// When user buys a stock, Check whether that stockTicker alreasy exist in

			// When user buys a stock, Check whether that stockTicker already exist in

			// holdings.
			String checkForExist = "SELECT COUNT(*) FROM trade_information where stockTicker = ?";
			int Exist = template.queryForObject(checkForExist, Integer.class, stockTicker);
			
			
			// If the user not holding any volume of that stock currently, Then insert it
			// into trade_information
			if (Exist == 0) {
				
				//check if status code is 2
				// if 2, insert
				//String checkstatus = "SELECT statusCode FROM order_history where stockTicker = ?";
				//int status = template.queryForObject(checkstatus, Integer.class, stockTicker);
				
				
				//if(status==2)
				//{
				String inserthold = "INSERT INTO trade_information(stockTicker,price,volume,Date_Time)Values(?,?,?,?)";
				template.update(inserthold, stockTicker, price, volume, Date_Time);
				//}
			}
			// If the user holding that stock already, Update the volume alone (Current
			// volume = Existing Volume+Order volume)
			else {
				
				// get the existing stock volume
				String sql = "SELECT volume FROM trade_information where stockticker = ?";
				int Count = template.queryForObject(sql, Integer.class, stockTicker);				// update the volume
				String updateQuery = "UPDATE trade_information set volume = ? where stockTicker =?";
				template.update(updateQuery, Count + volume, stockTicker);
			}

			return "Order Success";
		}

		// when it is sell call Buystock function
		else {

			return BuyStock(volume, stockTicker);
		}

	}

	@Override
	public String BuyStock(int sellCount, String stockName) {
		// int Count = getJdbcTemplate().queryForInt("SELECT volume FROM
		// trade_information");
		String sql = "SELECT volume FROM trade_information where stockticker = ?";
		int Count = template.queryForObject(sql, Integer.class, stockName);

		// When sell volume is greater than Available volume It will return More Volume
		// than available.
		if (Count - sellCount < 0) {
			return "Failure -> Not available";
		}

		// when sell volume is less than available volume just update the volume of that
		// stock in trade_information.
		else if (Count - sellCount > 0) {
			// update
			String updateQuery = "UPDATE trade_information set volume = ? where stockTicker =?";
			template.update(updateQuery, Count - sellCount, stockName);
			// return "US";
		}

		// when sell volume is equal to available volume(Out of Stock) just delete that
		// stock details from trade_information.
		else {
			// delete
			String deleteQuery = "DELETE FROM trade_information where stockTicker =?";
			template.update(deleteQuery, stockName);
			// return "DS";
		}
		return "Success";
	}

	class OrderRowMapper implements RowMapper<TradingEntities> {
		public TradingEntities mapRow(ResultSet rs, int rowNum) throws SQLException {
			TradingEntities order = new TradingEntities();
			// order.setId(rs.getInt("order_id"));
			order.setStockTicker(rs.getString("stockTicker"));
			order.setPrice(rs.getDouble("price"));
			order.setVolume(rs.getInt("volume"));
			order.setBuyOrSell(rs.getString("buyOrSell"));
			order.setStatusCode(rs.getInt("statusCode"));
			order.setDate_Time(rs.getTimestamp("Date_Time"));
			return order;
		}
	}

}
