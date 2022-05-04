package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.APT;

public interface APTDAO {
	List<APT> seleteAll(String dong);

	String[] dongLocation(String dong);
}
