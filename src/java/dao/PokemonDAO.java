/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pokemon;

/**
 *
 * @author CARLOS
 */
public class PokemonDAO {
    
    private Connection conn;
	private int lastID;

	public PokemonDAO () throws Exception {
		try{
			this.conn = ConnectionDAO.getConnection();
		}catch(Exception e){
			throw new Exception("Erro: \n"+e.getMessage());                    
		}
	}
	
	public void salvar(Object ob) throws Exception {
		Pokemon p = (Pokemon) ob;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try{

				conn = ConnectionDAO.getConnection();
				String SQL = "INSERT INTO pokemon VALUES (?,?,?,?);";
				ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, p.getNum());
				ps.setString (2, p.getName());
				ps.setString(3, p.getPre_evolution());
				ps.setString(4, p.getNext_evolution());
                                //ps.setString(5, prof.getPassWd());
				int affectedRows = ps.executeUpdate();    
                                
                                salvarTipos(p.getTipos(), p.getNum());
                                
			
		}catch (SQLException sqle){
			throw new Exception("Erro ao salvar dados dos tipos de documentos: \n"+sqle);
		}finally{
			ConnectionDAO.closeConnection(conn,ps);
		}
	}
        
        public void salvarTipos(ArrayList<String> tipos, String n) throws Exception{            
            
            

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
                            for (String tipo : tipos) {
                                System.out.println(tipo);
                    
				conn = ConnectionDAO.getConnection();
				String SQL = "INSERT INTO tipo_pokemon VALUES (null,?,?);";
				ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                                
				ps.setString(1, tipo);
				ps.setString (2, n);
                                //ps.setString(5, prof.getPassWd());
				int affectedRows = ps.executeUpdate();
                            }
                    }catch (SQLException sqle){
                        System.out.println(sqle);
			throw new Exception("Erro ao salvar dados dos tipos de documentos: \n"+sqle);
		}finally{
			ConnectionDAO.closeConnection(conn,ps);
		}
            
        }

    
}
