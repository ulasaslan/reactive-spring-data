package ulas.reactivespringdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ulas.reactivespringdata.entity.Personel;
import ulas.reactivespringdata.repository.PersonelRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonelService {

    private final PersonelRepo personelRepo;


    public Mono<Personel> getPersonelById(Long id) {
        return personelRepo.findById(id);
    }

    public Flux<Personel> getAllPersonel() {
        return personelRepo.findAll();
    }

    public Mono<Personel> save(Personel personel) {
        return personelRepo.save(personel);
    }
}
