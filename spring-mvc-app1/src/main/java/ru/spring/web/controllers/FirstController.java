package ru.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        System.out.println(name + " " + surname );
        model.addAttribute("message","Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "op") String op,
                                 Model model){

        switch (op) {
            case "add":
                model.addAttribute("calc_answer", a+b);
                break;
            case "sub":
                model.addAttribute("calc_answer", a-b);
                break;
            case "mul":
                model.addAttribute("calc_answer", a*b);
                break;
            case "div":
                model.addAttribute("calc_answer", a/b);
                break;
        }
        return "first/calc";
    }
}
