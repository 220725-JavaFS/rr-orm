package com.ricketts.daos;

import java.util.List;

import com.ricketts.models.Soda;

public interface SodaDAO {
	
	// CREATE
	public abstract void createSoda(Soda soda);
	
	
	// READ
	List <Soda> displayAllSoda();
	
	public List <Soda> displaySodaById(Soda soda);
	
	
	// UPDATE
	
	public abstract void changeSodaInfo(Soda soda);
	
	
	// DELETE

	public abstract void deleteSoda(Soda soda);
}
