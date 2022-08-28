package com.ricketts.models;

public class Table {
	public String tableName;
	public String tablePrimaryKey;
	public String insertStmtColumns;
	public String updateStmtColumns;
	

	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Table(String tableName, String tablePrimaryKey) {
		super();
		this.tableName = tableName;
		this.tablePrimaryKey = tablePrimaryKey;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTablePrimaryKey() {
		return tablePrimaryKey;
	}
	public void setTablePrimaryKey(String tablePrimaryKey) {
		this.tablePrimaryKey = tablePrimaryKey;
	}
	@Override
	public String toString() {
		return "Table [tableName=" + tableName + ", tablePrimaryKey=" + tablePrimaryKey  + "]";
	}
	public String getInsertStmtColumns() {
		return insertStmtColumns;
	}
	public void setInsertStmtColumns(String insertStmtColumns) {
		this.insertStmtColumns = insertStmtColumns;
	}
	public String getUpdateStmtColumns() {
		return updateStmtColumns;
	}
	public void setUpdateStmtColumns(String updateStmtColumns) {
		this.updateStmtColumns = updateStmtColumns;
	}
}
