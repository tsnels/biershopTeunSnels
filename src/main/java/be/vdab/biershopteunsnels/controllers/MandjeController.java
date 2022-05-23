package be.vdab.biershopteunsnels.controllers;


import be.vdab.biershopteunsnels.domain.MandjeItems;
import be.vdab.biershopteunsnels.forms.AantalForm;
import be.vdab.biershopteunsnels.forms.PersoonsGegevens;
import be.vdab.biershopteunsnels.services.BierService;
import be.vdab.biershopteunsnels.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Controller
@RequestMapping("mandje")
public class MandjeController {

    private final Mandje mandje;
    private final BierService bierService;

    public MandjeController(Mandje mandje, BierService bierService) {
        this.mandje = mandje;
        this.bierService = bierService;
    }

    @PostMapping("{id}")
    public String voegToe(@PathVariable long id, AantalForm aantal) {
        var bier = bierService.findByBierId(id).get();
        mandje.voegToe(bier.getNaam(),bier.getPrijs(), aantal.aantal());
        return "redirect:/mandje";
    }

    @GetMapping
    public ModelAndView toonMandje() {
        ModelAndView modelAndView = new ModelAndView("mandje", "mandje",
            mandje.getItems());
        BigDecimal totalePrijs = mandje.getTotaal();
        modelAndView.addObject("totalePrijs", totalePrijs);
        modelAndView.addObject("persoonsGegevens",new PersoonsGegevens(null, null, null, 0, null));
//               bierService.findByIds(mandje.getItems().stream().map(MandjeItems::getBierId).collect(Collectors.toSet())));
//        modelAndView.addObject("mandje", mandje);
        return modelAndView;
    }

    @PostMapping()
    public String oke() {
        return "redirect:/mandje/bevestigd";
    }

    @GetMapping("bevestigd")
    public ModelAndView bevestiging(){
        return new ModelAndView("mandje", "bevestiging", "gelukt");
    }
}
