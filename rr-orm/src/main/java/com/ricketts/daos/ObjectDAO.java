package com.ricketts.daos;

import java.util.List;

import com.ricketts.models.Table;

public interface ObjectDAO {
	
	public abstract void createObj(Object o, Table table);
	
	public abstract void updateObj(Object o, Table table);
	
	public abstract void deleteObj(Object o, Table table);
	
//	public List<Object> readAllObj(Object o, Table table);
//	
//	public List<Object> readByIdObj(Object o, Table table);

}
