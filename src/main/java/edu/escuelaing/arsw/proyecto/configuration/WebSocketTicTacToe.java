package edu.escuelaing.arsw.proyecto.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This class is a Spring configuration class that enables the use of WebSocket message broker.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketTicTacToe implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/events"); //Donde recibo mensajes del servidor
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/tictactoe").setAllowedOriginPatterns("*").withSockJS();

    }

}