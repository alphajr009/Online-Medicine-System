package com.oop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import customer.DatabaseConnecter;

public class CustomerAuthentication {
	
	private String registrationSQL = "insert into custom(Cname,Caddress,cEmail,CpNo,pwd) values(?,?,?,?,?)";
	private String loginSQL = "select * from custom where Cname = ?";

	/*
	 * Handles customer login 
	 */
	public boolean customerLogin(String uName, String pwd) {
		
		String password = "";
		boolean response = false;
		
		try {
			Connection conn = DatabaseConnecter.initializeDatabase();
			PreparedStatement statement = conn.prepareStatement(loginSQL);
			
			statement.setString(1, uName);
			
			ResultSet resultset = statement.executeQuery();
			
			if (resultset.next()) {
				password = resultset.getString("pwd");
			}
			
			if (password.equals(pwd)) {
				response = true;
			} else {
				response = false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	/**
	 * Customer registration
	 */
	public boolean customerRegistration(String cName, String cAddrss, String cEmail, String cTpNo, String pwd) {
		
		int row = 0;
		
		try {
			Connection conn = DatabaseConnecter.initializeDatabase();
			PreparedStatement statement = conn.prepareStatement(registrationSQL);
			
			statement.setString(1, cName);
			statement.setString(2, cAddrss);
			statement.setString(3, cEmail);
			statement.setString(4, cTpNo);
			statement.setString(5, pwd);
			
			row = statement.executeUpdate();
			
			System.out.println("Row Count " + row);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(row > 0) {
			return true;
		} else {
			return false;
		}
		
	}
}
