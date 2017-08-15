package jp.co.rakus.stockmanagement.web;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ログイン関連のリクエストパラメータが入るフォーム.
 * @author igamasayuki
 *
 */
public class LoginForm {
	/** メールアドレス */
	@NotBlank(message = "値を入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "値を入力してください")
	private String password;
	
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
}
