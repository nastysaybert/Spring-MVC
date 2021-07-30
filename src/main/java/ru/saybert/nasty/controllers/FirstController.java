package ru.saybert.nasty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.saybert.nasty.CalculationAction;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") CalculationAction action,
                                 Model model){
        double equals;
        String actionSymbol;
        switch (action){
            case addition:
                equals = a + b;
                actionSymbol = " + ";
                break;
            case division:
                equals = a / (double)b;
                actionSymbol = " / ";
                break;
            case subtraction:
                equals = a - b;
                actionSymbol = " - ";
                break;
            case multiplication:
                equals = a * b;
                actionSymbol = " * ";
                break;
            default:
                equals = 0;
                actionSymbol = "undefined";
                break;
        }
        model.addAttribute("result", a + actionSymbol + b + " = " + equals);
        return "first/calculator";
    }
}
