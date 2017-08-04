package com.example.demo.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.domain.ServerFile;
import com.example.demo.repository.MyFileRepository;
import com.example.demo.service.FileExceptions;
import com.example.demo.service.ServerFileService;






@RestController
@RequestMapping("/file")
public class fileUploadRestController {
	
	@Autowired
	ServerFileService serverFileService;
	/*@Inject
	MyFileRepository myFileRepository;
	*//**
	 *
	 * Upload a file using these url's
	 * Using MultipartHttpServletRequest.
	 * 
	 *//*
	@RequestMapping(value = "/upload/clientFile",method = RequestMethod.POST)
	public List<MyFile> uploadClientFile(MultipartHttpServletRequest request){
		List<MyFile> UDfiles = new ArrayList<MyFile>();
		try {
			Iterator<String> itr = request.getFileNames();
			String rootDir = "D:";
			
			 * Iterate request in case of multiple file uploads
			 * 
			 
			while (itr.hasNext()) {
				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);

				
				 * Get file attributes
				 
				String filename = file.getOriginalFilename();
				Long filesize = file.getSize()/1024;
				String fileLocalPath = rootDir+"/"+filename;
				MyFile UDfile = new MyFile(filename,filesize,fileLocalPath);
				byte[] bytes = file.getBytes();
				
				myFileRepository.saveAndFlush(UDfile);
				FileCopyUtils.copy(bytes, new FileOutputStream(rootDir+"/"+UDfile.getFileName()));

				bytes=FileCopyUtils.copyToByteArray(new FileInputStream(rootDir+"/"+UDfile.getFileName()));
				UDfiles.add(UDfile);
			}
			return UDfiles;
		}
		catch (Exception e) {
			return UDfiles;
		}
	}
	
	
	*//**
	 *
	 * Download a file using these url's
	 * 
	 *//*
	@RequestMapping(value = "/download/clientFile/{uniqueId}", method = RequestMethod.GET)
	public ResponseEntity downloadClientFile(@PathVariable String uniqueId){
		String rootDir = "D:";
		try {
			File folder = new File(rootDir+uniqueId);
			String fnm="";
			for (final File fileEntry : folder.listFiles()) {
				fnm=fileEntry.getName();
			}

			MyFile serverFile = myFileRepository.findByFileUniqueId(uniqueId);

			// No file found based on the supplied filename
			if (serverFile == null) {
				return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
			}

			// Generate the http headers with the file properties
			HttpHeaders headers = new HttpHeaders();		      
			headers.add("content-disposition", "inline; filename=" + serverFile.getFileName());

			// Split the mimeType into primary and sub types
			String primaryType, subType;

			primaryType = serverFile.getFileMimeType().split("/")[0];
			subType = serverFile.getFileMimeType().split("/")[1];
			headers.setContentType( new MediaType(primaryType, subType) );
			return new ResponseEntity<>(new FileSystemResource(rootDir+uniqueId+"/"+fnm), headers, HttpStatus.OK);
		} 
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	/**
	 *
	 * Upload a file using these url's
	 * 
	 * 
	 */
	@RequestMapping(value = "/upload/clientFile",method = RequestMethod.POST)
	public List<ServerFile> uploadClientFile(MultipartHttpServletRequest request){

		
		List<ServerFile> UDfiles = new ArrayList<ServerFile>();

		String rootDir = "D:/watsonFiles/";

		try {
			Iterator<String> itr = request.getFileNames();
			//if(request.getContentLength()==10485760)

			/*
			 * Iterate request in case of multiple file uploads
			 * 
			 */
			while (itr.hasNext()) {
				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);

				/*
				 * Get file attributes
				 */
				String mimeType = file.getContentType();
				String filename = file.getOriginalFilename();
				String filetype = "client";
				Long filesize = file.getSize()/1024; 
				byte[] bytes = file.getBytes();

				/*
				 * Generate random string for folder
				 */
				String fuuid = UUID.randomUUID().toString();
				File f=new File(rootDir+fuuid);
				f.setReadable(true);
				f.setWritable(false);


				String filedownloadurl = "/file/download/clientFile/"+fuuid+"";
				String fileLocalPath = rootDir+fuuid+"/"+filename;
				ServerFile UDfile=new ServerFile(filename,filesize, mimeType,fuuid,filedownloadurl,filetype,fileLocalPath);

				
				boolean b=f.mkdir();

				if(!b)
					throw new FileExceptions("File Upload Exception : while creating a folder");
				else
					System.out.println("Error while uploading");
				//System.out.println("folder created "+b);

				FileCopyUtils.copy(bytes, new FileOutputStream(rootDir+fuuid+"/"+UDfile.getFileName()));

				bytes=FileCopyUtils.copyToByteArray(new FileInputStream(rootDir+fuuid+"/"+UDfile.getFileName()));
				//System.out.println("'uploading");
				serverFileService.uploadFile(UDfile);
				UDfiles.add(UDfile);
			}
			return UDfiles;
		}
		catch (Exception e) {
			return UDfiles;
		}
	}

	/**
	 *
	 * Download a file using these url's
	 * 
	 */
	@RequestMapping(value = "/download/clientFile/{uniqueId}", method = RequestMethod.GET)
	public ResponseEntity downloadClientFile(@PathVariable String uniqueId){
		
		String rootDir = "D:/watsonFiles/";
		try {
			File folder = new File(rootDir+uniqueId);
			String fnm="";
			for (final File fileEntry : folder.listFiles()) {
				fnm=fileEntry.getName();
			}

			ServerFile serverFile = serverFileService.findByFileUniqueId(uniqueId);

			// No file found based on the supplied filename
			if (serverFile == null) {
				return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
			}

			// Generate the http headers with the file properties
			HttpHeaders headers = new HttpHeaders();		      
			headers.add("content-disposition", "inline; filename=" + serverFile.getFileName());

			// Split the mimeType into primary and sub types
			String primaryType, subType;

			primaryType = serverFile.getFileMimeType().split("/")[0];
			subType = serverFile.getFileMimeType().split("/")[1];
			headers.setContentType( new MediaType(primaryType, subType) );
			return new ResponseEntity<>(new FileSystemResource(rootDir+uniqueId+"/"+fnm), headers, HttpStatus.OK);
		} 
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
