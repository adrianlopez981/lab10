package com.example.lab10.Daos;

import com.example.lab10.Beans.Credentials;

import java.sql.*;

public class DatosDao extends BaseDao {


    public Credentials buscarUsuario(String numero_documento, String password) {
        /*ArrayList<Employee> listaEmpleados = new ArrayList<>();*/

        Credentials credentials = null;

        String sql = "SELECT * FROM CREDENTIALS WHERE nro_documento = ? AND hashedPassword = sha2(?,256)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            int numero_documento_int = Integer.parseInt(numero_documento);



            pstmt.setString(2, password);
            pstmt.setInt(1, numero_documento_int);


            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    /*int nro_documento = rs.getInt(1);*/


                    credentials = new Credentials();
                    credentials.setTipoUsuario(rs.getInt(4));
                    credentials.setNumeroDocumento(rs.getString(1));




                    /*credentials = this.buscarPorId(nro_documento);*/
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return credentials;
    }


    public void createCredentialCliente(String numero_documento, String password) throws SQLException {

        String sql = "INSERT INTO credentials (nro_documento,password,hashedPassword,tipoUsuario) "
                + "VALUES (?,?,sha2(?,256),2)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, numero_documento);
            pstmt.setString(2, password);
            pstmt.setString(3, password);


            pstmt.executeUpdate();
        }
    }


        /*public Credentials buscarPorId(int nro_documento) {
        Clientes cliente = null;

        String sql = "select * from jm_client_bii WHERE g4093_nro_id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {


            pstmt.setInt(1, nro_documento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientes();
                    cliente.setIdUsuario(rs.getInt(1));
                    cliente.setNombre(rs.getString(2));



                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }*/






}