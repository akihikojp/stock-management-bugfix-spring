package jp.co.rakus.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.repository.MemberRepository;

/**
 * メンバー関連サービスクラス.
 * 
 * @author igamasayuki
 *
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	// public List<Member> findAll(){
	// return memberRepository.findAll();
	// }
	//
	// public Member findOne(Integer id) {
	// return memberRepository.findOne(id);
	// }

	public Member findOneByMailAddressAndPassword(String mailAddress, String password) {
		return memberRepository.findByMailAddressAndPassword(mailAddress, password);
	}

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	// public Member update(Member member){
	// return memberRepository.save(member);
	// }
	//
	// public void delete(Integer id){
	// memberRepository.delete(id);
	// }

	/**
	 * アドレス検索
	 * 
	 * @param mailAddress
	 * @return
	 */
	public Member findByMail(String mailAddress) {
		return memberRepository.findByMail(mailAddress);
	}
}
