package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * @author igamasayuki
 *
 */
public class MemberForm {
	/** 名前 */
	@NotBlank(message="名前を入力")
	private String name;
	/** メールアドレス */
	@NotBlank(message="メールアドレスを入力")
	private String mailAddress;
	/** パスワード */
	@Size(min=1, max=10,message="パスワードは１文字以上１０文字以下で入力してください")
	private String password;
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
}
