package com.ssafy.happyhouse.dao;


import com.ssafy.happyhouse.dto.Notice;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface NoticeDAO {

    void insert(Notice notice);
    void update(Notice notice)throws NoSuchElementException;
    void delete(int noticeNo) throws NoSuchElementException;
    ArrayList<Notice> select(String title)throws NoSuchElementException;
    ArrayList<Notice> selectAll();

}
