package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dto.Userinfo;
import com.ssafy.happyhouse.utill.DBUtil;

public class UserinfoDAOImpl implements UserinfoDAO{
	
	DBUtil DB = DBUtil.getInstance();
	@Override
	public int insert(Userinfo userinfo) {
		// 2. DB 연결
				Connection con = null;				
				PreparedStatement pstmt = null;
				int row = 0;
				try {
					con = DB.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String query = "INSERT INTO userinfo VALUES(?,?,?,?,?)";

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, userinfo.getId());
					pstmt.setString(2, userinfo.getPwd());
					pstmt.setString(3, userinfo.getName());
					pstmt.setString(4, userinfo.getTel());
					pstmt.setString(5, userinfo.getEmail());
					row = pstmt.executeUpdate();
					
			
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					// 4. query 결과처리

					// 5. DB연결 종료
					DB.close(con, pstmt);
				}
				
				return row;
		
	}

	@Override
	public void update(Userinfo userinfo) throws NoSuchElementException {
		Connection con = null;
		PreparedStatement pstmt = null;

		// 2. DB 연결
		try {
			con = DB.getConnection();
		} catch (SQLException e) {
			throw new NoSuchElementException();
		}

		// 3. query 실행
		String query = "UPDATE userinfo SET id=?, pwd=?, name=?, tel=?, email=? where = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userinfo.getId());
			pstmt.setString(2, userinfo.getPwd());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getTel());
			pstmt.setString(5, userinfo.getEmail());
			pstmt.setString(6, userinfo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. query 결과처리

			// 5. DB연결 종료
			DB.close(con, pstmt);

		}
		
	}

	@Override
	public void delete(String id) throws NoSuchElementException {
		Connection con = null;
		PreparedStatement pstmt = null;

		// 2. DB 연결
		try {
			con = DB.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. query 실행
		String query = "DELETE FROM userinfo WHERE id=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. query 결과처리

			// 5. DB연결 종료
			DB.close(con, pstmt);
		}
	}

	@Override
	public Userinfo select(String id) throws NoSuchElementException {
		Userinfo select = null;
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
		String query = "SELECT id, pwd, name, tel, email FROM userinfo WHERE id=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			// 4. query 결과처리
			result = pstmt.getResultSet();
			while (result.next()) {
				select = new Userinfo(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 5. DB연결 종료
			DB.close(con, pstmt, result);
		}
		return select;
	}

	@Override
	public ArrayList<Userinfo> selectAll() {
		ArrayList<Userinfo> userinfoList = new ArrayList<Userinfo>();

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
		String query = "SELECT id, pwd, name, tel, email FROM userinfo";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.executeQuery();
			// 4. query 결과처리
			result = pstmt.getResultSet();
			while (result.next()) {
				userinfoList.add(new Userinfo(result.getString(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 5. DB연결 종료
			DB.close(con, pstmt, result);
		}
		
		return userinfoList;		
	}

}
