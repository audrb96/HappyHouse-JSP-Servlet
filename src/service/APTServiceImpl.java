package service;

import java.util.List;

import com.ssafy.happyhouse.dao.APTDAO;
import com.ssafy.happyhouse.dao.APTDAOImpl;
import com.ssafy.happyhouse.dto.APT;

public class APTServiceImpl implements APTService {

	APTDAO dao = new APTDAOImpl();
	
	@Override
	public List<APT> search(String dong) {
		
		return dao.seleteAll(dong);
	}

	@Override
	public String[] dongLocation(String dong) {
		return dao.dongLocation(dong);
	}

}
