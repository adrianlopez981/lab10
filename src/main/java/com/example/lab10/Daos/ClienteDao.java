package com.example.lab10.Daos;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Contratos;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDao extends BaseDao {

    public Clientes buscarCliente(int nro_documento) {

        Clientes cliente = null;

        String sql = "select * from jm_client_bii where g4093_nro_id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {


            pstmt.setInt(1, nro_documento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientes();
                    cliente.setNombreCliente(rs.getString(1));
                    cliente.setEdad(rs.getString(2));
                    cliente.setTipoCliente(rs.getString(3));
                    cliente.setTipoDocumento(rs.getString(4));
                    cliente.setNumeroDocumento(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }




    public ArrayList<Clientes> listarClientesNoCredentials() {

        ArrayList<Clientes> lista = new ArrayList<>();
        String sql = "select jmc.* from jm_client_bii jmc join credentials c on jmc.g4093_nro_id != c.nro_documento group by g4093_nro_id";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Clientes clientes = new Clientes();
                clientes.setNumeroDocumento(rs.getString(1));
                clientes.setNombreCliente(rs.getString(2));
                clientes.setEdad(rs.getString(3));
                clientes.setTipoCliente(rs.getString(4));
                clientes.setTipoDocumento(rs.getString(5));


                lista.add(clientes);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lista;
    }












}
