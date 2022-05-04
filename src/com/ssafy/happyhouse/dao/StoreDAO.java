package com.ssafy.happyhouse.dao;



import com.ssafy.happyhouse.dto.Store;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface StoreDAO {

    ArrayList<Store> select(String dongCode) throws NoSuchElementException;
    ArrayList<Store> selectAll();

}
