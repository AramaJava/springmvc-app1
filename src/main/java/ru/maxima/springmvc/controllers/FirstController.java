package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author AramaJava 25.07.2023
 */
@Controller
@RequestMapping("/first")
public class FirstController {

/*
    Сделать калькулятор, который будет принимать в качестве
    аргументов запроса две переменные и вид операции и
    будет возвращать пользователю результат математической операции в виде html - страницы
 */
    @GetMapping("/calculator")
    public String calc(@RequestParam("a") int a,
                       @RequestParam("b") int b,
                       @RequestParam("operation") String operation,
                       Model model) {

        //System.out.println("Hello, " + name + " " + surname);

        double result = switch (operation) {
            case "mul" -> a * b;
            case "div" -> a / (double) b;
            case "sub" -> a - b;
            case "add" -> a + b;
            default -> 0;
        };

        model.addAttribute("result", result);
        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }


}
