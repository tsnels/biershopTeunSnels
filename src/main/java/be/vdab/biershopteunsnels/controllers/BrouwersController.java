package be.vdab.biershopteunsnels.controllers;

import be.vdab.biershopteunsnels.services.BierService;
import be.vdab.biershopteunsnels.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("brouwers")
public class BrouwersController {

    private final BrouwerService brouwerService;
    private final BierService bierService;

    public BrouwersController(BrouwerService brouwerService, BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("brouwers", "alleBrouwers", brouwerService.findAll());
    }

    @GetMapping("{id}")
    public ModelAndView findById(@PathVariable long id) {
        var brouwer = brouwerService.findById(id).stream().findFirst().get();
        var bieren = bierService.findByBrouwerId(brouwer.getId());
        var modelAndView = new ModelAndView("brouwer");
        modelAndView.addObject("brouwer", brouwer);
        modelAndView.addObject("bieren", bieren);
        return modelAndView;
    }

}