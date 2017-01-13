package com.splendor.web;

import com.splendor.model.Game;
import com.splendor.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/hello")
public class Endpoint {

    @Autowired
    private GameService gameService;

    @GET
    @Produces("application/json")
    public Game message() {
        return gameService.startNewGame();
    }

}