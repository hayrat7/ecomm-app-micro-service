package com.sid.invontory_service;

import com.sid.invontory_service.dao.ProduitRepository;
import com.sid.invontory_service.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InvontoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvontoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(ProduitRepository produitRepository, RepositoryRestConfiguration configuration){
        return args -> {
            configuration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"Apple",8.2,5));
            produitRepository.save(new Produit(null,"Aubergine",5.4,4));
            produitRepository.save(new Produit(null,"Banana",10,3));
            produitRepository.save(new Produit(null,"Cucumber",3.7,3));
            produitRepository.save(new Produit(null,"Garlic",13.8,3));
            produitRepository.save(new Produit(null,"Kiwi",15,3));
            produitRepository.save(new Produit(null,"lemon",4,3));
            produitRepository.save(new Produit(null,"Lettuce",2.5,3));
            produitRepository.save(new Produit(null,"Onions",3.5,3));
            produitRepository.save(new Produit(null,"Pepper",4.5,3));
            produitRepository.save(new Produit(null,"Potato",3,3));
            produitRepository.save(new Produit(null,"Tomato",5,3));
            produitRepository.findAll().forEach(
                    p-> System.out.println(p.toString())
            );
        };
    }
}
