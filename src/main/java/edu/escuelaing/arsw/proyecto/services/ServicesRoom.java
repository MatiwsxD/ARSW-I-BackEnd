package edu.escuelaing.arsw.proyecto.services;

import edu.escuelaing.arsw.proyecto.model.User;
import edu.escuelaing.arsw.proyecto.persistence.AutentificationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
/**
 * A class that is used to create a room.
 */
public class ServicesRoom {
    AutentificationLogin data = new AutentificationLogin();
    private Map<String, Integer> rooms = new HashMap<String, Integer>();
    private boolean isInit = false;

    /**
     * It creates and inicializate the rooms
     */
    public void initServicesRoom() {
        rooms.put("A", 0);
        rooms.put("B", 0);
        rooms.put("C", 0);
        rooms.put("D", 0);
        rooms.put("E", 0);
        rooms.put("F", 0);
        rooms.put("G", 0);

    }

    /**
     * It returns the number of players in a room
     * 
     * @param sala The room name
     * @return The number of players in the room.
     */
    public Integer playersInRoom(String sala) {
        return rooms.get(sala);

    }

    /**
     * It resets the value of a room to 0
     * 
     * @param sala The room name
     */
    public void resetSala(String sala) {
        rooms.replace(sala, 0);
    }

    /**
     * It checks if the room exists, if it does, it checks if there are less than 2
     * people in the room, if
     * there are, it increments the number of people in the room by 1, if there
     * aren't, it returns false.
     * If the room doesn't exist, it creates it and adds 1 person to it
     * 
     * @param sala the name of the room
     * @return A boolean value.
     */

    public boolean createRoom(String sala) {
        boolean flag = false;
        if (!isInit) {
            initServicesRoom();
            isInit = true;
        }
        if (rooms.containsKey(sala) && rooms.get(sala) < 2) {
            Integer temp = rooms.get(sala);
            rooms.replace(sala, temp + 1);
            flag = true;
        } else if (!rooms.containsKey(sala)) {
            rooms.put(sala, 1);
            flag = true;
        }
        return flag;
    }

    /**
     * It returns a user object from the data class
     * 
     * @param correo email
     * @return The user object.
     */

    public User getPerfil(String correo) {
        return data.getUser(correo);
    }

    /**
     * It takes a String as a parameter and calls the actualizarWinner method in the
     * data class
     * 
     * @param correo email
     */
    public void addWinn(String correo) {
        data.actualizarWinner(correo);
    }

    /**
     * It updates the loser column of the user with the email passed as a parameter
     * 
     * @param correo email of the user
     */
    public void addLoser(String correo) {
        data.actualizarLoser(correo);
    }

}
