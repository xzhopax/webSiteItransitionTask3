package com.dampcave.websiteitransitiontask3.controllers;



import com.dampcave.websiteitransitiontask3.models.People;
import com.dampcave.websiteitransitiontask3.repositoryes.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PeopleController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/peoples")
    public String allUsers(Model model){
        Iterable<People> people = userRepository.findAll();
        model.addAttribute("people", people);
        return "peoples";
    }



    @GetMapping("/people/add")
    public String usersAdd(Model model){
        return "people-add";
    }

    @PostMapping("/people/add")
    public String newUserAdd(@RequestParam String name, @RequestParam String email,
                              Model model){
        People people = new People(name, email);
        userRepository.save(people);

        return "redirect:/peoples";
    }

    @GetMapping("/people/{id}")
    public String userDetails(@PathVariable(value = "id") int id, Model model){
        if (!userRepository.existsById(id)){
            return "redirect:/peoples";
        }
        Optional<People> people = userRepository.findById(id);
        ArrayList<People> res = new ArrayList<>();
        people.ifPresent(res::add);
        model.addAttribute("people", res);
        return "people-details";
    }

    @GetMapping("/people/{id}/update")
    public String userGetUpdate(@PathVariable(value = "id") int id, Model model){
        if (!userRepository.existsById(id)){
            return "redirect:/people";
        }
        Optional<People> people = userRepository.findById(id);
        ArrayList<People> res = new ArrayList<>();
        people.ifPresent(res::add);
        model.addAttribute("people", res);
        return "people-update";
    }

    @PostMapping("/people/{id}/update")
    public String userUpdate(@PathVariable(value = "id") int id, @RequestParam String name,
                                 @RequestParam String email,Model model){
        People people = userRepository.findById(id).orElseThrow();
        people.setName(name);
        people.setEmail(email);
        userRepository.save(people);
        return "redirect:/peoples";
    }

    @PostMapping("/people/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") int id,Model model){
        People people = userRepository.findById(id).orElseThrow();
        userRepository.delete(people);
        return "redirect:/peoples";
    }

    @PostMapping("/people/deleteall")
    public String deleteAllUsers(){
        userRepository.deleteAll();
        return "redirect:/peoples";
    }
}
