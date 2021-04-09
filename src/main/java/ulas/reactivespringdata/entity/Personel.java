package ulas.reactivespringdata.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
    @Id
    private Long id;

    private  String ad;

    private  String soyad;
}
