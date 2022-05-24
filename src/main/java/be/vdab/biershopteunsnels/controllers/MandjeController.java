package be.vdab.biershopteunsnels.controllers;


import be.vdab.biershopteunsnels.forms.AantalForm;
import be.vdab.biershopteunsnels.forms.PersoonsGegevens;
import be.vdab.biershopteunsnels.services.BestelService;
import be.vdab.biershopteunsnels.services.BierService;
import be.vdab.biershopteunsnels.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class MandjeController {

//    private PersoonsGegevens persoonsGegevens = new PersoonsGegevens(null, null, null, 0, null);

    private long bestelId;
    private final BestelService bestelService;

    private final Mandje mandje;
    private final BierService bierService;

    public MandjeController(BestelService bestelbonService, Mandje mandje, BierService bierService) {
        this.bestelService = bestelbonService;
        this.mandje = mandje;
        this.bierService = bierService;
    }

//    public PersoonsGegevens getPersoonsGegevens() {
//        return persoonsGegevens;
//    }

    @PostMapping("/mandje/{id}")
    public String voegToe(@PathVariable long id, AantalForm aantal) {
        var bier = bierService.findByBierId(id).get();
        mandje.voegToe(bier.getNaam(),bier.getPrijs(), aantal.aantal(), bier.getId());
        return "redirect:/mandje";
    }

    @GetMapping("mandje")
    public ModelAndView toonMandje() {
        ModelAndView modelAndView = new ModelAndView("mandje", "mandje",
            mandje.getItems());
        BigDecimal totalePrijs = mandje.getTotaal();
        modelAndView.addObject("totalePrijs", totalePrijs);
        modelAndView.addObject("persoonsGegevens",new PersoonsGegevens(null, null, null,
                null, null));
//               bierService.findByIds(mandje.getItems().stream().map(MandjeItems::getBierId).collect(Collectors.toSet())));
//        modelAndView.addObject("mandje", mandje);
        return modelAndView;
    }

    @RequestMapping("/bestelBevestiging")
    public ModelAndView id () {
        return new ModelAndView("bestelBevestiging", "id", bestelId);
    }

    @PostMapping("/bestelBevestiging")
    public String BestelBonMaken(PersoonsGegevens persoonsGegevens) {
        System.err.println("works");
        bestelId = bestelService.createBestelling(persoonsGegevens, mandje);
        return "redirect:/bestelBevestiging";
    }
}