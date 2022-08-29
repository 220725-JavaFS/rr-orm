package com.ricketts.daos;

import java.io.ObjectStreamClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.ricketts.mappers.Mapper;
import com.ricketts.mappers.SqlMapper;
import com.ricketts.models.Table;
import com.ricketts.utils.ConnectionUtil;

public class ObjectDAOImpl implements ObjectDAO {
	Mapper m = new SqlMapper();
	
	@Override
	public void createObj(Object o, Table table) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String insertStmt = m.sqlInsertStmt(o, table);
			PreparedStatement statement = conn.prepareStatement(insertStmt);
			statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateObj(Object o, Table table) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String updateStmt = m.sqlUpdateStmt(o, table);
			PreparedStatement statement = conn.prepareStatement(updateStmt);
			statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteObj(Object o, Table table) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String deleteStmt = m.sqlDeleteStmt(o, table);
			PreparedStatement statement = conn.prepareStatement(deleteStmt);
			statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
//		@Override
//		public List<Object> readAllObj(Object o, Table table) {
//			
//		}
//
//		@Override
//		public List<Object> readByIdObj(Object o, Table table) {
//			
//		}
	}

}
