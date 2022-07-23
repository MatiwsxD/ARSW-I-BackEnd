package edu.escuelaing.arsw.proyecto.persistence;

import edu.escuelaing.arsw.proyecto.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It's a class that extends ConexionSQL, and has a method called login.
 */
public class AutentificationLogin extends ConexionSQL {
    java.sql.Statement st;
    ResultSet rs;

    /**
     * It connects to a database, then it checks if the user exists and if the
     * password is correct
     * 
     * @param correo     email
     * @param contraseña password
     * @return A boolean value.
     */
    public boolean getUserLogin(String correo, String contraseña) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next() && rs.getString("password").equals(contraseña)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            // System.out.println("no se encontro registro");
            return false;
        }

    }

    /**
     * It connects to the database, creates a statement, and executes the query
     * 
     * @param user is the object that contains the data to be inserted into the
     *             database.
     */
    public void insertar(User user) {
        try {

            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into registro(usernames,correo,password,pganadas,pperdidas) values('" + user.getName()
                    + "','" + user.getCorreo() + "','" + user.getPassword() + "','" + user.getpGanadas() + "','"
                    + user.getpPerdidas() + "');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * It gets the user's information from the database and returns it
     * 
     * @param correo email
     * @return The userInfo object is being returned.
     */
    public User getUser(String correo) {
        User userInfo = new User();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                userInfo.setName(rs.getString("usernames"));
                userInfo.setpGanadas(Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(Integer.valueOf(rs.getString("pperdidas")));
            } else {
                userInfo.setName("No value");
            }

            return userInfo;
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            // System.out.println("no se encontro registro");
            return userInfo;
        }

    }

    /**
     * It checks if a user is registered in the database
     * 
     * @param correo email
     * @return A boolean value.
     */

    public boolean isRegister(String correo) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
            // System.out.println("no se encontro registro");
            return false;
        }

    }

    /**
     * It takes a string as a parameter, and then it updates the database with the
     * new information
     * 
     * @param correo email
     */
    public void actualizarWinner(String correo) {
        User userInfo = new User();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                userInfo.setName(rs.getString("usernames"));
                userInfo.setCorreo(rs.getString("correo"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setpGanadas(1 + Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(Integer.valueOf(rs.getString("pperdidas")));
                String sql2 = "delete from registro where correo='" + correo + "'; ";
                st.executeUpdate(sql2);
                insertar(userInfo);

            }
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * It takes a string as a parameter, connects to a database, queries the
     * database, and then updates the
     * database
     * 
     * @param correo email
     */
    public void actualizarLoser(String correo) {
        User userInfo = new User();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from registro where correo='" + correo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                userInfo.setName(rs.getString("usernames"));
                userInfo.setCorreo(rs.getString("correo"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setpGanadas(Integer.valueOf(rs.getString("pganadas")));
                userInfo.setpPerdidas(1 + Integer.valueOf(rs.getString("pperdidas")));
                String sql2 = "delete from registro where correo='" + correo + "'; ";
                st.executeUpdate(sql2);
                insertar(userInfo);

            }
        } catch (Exception e) {
            Logger.getLogger(AutentificationLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}