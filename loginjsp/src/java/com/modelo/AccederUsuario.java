
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Nombre de Clase: AccederUsuario.
 * Fecha: 29-09-2017.
 * Version: 1.0.
 * Copyright: ITCA-FEPADE.
 * @author Victor Alvarado
 */
public class AccederUsuario extends Conexion
{
    public String login(Usuario usu)throws Exception
    {
        String estado = "";
        ResultSet rs;
        try 
        {
            this.conectar();
            String sql = "select tipoUsuario from usuario where nombreUsuario=? and clave=?";
            PreparedStatement ps =this.getCon().prepareStatement(sql);
            ps.setString(1, usu.getNombreUsuario());
            ps.setString(2, usu.getClave());
            rs= ps.executeQuery();
            if (rs.next()) {

                estado = "true";

            }
            usu.setTipoUsuario(rs.getString("tipoUsuario"));
        } catch (Exception e) 
        {
            throw e;
        }
        return estado;
    }
}
