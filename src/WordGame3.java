import java.awt.*; //awt 내의 모든 내가 사용하는 클래스 import

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.util.TimerTask;
import java.util.Timer;

// 자바 스윙 swing

public class WordGame3 extends JFrame {

	Image Back3; // 배경 이미지 설정

	boolean state = true; // 현재 멈춰있는 상태인지 아닌지 판단하기 위한 변수
	MovingWord words[];

	GamePanel panel; // 게임이 진행되는 패널이며, 계속 업데이트

	int selectlevel = 0; // 레벨 선택 변수

	int selectcategory = 0; // 카테고리 선택 변수
	int n = 50; // 초기 프로그래스바를 50으로 설정

	String[] list = { "코리아텍", "견물생심", "우리나라", "프로젝트", "응용프로그래밍", "놀이동산", "카카오", "명중", "한맥제", "훈민정음", "오나라" };

	String[] list1 = { "어디에도", "신호등", "포장마차", "체념", "응급실", "아로하", "스토커", "너였다면", "눈사람", "팔레트", "고백", "편지", "라라라", "소녀",
			"빗속에서", "옛사랑", "아시나요", "거짓말", "애상", "낭만고양이", "보고싶다", "챔피언", "강남스타일", "아버지", "예술이야", "한남자", "겁쟁이", "거리에서",
			"야생화", "음파음파" };

	String[] list2 = { "고양이", "강아지", "거북이", "토끼", "호랑이", "표범", "치타", "하이에나", "코끼리", "코뿔소", "펭귄", "올빼미", "돼지", "독수리",
			"고릴라", "오랑우탄", "침팬지", "원숭이", "코알라", "캥거루", "칠면조", "직박구리", "청설모", "메추라기", "앵무새", "스라소니", "판다", "오소리", "고슴도치",
			"두더지", };

	String[] list3 = { "제니", "지민", "정국", "류진", "전현무", "임영웅", "유재석", "영탁", "나연", "정연", "다현", "쯔위", "아이유", "박서준", "차은우",
			"김수현", "수지", "주지훈", "손예진", "박진영", "성시경", "이승기", "이효리", "조정석", "강호동", "이광수", "송지효", "전소민", "양세찬", "서장훈" };

	String[] list4 = { "축구", "농구", "배구", "핸드볼", "야구", "미식축구", "골프", "배드민턴", "탁구", "수영", "역도", "태권도", "씨름", "유도", "킥복싱",
			"레슬링", "팔씨름", "주짓수", "양궁", "승마", "쇼트트랙", "마라톤", "멀리뛰기", "높이뛰기", "테니스", "풋살", "펜싱", "스키점프", "바이애슬론", "컬링" };

	String[] list5 = { "예지관", "해울관", "함지관", "다솔관", "참빛관", "청솔관", "은솔관", "아우누리", "아우미르", "아우내참", "홍대정", "담헌실학관", "다산정보관",
			"비상", "빠샤", "소울메이트", "한소리", "스플릿", "펜타곤", "로봇사랑", "복지관", "능수관", "코리아텍", "설순욱교수님", "병천", "한솥", "인문경영관",
			"나래돔", "산학협력관", "나우리인성관", };

	String[] list6 = { "이상해씨", "파이리", "꼬부기", "캐터피", "버터풀", "피죤투", "꼬렛", "깨비조", "아보크", "피카츄", "모래두지", "니드런", "픽시",
			"식스테일", "푸크린", "골뱃", "라플레시아", "디그다", "닥트리오", "나옹", "페르시온", "고라파덕", "골덕", "성원숭", "윈디", "캐이시", "알통몬", "꼬마돌",
			"딱구리", "포니타" };

	String[] list7 = { "죽마고우", "수어지교", "각골난망", "군계일학", "백면서생", "좌정관천", "고진감래", "환골탈태", "과유불급", "금의환향", "목불식정", "일자무식",
			"노심초사", "금상첨화", "일석이조", "역지사지", "주객전도", "대기만성", "표리부동", "대동소이", "우이독경", "화룡정점", "불치하문", "사필귀정", "오합지졸",
			"청출어람", "교학상장", "새옹지마", "오매불망", "선견지명" };

	String[] list8 = { "가나", "그리스", "나이지리아", "독일", "러시아", "레바논", "루마니아", "모로코", "몽골", "베트남", "브라질", "스웨덴", "스페인", "알제리",
			"에콰도르", "우루과이", "우크라이나", "이라크", "이란", "이스라엘", "이집트", "인도", "인도네시아", "자메이카", "칠레", "콜롬비아", "크로아티아", "태국",
			"포르투갈", "필리핀" };

	String[] list9 = { "구글", "나이키", "네이버", "넷마블", "농심", "월트디즈니", "롯데", "루이비통", "마이크로소프트", "맥도날드", "삼성", "세븐일레븐", "샤넬",
			"알리바바", "아디다스", "야마하", "유니클로", "코카콜라", "카카오", "쿠팡", "테슬라", "토요타", "페이스북", "파리바게트", "한화", "한국타이어", "금호",
			"트위터", "넷플릭스", "아우디" };

	String[] list10 = { "이즈리얼", "카이사", "루시안", "럭스", "야스오", "사미라", "노틸러스", "탈론", "사일러스", "제라스", "아칼리", "제드", "베인", "케일",
			"블리츠크랭크", "스웨인", "다이애나", "징크스", "케이틀린", "벡스", "니달리", "카직스", "모르가나", "갱플랭크", "파이크", "카타리나", "녹턴", "르블랑",
			"잭스", "쓰레쉬" };
	// 리스트 배열 10개 생성

	JLabel l2;

	JLabel l4;// 컴퓨터와 내 점수 표시 레이블을 멤버 변수로 설정하여 생성자가 아닌 다른 곳에서도 접근하여 수정할 수 있도록.
	JProgressBar progress; // 진행현황 바

	int comword = 0; // 컴퓨터가 맞춘 단어
	int myword = 0; // 내가 맞춘 단어

	int time = 1000; // 떨어지는 시간

	int count; // 전체 단어의 수 카윤트 (단어를 다 맞췄을 때 종료를 위함)

	public WordGame3() {

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 4, (windowSize.height - frameSize.height) / 4); // 화면 중앙에 띄우기
		setSize(1300, 870); // 창의 크기 지정

		JPanel uppan = new JPanel(new FlowLayout());
		JPanel uppan2 = new JPanel(new FlowLayout());
		JPanel uppan3 = new JPanel(new FlowLayout());

		// 판넬 생성

		ImageIcon imageIcon = new ImageIcon("./image/Back3.png"); // 이미지 생성
		Back3 = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		// 배경이미지 크기 지정

		progress = new JProgressBar(0, 100);
		progress.setBackground(Color.BLUE);
		progress.setForeground(Color.RED); // 바의 크기와 색 설정

		JLabel l1 = new JLabel("나 :", JLabel.RIGHT); // 텍스트 오른쪽으로 배치

		l2 = new JLabel("0", JLabel.LEFT); // 텍스트를 왼쪽으로, 멤버변수로 설정된 변수 값을 설정한 것임

		JLabel l3 = new JLabel(": 컴퓨터", JLabel.CENTER); // 텍스트를 가운데

		l4 = new JLabel("0", JLabel.LEFT); // 텍스트를 왼쪽에

		JButton btn = new JButton("ㅣㅣ");
		JButton btnstart = new JButton("시작"); // 시작버튼과 일시정지버튼 설정

		uppan.add(l1);
		uppan.add(l2);
		progress.setValue(n);
		progress.setStringPainted(true);

		uppan2.add(l4);
		uppan2.add(l3);
		uppan3.add(btn);
		uppan3.add(btnstart);

		add(uppan);
		uppan.add(progress);
		uppan.add(uppan2);
		uppan.add(uppan3);
		progress.setVisible(false); // uppan에 l1, l2를 붙이고 바를 넣은 뒤 uppan에 uppan2, uppan3를 넣는다

		l1.setVisible(false);

		l2.setVisible(false);

		l3.setVisible(false);

		l4.setVisible(false);

		btn.setVisible(false); // 초기에는 안 보이기 한다.

		setVisible(true);

		JMenuBar mb = new JMenuBar();

		JMenu level = new JMenu("난이도");

		JMenu category = new JMenu("카테고리");

		JMenuItem item1 = new JMenuItem("1단계");

		JMenuItem item2 = new JMenuItem("2단계");

		JMenuItem item3 = new JMenuItem("3단계");

		JMenuItem item4 = new JMenuItem("4단계");

		JMenuItem item5 = new JMenuItem("5단계");

		JMenuItem item6 = new JMenuItem("6단계");

		JMenuItem item7 = new JMenuItem("7단계");

		JMenuItem item8 = new JMenuItem("8단계");

		JMenuItem item9 = new JMenuItem("9단계");

		JMenuItem item10 = new JMenuItem("10단계");

		level.add(item1);

		level.add(item2);

		level.add(item3);

		level.add(item4);

		level.add(item5);

		level.add(item6);

		level.add(item7);

		level.add(item8);

		level.add(item9);

		level.add(item10);

		JMenuItem tem1 = new JMenuItem("음악");

		JMenuItem tem2 = new JMenuItem("동물");

		JMenuItem tem3 = new JMenuItem("연예인");

		JMenuItem tem4 = new JMenuItem("스포츠");

		JMenuItem tem5 = new JMenuItem("한기대");

		JMenuItem tem6 = new JMenuItem("역이름");

		JMenuItem tem7 = new JMenuItem("포켓몬");

		JMenuItem tem8 = new JMenuItem("나라 이름");

		JMenuItem tem9 = new JMenuItem("브랜드 이름");

		JMenuItem tem10 = new JMenuItem("리그 오브 레전드");

		category.add(tem1);

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

		mb.add(category); // 메뉴를 만든다.

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1단계":
					time = 5000;
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
					time = 4000;
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
					time = 3500;
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
					time = 3000;
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
					time = 2700;
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
					time = 2500;
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
					time = 2000;
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
					time = 1700;
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
					time = 1500;
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
					time = 1000;
					selectlevel = 10;
					level.setText("10단계");
					break;
				}
			}
		}); // 각 레벨 메뉴마다 시간과 레벨을 다르게 설정.

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
				case "역이름":
					selectcategory = 6;
					category.setText("역이름");
					;
					break;
				}
			}
		});

		tem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "포켓몬":
					selectcategory = 7;
					category.setText("포켓몬");
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
				case "브랜드 이름":
					selectcategory = 9;
					category.setText("브랜드 이름");
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
		});// 각 카테고리 메뉴마다 떨어지는 단어 배열을 다르게 설정.

		add(uppan, BorderLayout.NORTH); // 상단 패널을 프레임 북쪽에 배치

		panel = new GamePanel(); // JPanel을 상속받은 나만의 판넬. 화면 중앙 패널
		panel.add(new JLabel(new ImageIcon(Back3))); // 배경이미지를 판넬에 붙이기
		panel.setPreferredSize(new Dimension(300, 300)); // 판넬 크기 지정

		add(panel, BorderLayout.CENTER); // 프레임의 중앙에 배치

		JTextField msgInput = new JTextField(); // 텍스트 입력 콤포넌트

		add(msgInput, BorderLayout.SOUTH); // 프레임 남쪽에 텍스트 입력 필드 배치

		btn.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여

			@Override

			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < list.length; i++) {

					if (e.getActionCommand().equals("ㅣㅣ")) {

						btn.setText("▶");
						repaint();
						words[i].suspend();
						state = false;
						msgInput.setVisible(false);

					} // 일시정지를 눌렀을 때 버튼의 이름이 바뀌고, state = false로 지정, 입력하지 못하도록 설정.

					else {

						btn.setText("ㅣㅣ");
						repaint();
						words[i].resume(); // 쓰레드 객체를 시작하도록 하는 명령
						state = true;

						msgInput.setVisible(true);

					} // 다시 재생을 누르면 버튼의 이름이 바뀌고 state = true로 지정, 입력창 다시 생성.

				}

			}

		});

		msgInput.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여

			@Override

			public void actionPerformed(ActionEvent e) {

				msgInput.getText();

				System.out.println("키보드 엔터키 눌렀군");

				System.out.println("네가 입력한 문자:" + msgInput.getText());

				int t = 0; // 정답 처리 변수, 초기 t값은 0

				int a = msgInput.getText().equals("") ? 1 : 0; // 맞춘 단어 확인

				for (int i = 0; i < words.length; i++) { // 배열 words의 길이만큼 반복

					t = words[i].word.equals(msgInput.getText()) ? 1 : 0;

					// 입력한 단어가 배열 중에 있는가? 있다면 1 아니면 0 변수 t에 저장합니다

					if (t == 1 && a != 1) { // 만약 t가 1이라면

						System.out.println("정답입니다."); // 정답입니다. 를 출력합니다.

						words[i].word = ""; // 그리고 정답 처리된 단어는 공백으로 바뀝니다.(아직 사라진게 아니고 공백으로 계속 내려갑니다.)

						switch (selectlevel) {

						case 1:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 2:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 3:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 4:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 5:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 6:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 7:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 8:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 9:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						case 10:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("카운트 값은 " + count);
							break;

						} // 내가 정답을 맞추면 count값이 줄고, 내가 맞춘 단어인 myword 증가.

						l2.setText("" + myword); // 스코어를 화면에 출력되게 합니다
						progress.setValue(n);
						msgInput.setText(""); // 입력한 문자를 지워줍니다.
						break;

					}

				}

				if (t == 0) { // 만약 t가 1이 아니라면 (입력한 단어가 배열 중에 없다면)

					msgInput.setText(""); // 입력한 문자를 지워줍니다.

				}

			}

		});

		btnstart.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO 자동 생성된 메소드 스텁

				generateWords();

				level.setVisible(false);

				category.setVisible(false);

				l1.setVisible(true);

				l2.setVisible(true);

				l3.setVisible(true);

				l4.setVisible(true);

				progress.setVisible(true);

				btn.setVisible(true);
				btnstart.setVisible(false);
				m_timer.schedule(m_task, 2000, time);

			}

		}); // 시작 버튼을 누르면 메뉴가 보이지 않고, 라벨과 바가 보이도록 설정, 타이머도 2초 뒤 시작하도록 설정.

		if (selectlevel >= 1 && selectcategory >= 1) {

			generateWords(); // 레벨과 카테고리 설정 후 게임 실행

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우(프레임) 종료 버튼에 창닫기 기능 부여

		setVisible(true); // 창의 화면에 나타나도록

	}

	void generateWords() {

		switch (selectcategory) {

		case 1:
			list = list1;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 2:
			list = list2;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 3:
			list = list3;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 4:
			list = list4;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 5:
			list = list5;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 6:
			list = list6;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 7:
			list = list7;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 8:
			list = list8;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 9:
			list = list9;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		case 10:
			list = list10;
			count = list.length;
			System.out.println("카운트 값은 " + count);
			break;

		} // 각 리스트 메뉴에 다른 배열을 넣어줌

		words = new MovingWord[list.length];

		for (int i = 0; i < list.length; i++) {

			words[i] = new MovingWord();

			words[i].word = list[i];

			words[i].start(); // 쓰레드 객체를 시작하도록 하는 명령

		}

	}

	class GamePanel extends JPanel {

		@Override

		public void paint(Graphics g) { // repaint()할 때마다 호출됨

			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Font font = new Font("SansSerif", Font.BOLD, 20); // font의 폰트 지정
			g2.setFont(font);

			if (words == null)
				return;
			for (int i = 0; i < list.length; i++) {
				g.setColor(Color.WHITE); // g2를 이용해 떨어지는 단어를 흰색으로 칠해짐

				g2.drawString(words[i].word, words[i].x, words[i].y);

			}

			// g2.drawString(w1.word, w1.x, w1.y); //문자열을 패널 상의 해당 좌표에 그려줌

			if (count <= 0) {

				// 종료 조건. 종료조건을 life가 0이 되었을 때

				// 화면 가운데 "Game Over" 표시하기

				Font font1 = new Font("SansSerif", Font.BOLD, 20);

				g2.setFont(font1);

				if (n > 50 && count == 0) {

					g2.drawString("Congratulations! You Win", 530, getHeight() / 2);

				} // 단어가 다 사라졌을 때, 내가 더 많이 맞추면 Win

				else {

					g2.drawString("Game Over, your Lose ", 530, getHeight() / 2);

				} // 단어가 다 사라졌을 때, 컴퓨터가 더 많이 맞추면 Lose

			}

		}

	}

	Timer m_timer = new Timer();
	TimerTask m_task = new TimerTask() {

		@Override
		public void run() {
			if (count <= 0 || state == false) {

				System.out.println("컴퓨터 사용금지");
			} // 단어가 다 사라졌거나, 멈춤 상태가 되면 컴퓨터가 입력을 멈춤
			else
				for (int i = 0; i < list.length - 1; i++) {
					double com = Math.random() * 30;
					int com2 = (int) com;
					System.out.println("컴퓨터 입력" + com);
					if (words[(int) com].word.equals("")) {

						break;
					} // 맞췄던 단어를 또 맞추면 아무것도 동작 안 함.
					else
						words[com2].word = ""; // 컴퓨터가 맞춘 단어를 공백처리
					count--; // 전체 단어 수 하나 감소.
					n -= 3.225806452; // 바의 게이지가 컴퓨터쪽으로 3만큼 올라감
					System.out.println("카운트 값은 " + count);
					comword++; // 컴퓨터가 맞춘 단어 수 증가
					l4.setText("" + comword); // 컴퓨터가 맞춘 단어가 화면에 출력되게 합니다.
					progress.setValue(n); // 바 셋팅
					break;
				}

		}

	};

	class MovingWord extends Thread { // 나만의 움직이는 문자열

		String word = "코리아텍"; // 문자열 초깃값

		int random = (int) (Math.random() * 20); // random이라는 변수로 랜덤한 값을 지정합니다.

		int x = random * 55, y = 0; // 문자열 좌표

		int time = (int) (Math.random() * 13000); // time이라는 변수로 랜덤한 값을 지정합니다.

		@Override

		public void run() {

			// 랜덤하게 대기

			try {

				sleep(time); // 대기

				System.out.println(time);

				while (true) { // 무한루프

					y++; // 계속 아래로 이동

					int k = (word.equals("")) ? 1 : 2;

					// k라는 변수로 정답 처리 되어서 ""로 떨어지는 중인 word가 ""를 포함하고 있다면 1, 아니면 2로 합니다.

					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {

						// k가 2일때의 조건을 추가합니다.(만약 정답이 아닌 채로 끝까지 떨어졌다면)

						System.out.println("바닥 도착");

						word = ""; // 아무 표시 나지 않도록
						count--;
						System.out.println("카운트 값은 " + count);

						break;

					}

					if (count <= 0) {

						// 만약 life가 0이 되면 모든 단어를 멈추게 합니다.

						break;

					}

					switch (selectlevel) {

					case 1:
						sleep(40);
						repaint();
						break;

					case 2:
						sleep(40);
						repaint();
						break;

					case 3:
						sleep(40);
						repaint();
						break;

					case 4:
						sleep(30);
						repaint();
						break;

					case 5:
						sleep(30);
						repaint();
						break;

					case 6:
						sleep(30);
						repaint();
						break;

					case 7:
						sleep(20);
						repaint();
						break;

					case 8:
						sleep(20);
						repaint();
						break;

					case 9:
						sleep(20);
						repaint();
						break;

					case 10:
						sleep(10);
						repaint();
						break;

					} // 레벨에 따라 sleep타임을 다르게 설정하여 난이도 조절

				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		new WordGame3(); // WordGame3 실행

	}
}