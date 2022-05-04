package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.APT;
import com.ssafy.happyhouse.dto.Userinfo;
import com.ssafy.happyhouse.utill.DBUtil;

public class APTDAOImpl implements APTDAO {

	DBUtil DB = DBUtil.getInstance();

	@Override
	public List<APT> seleteAll(String dong) {
		List<APT> list = new ArrayList<APT>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		// 2. DB 연결
		try {
			con = DB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. query 실행
		String query = "SELECT d.AptName, d.dealAmount, d.area, concat(d.dealYear, '.', d.dealMonth, '.', d.dealDay) date, i.lat, i.lng \n";
		query += "FROM houseinfo i join housedeal d \n";
		query += "ON i.AptName = d.AptName \n";
		query += "WHERE d.code = ? \n";
		query += "GROUP BY d.AptName";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dong);
			pstmt.executeQuery();
			// 4. query 결과처리
			result = pstmt.getResultSet();
			while (result.next()) {
				list.add(new APT(result.getString(1), result.getString(2).trim(), result.getDouble(3),
						result.getString(4), result.getDouble(5), result.getDouble(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 5. DB연결 종료
			DB.close(con, pstmt, result);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		APTDAO aa = new APTDAOImpl();
		for(APT a : aa.seleteAll("11110")) {
			System.out.println(a);
		}
	}

	@Override
	public String[] dongLocation(String dong) {
		String[] list = new String[2];
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;

		// 2. DB 연결
		try {
			con = DB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. query 실행
		String query = "SELECT lat, lng \n";
		query += "FROM baseaddress \n";
		query += "WHERE dongcode = ? \n";
		query += "limit 1";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dong);
			pstmt.executeQuery();
			// 4. query 결과처리
			result = pstmt.getResultSet();
			if(result.next()) {
				list[0] = result.getString(1);
				list[1] = result.getString(2);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 5. DB연결 종료
			DB.close(con, pstmt, result);
		}
		
		return list;
	}

}
