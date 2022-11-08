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

import com.tein8.easybus.model.Onibus;
import com.tein8.easybus.service.OnibusService;



@Controller
@RequestMapping("/onibus")
public class OnibusWebController {

    @Autowired
    OnibusService service;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "false") String done){
        List<Onibus> list;
        if(done.equals("true")) {
            list = service.listCheio();
        }else{
            list = service.listNaoCheio();
        }
        return new ModelAndView("onibus/index")
                .addObject("onibuss", list);
    }

    @GetMapping("new")
    public String form(Onibus onibus){
        return "onibus/form";
    }

    @PostMapping
    public String create(@Valid Onibus onibus, BindingResult result, RedirectAttributes redirect){
        if( result.hasErrors() ) return "Onibus/form";
        String message = (onibus.getCdOnibus()==null)?"Tarefa cadastrada com sucesso":"Tarefa atualizada com sucesso";
        service.save(onibus);
        redirect.addFlashAttribute("message", message);
        return "redirect:/onibus";
    }

    @GetMapping("delete/{cdOnibus}")
    public String delete(@PathVariable Long cdOnibus,  RedirectAttributes redirect){
        service.deleteByCdOnibus(cdOnibus);
        redirect.addFlashAttribute("message", "Onibus removido com sucesso");
        return "redirect:/onibus";
    }

    @GetMapping("{cdOnibus}")
    public ModelAndView edit(@PathVariable Long cdOnibus, Onibus onibus){
        onibus = service.getByCdOnibus(cdOnibus).get();
        return new ModelAndView("onibus/form").addObject("onibus", onibus);
    }

    @GetMapping("confirm/{cdOnibus}")
    public ModelAndView concluir(@PathVariable Long cdOnibus, Onibus onibus){
        onibus = service.getByCdOnibus(cdOnibus).get();
        return new ModelAndView("onibus/confirm").addObject("onibus", onibus);
    }
    
}
