package com.splendor.web;

import com.splendor.model.Game;
import com.splendor.model.Player;
import com.splendor.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pvyletelek on 1/7/2017.
 */
@Controller
public class GameController {

    @Autowired
    private GameService gameService;
    
    @GetMapping("/splendor")
    @ResponseBody
    public String playGame() {
        String s = new Game().toString();
        System.out.println(s);
        return format(s);
    }

    private String format(String s) {
        return s.replace("\n", "<BR/>");
    }
}
