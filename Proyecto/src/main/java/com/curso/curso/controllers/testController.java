package com.curso.curso.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class testController {
/*
    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable("imageName") String imageName) throws IOException {
        // Obtener la ruta de la imagen externa
        String externalImagePath = "D:/racin/Escritorio/test/" + imageName;

        // Crear un recurso de Spring para la imagen externa
        Resource imageResource = new FileSystemResource(externalImagePath);

        // Verificar si el recurso existe
        if (!imageResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Obtener el tipo de contenido de la imagen
        String contentType = Files.probeContentType(Path.of(externalImagePath));

        // Crear la respuesta con el recurso y el tipo de contenido
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(imageResource);
    }*/
}
