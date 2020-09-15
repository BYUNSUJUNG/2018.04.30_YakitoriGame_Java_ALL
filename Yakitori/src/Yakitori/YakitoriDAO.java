package Yakitori;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class YakitoriDAO {

	Connection con = null;
	
	public void getConnection() throws Exception {
			
		Properties prop = new Properties(); // 이것도 일종의 map자료구조 
		// HashMap? : <key, value> : key를 입력하면 value값이 나온다.
		
		File file = new File("config.properties");
		FileInputStream fi =  new FileInputStream(file);
		
		prop.load(fi); // 읽어들인다.
		
		
		String DriverName = prop.getProperty("DriverName");
		
		String url = prop.getProperty("DBURL");
		String name = prop.getProperty("DBUser");
		String pw = prop.getProperty("DBPw");
		
		try {
			Class.forName(DriverName);
			System.out.print("드라이버 적재 성공.");
			con=DriverManager.getConnection(url,name,pw);
			System.out.print("데이터베이스 연결 성공.");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch(SQLException e) {
			System.out.println("연결에 실패했습니다.");
		}
	 
		
	}
	

	public void insertScore(YakitoriScore yc) throws Exception {
		
		getConnection();
		try {
				
			String sql = " insert into score values(?,?) ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, yc.id);
		        pstmt.setInt(2, yc.score);

			pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {
				
			}
		}
	}
	
	/*
	public void deleteScore(String id) throws Exception {
		
		getConnection();
		
		try {
					
			String sql = "delete from score where id=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {} 
		}
	}
	
	
	public ArrayList<YakitoriScore> listScore() throws Exception {
		ArrayList<YakitoriScore> list = new ArrayList<YakitoriScore>();
		
		getConnection();

		try {
			
			String sql = "select * from Score";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			YakitoriScore ys = null;
			
			while(rs.next()) {
				String id= rs.getString(1);
				int score= rs.getInt(2);
			
	            ys = new YakitoriScore();

	     //       p.setPattyPoint(pattyPoint1)[0];
	            
	            list.add(ys);
			}

		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {}
		}
		return list;	
	}


	public void updateScore(YakitoriScore yc) throws Exception {

		getConnection();

		try {
			
			String sql = "update score set score=? where id = ?";
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
				pstmt.setString(1, yc.id);
		        pstmt.setInt(2, yc.score);
		    
	         pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {}
		}
	}

 */
	
}
