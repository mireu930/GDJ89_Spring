package com.root.app.users;

import com.root.app.files.FileDTO;

public class UserFileDTO extends FileDTO {
	
	private String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
