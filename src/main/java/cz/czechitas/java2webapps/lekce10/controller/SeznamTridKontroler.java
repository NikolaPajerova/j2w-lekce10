package cz.czechitas.java2webapps.lekce10.controller;

import com.sun.xml.bind.v2.model.core.ID;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.service.TridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SeznamTridKontroler {
    private final TridaService tridaService;

    @Autowired
    public SeznamTridKontroler(TridaService tridaService) {
        this.tridaService = tridaService;
    }

    @GetMapping("/")
    public ModelAndView seznamTrid() {
        return new ModelAndView("seznamTrid")
                .addObject("seznam", tridaService.zobrazVse());
    }

    @GetMapping("/{id:[0-9]+}")
    public ModelAndView detail(@PathVariable Integer id) {
        return new ModelAndView("detail")
                .addObject("trida", tridaService.zobrazVybranou(id));
    }

    @GetMapping("/student/{id:[0-9]+}")
    public ModelAndView student(@PathVariable Integer id) {
        return new ModelAndView("student")
                .addObject("student",tridaService.zobrazStudenta(id));
    }

}
