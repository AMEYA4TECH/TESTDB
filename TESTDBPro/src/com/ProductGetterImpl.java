package com;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.mysql.jdbc.Statement;

public class ProductGetterImpl {

	private SessionFactory sessionFactory;
	@Autowired
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * This is the master table where the entire application will write their
	 * values for specific get/post calls.
	 */

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(PRoductDTO Obj) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// session.persist(extloggerObj);
		session.save(Obj);
		tx.commit();
		session.close();
	}

	public Product getProduct(String xid) {
		// Product product;
		try {

			Session session = sessionFactory.openSession();

			String ID = null;
			String Name = null;
			String Decr=null;
			String Catagory = null;
			String Color = null;
			String Material = null;
			String Shape = null;
			String Origin=null;

			Transaction tx = session.beginTransaction();

			// session.save(apiLog);
			// Query query =
			// session.createQuery("select Category from product where Name='testpro'");
			tx.commit();

			session.close();

			try {
				// create our mysql database connection
				String myDriver = "com.mysql.jdbc.Driver";
				String myUrl = "jdbc:mysql://localhost:3306/test";
				Class.forName(myDriver);
				java.sql.Connection conn = DriverManager.getConnection(myUrl,
						"root", "root");

				// our SQL SELECT query.
				// if you only need a few columns, specify them by name instead
				// of using "*"
				String query = "SELECT * FROM product where ID="+xid;

				// create the java statement
				java.sql.Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next()) {
					ID = rs.getString("ID");
					Name = rs.getString("Name");
					Decr = rs.getString("Decr");
					Catagory = rs.getString("Catagory");
					Color = rs.getString("Color");
					Material = rs.getString("Material");
					Shape= rs.getString("Shape");//Origin
					Origin= rs.getString("Origin");
					// print the results
					System.out.format("%s, %s, %s, %s, %s, %s\n", ID,
							Name,Decr, Catagory,Color, Material, Shape,
							Origin);
				}
				st.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
			product.setID(ID);
			product.setName(Name);
			product.setDecr(Decr);
			product.setCatagory(Catagory);
			product.setColor(Color);
			product.setMaterial(Material);
			product.setShape(Shape);
			product.setOrigin(Origin);
			
			// return product;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return product;
	}

	public boolean postProduct(Product xid) {
		// Product product;
		boolean countFlag=false;
		boolean insertFlag=false;
		try {
			// create our mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/test";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl,
					"root", "root");
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
			
			Statement stmt3 = (Statement) conn.createStatement();
			int count=0;
			ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(ID) AS IDCount FROM product WHERE ID="+xid.getID());
			if(rs3!=null){
		    while(rs3.next()){
		    count = rs3.getInt("IDCount");
		    }
			}
		    stmt3.close();
		    rs3.close();
		    if(count==1){
		    	countFlag=true;
		    }
			if(!countFlag){
			PreparedStatement preparedStatement = null;
			String insertTableSQL = "INSERT INTO product"
					+ "(ID, Name, Decr, Catagory,Color,Material,Shape,Origin) VALUES"
					+ "(?,?,?,?,?,?,?,?)";
			insertFlag=true;
			// session.save(apiLog);
			// Query query =
			// session.createQuery("select Category from product where Name='testpro'");
			 
			try {
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, xid.getID());
				preparedStatement.setString(2, xid.getName());
				preparedStatement.setString(4, xid.getDecr());
				preparedStatement.setString(3, xid.getCatagory());
				preparedStatement.setString(5, xid.getColor());
				preparedStatement.setString(6, xid.getMaterial());
				preparedStatement.setString(7, xid.getShape());
				preparedStatement.setString(8, xid.getOrigin());
				// execute insert SQL stetement
				preparedStatement.executeUpdate();
				System.out.println("Record is inserted into DBUSER table!");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			} finally {
				if (preparedStatement != null) {
						preparedStatement.close();
				}
			}
				if (conn != null) {
						conn.close();
				}
		}
		 
	
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return false;
	}
		return insertFlag;
}
	
	public boolean deleteProduct(String xid) {
	
		try {

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();

			// session.save(apiLog);
			// Query query =
			// session.createQuery("select Category from product where Name='testpro'");
			tx.commit();

			session.close();

			try {
				// create our mysql database connection
				String myDriver = "com.mysql.jdbc.Driver";
				String myUrl = "jdbc:mysql://localhost:3306/test";
				Class.forName(myDriver);
				java.sql.Connection conn = DriverManager.getConnection(myUrl,
						"root", "root");

				// our SQL SELECT query.
				// if you only need a few columns, specify them by name instead
				// of using "*"
				String query = "DELETE FROM product WHERE ID ="+xid;
					
				
				Statement stmt3 = (Statement) conn.createStatement();
				int count=0;
				ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(ID) AS IDCount FROM product WHERE ID="+xid);
			    while(rs3.next()){
			    count = rs3.getInt("IDCount");
			    }
			    stmt3.close();
			    rs3.close();
			    if(count==1){
				// create the java statement
				java.sql.Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				  st.execute(query);
				  System.out.println("Record"+xid+" is deleted into DBUSER table!");
			    }else{
			    	System.out.println("Record"+xid+" is does not exist!");
			    	return false;
			    }
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return true;
	}
	
	
	
	public ArrayList<Product> getAllProduct( ) {
		ArrayList<Product> productList=new ArrayList<>();
		// Product product;
		try {
			

			Session session = sessionFactory.openSession();

			String ID = null;
			String Name = null;
			String Decr=null;
			String Catagory = null;
			String Color = null;
			String Material = null;
			String Shape = null;
			String Origin=null;

			Transaction tx = session.beginTransaction();

			// session.save(apiLog);
			// Query query =
			// session.createQuery("select Category from product where Name='testpro'");
			tx.commit();

			session.close();

			try {
				// create our mysql database connection
				String myDriver = "com.mysql.jdbc.Driver";
				String myUrl = "jdbc:mysql://localhost:3306/test";
				Class.forName(myDriver);
				java.sql.Connection conn = DriverManager.getConnection(myUrl,
						"root", "root");

				// our SQL SELECT query.
				// if you only need a few columns, specify them by name instead
				// of using "*"
				String query = "SELECT * FROM product ";

				// create the java statement
				java.sql.Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next()) {
					
					Product	product=new Product();
					ID = rs.getString("ID");
					Name = rs.getString("Name");
					Decr = rs.getString("Decr");
					Catagory = rs.getString("Catagory");
					Color = rs.getString("Color");
					Material = rs.getString("Material");
					Shape= rs.getString("Shape");//Origin
					Origin= rs.getString("Origin");
					// print the results
					System.out.format("%s, %s, %s, %s, %s, %s\n", ID,
							Name,Decr, Catagory,Color, Material, Shape,
							Origin);
					
					product.setID(ID);
					product.setName(Name);
					product.setDecr(Decr);
					product.setCatagory(Catagory);
					product.setColor(Color);
					product.setMaterial(Material);
					product.setShape(Shape);
					product.setOrigin(Origin);
					productList.add(product);
				}
				st.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
			
			
			// return product;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return productList;
	}
}
