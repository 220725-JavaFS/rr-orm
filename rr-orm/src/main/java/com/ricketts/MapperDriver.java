package com.ricketts;

import java.util.Scanner;

import com.ricketts.daos.SodaDAO;
import com.ricketts.daos.SodaDAOImpl;
import com.ricketts.daos.TableDAO;
import com.ricketts.daos.TableDAOImpl;
import com.ricketts.models.Soda;
import com.ricketts.models.Table;

public class MapperDriver {
	
	public static void main(String[] args) {
		TableDAO tableDao = new TableDAOImpl();
		SodaDAO sodaDao = new SodaDAOImpl();
		Mapper m = new SqlMapper();
		Table table = new Table();
		Soda soda = new Soda();
		
//		// test insert statement string
//		tableDao.start("sodas" , table);
//		
//		String insertStmt = m.sqlInsertStmt(soda, table);
//		System.out.println(insertStmt);
//		
//		System.out.println("-----------------------");
//		
//		// test update statement string
//		String updateStmt = m.sqlUpdateStmt(soda, table);
//		System.out.println(updateStmt);
//		
//		System.out.println("-----------------------");
//		
//		// test Select all statement string
//		String selectAllStmt = m.sqlSelectAllStmt(soda, table);
//		System.out.println(selectAllStmt);
//		
//		System.out.println("-----------------------");
//		
//		// test Select by id statement string
//		String selectbyIdStmt = m.sqlSelectByIdStmt(soda, table);
//		System.out.println(selectbyIdStmt);
//		
//		System.out.println("-----------------------");
//		
//		// test delete statement string
//		String deleteStmt = m.sqlDeleteStmt(soda, table);
//		System.out.println(deleteStmt);
//		
//		System.out.println("-----------------------");
//		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Delete by id number: ");
		soda.setSodaId(scanner.nextInt());
		
		tableDao.start("sodas" , table);
		sodaDao.deleteSoda(soda);
	
				
	}
}
