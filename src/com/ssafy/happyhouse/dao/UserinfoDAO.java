package com.ssafy.happyhouse.dao;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dto.Userinfo;

public interface UserinfoDAO {
	
	int insert(Userinfo userinfo);
	void update(Userinfo userinfo)throws NoSuchElementException;
	void delete(String id) throws NoSuchElementException;
	Userinfo select(String id)throws NoSuchElementException;
	ArrayList<Userinfo> selectAll();
	
}
