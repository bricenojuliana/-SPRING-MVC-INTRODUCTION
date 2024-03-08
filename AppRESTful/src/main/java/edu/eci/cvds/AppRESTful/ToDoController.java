package edu.eci.cvds.AppRESTful;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoController {
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
}
