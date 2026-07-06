package com.jpa.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.test.helper.FileUploadHelper;

@RestController
public class FileController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.isEmpty());
//		System.out.println(file.getSize());
		
		//validation
		
		try {
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		//
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File must be a Jpeg");
		}
		
		
		// file upload code...
		
		boolean f = fileUploadHelper.uploadFile(file);
		if(f) {
			return ResponseEntity.ok("file is successfully uploaded");
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again!");
	}
}
