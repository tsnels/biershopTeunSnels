package be.vdab.biershopteunsnels.controllers;

import be.vdab.biershopteunsnels.forms.AantalForm;
import be.vdab.biershopteunsnels.services.BierService;
import be.vdab.biershopteunsnels.services.BrouwerService;
import be.vdab.biershopteunsnels.sessions.Bestelling;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("bier")
public class BierController {

    private final BrouwerService brouwerService;
    private final BierService bierService;
    private final Bestelling bestelling;

    public BierController(BrouwerService brouwerService, BierService bierService, Bestelling bestelling) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
        this.bestelling = bestelling;
    }

    @GetMapping("{id}")
    public ModelAndView findDetails(@PathVariable long id) {
        var modelAndView = new ModelAndView("bier");
        modelAndView.addObject("bierDetails", bierService.findByBierId(id).stream().findFirst().get());
//        modelAndView.addObject(new Aantal(0));
        return modelAndView;
    }

    @PostMapping("{id}")
    public ModelAndView bier(@Valid AantalForm form, Errors errors) {
        if (errors.hasErrors()) {
            return new ModelAndView("bierDetails").addObject();
        }
        bestelling.setAantal(form.aantal());
        return new ModelAndView("redirect:/");
    }

//    @GetMapping("aantal/from")
//    public ModelAndView aantalForm() {
//        return new ModelAndView("aantal");
//    }

}
