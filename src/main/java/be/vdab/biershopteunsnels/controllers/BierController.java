package be.vdab.biershopteunsnels.controllers;

import be.vdab.biershopteunsnels.forms.AantalForm;
import be.vdab.biershopteunsnels.services.BierService;
import be.vdab.biershopteunsnels.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("bier")
public class BierController {

    private final BrouwerService brouwerService;
    private final BierService bierService;


    public BierController(BrouwerService brouwerService, BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }

    @GetMapping("{id}")
    public ModelAndView findDetails(@PathVariable long id) {
        var modelAndView = new ModelAndView("bier");
        modelAndView.addObject("bierDetails", bierService.findByBierId(id).stream().findFirst().get());
        modelAndView.addObject("aantal", new AantalForm(2));
        return modelAndView;
    }

//    @GetMapping("")

//    @PostMapping
//    public String toevoegen(@Valid NaarWinkelwagen naarWinkelwagen, Errors errors, RedirectAttributes redirect) {
//        if (errors.hasErrors()) {
//            return "";
//        }
//        redirect.addAttribute("toegevoegd").addAttribute(bierService.create());
//    }

//    @PostMapping("/mandje")
//    public String bier(@Valid AantalForm form, Errors errors) {
//        if (errors.hasErrors()) {
//            return "redirect:/mandje";
//        }
//        bestelling.setAantal(form.aantal());
//        return "redirect:/mandje";
//    }

//    @GetMapping("{id}")
//    public ModelAndView aantalForm(@PathVariable long id) {
//        return new ModelAndView("aantal").addObject(new AantalForm(2));
//    }

}
