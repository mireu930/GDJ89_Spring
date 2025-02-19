package com.root.app.accounts;

import java.sql.Date;

public class AccountDTO {
	private String accountNum;
	private Long productNum;
	private String user_name;
	private Long accountsBalance;
	private Date accountDate;
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Long getAccountsBalance() {
		return accountsBalance;
	}
	public void setAccountsBalance(Long accountsBalance) {
		this.accountsBalance = accountsBalance;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
	
}
