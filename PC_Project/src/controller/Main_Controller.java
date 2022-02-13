package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;
import dto.PcVO;
import service.MemberService;
import service.PcService;

public class Main_Controller {

	public static void main(String[] args) {
		int choice = 0;
		int subChoice = 0;
		String id = "";
		String pw = "";
		String name = "";
		boolean check = false;
		String loginId = "";
		ArrayList<MemberVO> dtos;
		ArrayList<PcVO> dtos2;
		MemberService service = new MemberService();
		PcService service2 = new PcService();
		Scanner sc = new Scanner(System.in);

		System.out.println("┏                               ┒");
		System.out.println("           PC방 프로그램 ");
		System.out.println("┖                               ┚");

		while (true) {
			Menu();
			choice = sc.nextInt();
			if (choice == 0) {
				break;
			}
			switch (choice) {
			case 1:
				// 회원가입
				dtos = service.getAllMember();
				check = false;
				System.out.print("사용할 아이디 입력 >>");
				id = sc.next();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						check = true; // 중복된 id라면 true로 바뀐다
					}
				}
				if (check == true) {
					System.out.println("현재 사용중인 아이디입니다.\n다른아이디를 입력해주세요.");
					break;
				} else {
					System.out.print("사용할 pw 입력 >>");
					pw = sc.next();
					System.out.print("이름 입력 >>");
					name = sc.next();
					dtos = service.insertMember(id, pw, name);
				}
				break;
			case 2:
				// 아이디, 비밀번호찾기
				int findInfo = 0;
				System.out.println("1.아이디찾기");
				System.out.println("2.비밀번호찾기");
				findInfo = sc.nextInt();
				dtos = service.getAllMember();
				if (findInfo == 1) {
					System.out.print("찾으려는 아이디의 이름 입력 >>");
					name = sc.next();
					for (int i = 0; i < dtos.size(); i++) {
						if (dtos.get(i).getName().equals(name)) {
							System.out.print("아이디는 [" + dtos.get(i).getID() + "] 입니다.");
							System.out.println();
						}
					}
				} else if (findInfo == 2) {
					System.out.print("아이디 입력 >>");
					id = sc.next();
					for (int i = 0; i < dtos.size(); i++) {
						if (dtos.get(i).getID().equals(id)) {
							System.out.print("비밀번호는 [" + dtos.get(i).getPW() + "] 입니다.");
							System.out.println();
						}
					}
				}
				break;
			case 3:
				loginId = "";
				check = false;
				int useSeat = 0;
				dtos = service.getAllMember();
				System.out.print("아이디 입력 >>");
				id = sc.next();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						loginId = id; // loginId에 id저장
						System.out.print("비밀번호 입력 >>");
						pw = sc.next();
						check = true; // 아이디 중복여부 체크
						if (dtos.get(i).getPW().equals(pw)) {
							System.out.println("로그인완료!");
						}
					}
				}
				if (check = false) {
					System.out.println("아이디를 다시 확인해주세요.");
					break;
				}
				while (true) {
					subMenu();
					subChoice = sc.nextInt();
					if (subChoice == 0) {
						break; // 로그아웃
					}
					switch (subChoice) {
					case 1:
						// 회원 정보
						System.out.println(" ----- 회원 정보 열람 ----- ");
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								System.out.println("아이디: " + dtos.get(i).getID());
								System.out.println("비밀번호: " + dtos.get(i).getPW());
								System.out.println("이름: " + dtos.get(i).getName());
								if (dtos.get(i).getRemainTime() != null) {
									System.out.println("남은시간 " + dtos.get(i).getRemainTime().substring(11, 19));
								} else {
									System.out.println("남은시간은 0분입니다.");
								}
							}
						}
						break;
					case 2:
						// 좌석 현황
						int seat = 0;
						dtos2 = service2.getAllPcInfo();
						for (int i = 0; i < dtos2.size(); i++) {
							seat = dtos2.get(i).getSeat();
							if (i % 5 == 0) { // 콘솔창 줄바꿈
								System.out.println();
								System.out.println(" ---  ---  ---  ---  ---  ");
							}
							if (dtos2.get(i).getID() != null) { // pc 좌석이 사용중이라면 *출력
								System.out.print(" |* |");
							} else {
								if (i < 9) {
									System.out.print(" |" + seat + " |");
								} else {
									System.out.print(" |" + seat + "|");
								}
							}

						}
						System.out.println();
						break;
					case 3:
						check = false;
						// 좌석선택 및 요금
						dtos2 = service2.getAllPcInfo();
						seat = 0;
						int input_Time = 0;
						System.out.println(" ┌──────────────────────┐");
						System.out.println("      1 시간 1OOO원      ");
						System.out.println("      6 시간 5OOO원      ");
						System.out.println("      1O시간 8OOO원      ");
						System.out.println(" └──────────────────────┘");
						System.out.print("좌석 번호 입력 >>");
						seat = sc.nextInt();
						for (int i = 0; i < dtos2.size(); i++) {
							if (dtos2.get(i).getSeat() == seat) {
								if (dtos2.get(i).getID() != null) {
									System.out.println("현재 사용중인 자리입니다.");
									System.out.println("다른 좌석을 선택해주세요.");
									check = true;
									break;
								}
							}
						}
						if (check == true) {
							break;
						}

						useSeat = seat;
						System.out.print("구매 시간 입력 >>");
						input_Time = sc.nextInt();
						System.out.println();
						int remainHour = 0;
						int remainMinute = 0;
						int remainSecond = 0;
						LocalDateTime now = LocalDateTime.now(); // 현재 날짜,시간
						String fmNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

						int nowHour = now.getHour(); // 현재 시(Hour)만 추출
						int nowMinute = now.getMinute();
						int nowSecond = now.getSecond();
						int nowDay = now.getDayOfMonth();

						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								if (dtos.get(i).getRemainTime() != null) { // 로그인 id에 잔여시간이 있다면
									String rmHour = dtos.get(i).getRemainTime().substring(11, 13);
									String rmMinute = dtos.get(i).getRemainTime().substring(14, 16);
									String rmSecond = dtos.get(i).getRemainTime().substring(17, 19);

									System.out
											.println("잔여시간은 " + rmHour + "시간 " + rmMinute + "분 " + rmSecond + "초 입니다.");

									remainHour = Integer.parseInt(rmHour);
									remainMinute = Integer.parseInt(rmMinute);
									remainSecond = Integer.parseInt(rmSecond);

									nowHour = nowHour + remainHour; // nowHour에 저장
									nowMinute = nowMinute + remainMinute;
									nowSecond = nowSecond + remainSecond;

									if (59 < nowMinute) {
										nowHour += 1;
										nowMinute -= 60;
									}
									if (59 < nowSecond) {
										nowMinute += 1;
										nowSecond -= 60;
									}

									break;
								}
							}
						}

						int buyHour = input_Time + nowHour;

						if (buyHour > 23) { // 현재시간에 구매시간을 더햇을때 24이상이면 날짜가 하루올라간다.
							nowDay += 1;
							buyHour -= 24;
						}

						String endTime = buyHour + ":" + nowMinute + ":" + nowSecond;

						dtos2 = service2.UpdatePcInfo(seat, fmNow, endTime, input_Time, loginId);
						int price = 0;
						int calc_Num = input_Time;
						for (int i = 1; i <= calc_Num;) { // 요금 계산
							if (calc_Num >= 10) {
								price += 8000;
								calc_Num -= 10;
							} else if (calc_Num >= 6) {
								price += 5000;
								calc_Num -= 6;
							} else {
								price += 1000;
								calc_Num -= 1;
							}
						}
						System.out.printf("구매시간은 %d시간 이며, ", input_Time);
						System.out.printf("요금은 %d원 입니다.\n", price);

						break;
					case 4:
						// 사용시간
						String stTime = "";
						int buyTime = 0;
						String TotalrmTime = "";
						int TotalRMHour = 0;
						int TotalRMMinute = 0;
						int TotalRMSecond = 0;
						dtos2 = service2.getAllPcInfo();
						for (int i = 0; i < dtos2.size(); i++) {
							if (dtos2.get(i).getID() != null) {
								if (dtos2.get(i).getID().equals(loginId)) {
									stTime = dtos2.get(i).getStartTime();
									buyTime = dtos2.get(i).getBuyTime();
								}
							}
						}
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								if (dtos.get(i).getRemainTime() != null) {
									TotalrmTime = dtos.get(i).getRemainTime();
								} else {
									TotalrmTime = "2021-10-01 00:00:00";
								}
							}
						}
						String stTimeHour = stTime.substring(11, 13);
						String stTimeMinute = stTime.substring(14, 16);
						String stTimeSecond = stTime.substring(17, 19);

						String rmTimeHour = TotalrmTime.substring(11, 13);
						String rmTimeMinute = TotalrmTime.substring(14, 16);
						String rmTimeSecond = TotalrmTime.substring(17, 19);

						int stHour = Integer.parseInt(stTimeHour); // 시작시간 String -> int
						int stMinute = Integer.parseInt(stTimeMinute);
						int stSecond = Integer.parseInt(stTimeSecond);

						int rmHour = Integer.parseInt(rmTimeHour); // 남은시간 String -> int
						int rmMinute = Integer.parseInt(rmTimeMinute);
						int rmSecond = Integer.parseInt(rmTimeSecond);
						
						if(rmMinute==0) {
							rmMinute=59;
						}
						if(rmSecond==0) {
							rmSecond=60;
						}

						LocalDateTime UseNow = LocalDateTime.now();
						nowHour = UseNow.getHour(); // 현재 시(Hour)만 추출
						nowMinute = UseNow.getMinute();
						nowSecond = UseNow.getSecond();

						stHour = Math.abs(stHour - nowHour); // 시작시간에서 현재시간을 빼서 사용시간 추출
						stMinute = Math.abs(stMinute - nowMinute);
						stSecond = Math.abs(stSecond - nowSecond);

						rmHour = rmHour + buyTime; // 기존에 남아잇던 잔여시간에 구매시간을 더한다

						TotalRMHour = Math.abs(rmHour - stHour -1); // 더한 잔여시간에서 사용시간을 빼면 사용후 남은시간
						TotalRMMinute = Math.abs(rmMinute - stMinute);
						TotalRMSecond = Math.abs(rmSecond - stSecond);

						String remainTime = TotalRMHour + ":" + TotalRMMinute + ":" + TotalRMSecond;

						System.out
								.println(loginId + "님의 사용시간은 " + stHour + "시간 " + stMinute + "분 " + stSecond + "초 이며,");
						System.out.println(
								"남은 시간은 " + TotalRMHour + "시간 " + TotalRMMinute + "분 " + TotalRMSecond + "초 입니다.");
						System.out.println("저장이 완료되었습니다. 감사합니다.");
						dtos2 = service2.LogoutPc(useSeat);
						dtos = service.SaveTime(loginId, remainTime);
						break;
					}
				}
				break;
			case 4:
				check = false;
				System.out.print("탈퇴할 id 입력 >>");
				id = sc.next();
				dtos = service.getAllMember();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						pw = sc.next();
						if (dtos.get(i).getPW().equals(pw)) {
							check = true;
						}
					}
				}
				if (check == true) {
					dtos = service.DeleteMember(id);
					System.out.println("삭제가 완료되었습니다.");
					System.out.println("이용해주셔서 감사합니다.");
				} else {
					System.out.println("id와 pw를 다시 확인해주세요.");
				}
				break;
			}

		}
		sc.close();
	}

	public static void Menu() {
		System.out.println();
		System.out.println("1.회원가입");
		System.out.println("2.아이디,비밀번호찾기");
		System.out.println("3.로그인");
		System.out.println("4.탈퇴");
		System.out.println("0.종료");

	}

	public static void subMenu() {
		System.out.println();
		System.out.println("1.회원정보");
		System.out.println("2.좌석현황");
		System.out.println("3.좌석선택 및 요금");
		System.out.println("4.사용종료");
		System.out.println("0.로그아웃");
	}
}
