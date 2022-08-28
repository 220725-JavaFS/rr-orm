package com.ricketts.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	// A singleton design pattern only allows one instance of a Class to exist in memory at a time.
	
			// Call the JDBC Connection class and create variable 'connection'
			private static Connection connection;
			
			// Create a method to getConnection() from driver manager
			public static Connection getConnection() throws SQLException{
				
				//if the connection is not null or closed then connect to database
				if(connection!=null && !connection.isClosed()) {
					return connection;
				}
				//if the connection is null or closed then reconnect to database
				else {
					// For many frameworks, or in cases where there are multiple SQL drivers, you will need to register which
					//  Driver you are using for the connection interface. The Class.forName method will allow you to do this.
					//  This step is often unnecessary for simple projects but is considered best practice.
					
					try {
						Class.forName("org.postgresql.Driver");
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					String url = "jdbc:postgresql://javafs220725.clmzjyumxjwv.us-east-1.rds.amazonaws.com:5432/project1";
					String username = "postgres"; // u can hide credentials by using ENV variables
					String password = "password"; // you can access those variables with System.getenv("var-name");
					
					connection = DriverManager.getConnection(url, username, password);
					
					return connection;
					
				}//else
				
			}//getConnection

			public static void main(String[] args) {
				//Call getConnection() and print message if you are connected
				try {
					getConnection();
					System.out.println("connection successful!");
				}
				//If you fail to connect print out SQL connection error
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}