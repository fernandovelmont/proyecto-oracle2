/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Fernandodaniel
 */
public class DAONetflix {
      public static String guardarPelicula(String titulo, String sinopsis) throws Exception{
       ModeloConexion c=new ModeloConexion();
        Connection con=c.conectarse();
     CallableStatement registro=con.prepareCall("{call guardar_pelicula(?,?,?)}");
        registro.registerOutParameter(1,java.sql.Types.INTEGER);
        registro.setString(2,titulo);
        registro.setString(3,sinopsis);
        registro.execute();
        int pk=registro.getInt(1);
        return "SE guardo la pelicula con id:"+pk; 
    }
}
