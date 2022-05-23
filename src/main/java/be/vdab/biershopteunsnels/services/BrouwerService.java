package be.vdab.biershopteunsnels.services;


import be.vdab.biershopteunsnels.domain.Brouwer;
import be.vdab.biershopteunsnels.repositories.BrouwerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BrouwerService {

    private final BrouwerRepository brouwerRepository;

    public BrouwerService(BrouwerRepository brouwerRepository) {
        this.brouwerRepository = brouwerRepository;
    }

    public List<Brouwer> findAll() {
        return brouwerRepository.findAll();
    }

    public Optional<Brouwer> findById(long id) {
        return brouwerRepository.findById(id);
    }

}