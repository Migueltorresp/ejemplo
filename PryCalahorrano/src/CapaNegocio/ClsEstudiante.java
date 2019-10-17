/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author Usuario
 */
public class ClsEstudiante {
    public int _clave;
    public String _nombre;
    public float [] _Nota= new float[10];

    public int getClave() {
        return _clave;
    }

    public void setClave(int clave) {
        this._clave = clave;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public float[] getNota() {
        return _Nota;
    }

    public void setNota(float[] Nota) {
        this._Nota = Nota;
    }
    public float promedio(float sumnotas, int num_notas)
    {
        float prom= sumnotas/num_notas;
        return prom;
    }
    public boolean estado(float promedio)
    {
        boolean prom= false;
        if(promedio>=7)
        {
            prom=true;
            return prom;
        }
        return prom;     
    }
    public String toString(String Nombre,float promedio, boolean prom)
    {
        if(prom)
        {
            String nombre=" "+Nombre+"," +promedio+ ", Aprueba";
            return nombre;
        }
        String nombre=" "+Nombre+"," +promedio+ ", Reprueba";
        return nombre;
    }
}
