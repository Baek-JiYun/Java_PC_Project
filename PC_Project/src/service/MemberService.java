package service;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberVO;

public class MemberService {
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public ArrayList<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	public ArrayList<MemberVO> insertMember(String id, String pw, String name) {
		return dao.insertMember(id, pw, name);
	}

	public ArrayList<MemberVO> SaveTime(String loginId, String remainTime) {
		return dao.SaveTime(loginId, remainTime);
	}

	public ArrayList<MemberVO> DeleteMember(String id) {
		return dao.DeleteMember(id);
	}
}
