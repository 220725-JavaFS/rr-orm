package com.ricketts.services;

import java.util.List;

import com.ricketts.daos.ObjectDAO;
import com.ricketts.daos.ObjectDAOImpl;
import com.ricketts.daos.TableDAO;
import com.ricketts.daos.TableDAOImpl;
import com.ricketts.models.Table;

public class OrmServices {
	TableDAO tableDao = new TableDAOImpl();
	ObjectDAO objDao = new ObjectDAOImpl();
	Table table = new Table();
	
	
	public void begin(String dbTable, Table table) {
		tableDao.start(dbTable, table);
	}
	
	
	public void create(Object o, Table table) {
		objDao.createObj(o, table);
	}
	
	public void update(Object o, Table table) {
		objDao.updateObj(o, table);
	}
	
	public void delete(Object o, Table table) {
		objDao.deleteObj(o, table);
	}
	
//	public List<Object> readAll(Object o, Table table){
//	return objDao.readAllObj(o, table);
//  }
//
//  public List<Object> readById(Object o, Table table){
//	return objDao.readByIdObj(o, table);
//  }

}
