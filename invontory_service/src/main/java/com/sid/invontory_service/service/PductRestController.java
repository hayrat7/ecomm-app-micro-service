package com.sid.invontory_service.service;

import com.sid.invontory_service.dao.ProduitRepository;
import com.sid.invontory_service.entities.Produit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PductRestController {
    private ProduitRepository produitRepository;

    public PductRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping(path ="/productPic/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id")Long id) throws Exception{
        Produit p=produitRepository.findById(id).get();
        String photoName=p.getName().replaceAll(" ", "") + ".png";
        File file=new File(System.getProperty("user.home")+"/e-comm/products/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
