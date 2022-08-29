package com.ricketts.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ricketts.mappers.Mapper;
import com.ricketts.mappers.SqlMapper;
import com.ricketts.models.Table;
import com.ricketts.utils.ConnectionUtil;

public class TableDAOImpl implements TableDAO {
	
	@Override
	public void retrievePrimaryKey(Table table) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT c.column_name "
					+ "FROM information_schema.key_column_usage AS c "
					+ "LEFT JOIN information_schema.table_constraints AS t "
					+ "ON t.constraint_name = c.constraint_name "
					+ "WHERE t.table_name = '"+table.getTableName()+"' AND t.constraint_type = 'PRIMARY KEY';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			
			while(result.next()) {
				table.setTablePrimaryKey(result.getString("column_name").trim());
			}
			//System.out.println(table.getTablePrimaryKey());
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public void retrieveColumns(Table table) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT column_name "
					+ "  FROM information_schema.COLUMNS "
					+ " WHERE table_schema = 'public' "
					+ " AND table_name   = '"+table.getTableName()+"';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List <String> arrayList = new ArrayList<String>();

			while(result.next()) {
				
				String str = result.getString("column_name").trim();
				if (str.equals(table.getTablePrimaryKey().trim())) {
					continue;
				}
				else {
				arrayList.add(str);
				}
			}
			
			//For insert statement
			StringBuilder sb1 = new StringBuilder();
			//For update statement
			StringBuilder sb2 = new StringBuilder();
			
			sb1.append("(");
			for(int i = 0; i<arrayList.size();i++) {
				
				String listMember = arrayList.get(i);
				
				int lastIndex = arrayList.size()-1;
				
				if (listMember.equals(arrayList.get(lastIndex))) {
					sb1.append(listMember + ") ");
					sb2.append(listMember);
				}
				else {
				sb1.append(listMember + ", ");
				sb2.append(listMember + " ");
				}
			}
			
			table.setInsertStmtColumns(sb1.toString());
			table.setUpdateStmtColumns(sb2.toString());
			
			//System.out.println(table.getInsertStmtColumns());
			//System.out.println(table.getUpdateStmtColumns());

		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	
	public void start(String dbTable, Table table) {
		
		table.setTableName(dbTable);
		
		retrievePrimaryKey(table);
		
		retrieveColumns(table);
		
	}

}
