package com.example.lab10.Daos;

import com.example.lab10.Beans.Contratos;
import com.example.lab10.Dtos.CantidadContratosDto;
import com.example.lab10.Dtos.ExpectedLossxContratoDto;

import java.sql.*;
import java.util.ArrayList;

public class ContratoDao extends BaseDao{
    public ArrayList<Contratos> listaContratos(int nro_id_cliente) {

        ArrayList<Contratos> lista = new ArrayList<>();
        String sql = "SELECT * from jm_cotr_bis where client_nro_id = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            pstmt.setInt(1, nro_id_cliente);

            while(rs.next()){
                Contratos contratos = new Contratos();

                contratos.setNroDeContrato(rs.getString(1));
                contratos.setIdCliente(rs.getInt(2));
                contratos.setDivisa(rs.getString(3));
                contratos.setEstado(rs.getInt(4));
                contratos.setMesesEnEseEstado(rs.getInt(5));

                lista.add(contratos);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }



    public ArrayList<CantidadContratosDto> mostrarCantidadContratos(int nro_id_cliente) {

        ArrayList<CantidadContratosDto> lista = new ArrayList<>();
        String sql = "select count(*),g6789_status from jm_cotr_bis where client_nro_id=? group by g6789_status";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            pstmt.setInt(1, nro_id_cliente);

            while(rs.next()){
                CantidadContratosDto cantidadContratosDto = new CantidadContratosDto();

                cantidadContratosDto.setNumeroContratos(rs.getInt(1));
                cantidadContratosDto.setEstadoContratos(rs.getInt(2));


                lista.add(cantidadContratosDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }



    public ArrayList<ExpectedLossxContratoDto> mostrarExpectedLoss(int nro_id_cliente) {



        ArrayList<ExpectedLossxContratoDto> lista = new ArrayList<>();
        String sql = "select c.g6789_contract, c.client_nro_id, ((v.lgd_value*v.pd_value)*(1-v.recovery_rate)) as expectedLoss from jm_values v, jm_cotr_bis c where v.jm_cotr_bis_g6789_cod_nup = c.g6789_contract and c.client_nro_id = ?  group by v.jm_cotr_bis_g6789_cod_nup";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            pstmt.setInt(1, nro_id_cliente);


            while(rs.next()){
                ExpectedLossxContratoDto expectedLossxContratoDto = new ExpectedLossxContratoDto();

                expectedLossxContratoDto.setNro_contrato(rs.getInt(1));
                expectedLossxContratoDto.setNro_documento(rs.getString(2));
                expectedLossxContratoDto.setExpectedLoss(rs.getFloat(3));


                lista.add(expectedLossxContratoDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }











}
