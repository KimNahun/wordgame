import java.awt.*; //awt 내의 모든 내가 사용하는 클래스 import

import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.TimerTask;
import java.util.Timer;

// 자바 스윙 swing

public class WordGame1 extends JFrame {
	// 변수
	// 함수
	// 생성자
	// MovingWord w1; //움직이는 단어 1개 선언
	Image Back1; // 배경화면
	Image Win; // 단어를 맞췄을 때의 이미지
	Image Lose; // 단어를 틀렸을 때의 이미지
	Image recovery; // 아이템 5개의 이미지
	Image fever;
	Image delay;
	Image shot;
	Image Shield;
	Image use; // 이미 사용한 아이템 표시 이미지

	boolean facestate = true;
	MovingWord words[];
	GamePanel panel; // 게임이 진행되는 패널이며, 계속 업데이트
	int selectlevel = 0; // 메뉴바에서 레벨을 선택할 수 있는데, 초깃값은 0으로합니다.
	int selectcategory = 0; //// 메뉴바에서 카테고리를 선택할 수 있는데, 초깃밗은 0으로 합니다.
	String[] list = { "코리아텍", "견물생심", "우리나라", "프로젝트", "응용프로그래밍", "놀이동산", "카카오", "명중", "한맥제", "훈민정음", "오나라" }; // list
	// 배열의
	// 초깃값
	String[] list1 = { "좋니", "좋아", "가시", "어디에도", "신호등", "포장마차", "체념", "응급실", "친구", "아로하", "스토커", "너였다면", "무릎", "눈사람",
			"미안해", "푸르던", "마음", "비가와", "팔레트", "넘어와", "우산", "고백", "편지", "지난날", "해바라기", "라라라", "내사람", "소녀", "빗속에서",
	"옛사랑" };
	String[] list2 = { "고양이", "강아지", "거북이", "토끼", "뱀", "사자", "호랑이", "표범", "치타", "하이에나", "기린", "코끼리", "코뿔소", "하마", "악어",
			"펭귄", "부엉이", "올빼미", "곰", "돼지", "소", "닭", "독수리", "타조", "고릴라", "오랑우탄", "침팬지", "원숭이", "코알라", "캥거루" };
	String[] list3 = { "제니", "지수", "로제", "리사", "진", "슈가", "지민", "뷔", "정국", "류진", "전현무", "임영웅", "유재석", "영탁", "나연", "정연",
			"모모", "사나", "지효", "미나", "다현", "쯔위", "아이유", "박서준", "이민호", "차은우", "백종원", "김수현", "수지", "주지훈" };
	String[] list4 = { "축구", "농구", "배구", "핸드볼", "야구", "럭비", "미식축구", "당구", "골프", "티볼", "족구", "배드민턴", "탁구", "수영", "역도",
			"태권도", "씨름", "유도", "복싱", "킥복싱", "레슬링", "팔씨름", "주짓수", "양궁", "승마", "피겨", "쇼트트랙", "하키", "스키", "사이클" };
	String[] list5 = { "해울관", "예지관", "함지관", "다솔관", "한울관", "참빛관", "청솔관", "응프", "예솔관", "은솔관", "솔빛관", "방하착", "아우누리",
			"아우미르", "아우내참", "정약용", "홍대정", "담헌실학관", "다산정보관", "본관동", "오케스트라", "비상", "빠샤", "소울메이트", "한소리", "밥버러지", "셔터",
			"컷", "슛", "수리들어간다", };
	String[] list6 = { "이상해씨", "이상해풀", "이상해꽃", "파이리", "리자드", "리자몽", "꼬부기", "어니부기", "거북왕", "캐터피", "버터풀", "구구", "피죤",
			"피죤투", "꼬렛", "레트라", "깨비조", "아보크", "피카츄", "라이츄", "모래두지", "니드런", "니드킹", "니드퀸", "삐삐", "픽시", "식스테일", "나인테일",
			"푸린", "푸크린" };
	String[] list7 = { "죽마고우", "수어지교", "각골난망", "군계일학", "백미", "격세지감", "당랑거철", "계란투석", "계륵", "백면서생", "좌정관천", "고진감래",
			"환골탈태", "괄목상대", "과유불급", "부화뇌동", "동분서주", "금의환향", "목불식정", "일자무식", "노심초사", "금상첨화", "일석이조", "다다익선", "역지사지",
			"주객전도", "대기만성", "양두구육", "표리부동", "대동소이" };
	String[] list8 = { "북한", "가나", "그리스", "나이지리아", "남수단", "네팔", "노르웨이", "뉴질랜드", "독일", "러시아", "레바논", "루마니아", "말레이시아",
			"멕시코", "모로코", "몽골", "미국", "바레인", "베트남", "브라질", "스웨덴", "스위스", "스페인", "시리아", "알제리", "에콰도르", "영국", "우루과이",
			"우크라이나", "이라크" };
	String[] list9 = { "구글", "나이키", "농협", "네이버", "넷마블", "넥슨", "농심", "두산", "월트디즈니", "롯데", "루이비통", "마이크로소프트", "마스터카드",
			"맥도날드", "마블", "삼성", "시스코", "소니", "세븐일레븐", "샤넬", "애플", "아마존", "월마트", "알리바바", "어도브", "아디다스", "엘지", "야마하",
			"알파벳", "인텔" };
	String[] list10 = { "세나", "비에고", "케일", "블리츠크랭크", "스웨인", "오공", "다이애나", "징크스", "다리우스", "케이틀린", "세트", "카르마", "말파이트",
			"레오나", "벡스", "니달리", "애쉬", "룰루", "케인", "카직스", "모르가나", "갱플랭크", "파이크", "카타리나", "녹턴", "르블랑", "잭스", "티모", "샤코",
	"쓰레쉬" };
	// 30개짜리 배열 10개 생성

	JLabel l2; // 스코어 표시 레이블을 멤버 변수로 설정하여 생성자가 아닌 다른 곳에서도 접근하여 수정할 수 있도록.
	JLabel l4;// 라이프 표시 레이블
	JLabel l5;
	int life = 5; // life 의 초깃값은 5
	int score; // score
	double correctword = 0; // correctword 초깃값 0.0
	double incorrectword = 0; // incorrectword 초깃값 0.0
	int combo = 0; // 콤보 초깃값 0
	int maxcombo = 0; // 맥스콤보 초깃값 0
	int remainingword = list.length; // 남은 단어의 개수는 배열의 길이
	int item = 0; // 내가 입력한 단어가 item인지 판단학 위한 변수
	JButton resultbtn; // 결과 버튼
	int itemtimestop = 1; // 여기서부터는 아이템. itemtimestop은 초깃값 1 (item을 사용하면 1개 줄어들고, 모든 아이템의 초깃값은 1이기때문에 각각
	// 1번씩만 사용가능)
	int itemlifeplus = 1;
	int itemshield = 1;
	int shield = 0; // shield는 itemshield의 기능을 보조하기 위함. 뒤에서 다시 나옴.
	int itemdoubleshot = 1;
	int doubleshot = 0; // doubleshot은 itemdoubleshot의 기능을 보존하기 위함.
	int itemfevertime = 1;
	int fevertime = 0; // fevertime은 itemfevertime의 기능을 보조하기 위함.
	int once = 0;

	public WordGame1() {
		setSize(1300, 870); // 창의 크기 지정
		// 필요한 컴포넌트 배치

		setLayout(new BorderLayout()); // 배치 방식을 지정
		Panel info = new Panel(new GridLayout(1, 8)); // 1행 4열 상단 패널 준비
		JLabel l1 = new JLabel("Score:", JLabel.RIGHT); // 텍스트 오른쪽으로 배치
		l2 = new JLabel("0", JLabel.LEFT); // 텍스트를 왼쪽으로, 멤버변수로 설정된 변수 값을 설정한 것임
		JLabel l3 = new JLabel("Life:", JLabel.CENTER); // 텍스트를 가운데
		l4 = new JLabel("" + life, JLabel.LEFT); // 텍스트를 왼쪽에
		l5 = new JLabel("현재콤보:" + combo, JLabel.LEFT);
		JButton btn = new JButton("ㅣㅣ"); // 정지 버튼
		JMenuBar mb = new JMenuBar(); // 메뉴바
		JButton btnstart = new JButton("시작"); // 시작버튼
		resultbtn = new JButton("결과"); // 결과 버튼
		JMenu level = new JMenu("난이도"); // 난이도 결정 메뉴바
		JMenu category = new JMenu("카테고리"); // 카테고리 결정 메뉴바

		l3.setFont(new Font("Verdana", Font.BOLD, 20)); // 레이블의 폰트 지정
		l3.setPreferredSize(new Dimension(100, 40)); // 레이블의 크기 지정
		l3.setForeground(Color.CYAN); // 텍스트 컬러 지정
		l3.setBackground(Color.BLUE); // 백그라운드 컬러 지정
		l3.setOpaque(true); // 백그라운드 색상이 적용되려면 필요

		info.add(btnstart);
		info.add(l1); // 상단 패널에 레이블 순서대로 추가 (점수와 생명 등 확인용)
		info.add(l2);
		info.add(l3);
		info.add(l4);
		info.add(l5);
		info.add(btn);
		info.add(resultbtn);

		l1.setVisible(false); // 처음에는 라이프, 스코어 값등 안보임
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		resultbtn.setVisible(false);

		btnstart.setBackground(Color.WHITE); // 시작 버튼의 색은 흰 색

		JMenuItem item1 = new JMenuItem("1단계"); //// 1단계 ~ 10단계를 추가합니다.
		JMenuItem item2 = new JMenuItem("2단계");
		JMenuItem item3 = new JMenuItem("3단계");
		JMenuItem item4 = new JMenuItem("4단계");
		JMenuItem item5 = new JMenuItem("5단계");
		JMenuItem item6 = new JMenuItem("6단계");
		JMenuItem item7 = new JMenuItem("7단계");
		JMenuItem item8 = new JMenuItem("8단계");
		JMenuItem item9 = new JMenuItem("9단계");
		JMenuItem item10 = new JMenuItem("10단계");

		level.add(item1); // //추가한 1~10단계를 ,level 메뉴바에 놓습니다.
		level.add(item2);
		level.add(item3);
		level.add(item4);
		level.add(item5);
		level.add(item6);
		level.add(item7);
		level.add(item8);
		level.add(item9);
		level.add(item10);

		JMenuItem tem1 = new JMenuItem("음악"); //// 음악 ~ 리그오브레전드까지의 카테고리를 메뉴바에 놓습니다.
		JMenuItem tem2 = new JMenuItem("동물");
		JMenuItem tem3 = new JMenuItem("연예인");
		JMenuItem tem4 = new JMenuItem("스포츠");
		JMenuItem tem5 = new JMenuItem("한기대");
		JMenuItem tem6 = new JMenuItem("포켓몬");
		JMenuItem tem7 = new JMenuItem("고사성어");
		JMenuItem tem8 = new JMenuItem("나라 이름");
		JMenuItem tem9 = new JMenuItem("세계 기업");
		JMenuItem tem10 = new JMenuItem("리그 오브 레전드");

		category.add(tem1); // 추가한 카테고리를 메뉴바에 놓습니다.
		category.add(tem2);
		category.add(tem3);
		category.add(tem4);
		category.add(tem5);
		category.add(tem6);
		category.add(tem7);
		category.add(tem8);
		category.add(tem9);
		category.add(tem10);

		setJMenuBar(mb);
		mb.add(level);
		mb.add(category);

		ImageIcon imageIcon4 = new ImageIcon("./image/Back1.png");
		Back1 = imageIcon4.getImage().getScaledInstance(700, getHeight(), java.awt.Image.SCALE_SMOOTH);
		// 배경화면 이미지

		ImageIcon imageIcon2 = new ImageIcon("./image/Win.png");
		Win = imageIcon2.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // 단어를 맞췄을 때의 이미지

		ImageIcon imageIcon3 = new ImageIcon("./image/Lose.png");
		Lose = imageIcon3.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // 단어를 틀렸을 때의 이미지

		ImageIcon imageIcon5 = new ImageIcon("./image/recovery.png");
		recovery = imageIcon5.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // 아이템 '회복' 이미지

		ImageIcon imageIcon6 = new ImageIcon("./image/fever.png");
		fever = imageIcon6.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // 아이템 '피버타임' 이미지

		ImageIcon imageIcon7 = new ImageIcon("./image/delay.png");
		delay = imageIcon7.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // 아이템 '시간 정지' 이미지

		ImageIcon imageIcon8 = new ImageIcon("./image/shot.png");
		shot = imageIcon8.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // 아이템 '더블 샷' 이미지

		ImageIcon imageIcon9 = new ImageIcon("./image/Shield.png");
		Shield = imageIcon9.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // 아이템 '실드' 이미지

		ImageIcon imageIcon10 = new ImageIcon("./image/use.png");
		use = imageIcon10.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // 이미 사용한 아이템 표시 이미지

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1단계":
					selectlevel = 1;
					level.setText("1단계");
					break;
				}
			}
		});
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "2단계":
					selectlevel = 2;
					level.setText("2단계");
					break;
				}
			}
		});
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "3단계":
					selectlevel = 3;
					level.setText("3단계");
					break;
				}
			}
		});
		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "4단계":
					selectlevel = 4;
					level.setText("4단계");
					break;
				}
			}
		});
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "5단계":
					selectlevel = 5;
					level.setText("5단계");
					break;
				}
			}
		});
		item6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "6단계":
					selectlevel = 6;
					level.setText("6단계");
					break;
				}
			}
		});
		item7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "7단계":
					selectlevel = 7;
					level.setText("7단계");
					break;
				}
			}
		});
		item8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "8단계":
					selectlevel = 8;
					level.setText("8단계");
					break;
				}
			}
		});
		item9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "9단계":
					selectlevel = 9;
					level.setText("9단계");
					break;
				}
			}
		});
		item10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "10단계":
					selectlevel = 10;
					level.setText("10단계");
					break;
				}
			}
		});
		// 메뉴바에서 item1~10인, 1~10단계를 골랐다면, selectlevel 변수는 1~10으로 가변되고, 메뉴바가 1~10단계로 눈으로
		// 보이게합니다.

		tem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "음악":
					selectcategory = 1;
					category.setText("음악");
					;
					break;
				}
			}
		});
		tem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "동물":
					selectcategory = 2;
					category.setText("동물");
					;
					break;
				}
			}
		});
		tem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "연예인":
					selectcategory = 3;
					category.setText("연예인");
					;
					break;
				}
			}
		});
		tem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "스포츠":
					selectcategory = 4;
					category.setText("스포츠");
					;
					break;
				}
			}
		});
		tem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "한기대":
					selectcategory = 5;
					category.setText("한기대");
					;
					break;
				}
			}
		});
		tem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "포켓몬":
					selectcategory = 6;
					category.setText("포켓몬");
					;
					break;
				}
			}
		});
		tem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "고사성어":
					selectcategory = 7;
					category.setText("고사성어");
					;
					break;
				}
			}
		});
		tem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "나라 이름":
					selectcategory = 8;
					category.setText("나라 이름");
					;
					break;
				}
			}
		});
		tem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "세계 기업":
					selectcategory = 9;
					category.setText("세계 기업");
					;
					break;
				}
			}
		});
		tem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "리그 오브 레전드":
					selectcategory = 10;
					category.setText("리그 오브 레전드");
					;
					break;
				}
			}
		});
		// 메뉴바에서 tem1~10인, 음악~리그오브레전드를 골랐다면, selectcategory 변수는 1~10으로 가변되고, 메뉴바가
		// 음악~리그오브레전드로 눈으로 보이게 합니다.

		add(info, BorderLayout.NORTH); // 상단 패널을 프레임 북쪽에 배치
		panel = new GamePanel(); // JPanel을 상속받은 나만의 판넬. 화면 중앙 패널
		panel.setPreferredSize(new Dimension(300, 300));

		add(panel, BorderLayout.CENTER); // 프레임의 중앙에 배치
		panel.add(new JLabel(new ImageIcon(Back1)));

		JTextField msgInput = new JTextField(); // 텍스트 입력 콤포넌트
		add(msgInput, BorderLayout.SOUTH); // 프레임 남쪽에 텍스트 입력 필드 배치
		btn.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.length; i++) {
					if (e.getActionCommand().equals("ㅣㅣ")) {
						btn.setText("▶");
						words[i].suspend();
						repaint();
						msgInput.setVisible(false);
					} else {
						btn.setText("ㅣㅣ");
						words[i].resume(); // 쓰레드 객체를 시작하도록 하는 명령
						repaint();
						msgInput.setVisible(true);
					}
				}
			}
		});
		resultbtn.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여. 결과버튼을 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(20, 20); // 사이즈는 20,20으로 작아짐.
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼
				frame.setSize(500, 400); // 사이즈
				frame.setLocationRelativeTo(null);
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel);
				int b[] = { 0, 0, 0, 0, 0 }; // 랭크를 담을 b[]배열
				try {
					FileInputStream fin = new FileInputStream("C://Temp//test14.out"); // test14 파일을 읽습니다.
					int n = 0;
					int c = 0;
					while ((c = fin.read()) != -1) {
						b[n] = (int) c;
						n++;
					}
					fin.close();
				} catch (IOException y) {
				}
				System.out.println();
				try {
					FileOutputStream fout = new FileOutputStream("C://Temp//test14.out"); // test14 파일에다가 씁니다.
					if ((score / 100) >= b[b.length - 1]) { // 스코어 배열 순서 정렬. 새로운 score가 배열에 있는 값보다 크면, 그 score를 기록.
						b[b.length - 1] = (score / 100);
						for (int i = 0; i < b.length; i++) {
							for (int j = i + 1; j < b.length; j++) {
								if (b[i] < b[j]) {
									int temp;
									temp = b[i];
									b[i] = b[j];
									b[j] = temp;
								}
							}
						}
					}
					for (int i = 0; i < b.length; i++)
						fout.write((int) b[i]);
					fout.close();
				} catch (IOException y) {
					System.out.print("입출력오류");
				}
				try {
					FileInputStream fin = new FileInputStream("C://Temp//test14.out"); // test 14파일을 다시 읽습니다.
					int n = 0;
					int c = 0;
					while ((c = fin.read()) != -1) {
						b[n] = (int) c; // 읽어서 b[n] 배열에 담습니다.
						n++;
					}
					fin.close();
				} catch (IOException y) {
				}
				double accuracy = correctword / (incorrectword + correctword) * 100; // 정확도
				double word = correctword + incorrectword; // 입력한 단어의 숫자
				JLabel yourscore = new JLabel("SCORE " + score + "점"); // 사용자의 스코어
				JLabel data = new JLabel("사용자 데이터 분석"); // 사용자의 데이터
				JLabel yourinput = new JLabel("당신이 입력한 단어는 " + (int) word + "개"); // 사용자 입력한 단어 개수
				JLabel yourcorrect = new JLabel("이중 정확히 입력한 단어는" + (int) +correctword + "개"); // 사용자 정확히 입력한 단어 개수
				JLabel yourincorrect = new JLabel("이중 틀리게 입력한 단어는" + (int) +incorrectword + "개"); // 사용자 틀리게 입력한 단어 개수
				JLabel youraccuracy = new JLabel("따라서 정확도는 " + (int) accuracy + "%"); // 사용자 정확도
				JLabel yourmaxcombo = new JLabel("당신의 max combo는 " + maxcombo); // 사용자 maxcombo
				JLabel la0 = new JLabel("역대 랭킹 순위");
				JLabel la1 = new JLabel("1등:" + (b[0] * 100) + "점");
				JLabel la2 = new JLabel("2등:" + (b[1] * 100) + "점");
				JLabel la3 = new JLabel("3등:" + (b[2] * 100) + "점");
				JLabel la4 = new JLabel("4등:" + (b[3] * 100) + "점");
				JLabel la5 = new JLabel("5등:" + (b[4] * 100) + "점");
				JLabel blank = new JLabel();
				la0.setLocation(320, 80);
				la0.setSize(200, 70);
				la1.setLocation(320, 100);
				la1.setSize(200, 70);
				la2.setLocation(320, 120);
				la2.setSize(200, 70);
				la3.setLocation(320, 140);
				la3.setSize(200, 70);
				la4.setLocation(320, 160);
				la4.setSize(200, 70);
				la5.setLocation(320, 180);
				la5.setSize(200, 70);

				data.setLocation(70, 40);
				data.setSize(200, 70);
				yourscore.setLocation(70, 80);
				yourscore.setSize(200, 70);
				yourinput.setLocation(70, 120);
				yourinput.setSize(200, 70);
				yourcorrect.setLocation(70, 160);
				yourcorrect.setSize(200, 70);
				yourincorrect.setLocation(70, 200);
				yourincorrect.setSize(200, 70);
				youraccuracy.setLocation(70, 240);
				youraccuracy.setSize(200, 70);
				yourmaxcombo.setLocation(70, 280);
				yourmaxcombo.setSize(200, 70);
				blank.setLocation(70, 200);
				blank.setSize(130, 70);// 위치, 크기 지정합니다.
				frame.add(la0);
				frame.add(la1);
				frame.add(la2);
				frame.add(la3);
				frame.add(la4);
				frame.add(la5);
				frame.add(data);
				frame.add(yourscore);
				frame.add(yourinput);
				frame.add(yourcorrect);
				frame.add(yourincorrect);
				frame.add(youraccuracy);
				frame.add(yourmaxcombo);
				frame.add(blank);
				frame.setVisible(true); // frame에 추가한 후, frame을 보이게 합니다.

			}
		});

		msgInput.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여
			@Override
			public void actionPerformed(ActionEvent e) {
				msgInput.getText();
				System.out.println("키보드 엔터키 눌렀군");
				System.out.println("네가 입력한 문자:" + msgInput.getText());
				int t = 0; // t는 0
				int a = msgInput.getText().equals("") ? 1 : 0;
				if ((msgInput.getText().equals("3")) || msgInput.getText().equals("1") || msgInput.getText().equals("5")
						|| msgInput.getText().equals("4") || msgInput.getText().equals("2")) {
					item = 1; // item을 사용했다고 가정하는 조건, 사용자 입력이 1,2,3,4,5라면 item을 사용하려고 했다고 간주. item변수가 1이 됩니다.
				}

				if (msgInput.getText().equals("3")) { // 3을 입력했을 때
					if (score >= 700 && itemtimestop >= 1) { // 스코어가 700이 넘고 '시간정지'아이템이 1개 이상이면
						score -= 700; // 스코어 700점 제거
						l2.setText("" + score); // 갱신된 스코어가 보이게
						itemtimestop--; // '시간정지'아이템 개수 1개 제거
						for (int i = 0; i < list.length; i++) {
							words[i].suspend(); // 모든 단어 정지
						}
						m_timer.schedule(m_task, 5000); // 5초동안
					} else if (score < 700) { // 스코어가 700보다 적다면
						System.out.println("score부족"); // 스코어가 부족하다고 나옵니다.
					} else if (itemtimestop == 0) { // '시간정지'아이템이 0개라면
						System.out.println("해당 아이템을 이미 모두 사용"); // 해당아이템을 이미 모두 사용했다고 나옵니다.
					}
				}
				if (msgInput.getText().equals("5")) { // 5를 입력했을 때
					if (score >= 1000 && itemshield >= 1) {// 스코어가 1000이 넘고 '시간정지'아이템이 1개 이상이면
						shield = 1; // shield 변수가 1이 됩니다.
						score -= 1000; // 스코어 1000점 제거
						l2.setText("" + score);// 갱신된 스코어 보이게

						n_timer.schedule(n_task, 5000); // 5초동안
						itemshield--; // '실드'아이템 1개 제거
						System.out.println("아이템사용");
					} else if (score < 1000) {
						System.out.println("score 부족"); // 스코어가 1000보다 적으면 스코어가 부족하다고 나옵니다.
					} else if (itemshield == 0) {
						System.out.println("해당 아이템을 이미 모두 사용");
					}
				}

				if (msgInput.getText().equals("4")) { // 4를 입력했을 때
					if (score >= 700 && itemdoubleshot >= 1) {// 스코어가 700이 넘고 '더블샷'아이템이 1개 이상이면
						doubleshot = 1; // 더블샷 변수가 1이되고
						score -= 700; // 스코어 700점 제거
						l2.setText("" + score);
						p_timer.schedule(p_task, 5000); // 5초동안
						itemdoubleshot--; // 더블샷 아이템 1개 제거
						System.out.println("아이템사용");
					} else if (score < 700) {
						System.out.println("score 부족"); // 스코어가 700보다 적으면 스코어수가 부족하다고 나옵니다.
					} else if (itemshield == 0) {
						System.out.println("해당 아이템을 이미 모두 사용");
					}
				}

				if (msgInput.getText().equals("2")) { // 2를 입력했을 때
					if (score >= 500 && itemfevertime >= 1) { // 스코어가 500이 넘고 피버타임 아이템이 1이상이면
						fevertime = 1; // 피버타임 변수가 1이되고
						score -= 500; // 점수가 500점 깎입니다.
						l2.setText("" + score);
						o_timer.schedule(o_task, 5000); // 5초동안
						itemfevertime--; // 피버타임 아이템 1개 제거
						System.out.println("아이템사용");
					} else if (score < 500) {
						System.out.println("score 부족"); // 점수가 500보다 적으면 스코어수가 부족하다고 나옵니다.
					} else if (itemshield == 0) {
						System.out.println("해당 아이템을 이미 모두 사용");
					}
				}
				if (msgInput.getText().equals("1")) { // 1을 입력했을 때
					if (score >= 300 && itemlifeplus >= 1) { // 스코어가 300이 넘고 라이프플러스 아이템이 1개이상이면
						score -= 300; // 스코어 300깎고
						life++; // 라이프 증가
						itemlifeplus--; // 라이프플러스 아이템 1개 제거
						l2.setText("" + score); // 스코어를 화면에 출력되게 합니다
						l4.setText("" + life); // 라이프가 화면에 출력되게

					} else if (score < 300) {
						System.out.println("score 부족"); // 스코어가 300보다 적으면 스코어수가 부족하다고 나옵니다.
					} else if (itemtimestop <= 0) {
						System.out.println("해당 아이템을 이미 모두 사용"); // 라이프플러스아이템이 0개면, 해당아이템을 이미 모두 사용했다고 나옵니다.
					}
				}

				for (int i = 0; i < words.length; i++) { // 배열 words의 길이만큼 반복
					t = words[i].word.equals(msgInput.getText()) ? 1 : 0; // 사용자가 입력한 단어가 있는지 판단하기 위한 변수 t
					// 입력한 단어가 배열 중에 있는가? 있다면 1 아니면 0 변수 t에 저장합니다
					if (t == 1 && a != 1) { // 만약 t가 1이고 a가 1이 아니면
						System.out.println("정답입니다."); // 정답입니다. 를 출력합니다.
						combo++;// 콤보 증가
						facestate = true; // 웃는 얼굴
						if (doubleshot == 0) { // 만약 doubleshot이 0이면 단어가 1개 제거
							words[i].word = "";
						} // 그리고 정답 처리된 단어는 공백으로 바뀝니다.(아직 사라진게 아니고 공백으로 계속 내려갑니다.)
						else if (doubleshot == 1) { // 만약 doubleshot이 1개면 단어가 1개 제거되고 그보다 1개 더 큰 원소의 단어가 제거(단어가 일정확률로 2개
							// 제거됨)
							words[i].word = "";
							words[i + 1].word = "";
						}

						if (fevertime == 0) { // fevertime이 0이면
							switch (selectlevel) { // 레벨에 따라 100~1000점의 점수 증가
							case 1:
								score += 100;
								break;
							case 2:
								score += 200;
								break;
							case 3:
								score += 300;
								break;
							case 4:
								score += 400;
								break;
							case 5:
								score += 500;
								break;
							case 6:
								score += 600;
								break;
							case 7:
								score += 700;
								break;
							case 8:
								score += 800;
								break;
							case 9:
								score += 900;
								break;
							case 10:
								score += 1000;
								break;
							}
						}
						if (fevertime == 1) { // fevertime이 1이면
							switch (selectlevel) { // 레벨에 따라 200~2000의 점수 증가
							case 1:
								score += 200;
								break;
							case 2:
								score += 400;
								break;
							case 3:
								score += 600;
								break;
							case 4:
								score += 800;
								break;
							case 5:
								score += 1000;
								break;
							case 6:
								score += 1200;
								break;
							case 7:
								score += 1400;
								break;
							case 8:
								score += 1600;
								break;
							case 9:
								score += 1800;
								break;
							case 10:
								score += 2000;
								break;
							}
						}

						if (combo % 10 == 0 && combo != 0) { // 10의 배수의 콤보를 달성하면
							score += 100 * selectlevel; // 레벨에 비례한 스코어 보상 추가
							System.out.println(combo + "콤보 달성!" + 100 * selectlevel + "점 추가");
						}
						if (combo >= maxcombo) { // combo가 maxcombo보다 크면, maxcombo 갱신
							maxcombo = combo;
						}
						l2.setText("" + score); // 스코어를 화면에 출력되게 합니다
						l5.setText("현재콤보:" + combo);
						msgInput.setText(""); // 입력한 문자를 지워줍니다.
						correctword++; // 정확히 입력한 단어 1개 증가
						break;
					}
				}
				if (t == 0 && item == 0) { // 만약 t가 0이고 item이 0이라면 (입력한 단어가 배열 중에 없고, 아이템을 사용하려고 했던 것이 아니라면)
					for (int j = 0; j < words.length; j++) { // words의 길이만큼 반복
						int r = words[j].word.equals(msgInput.getText()) ? 1 : 0; // 사용자가 입력하려고 한 단어가 배열에 있는지 판단.
						// r은 변수 t의 기능과 동일합니다
						r += r;// 모든 r을 더하고, 하나라도 같다면 1이 나와야 합니다.( 모두 틀렸다면 0이 나옵니다.)
						if (life > 0) { // 라이프가 1이상이면
							if (r == 0 || a == 1) { // 만약 r이 0이거나(모든 r을 더해봐도 1이 되지 않았다면), a가 1이라면)
								if (shield == 0) { // shield 아이템을 사용중이 아니라면
									life--; // 틀린 값을 입력했다고 간주하고 스코어를 깎습니다.
									facestate = false; // 찡그린 얼굴
									l4.setText("" + life); // 스코어를 화면에 출력되게 합니다.
									msgInput.setText(""); // 입력한 문자를 지워줍니다.
									incorrectword++; // 틀리게 입력한 단어 추가
									combo = 0; // 콤보는 0이됨
									l5.setText("현재콤보:" + combo);
									break;
								}

							}
						} else {
							msgInput.setText(""); // 입력한 단어 지워줌
						}
					}
				} else {
					msgInput.setText(""); // 입력한 단어 지워줌
				}
				if (item >= 1) { // 아이템을 사용하려고 했던 것이었고, item이 1이 되었었더라면,
					item--; // 이제 item은 그 기능을 다했으므로 다시 0으로 해줍니다.
				}
			}

		});
		btnstart.addActionListener(new ActionListener() { // 시작버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
				generateWords(); // 단어 생성
				level.setVisible(false); // 레벨 메뉴바 안보이제
				category.setVisible(false); // 카테고리 메뉴바 안보이게
				l1.setVisible(true); // 스코어,라이프, 콤보 등 눈에 보이게
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				remainingword = list.length; // 남은 단어는 list의 길이
			}
		});
		if (selectlevel >= 1 && selectcategory >= 1) { // 레벨 1이상, 카테고리를 고른 상태라면
			generateWords(); // 단어 생성
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우(프레임) 종료 버튼에 창닫기 기능 부여
		setVisible(true); // 창의 화면에 나타나도록
	}

	void generateWords() {
		switch (selectcategory) { // 가변한 카테고리에 따라서 배열 달라짐
		case 1:
			list = list1;
			break;
		case 2:
			list = list2;
			break;
		case 3:
			list = list3;
			break;
		case 4:
			list = list4;
			break;
		case 5:
			list = list5;
			break;
		case 6:
			list = list6;
			break;
		case 7:
			list = list7;
			break;
		case 8:
			list = list8;
			break;
		case 9:
			list = list9;
			break;
		case 10:
			list = list10;
			break;
		}
		words = new MovingWord[list.length];
		for (int i = 0; i < list.length; i++) {
			words[i] = new MovingWord();
			words[i].word = list[i];
			words[i].start(); // 쓰레드 객체를 시작하도록 하는 명령

		}
	}

	Timer m_timer = new Timer(); // m 타이머. 시간정지 버튼에서 다시 단어가 움직이게 함
	TimerTask m_task = new TimerTask() {
		@Override
		public void run() {
			for (int i = 0; i < list.length; i++) {
				words[i].resume();
			}
		}
	};
	Timer n_timer = new Timer(); // n 타이머. shield 아이템 지속시간 5초 끝. shield 변수는 0
	TimerTask n_task = new TimerTask() {
		@Override
		public void run() {
			shield = 0;
		}
	};
	Timer p_timer = new Timer(); // p 타이머. doubleshot 아이템 지속시간 5초 끝. doubleshot 변수는 0
	TimerTask p_task = new TimerTask() {
		@Override
		public void run() {
			doubleshot = 0;
		}
	};
	Timer o_timer = new Timer(); // o 타이머. 피버타임 아이템 지속시간 5초 끝. fevertime 변수는 0
	TimerTask o_task = new TimerTask() {
		@Override
		public void run() {
			fevertime = 0;
		}
	};

	class GamePanel extends JPanel {
		@Override
		public void paint(Graphics g) { // repaint()할 때마다 호출됨

			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Font font = new Font("SansSerif", Font.BOLD, 20);
			g2.setFont(font);
			ImageIcon imageIcon5 = new ImageIcon(recovery); // 회복 아이템 이미지
			Image image5 = imageIcon5.getImage();
			g2.drawImage(image5, 1000, 10, this);

			ImageIcon imageIcon6 = new ImageIcon(fever); // 피버타임 아이템 이미지
			Image image6 = imageIcon6.getImage();
			g2.drawImage(image6, 1000, 160, this);

			ImageIcon imageIcon7 = new ImageIcon(delay); // 시간 정지 아이템 이미지
			Image image7 = imageIcon7.getImage();
			g2.drawImage(image7, 1000, 310, this);

			ImageIcon imageIcon8 = new ImageIcon(shot); // 더블샷 아이템 이미지
			Image image8 = imageIcon8.getImage();
			g2.drawImage(image8, 1000, 460, this);

			ImageIcon imageIcon9 = new ImageIcon(Shield); // 실드 아이템 이미지
			Image image9 = imageIcon9.getImage();
			g2.drawImage(image9, 1000, 610, this);

			if (itemtimestop == 0) { // 아이템이 0개가 되면, 다썼다는 표시가 나오게함
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 320, this);
			}
			if (itemshield == 0) {// 아이템이 0개가 되면, 다썼다는 표시가 나오게함
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 620, this);
			}
			if (itemdoubleshot == 0) {// 아이템이 0개가 되면, 다썼다는 표시가 나오게함
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 470, this);
			}
			if (itemfevertime == 0) {// 아이템이 0개가 되면, 다썼다는 표시가 나오게함
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 170, this);
			}
			if (itemlifeplus == 0) {// 아이템이 0개가 되면, 다썼다는 표시가 나오게함
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 20, this);
			}

			if (facestate == true) { // 단어를 맞추고 있는 상태면
				ImageIcon imageIcon1 = new ImageIcon("./image/Win.png"); // 웃는 이미지
				Image image1 = imageIcon1.getImage();
				g2.drawImage(image1, 65, 200, this);
			} else {// 아니라면
				ImageIcon imageIcon2 = new ImageIcon("./image/Lose.png"); // 찡그린 이미지
				Image image2 = imageIcon2.getImage();
				g2.drawImage(image2, 65, 200, this);
			}

			if (words == null)
				return;

			for (int k = 0; k < list.length; k++) {

				g2.drawString(words[k].word, words[k].x, words[k].y); // 단어 그림
			}
			;

			// g2.drawString(w1.word, w1.x, w1.y); //문자열을 패널 상의 해당 좌표에 그려줌
			if (life <= 0 || remainingword == 0) {
				// 종료 조건. 종료조건을 life가 0이 되었거나, 남은 단어가 0개라면
				// 화면 가운데 "Game Over" 표시하기
				resultbtn.setVisible(true); // 결과 버튼이 보이게 함
				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				g2.setFont(font1);
				FontMetrics fm = getFontMetrics(font1);
				int width = fm.stringWidth("Game Over");
				if (remainingword == 0 && life >= 1) { // 남은 단어가 0개이고, 라이프가 1 이상이면
					g2.drawString("Congratulations!", (getWidth() - width) / 2, 210); // 게임 클리어 간주. 축하한다고 말함.
					g2.drawString("Game Clear! your score is " + score, (getWidth() - width) / 2, getHeight() / 2); // 스코어
					// 출력
				} else {
					g2.drawString("Game Over, your score is " + score, (getWidth() - width) / 2, getHeight() / 2);
				}
			}
		}
	}

	class MovingWord extends Thread { // 나만의 움직이는 문자열
		String word = "코리아텍"; // 문자열 초깃값
		int random = (int) (Math.random() * 30); // random이라는 변수로 랜덤한 값을 지정합니다.

		int x = 350 + random * 20, y = 0; // 문자열 좌표

		int time = (int) (Math.random() * 30000); // time이라는 변수로 랜덤한 값을 지정합니다.

		@Override
		public void run() {
			// 랜덤하게 대기
			try {
				sleep(time + 2000); // 대기
				System.out.println(time);
				while (true) { // 무한루프
					y++; // 계속 아래로 이동

					int k = (word.equals("")) ? 1 : 2;

					int c = 0; // c변수 초깃값 0
					for (int i = 0; i < 30; i++) { // 30번까지 반복
						int b = (words[i].word.equals("")) ? 0 : 1; // 공백을 포함하는지 질문, 맞다면 0 아니면 1
						c += b; // 다 더함(모두 공백이라면 c는 0)
					}
					if (c == 0) // c가 0이라면 남은 단어 개수는 remainingword는 0개 ==종료조건.
						remainingword = 0;

					// k라는 변수로 정답 처리 되어서 ""로 떨어지는 중인 word가 ""를 포함하고 있다면 1, 아니면 2로 합니다.
					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {
						// k가 2일때의 조건을 추가합니다.(만약 정답이 아닌 채로 끝까지 떨어졌다면)
						System.out.println("바닥 도착");
						facestate = false;
						word = ""; // 아무 표시 나지 않도록

						if (life >= 0) { // 만약 라이프가 0이상이면
							if (shield == 0) { // 만약 실드 아이템이 활성화가 되지 않았다면
								life--; // 라이프를 1 줄입니다.
							}
						}
						l4.setText("" + life); // life가 화면에 출력되게 합니다.
						combo = 0;
					}
					if (life <= 0 || remainingword == 0) {
						// 만약 life가 0이 되거나 남은 단어가 0개라면
						if (life < 0) {
							life = 0;
							l4.setText("" + life);
						}
						break; // 멈춘다.
					}
					switch (selectlevel) { // selectlevel에 따라 속도 다르게
					case 1:
						sleep(40);
						repaint();
						break;
					case 2:
						sleep(35);
						repaint();
						break;
					case 3:
						sleep(30);
						repaint();
						break;
					case 4:
						sleep(25);
						repaint();
						break;
					case 5:
						sleep(20);
						repaint();
						break;
					case 6:
						sleep(15);
						repaint();
						break;
					case 7:
						sleep(13);
						repaint();
						break;
					case 8:
						sleep(10);
						repaint();
						break;
					case 9:
						sleep(7);
						repaint();
						break;
					case 10:
						sleep(5);
						repaint();
						break;
					}
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new WordGame1();
	}
}