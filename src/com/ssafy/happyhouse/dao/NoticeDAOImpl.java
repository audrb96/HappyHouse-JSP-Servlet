package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.utill.DBUtil;

public class NoticeDAOImpl implements NoticeDAO{
	
	DBUtil DB = DBUtil.getInstance();
	
    @Override
    public void insert(Notice notice) {
        // 2. DB 연결
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO notice (title, body, views,userInfo_id) VALUES(?,?,0,?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, notice.getTitle());
            pstmt.setString(2, notice.getBody());
            pstmt.setString(3, notice.getUserInfoId());
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
    public void update(Notice notice) throws NoSuchElementException {
        Connection con = null;
        PreparedStatement pstmt = null;

        // 2. DB 연결
        try {
            con = DB.getConnection();
        } catch (SQLException e) {
            throw new NoSuchElementException();
        }

        // 3. query 실행
        String query = "UPDATE notice SET title = ?, body = ? where = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, notice.getTitle());
            pstmt.setString(2, notice.getBody());
            pstmt.setInt(3, notice.getNoticeNo());

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
    public void delete(int noticeNo) throws NoSuchElementException {
        Connection con = null;
        PreparedStatement pstmt = null;

        // 2. DB 연결
        try {
            con = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3. query 실행
        String query = "DELETE FROM notice WHERE noticeNo=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, noticeNo);
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
    public ArrayList<Notice> select(String title) throws NoSuchElementException {
        ArrayList<Notice> select = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;


        // 2. DB 연결
        try {
            con = DB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3. query 실행
        String query = "SELECT * FROM notice WHERE title like ? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%"+title+"%");
            pstmt.executeQuery();
            // 4. query 결과처리
            result = pstmt.getResultSet();
            while (result.next()) {
                select.add(new Notice(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 5. DB연결 종료
            DB.close(con, pstmt, result);
        }

        return select;
    }



    @Override
    public ArrayList<Notice> selectAll() {
        ArrayList<Notice> select = null;
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
        String query = "SELECT * FROM notice";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.executeQuery();
            // 4. query 결과처리
            result = pstmt.getResultSet();
            while (result.next()) {
                select.add(new Notice(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getString(5)));
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
