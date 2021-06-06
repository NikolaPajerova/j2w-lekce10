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
    private final TridaRepository tridaRepository;

    @Autowired
    public SeznamTridKontroler(TridaService tridaService, TridaRepository tridaRepository) {
        this.tridaService = tridaService;
        this.tridaRepository = tridaRepository;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznamTrid")
                .addObject("seznam", tridaService.zobrazVse());
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id) {
        Optional<Trida> trida = tridaRepository.findById(id);
        if (trida.isPresent()) {
            return new ModelAndView("detail")
                    .addObject("trida", trida.get());
        }
        return null;
    }

}
