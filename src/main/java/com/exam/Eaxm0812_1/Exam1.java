package com.exam.Eaxm0812_1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Exam1 {
	 public static void searchCity(String search){
//		   Connection conn=null;
		 
		   String sql ="SELECT city_id,city FROM `city`WHERE country_id="+search+";";
	       Connection conn= null;
	       Statement st= null;
	       ResultSet rs= null;
	       try {
	             Class. forName("com.mysql.jdbc.Driver");
	             conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
	             st=(Statement) conn.createStatement();
	             rs= st.executeQuery( sql);
	            
	             System.out.println("城市ID|城市名称");
	             while( rs.next()){
	                  System. out.print( rs.getInt( "city_id")+ "    |");
	                  System. out.print( rs.getString( "city")+ "  ");
	                  System. out.println();
	             }
	             
	            
	     } catch (Exception e) {
	            e.printStackTrace();
	     }finally {
	            try {
	                 rs.close();
	           } catch (Exception e2) {
	           
	           }
	            try {
	                 st.close();
	           } catch (Exception e2) {
	                
	           }
	            try {
	                 conn.close();
	           } catch (Exception e2) {
	                 // TODO: handle exception
	           }
	     }
	 }

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入Country ID：");
		String search=scanner.next();
		searchCity(search);
		
	}

}
