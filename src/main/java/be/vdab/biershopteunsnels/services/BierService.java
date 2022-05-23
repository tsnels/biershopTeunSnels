package be.vdab.biershopteunsnels.services;

import be.vdab.biershopteunsnels.domain.Bier;
import be.vdab.biershopteunsnels.domain.Brouwer;
import be.vdab.biershopteunsnels.domain.NaarWinkelwagen;
import be.vdab.biershopteunsnels.repositories.BierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class BierService {

    private final BierRepository bierRepository;

    public BierService(BierRepository bierRepository) {
        this.bierRepository = bierRepository;
    }

    public long findAantal() {
        return bierRepository.findAantal();
    }

    public List<Bier> findByBrouwerId(long id) {
        return bierRepository.findByBrouwerId(id);
    }

    public Optional<Bier> findByBierId(long id) { return bierRepository.findByBierId(id); }

    public List<Bier> findByIds(Set<Long> ids) {
        return bierRepository.findByIds(ids);
    }

//    public void create(){
//        bierRepository.create();
//    }
}