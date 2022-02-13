package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.PcVO;

public class PcDAO {
	private ArrayList<PcVO> dtos2;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public PcDAO() {
		dtos2 = new ArrayList<PcVO>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public ArrayList<PcVO> getAllPcInfo() {
		dtos2 = new ArrayList<PcVO>();
		String SQL = "SELECT * FROM pc";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int seat = rs.getInt("seat");
				String startTime = rs.getString("starttime");
				String endTime = rs.getString("endtime");
				int buyTime = rs.getInt("buytime");
				String id = rs.getString("id");
				PcVO VO = new PcVO(seat, startTime, endTime, buyTime, id);
				dtos2.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}

	public ArrayList<PcVO> UpdatePcInfo(int seat, String fmNow, String endTime, int input_Time, String loginId) {
		String SQL = "UPDATE pc SET starttime=TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),endtime=TO_DATE(?,'hh24:mi:ss'),buytime=?,id=? WHERE seat=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, fmNow);
			pstmt.setString(2, endTime);
			pstmt.setInt(3, input_Time);
			pstmt.setString(4, loginId);
			pstmt.setInt(5, seat);
			pstmt.executeUpdate();
			System.out.println("좌석 사용 등록이 완료되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}

	public ArrayList<PcVO> LogoutPc(int seat) {
		String SQL = "UPDATE pc SET starttime=null,endtime=null,buytime=null,id=null WHERE seat=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, seat);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dtos2;
	}
}
