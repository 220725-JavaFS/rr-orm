package com.ricketts.daos;

import com.ricketts.models.Table;

public interface TableDAO {
	
	public abstract void retrievePrimaryKey(Table table);
	
	public abstract void retrieveColumns(Table table);
	
	public abstract void start(String dbTable, Table table);
}
