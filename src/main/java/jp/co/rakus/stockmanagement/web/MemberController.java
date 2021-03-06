package jp.co.rakus.stockmanagement.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.service.MemberService;

/**
 * メンバー関連処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/member")
@Transactional
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public MemberForm setUpForm() {
		return new MemberForm();
	}

	/**
	 * メンバー情報登録画面を表示します.
	 * 
	 * @return メンバー情報登録画面
	 */
	@RequestMapping(value = "form")
	public String form() {
		return "/member/form";
	}

	/**
	 * メンバー情報を登録します.
	 * 
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト
	 * @param model
	 *            モデル
	 * @return ログイン画面
	 */
	@RequestMapping(value = "create")
	public String create(@Validated MemberForm form, BindingResult result, Model model) {
		/** Formタグ@NotBlankでエラー表示 */
		if (result.hasErrors()) {
			return "/member/form";
		}

		String password = form.getPassword();
		String passwordCheck = form.getPasswordCheck();
		if(!(password.equals(passwordCheck))){
			model.addAttribute("passwordError", "正しいパスワードを入力してください。");
			return "/member/form";
		}

			/** 入力されたアドレスが既存かどうか照合する */
			String inputMailAddress = form.getMailAddress();
			Member member = memberService.findByMail(inputMailAddress);

			if (member != null) {
				model.addAttribute("addressError", "そのアドレスはすでに使われています。");
				return "/member/form";
			}

			/** 新規アドレスだった場合、以下のsaveメソッド発動後に、ログイン画面へ変遷 */
			Member newMember = new Member();
			BeanUtils.copyProperties(form, newMember);
			memberService.save(newMember);
			return "redirect:/";
		}
}

// queryForObjectの場合、取得結果が0件だと下記のような例外が発生する。
// Incorrect result size: expected 1, actual 0
