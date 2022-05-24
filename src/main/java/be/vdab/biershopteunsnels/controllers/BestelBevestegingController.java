//package be.vdab.biershopteunsnels.controllers;
//
//import be.vdab.biershopteunsnels.forms.PersoonsGegevens;
//import be.vdab.biershopteunsnels.services.BestelService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("bestelBevestiging")
//public class BestelBevestegingController {
//
//    private final MandjeController mandjeController;
//    public final BestelService bestelbonService;
//
//    public BestelBevestegingController(MandjeController mandjeController, BestelService bestelbonService) {
//        this.mandjeController = mandjeController;
//        this.bestelbonService = bestelbonService;
//    }
//
//    @RequestMapping()
//    public ModelAndView id () {
//        return new ModelAndView("bestelBevestiging", "id", 5);
//    }
//
//    @PostMapping()
//    public String BestelBonMaken(PersoonsGegevens persoonsGegevens) {
//        System.err.println("works");
//        bestelbonService.createBestelling(persoonsGegevens);
//        return "redirect:/bestelBevestiging";
//    }
//}