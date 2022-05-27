package be.vdab.biershopteunsnels.controllers;

import be.vdab.biershopteunsnels.services.BierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final BierService bierService;

    public IndexController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        var aantal = bierService.findAantal();
        return new ModelAndView("index", "bieren", aantal);
    }

}
