package com.ricketts.mappers;

import com.ricketts.models.Table;

public interface Mapper {
	
    public String sqlInsertStmt(Object o, Table table);
	
	public String sqlUpdateStmt(Object o, Table table);
	
	public String sqlSelectAllStmt(Table table);
	
	public String sqlSelectByIdStmt(Object o, Table table);
	
    public String sqlDeleteStmt(Object o, Table table);
    
    
	
}
