package ulas.reactivespringdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ulas.reactivespringdata.entity.Personel;
import ulas.reactivespringdata.service.PersonelService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personel")
public class PersonelController {

        private final PersonelService personelService;

        @GetMapping("/{id}")
        public Mono<Personel> getPersonelBById(@PathVariable Long id){
            return personelService.getPersonelById(id);
        }

    @GetMapping("/")
    public Flux<Personel> listPersonel(){
        return personelService.getAllPersonel();
    }

    @PostMapping
    public Mono<Personel> savePersonel(@RequestBody Personel personel){
        return personelService.save(personel);
    }
}
