package service;

import java.util.NoSuchElementException;

import com.ssafy.happyhouse.dao.UserinfoDAO;
import com.ssafy.happyhouse.dao.UserinfoDAOImpl;
import com.ssafy.happyhouse.dto.Userinfo;

public class UserServiceImpl implements UserService {
	
	UserinfoDAO UserDao = new UserinfoDAOImpl();
	
	@Override
	public Userinfo select(String id) throws NoSuchElementException {
		return UserDao.select(id);
	}

	@Override
	public int join(Userinfo userinfo) {
		
		return UserDao.insert(userinfo);	
	}

	@Override
	public void Modify(Userinfo userinfo) {
		UserDao.update(userinfo);
	}

	@Override
	public void DeleteId(String id) {
		UserDao.delete(id);
		
	}
	
	
	
}
