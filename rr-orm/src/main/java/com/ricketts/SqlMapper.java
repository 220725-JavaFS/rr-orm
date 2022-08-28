package com.ricketts;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ricketts.models.Table;

public class SqlMapper implements Mapper {

	@Override
	public String sqlInsertStmt(Object o, Table table) {
		Class<?> objectClass = o.getClass();
		Field[] fields = objectClass.getDeclaredFields();

		StringBuilder insertBuilder = new StringBuilder("\"INSERT INTO "+table.getTableName()+" "+table.getInsertStmtColumns()+"VALUES (");
		
		for(Field field: fields) {
			if(field == fields[0]) {
				continue;
			}

			String fieldName = field.getName();

				// obtain the appropriate getter (using the field name)
				String getterName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

			
				try {
					// obtain the getter method from the class we are mapping 
					Method getterMethod = objectClass.getMethod(getterName);
					
					// invoke that method on the object that we are mapping
					Object fieldValue = getterMethod.invoke(o);
				
					//System.out.println(fieldValue.getClass());
									
					// construct a key value pair for each field name and field value
					String values = fieldValue+ ", ";
					
					// combine all of the key value pairs into a result string
					insertBuilder.append(values);
				
				
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		return insertBuilder.substring(0, insertBuilder.length()-2) + ");\"";
	}

	@Override
	public String sqlUpdateStmt(Object o, Table table) {
		Class<?> objectClass = o.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		StringBuilder updateBuilder = 
				new StringBuilder("\"UPDATE "+table.getTableName()+" SET "+table.getUpdateStmtColumns()+"WHERE "+table.getTablePrimaryKey()+" = ");
		
		for(Field field: fields) {
			if(field == fields[0]) {

				String fieldName = field.getName();

				// obtain the appropriate getter (using the field name)
				String getterName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

			
				try {
					// obtain the getter method from the class we are mapping 
					Method getterMethod = objectClass.getMethod(getterName);
					
					// invoke that method on the object that we are mapping
					Object fieldValue = getterMethod.invoke(o);
				
					// construct a key value pair for each field name and field value
					String values = fieldValue+ ";\"";
					
					// combine all of the key value pairs into a result string
					updateBuilder.append(values);
				
				
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return updateBuilder.substring(0, updateBuilder.length());
	
	}

	@Override
	public String sqlSelectAllStmt(Object o, Table table) {
		StringBuilder selectAllBuilder = new StringBuilder("\"SELECT * FROM "+table.getTableName());
		return selectAllBuilder.substring(0, selectAllBuilder.length())+ ";\"";
	}

	@Override
	public String sqlSelectByIdStmt(Object o, Table table) {
		Class<?> objectClass = o.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		StringBuilder selectByIdBuilder = 
				new StringBuilder("\"SELECT * FROM "+table.getTableName()+" WHERE "+table.getTablePrimaryKey()+" = ");
		
		for(Field field: fields) {
			if(field == fields[0]) {

				String fieldName = field.getName();

				// obtain the appropriate getter (using the field name)
				String getterName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

			
				try {
					// obtain the getter method from the class we are mapping 
					Method getterMethod = objectClass.getMethod(getterName);
					
					// invoke that method on the object that we are mapping
					Object fieldValue = getterMethod.invoke(o);
				
					// construct a key value pair for each field name and field value
					String values = fieldValue+ ";\"";
					
					// combine all of the key value pairs into a result string
					selectByIdBuilder.append(values);
				
				
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return selectByIdBuilder.substring(0, selectByIdBuilder.length());
	}

	@Override
	public String sqlDeleteStmt(Object o, Table table) {
		Class<?> objectClass = o.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		StringBuilder deleteBuilder = 
				new StringBuilder("DELETE FROM "+table.getTableName()+" WHERE "+table.getTablePrimaryKey()+" = ");
		
		for(Field field: fields) {
			if(field == fields[0]) {

				String fieldName = field.getName();

				// obtain the appropriate getter (using the field name)
				String getterName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

			
				try {
					// obtain the getter method from the class we are mapping 
					Method getterMethod = objectClass.getMethod(getterName);
					
					// invoke that method on the object that we are mapping
					Object fieldValue = getterMethod.invoke(o);
				
					// construct a key value pair for each field name and field value
					String values = fieldValue+ ";";
					
					// combine all of the key value pairs into a result string
					deleteBuilder.append(values);
				
				
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return deleteBuilder.substring(0, deleteBuilder.length());
	}

	

	
	


}
