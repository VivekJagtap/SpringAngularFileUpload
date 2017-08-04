package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ServerFile;
import com.example.demo.repository.MyFileRepository;







@Service
public class ServerFileService {
		@Autowired
		MyFileRepository myFileRepository;

	    // Retrieve file
	    public ServerFile findByFileUniqueId(String fileUniqueId) {
	        return myFileRepository.findByFileUniqueId(fileUniqueId);
	    }
	    
	    
	    /*
	     *  public void uploadFile(LinkedList<FileUpload> files) {
	        fileUploadRepository.save(files);
	    }
	     * */

	    // Upload the file
	    public void uploadFile(ServerFile newFile) {
	    	myFileRepository.saveAndFlush(newFile);
	    }
}
