package com.qiuxs.salbum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JdbcTest {
	
	@Test
	public void testJdbc() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salbum?characterEncoding=utf8", "root", "000000");
			PreparedStatement prepareStatement = connection.prepareStatement("select 1");
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				System.out.println(executeQuery.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
