package edu.eci.cvds.AppRESTful;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ToDoController {

    private GuessGame guessGame = new GuessGame();

    @RequestMapping("/hello")
    //@ResponseBody
    private String hello() {
        return "hello";
    }

    @RequestMapping("/todo/{id}")
    private ModelAndView getUser(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        RestTemplate restTemplate = new RestTemplate();

        ToDo toDo = restTemplate.getForObject(uri, ToDo.class);

        ModelAndView modelAndView = new ModelAndView("toDo");
        modelAndView.addObject("toDo", toDo);

        return modelAndView;
    }

    @GetMapping("/guess")
    public String showGame(Model model) {
        model.addAttribute("Prize", guessGame.getPrize());
        model.addAttribute("Attempts", guessGame.getAttempts());
        return "juego";
    }

    @PostMapping("/makeGuess")
    public String guessNumber(@RequestParam("numero") int numero, Model model) {
        try {
            guessGame.makeGuess(numero);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("Prize", guessGame.getPrize());
        model.addAttribute("Attempts", guessGame.getAttempts());
        return "juego"; // Retorna la vista directamente en lugar de hacer una redirección
    }

    @PostMapping("/reset")
    public String reset() {
        guessGame.reset();
        return "redirect:/guess";
    }
}
