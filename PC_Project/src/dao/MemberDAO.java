package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MemberVO;

public class MemberDAO {
	private ArrayList<MemberVO> dtos;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		dtos = new ArrayList<MemberVO>();
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

	public ArrayList<MemberVO> getAllMember() {
		dtos = new ArrayList<MemberVO>();
		String SQL = "SELECT * FROM pcmember";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String remainTime = rs.getString("remaintime");
				MemberVO VO = new MemberVO(id, pw, name, remainTime);
				dtos.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;

	}

	public ArrayList<MemberVO> insertMember(String id, String pw, String name) {
		String SQL = "INSERT INTO pcmember(id,pw,name) VALUES (?,?,?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			System.out.println("저희 pc방의 회원이 되신 것을 환영합니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> SaveTime(String loginId, String remainTime) {
		String SQL = "UPDATE pcmember SET remaintime=TO_DATE(?,'hh24:mi:ss') where id=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, remainTime);
			pstmt.setString(2, loginId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> DeleteMember(String id) {
		String SQL = "DELETE FROM pcmember where id=?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
