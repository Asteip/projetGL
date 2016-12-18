package com.alma.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public final class DBHandlerEns {

	private static volatile DBHandlerEns instance = null;
	private static final Logger logger = Logger.getLogger(DBHandlerEns.class);
	Statement stmt = null;
	Statement stmtStock = null;
	Connection c = null;

	/**
	 *  Singleton
	 */
	private DBHandlerEns() {
		super();
	}



  //recup le fichier, si il la pas le crÃ©er

	public static final DBHandlerEns getInstance() {

		if (DBHandlerEns.instance == null) {
			synchronized(DBHandlerEns.class) {
				if (DBHandlerEns.instance == null) {
					DBHandlerEns.instance = new DBHandlerEns();
				}
			}
		}
		return DBHandlerEns.instance;
	}



	/**
	 * Open Database Connection
	 */



	public void openDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:../persistanceEns/db_enseignant.sqllite");
			c.setAutoCommit(false);
			logger.info("Opened database successfully");
		} catch ( Exception e ) {
			logger.warn(e);
		}
	}

	/**
	 * Close Database Connection
	 */
	public void closeDB(){
		try {
			c.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Database closed");
	}


  //create
	/**
	 * Creer un souhait et le sauvegarde dans la base de donnée
	 
	 * @param mod
	 * @param description
	 * @param price
	 * @param id
	 */
	public void create(int id, Module mod, Enseignement e, int volumeHoraire, int priorite){
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO SOUHAIT (ID,MODULE,ENSEIGNEMENT,VOLUMEHORAIRE,PRIORITE) "+"VALUES ('"+id+"', '"+mod+"', "+e+", '"+volumeHoraire+"', '"+priorite+"');";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO LISTSOUHAIT (ID,NB_PROD) "+"VALUES ('"+id+"');";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
	}


  //retrieve
	/**
	 * retrieve a product by ID
	 * @param id
	 * @return Map<String,String>
	 */
	public  Map<String,String> retrieve(int id){
		Map<String,String> res = new HashMap<>();
		try{
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT where ID="+ id +";" );
			while ( rs.next() ) {
				res.put("name",rs.getString("name"));
				res.put("description",rs.getString("description"));
				res.put("price",Float.toString(rs.getFloat("price")));
				res.put("id",Integer.toString(rs.getInt("id")));
			}
			rs.close();
			rs = stmt.executeQuery( "SELECT NB_PROD FROM STOCK where ID="+ id +";" );
			res.put("nb_prod",Integer.toString(rs.getInt("nb_prod")));
			stmt.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Operation done successfully");

		return res;
	}

  //recup list
	/**
	 * retrieve all products
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> retrieveAll(){
		ArrayList<Map<String,String>> res = new ArrayList<>();
		Map<String,String> tupple;
		try{
			stmt = c.createStatement();
			stmtStock = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCT;" );
			while ( rs.next() ) {
				tupple = new HashMap<>();
				tupple.put("name",rs.getString("name"));
				tupple.put("description",rs.getString("description"));
				tupple.put("price",Float.toString(rs.getFloat("price")));
				tupple.put("id",Integer.toString(rs.getInt("id")));
				ResultSet rsStock = stmtStock.executeQuery( "SELECT NB_PROD FROM STOCK where ID="+ rs.getInt("id") +";" );
				tupple.put("nb_prod",Integer.toString(rsStock.getInt("nb_prod")));
				res.add(tupple);
			}
			rs.close();
			stmt.close();
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Operation done successfully");

		return res;
	}


// update
	/**
	 * update the name of a product
	 * @param name
	 * @param id
	 **/
	public void updateName(String name, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set NAME="+name+" WHERE ID="+id+";";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

	/**
	 * update the description of a product
	 * @param description
	 * @param id
	 **/
	public void updateDescription(String description, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set DESCRIPTION="+description+" WHERE ID="+id+";";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

  //update prix
	/**
	 * update the price of a product
	 * @param price
	 * @param id
	 **/
	public void updatePrice(Float price, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE PRODUCT set PRICE="+price+" WHERE ID="+id+";";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}

	/**
	 * update the stock of a product
	 * @param stock
	 * @param id
	 **/
	public void updateStock(int stock, int id){
		try {
			stmt = c.createStatement();
			String sql = "UPDATE STOCK set NB_PROD="+stock+" WHERE ID="+id+";";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Update done successfully");
	}


  //suppression
	/**
	 * delete a product
	 * @param id
	 **/
	public void delete(int id){
		try {
			stmt = c.createStatement();
			String sql = "DELETE FROM  PRODUCT WHERE ID="+id+";";
			stmt.executeUpdate(sql);
			sql = "DELETE FROM  STOCK WHERE ID="+id+";";
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			logger.warn(e);
		}
		logger.info("Delete done successfully");
	}

}
