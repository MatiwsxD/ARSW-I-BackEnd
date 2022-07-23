package edu.escuelaing.arsw.proyecto.model;

import java.util.ArrayList;

/**
 * A class that represents a user.
 */
public class User {
    private String name;
    private String correo;
    private String password;
    private Integer pGanadas = 0;
    private Integer pPerdidas = 0;

    public User() {

    }

    /**
     * It returns the value of the variable correo.
     * 
     * @return The value of the variable correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * It sets the value of the correo variable.
     * 
     * @param correo email
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * It returns the name of the object.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * This function sets the name of the object to the name passed in as a
     * parameter
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns the password of the user
     * 
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This function sets the password of the user
     * 
     * @param password The password to use for the connection.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * It returns the value of the variable pGanadas.
     * 
     * @return The value of the variable pGanadas.
     */
    public Integer getpGanadas() {
        return pGanadas;
    }

    /**
     * This function sets the value of the pGanadas variable to the value of the
     * pGanadas parameter
     * 
     * @param pGanadas number of games won
     */
    public void setpGanadas(Integer pGanadas) {
        this.pGanadas = pGanadas;
    }

    /**
     * It returns the value of the variable pPerdidas.
     * 
     * @return The value of the variable pPerdidas.
     */

    public Integer getpPerdidas() {
        return pPerdidas;
    }

    /**
     * This function sets the value of the private variable pPerdidas to the value
     * of the parameter
     * pPerdidas
     * 
     * @param pPerdidas Integer
     */

    public void setpPerdidas(Integer pPerdidas) {
        this.pPerdidas = pPerdidas;
    }

}
