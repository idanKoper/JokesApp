package koper.JokesApp.controller;

import koper.JokesApp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    private Random rand = new Random();

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){
        model.addAttribute("joke",jokeService.getJoke());
        model.addAttribute("random",rand.nextInt(1000));
        return "chucknorris";
    }
}