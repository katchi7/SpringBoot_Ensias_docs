package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.models.Document;
import com.ensias.Ensias_docs.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    DocumentService documentService;
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable int filename, @RequestParam("download") int download) {

        Document document = documentService.finddocument(filename);


        Resource file = documentService.loadDocument(document);
        if(download==1){
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" +document.getDocName()+ "\"").body(file);
        }
        else
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,document.getDocMime()).header("X-Frame-Options","ALLOW-FROM").body(file);
    }
}
