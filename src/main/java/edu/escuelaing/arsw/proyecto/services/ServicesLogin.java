package edu.escuelaing.arsw.proyecto.services;

import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesLogin {
    AutentificationLogin data = new AutentificationLogin();

    /**
     * This function creates a new user and insert in the database
     * 
     * @param usuario    The username
     * @param correo     email
     * @param contraseña password
     */
    public void registrarPlayer(String usuario, String correo, String contraseña) {
        User userProfile = new User();
        userProfile.setName(usuario);
        userProfile.setPassword(contraseña);
        userProfile.setCorreo(correo);
        data.insertar(userProfile);
    }

    /**
     * This function returns true if the email is registered in the database, false
     * otherwise.
     * 
     * @param correo email
     * @return A boolean value.
     */
    public boolean estaRegistrado(String correo) {
        return data.isRegister(correo);
    }

    /**
     * The function loginPlayer() takes two strings as parameters, and returns a
     * boolean
     * 
     * @param correo     email
     * @param contraseña password
     * @return A boolean value.
     */
    public boolean loginPlayer(String correo, String contraseña) {
        return data.getUserLogin(correo, contraseña);
    }

    /**
     * This function returns a user from the database.
     * 
     * @param usuario the username of the user
     * @return The user object.
     */
    public User getUser(String usuario) {
        return data.getUser(usuario);
    }

}
