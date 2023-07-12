package egovframework.let.member.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {
   
   @Resource(name = "memberMapper")
   private MemberMapper memberMapper;
   
   // 회원ID찾기
   public MemberVO findId(MemberVO vo) throws Exception {
	   return memberMapper.findId(vo);
   }

   // 회원 비밀번호 찾기
	public MemberVO findPassword(MemberVO vo) throws Exception {
		return memberMapper.findPassword(vo);
	}
	
	// 회원 비밀번호 업데이트
	public void passwordUpdate(MemberVO vo) throws Exception{
		// 입력한 비밀번호를 암호화한다.
		String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getEmplyrId());
		vo.setPassword(enpassword);
		
		memberMapper.passwordUpdate(vo);
	}
}