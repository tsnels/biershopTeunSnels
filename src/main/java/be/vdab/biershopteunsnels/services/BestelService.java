package be.vdab.biershopteunsnels.services;


import be.vdab.biershopteunsnels.forms.PersoonsGegevens;
import be.vdab.biershopteunsnels.repositories.BestelRepository;
import be.vdab.biershopteunsnels.sessions.Mandje;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)

public class BestelService {

    BestelRepository bestelRepository;

    public BestelService(BestelRepository bestelbonRepository) {
        this.bestelRepository = bestelbonRepository;
    }

    @Transactional(readOnly = false)
    public long createBestelling (PersoonsGegevens persoonsGegevens, Mandje mandje) {

        long id = (bestelRepository.createBestelBon(persoonsGegevens));
        mandje.getItems().forEach(item -> {
            bestelRepository.createBestelbonlijnen(item, id);
        });
        mandje.emptyList();
    return id;
    }
}