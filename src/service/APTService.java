package service;

import java.util.List;

import com.ssafy.happyhouse.dto.APT;

public interface APTService {
	List<APT> search(String dong);
	String[] dongLocation(String dong);
}
