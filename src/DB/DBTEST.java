package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTEST {

	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	public void startConnect()
	{
		String dbFileUrl = "jdbc:sqlite:C:/sqllite/dbShopAppDB.db";
		try
		{
			//Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(dbFileUrl);
			System.out.println("SQLite DB Connected");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from TestTable");
			System.out.println(rs.toString());
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	
}
