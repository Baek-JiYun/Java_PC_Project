# ๐ฅ๏ธ Java+DB PCํ๋ก์ ํธ
- <b>Language</b> : <img alt="JAVA" src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"/>
- <b>Database</b> : <img alt="Oracle" src ="https://img.shields.io/badge/Oracle-%23F00000.svg?style=flat-square&logo=oracle&logoColor=white" />
- <b>Tool</b> : <img alt="Eclipse IDE" src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat-square&logo=Eclipse IDE&logoColor=white"/>
- ์๋ฐ ์ฝ์๋ก๋ง ์๋ํ๋ ํ๋ก๊ทธ๋จ์๋๋ค.

## ๐์ ์๊ธฐ๊ฐ ๋ฐ ๊ฐ๋ฐ์ธ์
- ๊ธฐ๊ฐ : 2021.10 ~ 2021.10 (์ฝ 1์ฃผ)
- ์ธ์ : 1๋ช (๊ฐ์ธํ๋ก์ ํธ)

## ๐์ฃผ์ ๊ธฐ๋ฅ

### ๐ธ ๋ฉ์ธ๋ฉ๋ด
- <b>๋ฉ๋ด ์ ํ</b> : ๋ฉ๋ด๋ง ์ถ๋ ฅํด์ฃผ๋ ๋ฉ์๋๋ฅผ ๋ฐ๋ก ๋ง๋ค์ด ํ์ํ ๋๋ง๋ค ์ถ๋ ฅํจ
- <b>ํ์๊ฐ์ / ๋ก๊ทธ์ธ / ๋ก๊ทธ์์ / ์ ๋ณด์์ </b> : ํ์ ๊ด๋ จ ๊ธฐ๋ฅ, ๋ก๊ทธ์ธ ์ดํ ์๋งค ๊ธฐ๋ฅ ์ฌ์ฉ๊ฐ๋ฅ
- <b>ID/PW ์ฐพ๊ธฐ</b> : ID๋ ์ด๋ฆ ๊ฒ์์ผ๋ก, PW๋ ID ๊ฒ์์ผ๋ก ์ฐพ์ ์ ์์ต๋๋ค.

<img src="img/main.PNG" width="240" height="330" >

<details>
<summary>์ฝ๋๋ณด๊ธฐ</summary>
<div markdown="1">

```java
// ์์ด๋, ๋น๋ฐ๋ฒํธ์ฐพ๊ธฐ
int findInfo = 0;
System.out.println("1.์์ด๋์ฐพ๊ธฐ");
System.out.println("2.๋น๋ฐ๋ฒํธ์ฐพ๊ธฐ");
findInfo = sc.nextInt();
dtos = service.getAllMember();
if (findInfo == 1) {
	System.out.print("์ฐพ์ผ๋ ค๋ ์์ด๋์ ์ด๋ฆ ์๋ ฅ >>");
	name = sc.next();
	for (int i = 0; i < dtos.size(); i++) {
		if (dtos.get(i).getName().equals(name)) {
			System.out.print("์์ด๋๋ [" + dtos.get(i).getID() + "] ์๋๋ค.");
			System.out.println();
		}
	}
} else if (findInfo == 2) {
	System.out.print("์์ด๋ ์๋ ฅ >>");
	id = sc.next();
	for (int i = 0; i < dtos.size(); i++) {
		if (dtos.get(i).getID().equals(id)) {
			System.out.print("๋น๋ฐ๋ฒํธ๋ [" + dtos.get(i).getPW() + "] ์๋๋ค.");
			System.out.println();
		}
	}
}
	
        
//๋ฉ์ธ๋ฉ๋ด
	public static void Menu() {
		System.out.println();
		System.out.println("1.ํ์๊ฐ์");
		System.out.println("2.์์ด๋,๋น๋ฐ๋ฒํธ์ฐพ๊ธฐ");
		System.out.println("3.๋ก๊ทธ์ธ");
		System.out.println("4.ํํด");
		System.out.println("0.์ข๋ฃ");

	}
```
	
</div>
</details>

<br>

### ๐ธ์๋ธ๋ฉ๋ด
- ๋ฉ์ธ๋ฉ๋ด์์ ๋ก๊ทธ์ธํ๋ฉด ์๋ธ๋ฉ๋ด๋ก ๋ค์ด์ต๋๋ค.
- <b>์ข์ ํํฉ</b> : ๋ฐ์ดํฐ๋ฒ ์ด์ค์์ ์ข์ํํฉ์ ๋ถ๋ฌ์ ์ฌ์ฉ์ค์ธ ์ข์์ด๋ผ๋ฉด | * |๋ก ํ๊ธฐ๋ฉ๋๋ค.

<img src="img/sub.PNG" width="200" height="300" >

<details>
<summary>์ฝ๋๋ณด๊ธฐ</summary>
<div markdown="1">

```java
//์๋ธ๋ฉ๋ด
	public static void subMenu() {
		System.out.println();
		System.out.println("1.ํ์์ ๋ณด");
		System.out.println("2.์ข์ํํฉ");
		System.out.println("3.์ข์์ ํ ๋ฐ ์๊ธ");
		System.out.println("4.์ฌ์ฉ์ข๋ฃ");
		System.out.println("0.๋ก๊ทธ์์");
	}
  
//์ข์ ํํฉ
int seat = 0;
dtos2 = service2.getAllPcInfo();
for (int i = 0; i < dtos2.size(); i++) {
	seat = dtos2.get(i).getSeat();
	if (i % 5 == 0) { // ์ฝ์์ฐฝ ์ค๋ฐ๊ฟ
		System.out.println();
		System.out.println(" ---  ---  ---  ---  ---  ");
	}
	if (dtos2.get(i).getID() != null) { // pc ์ข์์ด ์ฌ์ฉ์ค์ด๋ผ๋ฉด *์ถ๋ ฅ
		System.out.print(" |* |");
	} else {
		if (i < 9) {
			System.out.print(" |" + seat + " |");
		} else {
			System.out.print(" |" + seat + "|");
			}
		}
	}
```
	
</div>
</details>

#### ๐ธ ์ข์ ์ ํ ๋ฐ ์๊ฐ ๊ตฌ๋งค
- ์ข์ ์ ํ ํ ์๊ฐ ๊ตฌ๋งค๋ฅผ ํ  ๋ ํ์ฌ ์๊ฐ์ ๋ฐ์์ ๊ณ์ฐํด ์ข๋ฃ์๊ฐ์ DB์ ์ ์ฅํฉ๋๋ค.
- ๋ง์ฝ ์ด์ ์ ์ฌ์ฉํ๊ณ  ๋จ์ ์๊ฐ์ด ์๋ค๋ฉด ํฉํด์ ์ด ์์ฌ ์๊ฐ์ ์ถ๋ ฅํฉ๋๋ค.
- ์ฌ์ฉ์ค์ธ ์ข์์ ์ ํํ๋ค๋ฉด ์ด์  ๋ฉ๋ด๋ก ๋์๊ฐ๋๋ค.

<img src="img/sub2.PNG" width="240" height="300" >


```java
for (int i = 0; i < dtos.size(); i++) {
	if (dtos.get(i).getID().equals(loginId)) {
	if (dtos.get(i).getRemainTime() != null) { // ๋ก๊ทธ์ธ id์ ์์ฌ์๊ฐ์ด ์๋ค๋ฉด
		String rmHour = dtos.get(i).getRemainTime().substring(11, 13);
		String rmMinute = dtos.get(i).getRemainTime().substring(14, 16);
		String rmSecond = dtos.get(i).getRemainTime().substring(17, 19);

		System.out.println("์์ฌ์๊ฐ์ " + rmHour + "์๊ฐ " + rmMinute + "๋ถ " + rmSecond + "์ด ์๋๋ค.");
            //๋จ์ ์์ฌ์๊ฐ ์ถ๋ ฅ

		remainHour = Integer.parseInt(rmHour); //int๋ก ๋ณํ
		remainMinute = Integer.parseInt(rmMinute);
		remainSecond = Integer.parseInt(rmSecond);

		nowHour = nowHour + remainHour; // ํ์ฌ์๊ฐ์ ์์ฌ์๊ฐ์ ๋ํด ๋ณ์์ ์ ์ฅ->์ข๋ฃ 
		nowMinute = nowMinute + remainMinute;
		nowSecond = nowSecond + remainSecond;
            
            
            String endTime = buyHour + ":" + nowMinute + ":" + nowSecond;
```

#### ๐ธ ์ฌ์ฉ ์ข๋ฃ
- ์ฌ์ฉ์์ ์์ ์๊ฐ์์ ํ์ฌ ์๊ฐ์ ๋บ ํ ์ฌ์ฉ ์๊ฐ์ ๊ณ์ฐํฉ๋๋ค.
- ์ต์ข ์์ฌ ์๊ฐ์์ ์ฌ์ฉ ์๊ฐ์ ๋บ ํ DB์ ์ ์ฅํฉ๋๋ค.

<img src="img/final.PNG" width="240" height="230" >

```java
LocalDateTime UseNow = LocalDateTime.now();
nowHour = UseNow.getHour(); // ํ์ฌ ์(Hour)๋ง ์ถ์ถ
nowMinute = UseNow.getMinute();
nowSecond = UseNow.getSecond();

stHour = Math.abs(stHour - nowHour); // ์์์๊ฐ์์ ํ์ฌ์๊ฐ์ ๋นผ์ ์ฌ์ฉ์๊ฐ ์ถ์ถ
stMinute = Math.abs(stMinute - nowMinute); //ํ์ฌ์๊ฐ ๊ณ์ฐ ์ ๋ ์ง๊ฐ ๋ฐ๋๋ฉด ์์ ๊ฐ์ด ๋์ฌ ์ ์๊ธฐ ๋๋ฌธ์ ์ ๋๊ฐ์ผ๋ก ๊ณ์ฐ
stSecond = Math.abs(stSecond - nowSecond);

rmHour = rmHour + buyTime; // ๊ธฐ์กด ID์ ๋จ์์๋ ์์ฌ์๊ฐ์ ๊ตฌ๋งค์๊ฐ์ ๋ํ๋ค

TotalRMHour = Math.abs(rmHour - stHour -1); // ๋ํ ์์ฌ์๊ฐ์์ ์ฌ์ฉ์๊ฐ์ ๋นผ๋ฉด ์ฌ์ฉํ ๋จ์์๊ฐ
TotalRMMinute = Math.abs(rmMinute - stMinute); 
TotalRMSecond = Math.abs(rmSecond - stSecond);

String remainTime = TotalRMHour + ":" + TotalRMMinute + ":" + TotalRMSecond;

System.out.println(loginId + "๋์ ์ฌ์ฉ์๊ฐ์ " + stHour + "์๊ฐ " + stMinute + "๋ถ " + stSecond + "์ด ์ด๋ฉฐ,");
System.out.println("๋จ์ ์๊ฐ์ " + TotalRMHour + "์๊ฐ " + TotalRMMinute + "๋ถ " + TotalRMSecond + "์ด ์๋๋ค.");
System.out.println("์ ์ฅ์ด ์๋ฃ๋์์ต๋๋ค. ๊ฐ์ฌํฉ๋๋ค.");
dtos2 = service2.LogoutPc(useSeat);
dtos = service.SaveTime(loginId, remainTime);
```

# ๐ ๊ฐ์ฌํฉ๋๋ค.
