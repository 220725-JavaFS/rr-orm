package com.ricketts.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.ricketts.Mapper;
import com.ricketts.SqlMapper;
import com.ricketts.models.Soda;
import com.ricketts.models.Table;
import com.ricketts.utils.ConnectionUtil;

public class SodaDAOImpl implements SodaDAO {

	
	@Override
	public void createSoda(Soda soda) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO sodas (brand, flavor, quantity, ounces_per_can, price)"
					+ "VALUES(?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, soda.getBrand());
			statement.setString(++count, soda.getFlavor());
			statement.setInt(++count, soda.getQuantity());
			statement.setDouble(++count, soda.getOuncesPerCan());
			statement.setDouble(++count, soda.getPrice());
			
			statement.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public List<Soda> displayAllSoda() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM sodas;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Soda> sodaList = new LinkedList <>();

			while(result.next()) { 
				Soda soda = new Soda(
					result.getInt("soda_id"),
					result.getString("brand"),
					result.getString("flavor"),
					result.getInt("quantity"),
					result.getDouble("ounces_per_can"),
					result.getDouble("price"));
			
				sodaList.add(soda);
			}
			return sodaList;
		}//try 
		catch(SQLException e) {
			e.printStackTrace();
		}//catch
		return null;
	}

	
	 public List<Soda> displaySodaById(Soda soda) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM sodas WHERE soda_id = "+soda.getSodaId()+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Soda> sodaList1 = new LinkedList <>();

			while(result.next()) { 
				Soda soda1 = new Soda(
					result.getInt("soda_id"),
					result.getString("brand"),
					result.getString("flavor"),
					result.getInt("quantity"),
					result.getDouble("ounces_per_can"),
					result.getDouble("price"));
			
				sodaList1.add(soda1);
			}
			return sodaList1;
		}//try 
		catch(SQLException e) {
			e.printStackTrace();
		}//catch
		return null;
	}

	@Override
	public void changeSodaInfo(Soda soda) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE sodas SET brand = ?, flavor = ?, quantity = ?, ounces_per_can = ?, "
					+ "price = ?  WHERE soda_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0; 
			statement.setString(++count, soda.getBrand());
			statement.setString(++count, soda.getFlavor());
			statement.setInt(++count, soda.getQuantity());
			statement.setDouble(++count, soda.getOuncesPerCan());
			statement.setDouble(++count, soda.getPrice());
			statement.setInt(++count, soda.getSodaId());
			statement.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSoda(Soda soda) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			TableDAO tableDao = new TableDAOImpl();
			Mapper m = new SqlMapper();
			Table table = new Table();
			
			tableDao.start("sodas" , table);
			
			String deleteStmt = m.sqlDeleteStmt(soda, table);
			PreparedStatement statement = conn.prepareStatement(deleteStmt);
			
//			int count = 0; 
//			statement.setInt(++count, soda.getSodaId());
			statement.execute();
			
			System.out.println("soda removed!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
}//class
