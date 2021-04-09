package ulas.reactivespringdata.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ulas.reactivespringdata.entity.Personel;

public interface PersonelRepo extends ReactiveCrudRepository<Personel, Long> {

    Flux<Personel> findBySoyad(String soyad);
    Flux<Personel> findByAd(String ad);
    Mono<Personel> findById(Long id);

}