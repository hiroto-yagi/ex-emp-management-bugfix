package com.example.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "Name is required")
	private String name;
	/** メールアドレス */
	@Size(min=1, max=256, message = "Email Address is more than 1 and less than 256 letters")
	@Email(message = "Format is not correct")
	private String mailAddress;
	/** パスワード */
	@Size(min=1, max=30, message = "Password is more than 1 and less than 30 letters")
	private String password;
	/** パスワード（確認用） */
	@Size(min=1, max=30, message = "Password is more than 1 and less than 30 letters")
	private String passwordConfirmation;
	
	/** パスワードとパスワード（確認用）が一致しているかを判定 */
	@AssertTrue(message = "Password and Password confirmation don't match")
	public boolean isPasswordValid() {
		if (password == null || password.isEmpty()) {
			return true;
		}
		return password.equals(passwordConfirmation);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + "]";
	}

	
}
