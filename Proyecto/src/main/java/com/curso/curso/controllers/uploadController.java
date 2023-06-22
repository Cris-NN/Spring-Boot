package com.curso.curso.controllers;

import com.curso.curso.Models.Album;
import com.curso.curso.dao.AlbumDao;
import com.curso.curso.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
@Slf4j
public class uploadController {

    @Autowired
    AlbumDao albumdao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable("imageName") String imageName) throws IOException {

        String externalImagePath = "D:/racin/Escritorio/test/" + imageName;

        Resource imageResource = new FileSystemResource(externalImagePath);

        if (!imageResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(Path.of(externalImagePath));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(imageResource);
    }

    @GetMapping("api/imagen/{id}/{path}")
    public ResponseEntity<Resource> getImages(@PathVariable("id") String id,@PathVariable("path") String path) throws IOException {

        String externalImagePath = "D:/racin/Escritorio/test/" + id + "/" + path;

        Resource imageResource = new FileSystemResource(externalImagePath);

        if (!imageResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(Path.of(externalImagePath));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(imageResource);
    }

    @PostMapping("/api/upload")
    public String handleFileUpload(@RequestPart("file") MultipartFile file, @RequestParam("texto") String texto, @RequestParam("auth") String token) {
        Album album = new Album();
        try {

            String directorio = "D:/racin/Escritorio/test/" + jwtUtil.getKey(token);

            File carpeta = new File(directorio);

            if (!carpeta.exists()) {
                if (carpeta.mkdir()) {
                    System.out.println("Carpeta creada exitosamente.");
                } else {
                    System.out.println("No se pudo crear la carpeta.");
                }
            } else {
                System.out.println("La carpeta ya existe.");
            }


            if (!file.isEmpty()) {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Path filePath = Path.of("D:/racin/Escritorio/test/" + jwtUtil.getKey(token) + "/" + fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                album.setImg(jwtUtil.getKey(token) + "/" + fileName);
                album.setUserID(jwtUtil.getKey(token));
                album.setTexto(texto);

                albumdao.agregarImagen(album);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return "redirect:/subirImagen.html";
        }

        return "redirect:/subirImagen.html";
    }

}