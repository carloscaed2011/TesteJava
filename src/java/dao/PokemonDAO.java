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

    public PokemonDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public void salvar(Object ob) throws Exception {
        Pokemon p = (Pokemon) ob;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {

            conn = ConnectionDAO.getConnection();
            String SQL = "INSERT INTO pokemon VALUES (?,?,?,?);";
            ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNum());
            ps.setString(2, p.getName());
            ps.setString(3, p.getPre_evolution());
            ps.setString(4, p.getNext_evolution());
            //ps.setString(5, prof.getPassWd());
            int affectedRows = ps.executeUpdate();

            salvarTipos(p.getTipos(), p.getNum());

        } catch (SQLException sqle) {
            throw new Exception("Erro ao salvar dados dos tipos de documentos: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void salvarTipos(ArrayList<String> tipos, String n) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            for (String tipo : tipos) {
                // System.out.println(tipo);                   
                conn = ConnectionDAO.getConnection();
                String SQL = "INSERT INTO tipo_pokemon VALUES (null,?,?);";
                ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, tipo);
                ps.setString(2, n);
                //ps.setString(5, prof.getPassWd());
                int affectedRows = ps.executeUpdate();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
            throw new Exception("Erro ao salvar dados dos tipos de documentos: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    public int excluirID(String num) throws Exception {

        if (!num.equalsIgnoreCase("") || null != num) {
            PreparedStatement ps = null;
            Connection conn = null;
            ResultSet rs = null;
            try {
                conn = ConnectionDAO.getConnection();

                String SQL = "DELETE FROM `testejava`.`tipo_pokemon` WHERE `fk_pokemon_num`= ?;";
                ps = conn.prepareStatement(SQL);
                ps.setString(1, num);
                ps.executeUpdate();

                SQL = "DELETE FROM `testejava`.`pokemon` WHERE `num`= ?;";
                ps = conn.prepareStatement(SQL);
                ps.setString(1, num);
                return ps.executeUpdate();

            } catch (SQLException sqle) {
                throw new Exception("Erro ao remover: \n" + sqle);
            } finally {
                ConnectionDAO.closeConnection(conn, ps);
            }

        } else {
            throw new Exception("Objeto Passado é nulo!");
        }

    }

    public ArrayList<Pokemon> listaTodos() throws Exception {
        PreparedStatement ps = null;
        java.sql.Connection conn = null;
        ResultSet rs;
        ArrayList<Pokemon> pks = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM pokemon;";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String SQL2 = "SELECT * FROM tipo_pokemon where fk_pokemon_num=?;";
                conn = this.conn;
                PreparedStatement ps2 = conn.prepareStatement(SQL2);
                ps2.setString(1, rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> tps = new ArrayList<>();
                while (rs2.next()) {
                    tps.add(rs2.getString(2));
                }
                pks.add(new Pokemon(rs.getString(1), rs.getString(2), tps, rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

        return pks;
    }

    public Integer atualizar(Pokemon p) throws Exception {

        if (p != null) {
            PreparedStatement ps = null;
            Connection conn = null;
            try {

                conn = ConnectionDAO.getConnection();
                String SQL = "DELETE FROM `testejava`.`tipo_pokemon` WHERE `fk_pokemon_num`= ?;";
                ps = conn.prepareStatement(SQL);
                ps.setString(1, p.getNum());
                ps.executeUpdate();

                salvarTipos(p.getTipos(), p.getNum());

                String SQL2 = "UPDATE  testejava.pokemon SET name = ?, pre_evolution = ?, next_evolution = ? WHERE num = ?;";
                ps = conn.prepareStatement(SQL2);
                ps.setString(1, p.getName());
                ps.setString(2, p.getPre_evolution());
                ps.setString(3, p.getNext_evolution());
                ps.setString(4, p.getNum());
                return ps.executeUpdate();

            } catch (SQLException sqle) {
                throw new Exception("Erro ao atualizar: \n" + sqle);
            } finally {
                ConnectionDAO.closeConnection(conn, ps);
            }

        } else {
            throw new Exception("Objeto Passado é nulo!");
        }
    }

    public Pokemon procuraID(String num) throws Exception {
        Pokemon pk = new Pokemon();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM testejava.pokemon WHERE num = ?;";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, num);
            rs = ps.executeQuery();

            while (rs.next()) {
                String SQL2 = "SELECT * FROM tipo_pokemon where fk_pokemon_num=?;";
                PreparedStatement ps2 = conn.prepareStatement(SQL2);
                ps2.setString(1, num);
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> tps = new ArrayList<>();
                while (rs2.next()) {

                    tps.add(rs2.getString(2));
                }
                pk = new Pokemon(rs.getString(1), rs.getString(2), tps, rs.getString(3), rs.getString(4));
            }

            return pk;

        } catch (SQLException sqle) {
            throw new Exception("Erro ao procurar: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public ArrayList<Pokemon> procuraType(String type) throws Exception {
        ArrayList<Pokemon> pks = new ArrayList<>();
        Pokemon pk = new Pokemon();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM pokemon INNER JOIN tipo_pokemon on pokemon.num = tipo_pokemon.fk_pokemon_num where tipo_pokemon.tipo = ?;";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, type);
            rs = ps.executeQuery();

            while (rs.next()) {

                String SQL2 = "SELECT * FROM tipo_pokemon where fk_pokemon_num=?;";
                PreparedStatement ps2 = conn.prepareStatement(SQL2);
                ps2.setString(1, rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> tps = new ArrayList<>();
                while (rs2.next()) {
                    tps.add(rs2.getString(2));
                }
                pk = new Pokemon(rs.getString(1), rs.getString(2), tps, rs.getString(3), rs.getString(4));
                pks.add(pk);
            }

            return pks;

        } catch (SQLException sqle) {
            throw new Exception("Erro ao procurar: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public ArrayList<Pokemon> listaPagina(String pagina, String quantidade) throws Exception {
        int p = Integer.parseInt(pagina);
        int qt = Integer.parseInt(quantidade);
        ArrayList<Pokemon> formatado = new ArrayList<>();
        PreparedStatement ps = null;
        java.sql.Connection conn = null;
        ResultSet rs;
        ArrayList<Pokemon> pks = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM pokemon;";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String SQL2 = "SELECT * FROM tipo_pokemon where fk_pokemon_num=?;";
                conn = this.conn;
                PreparedStatement ps2 = conn.prepareStatement(SQL2);
                ps2.setString(1, rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> tps = new ArrayList<>();
                while (rs2.next()) {
                    tps.add(rs2.getString(2));
                }
                pks.add(new Pokemon(rs.getString(1), rs.getString(2), tps, rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

        for (int i = (p - 1) * qt; i < (qt * p); i++) {
            //System.out.println(i);
            if (i < pks.size()) {
                formatado.add(pks.get(i));
            }
        }

        return formatado;
    }

}
