
package com.conexion;
import java.sql.*;

/**
 * Nombre de Clase: Conexion.
 * Fecha: 29-09-2017.
 * Version: 1.0.
 * Copyright: ITCA-FEPADE.
 * @author Victor Alvarado
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?user=root&password=");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw e;
        }
    }
    
    public void desconectar() throws Exception
    {
        try
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.isClosed();
                }
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
    }
}
