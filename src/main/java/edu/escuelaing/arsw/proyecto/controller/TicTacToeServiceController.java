package edu.escuelaing.arsw.proyecto.controller;

import edu.escuelaing.arsw.proyecto.services.ServicesLogin;
import edu.escuelaing.arsw.proyecto.services.ServicesRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It's a controller class that has two autowired services.
 */
@RestController
@RequestMapping(value = "/tictac")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class TicTacToeServiceController {

    @Autowired
    ServicesLogin serviciosLogin;
    @Autowired
    ServicesRoom serviciosSala;

    /**
     * It takes a username, email and password from the URL and then calls a
     * function in a service class
     * that creates a new user in the database
     * 
     * @param usuario  String
     * @param correo   email
     * @param password String
     * @return A ResponseEntity object.
     */
    @PostMapping("/registry/{usuario}/{correo}/{password}")
    public ResponseEntity<?> registerPlayer(@PathVariable(value = "usuario") String usuario,
            @PathVariable(value = "correo") String correo, @PathVariable(value = "password") String password) {
        serviciosLogin.registrarPlayer(usuario, correo, password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * It takes a correo and a password, and returns a ResponseEntity with the
     * result of the loginPlayer
     * function
     * 
     * @param correo     String
     * @param contraseña String
     * @return A ResponseEntity with the status code of ACCEPTED.
     */
    @GetMapping("/login/{correo}/{password}")
    public ResponseEntity<?> loginPlayer(@PathVariable(value = "correo") String correo,
            @PathVariable(value = "password") String contraseña) {

        return new ResponseEntity<>(serviciosLogin.loginPlayer(correo, contraseña), HttpStatus.ACCEPTED);

    }

    /**
     * It gets the user's profile from the database
     * 
     * @param correo String
     * @return A ResponseEntity object.
     */
    @GetMapping("/getUser/{correo}")
    public ResponseEntity<?> getUser(@PathVariable(value = "correo") String correo) {
        return new ResponseEntity<>(serviciosSala.getPerfil(correo), HttpStatus.ACCEPTED);

    }

    /**
     * It checks if the user is registered in the database
     * 
     * @param correo String
     * @return A ResponseEntity object.
     */
    @GetMapping("/checkUser/{correo}")
    public ResponseEntity<?> loginPlayer(@PathVariable(value = "correo") String correo) {
        return new ResponseEntity<>(serviciosLogin.estaRegistrado(correo), HttpStatus.ACCEPTED);

    }

    /**
     * It returns a list of players in a room
     * 
     * @param sala the name of the room
     * @return A list of players in the room.
     */
    @GetMapping("/players/{sala}")
    public ResponseEntity<?> introducirEnSala(@PathVariable(value = "sala") String sala) {
        return new ResponseEntity<>(serviciosSala.playersInRoom(sala), HttpStatus.ACCEPTED);
    }

    /**
     * It creates a room with the name of the parameter passed to the function
     * 
     * @param sala The name of the room to be created.
     * @return A ResponseEntity object.
     */
    @GetMapping("createRoom/{sala}")
    public ResponseEntity<?> crearSala(@PathVariable("sala") String sala) {
        return new ResponseEntity<>(serviciosSala.createRoom(sala), HttpStatus.ACCEPTED);
    }

    /**
     * It resets the room, and returns a response entity with the status code of
     * accepted
     * 
     * @param sala The name of the room
     * @return A ResponseEntity object.
     */

    @PostMapping("/resetRoom/{sala}")
    public ResponseEntity<?> resetRoom(@PathVariable("sala") String sala) {
        serviciosSala.resetSala(sala);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * It takes a string as a parameter and returns a response entity with a status
     * of accepted
     * 
     * @param correo the email of the user who won the game
     * @return A ResponseEntity object.
     */

    @PostMapping("Winner/{correo}")
    public ResponseEntity<?> addWinner(@PathVariable("correo") String correo) {
        serviciosSala.addWinn(correo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * It takes a string as a parameter and returns a response entity with a status
     * code of 202
     * 
     * @param correo the email of the user
     * @return A ResponseEntity object.
     */
    @PostMapping("Loser/{correo}")
    public ResponseEntity<?> addLoser(@PathVariable("correo") String correo) {
        serviciosSala.addLoser(correo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
