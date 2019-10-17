/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ClsBdEstudiante {
    private Connection _base;
    private Statement _tabla;
    private ResultSet _registros;
    private PreparedStatement ps;
    public ClsBdEstudiante (String dirbase)
    {
        try
        {
            _base=DriverManager.getConnection("jdbc:ucanaccess://"+dirbase);
            _tabla= _base.createStatement(ResultSet.FETCH_UNKNOWN,ResultSet.TYPE_SCROLL_SENSITIVE);
            System.out.println("*** conexion exitosa ***");
        }
        catch(Exception err)
        {
            System.out.println("*** conexion errada ***"+err);
        }
    }
    public ResultSet registros()
    {
        return _registros;
    }
     public boolean consulta (String tabla) throws SQLException
    {
        boolean respuesta=false;
        _registros=null;
        String comando= "SELECT * FROM "+tabla;
        _registros=null;
        _tabla.execute(comando);
        _registros=_tabla.getResultSet();
        if(_registros!=null)
        {
            respuesta=true;
        }
        return respuesta;
    }
    public void siguiente() throws SQLException
    {
        try
        {
           if(!(_registros.next()))
            {
                _registros.first();
            } 
        }
        catch(SQLException err)
        {
            System.out.print("*** Error Recorrer ***");
        }
    }
    public void anterior() throws SQLException
    {
        try
        {
           if(!(_registros.previous()))
            {
                _registros.first();
            } 
        }
        catch(SQLException err)
        {
            System.out.print("*** Error Recorrer ***");
        }

    }
     public boolean consultanota (int clave) throws SQLException
    {
        boolean respuesta=false;
        _registros=null;
        String comando= "SELECT * FROM TbNotas WHERE Clavest= " + clave;
        _registros=null;
        _tabla.execute(comando);
        _registros=_tabla.getResultSet();
        if(_registros!=null)
        {
            respuesta=true;
        }
        return respuesta;
    }
    
}
