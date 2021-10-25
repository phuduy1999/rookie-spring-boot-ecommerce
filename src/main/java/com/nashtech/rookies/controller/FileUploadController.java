package com.nashtech.rookies.controller;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.storage.StorageService;
import com.nashtech.rookies.util.UriPathUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = UriPathUtil.uri)
public class FileUploadController {

    private final StorageService storageService;

    @GetMapping("/")
    public void listUploadedFiles() throws IOException {

        storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList());
    }

    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> handleFileUpload(@RequestPart("file") MultipartFile file, @RequestPart("category") CategoryDto categoryDto) {
        String destinationFileName = storageService.store(file); // save db
        return ResponseEntity.ok().body(destinationFileName+categoryDto.toString());
    }

}
