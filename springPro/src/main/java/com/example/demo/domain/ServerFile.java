package com.example.demo.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * A ServerFile.
 */
@Entity
@Table(name = "server_file")


public class ServerFile  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "file_mime_type")
    private String fileMimeType;

    @Column(name = "file_encoding")
    private String fileEncoding;

    @Column(name = "file_access_type")
    private String fileAccessType;

    @Column(name = "file_download_url")
    private String fileDownloadUrl;

    @Column(name = "file_unique_id")
    private String fileUniqueId;

    @Column(name = "file_uploaded_by")
    private String fileUploadedBy;

    @Column(name = "file_uploaded_date")
    private ZonedDateTime fileUploadedDate;

    @Column(name = "file_last_downloaded_by")
    private String fileLastDownloadedBy;

    @Column(name = "file_last_downloaded_date")
    private ZonedDateTime fileLastDownloadedDate;

    @Column(name = "file_local_path")
    private String fileLocalPath;

    @Column(name = "document_type")
    private String documentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public ServerFile fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public ServerFile fileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public ServerFile fileSize(Long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public ServerFile fileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
        return this;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public String getFileEncoding() {
        return fileEncoding;
    }

    public ServerFile fileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
        return this;
    }

    public void setFileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
    }

    public String getFileAccessType() {
        return fileAccessType;
    }

    public ServerFile fileAccessType(String fileAccessType) {
        this.fileAccessType = fileAccessType;
        return this;
    }

    public void setFileAccessType(String fileAccessType) {
        this.fileAccessType = fileAccessType;
    }

    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }

    public ServerFile fileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
        return this;
    }

    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }

    public String getFileUniqueId() {
        return fileUniqueId;
    }

    public ServerFile fileUniqueId(String fileUniqueId) {
        this.fileUniqueId = fileUniqueId;
        return this;
    }

    public void setFileUniqueId(String fileUniqueId) {
        this.fileUniqueId = fileUniqueId;
    }

    public String getFileUploadedBy() {
        return fileUploadedBy;
    }

    public ServerFile fileUploadedBy(String fileUploadedBy) {
        this.fileUploadedBy = fileUploadedBy;
        return this;
    }

    public void setFileUploadedBy(String fileUploadedBy) {
        this.fileUploadedBy = fileUploadedBy;
    }

    public ZonedDateTime getFileUploadedDate() {
        return fileUploadedDate;
    }

    public ServerFile fileUploadedDate(ZonedDateTime fileUploadedDate) {
        this.fileUploadedDate = fileUploadedDate;
        return this;
    }

    public void setFileUploadedDate(ZonedDateTime fileUploadedDate) {
        this.fileUploadedDate = fileUploadedDate;
    }

    public String getFileLastDownloadedBy() {
        return fileLastDownloadedBy;
    }

    public ServerFile fileLastDownloadedBy(String fileLastDownloadedBy) {
        this.fileLastDownloadedBy = fileLastDownloadedBy;
        return this;
    }

    public void setFileLastDownloadedBy(String fileLastDownloadedBy) {
        this.fileLastDownloadedBy = fileLastDownloadedBy;
    }

    public ZonedDateTime getFileLastDownloadedDate() {
        return fileLastDownloadedDate;
    }

    public ServerFile fileLastDownloadedDate(ZonedDateTime fileLastDownloadedDate) {
        this.fileLastDownloadedDate = fileLastDownloadedDate;
        return this;
    }

    public void setFileLastDownloadedDate(ZonedDateTime fileLastDownloadedDate) {
        this.fileLastDownloadedDate = fileLastDownloadedDate;
    }

    public String getFileLocalPath() {
        return fileLocalPath;
    }

    public ServerFile fileLocalPath(String fileLocalPath) {
        this.fileLocalPath = fileLocalPath;
        return this;
    }

    public void setFileLocalPath(String fileLocalPath) {
        this.fileLocalPath = fileLocalPath;
    }

    public String getDocumentType() {
        return documentType;
    }

    public ServerFile documentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerFile serverFile = (ServerFile) o;
        if (serverFile.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, serverFile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
    public ServerFile(){
    	
    }
	public ServerFile(String filename2, Long filesize2, String mimeType, String fuuid, String filedownloadurl2,
			String filetype2, String fileLocalPath2) {
		// TODO Auto-generated constructor stub
		this.fileName = filename2;
		this.fileSize = filesize2;
		this.fileMimeType = mimeType;
		this.fileUniqueId = fuuid;
		this.fileDownloadUrl = filedownloadurl2;
		this.fileType = filetype2;
		this.fileLocalPath = fileLocalPath2;
	}

    @Override
    public String toString() {
        return "ServerFile{" +
            "id=" + id +
            ", fileName='" + fileName + "'" +
            ", fileType='" + fileType + "'" +
            ", fileSize='" + fileSize + "'" +
            ", fileMimeType='" + fileMimeType + "'" +
            ", fileEncoding='" + fileEncoding + "'" +
            ", fileAccessType='" + fileAccessType + "'" +
            ", fileDownloadUrl='" + fileDownloadUrl + "'" +
            ", fileUniqueId='" + fileUniqueId + "'" +
            ", fileUploadedBy='" + fileUploadedBy + "'" +
            ", fileUploadedDate='" + fileUploadedDate + "'" +
            ", fileLastDownloadedBy='" + fileLastDownloadedBy + "'" +
            ", fileLastDownloadedDate='" + fileLastDownloadedDate + "'" +
            ", fileLocalPath='" + fileLocalPath + "'" +
            ", documentType='" + documentType + "'" +
            '}';
    }
}
