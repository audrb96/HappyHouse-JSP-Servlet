package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dto.Store;
import com.ssafy.happyhouse.utill.DBUtil;

public class StoreDAOImpl implements StoreDAO{
	
	DBUtil DB = DBUtil.getInstance();

    @Override
    public ArrayList<Store> select(String dongCode) throws NoSuchElementException {
        ArrayList<Store> select = null;
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
        String query = "SELECT * FROM store WHERE dongCode=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dongCode);
            pstmt.executeQuery();
            // 4. query 결과처리
            result = pstmt.getResultSet();
            while (result.next()) {
                select.add(new Store(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
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
    public ArrayList<Store> selectAll() {
        ArrayList<Store> select = null;
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
        String query = "SELECT * FROM store;";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.executeQuery();
            // 4. query 결과처리
            result = pstmt.getResultSet();
            while (result.next()) {
                select.add(new Store(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
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
}
