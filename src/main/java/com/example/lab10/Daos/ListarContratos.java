package com.example.lab10.Daos;

import com.example.lab10.Beans.Contratos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListarContratos extends BaseDao{
    public ArrayList<Contratos> listacontratos() {
        ArrayList<Contratos> listascontratos = new ArrayList<>();
        String sql = "SELECT count(*), client_nro_id from jm_cotr_bis group by client_nro_id";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Contratos contratos = new Contratos();
                contratos.(resultSet.getInt(1));
                newUser.setNombre(resultSet.getString(2));
                newUser.setApellido(resultSet.getString(3));
                newUser.setCorreo(resultSet.getString(4));
                newUser.setContrasena(resultSet.getString(5));
                newUser.setCodigo(resultSet.getString(6));
                newUser.setDni(resultSet.getString(7));
                newUser.setCelular(resultSet.getString(8));
                newUser.setCategoria(resultSet.getString(9));
                newUser.setRolId(resultSet.getInt(11));

                listascontratos.add();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

}
