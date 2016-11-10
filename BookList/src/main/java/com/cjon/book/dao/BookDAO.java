package com.cjon.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cjon.book.dto.BookDTO;

public class BookDAO {

	public String select(BookDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String result=null;
		
		System.out.println("여긴오니?");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("로딩은?");
			String url="jdbc:mysql://localhost:3306/library";
			String id="jQuery";
			String pw="jQuery";
			
			con=DriverManager.getConnection(url, id, pw);
			System.out.println("커넥?은?");
			String sql="select * from book where btitle like ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+dto.getBtitle()+"%");
			
			
			System.out.println(pstmt);
			
			rs=pstmt.executeQuery();
			
			JSONArray arr=new JSONArray();

			while(rs.next()){
				JSONObject obj=new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("title", rs.getString("btitle"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("price", rs.getString("bprice"));
				obj.put("imgurl", rs.getString("bimgurl"));
				
				arr.add(obj);
			}
			result=arr.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	
	
}
