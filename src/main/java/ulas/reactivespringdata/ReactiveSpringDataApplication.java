package ulas.reactivespringdata;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import ulas.reactivespringdata.entity.Personel;
import ulas.reactivespringdata.repository.PersonelRepo;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class ReactiveSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveSpringDataApplication.class, args);
    }

    @Bean
    ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                //.genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public CommandLineRunner demo(@Autowired PersonelRepo repository) {

        return (args) -> {
            repository.saveAll(Arrays.asList(
                    new Personel(1L,"Jack", "Bauer"),
                    new Personel(2L,"Chloe", "O'Brian"),
                    new Personel(3L,"Kim", "Bauer")
                    ))
                    ;

        };
    }


}
