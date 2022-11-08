package com.tein8.easybus.controller.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tein8.easybus.model.User;
import com.tein8.easybus.service.UserService;



@Controller
@RequestMapping("/user")
public class UserWebController {

    @Autowired
    UserService service;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "false") String done){
        List<User> list;
        list = service.listAll();
        return new ModelAndView("user/index")
                .addObject("users", list);
    }


    @GetMapping("new")
    public String form(User user){
        return "user/form";
    }

    @PostMapping
    public String create(@Valid User user, BindingResult result, RedirectAttributes redirect){
        if( result.hasErrors() ) return "user/form";
        String message = (user.getId()==null)?"Usuário cadastrado com sucesso":"Usuário atualizado com sucesso";
        service.save(user);
        redirect.addFlashAttribute("message", message);
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id,  RedirectAttributes redirect){
        service.deleteById(id);
        redirect.addFlashAttribute("message", "Usuário apagado com sucesso");
        return "redirect:/user";
    }

    @GetMapping("{id}")
    public ModelAndView edit(@PathVariable Long id, User user){
        user = service.getById(id).get();
        return new ModelAndView("user/form").addObject("user", user);

    }
    
}
