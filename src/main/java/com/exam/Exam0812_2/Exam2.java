package com.exam.Exam0812_2;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


	public class Exam2 {
		 public static void searchCity(String search){
//			   Connection conn=null;
			 
			   String sql ="SELECT first_name,last_name FROM `customer` WHERE customer_id="+search+";";
		       Connection conn= null;
		       Statement st= null;
		       ResultSet rs= null;
		       try {
		             Class. forName("com.mysql.jdbc.Driver");
		             conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "");
		             st=(Statement) conn.createStatement();
		             rs= st.executeQuery(sql);
		             
		             while( rs.next()){
		             String name=rs.getString("first_name");
		             String lname=rs.getString("last_name");             
		             System.out.println(name+"."+lname+"租用的film->");
		             }
		             System.out.println("film ID|file 名称|租用时间");
//   	                 sql="SELECT rental_id FROM `rental` where customer_id=571;";
//   	                 Statement st2= null;
//   		             ResultSet rs2= null;
//   	                 st2=(Statement) conn.createStatement();
//   	                 rs2=st2.executeQuery(sql);
//		  
//		             while( rs2.next()){
//		            	 String retal=rs2.getString("rental_id");
//		            	 String date=rs2.getString("rental_date");
//		            	 String in=rs2.getString("inventory_id");
//		            
//		            	 Statement st3= null;
//	   		             ResultSet rs3= null;
//	   		              st2=(Statement) conn.createStatement();
//	   	                  rs2=st2.executeQuery(sql);
//	             } 
		             
		            
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
			System.out.print("请输入Custemer ID：");
			String search=scanner.next();
			searchCity(search);
			
		}
}
