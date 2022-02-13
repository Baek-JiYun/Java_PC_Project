package service;

import java.util.ArrayList;

import dao.PcDAO;
import dto.PcVO;

public class PcService {
	private PcDAO dao;
	
	public PcService() {
		dao=new PcDAO();
	}
	public ArrayList<PcVO> getAllPcInfo(){
		return dao.getAllPcInfo();
	}
	public ArrayList<PcVO> UpdatePcInfo(int seat, String fmNow, String endTime, int input_Time, String loginId) {		
		return dao.UpdatePcInfo(seat,fmNow,endTime,input_Time,loginId);
	}
	public ArrayList<PcVO> LogoutPc(int seat) {
		return dao.LogoutPc(seat);
	}
}
