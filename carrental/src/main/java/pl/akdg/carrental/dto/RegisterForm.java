package pl.akdg.carrental.dto;

import javax.validation.constraints.Size;

public class RegisterForm {
	@Size(min=5, max=50)
	private String nickname;
	@Size(min=5, max=200)
	private String password;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
