package com.splendor.web;

import com.splendor.model.Game;
import com.splendor.service.GameService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/game")
public class GameEndpoint {

    @Inject
    private GameService gameService;

    @GET
    @Path("/createGame")
    @Produces("application/json")
    public Game createNewGame() {
        return gameService.createNewGame("Karl", "Finta", "Perplex");
    }

}