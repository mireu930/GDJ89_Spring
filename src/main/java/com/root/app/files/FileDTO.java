package com.root.app.files;

public class FileDTO {
	
	private String fileName;
	private String oldName;
	
	public String getFileName() {
		if(fileName ==null) {
			this.fileName ="default.jpg";
		}
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	
	
}
