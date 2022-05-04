package service;

import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dto.Userinfo;

public interface UserService {
	Userinfo select(String id) throws NoSuchElementException;
	int join(Userinfo userinfo);
	void Modify(Userinfo userinfo);
	void DeleteId(String id);
}
