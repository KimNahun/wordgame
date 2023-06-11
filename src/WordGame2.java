import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*; //import 

public class WordGame2 extends JFrame { // JFrame을 상속 받습니다.

	Image Back2; // WordGame2의 배경화면
	Image Win; // 단어를 맞췄을 상태의 이미지
	Image Lose; // 단어를 틀렸을 때의 이미지
	boolean facestate = true;
	int elapsed; // 타이머의 시간을 알려줄 변수
	private Timer timer; // 시간을 측정할 타이머

	MovingWord words[];
	GamePanel panel; // 게임이 진행되는 패널이며, 계속 업데이트
	int selectlevel = 0; // 메뉴바에서 레벨을 선택할 수 있는데, 초깃값은 0으로합니다.
	int selectcategory = 0; // 메뉴바에서 카테고리를 선택할 수 있는데, 초깃밗은 0으로 합니다.

	String list[] = { "", "", "", "", "", "", "", "", "", "" }; // selectcategory가 0일때의 list
	String list1[] = { "가시", "신호등", "응급실", "스토커", "라라라", "거짓말", "눈물", "소녀", "낭만고양이", "겁쟁이" }; // selectcategory가 1일때의
	// list...계속 이어집니다.
	String list2[] = { "닭", "곰", "거북이", "사자", "고슴도치", "코끼리", "돼지", "오리", "기린", "고양이" };
	String list3[] = { "유재석", "아이유", "백종원", "수지", "박진영", "성시경", "나훈아", "서장훈", "박명수", "지수" };
	String list4[] = { "축구", "농구", "야구", "태권도", "수영", "양궁", "승마", "피겨", "사이클", "스키" };
	String list5[] = { "한울관", "아우누리", "다산정보관", "소울메이트", "복지관", "병천", "대즐", "아우미르", "정약용", "솔빛관" };
	String list6[] = { "피카츄", "리자드", "닥트리오", "피죤투", "꼬부기", "이상해씨", "라이츄", "주뱃", "나옹", "포니타" };
	String list7[] = { "죽마고우", "계륵", "과유불급", "금의환향", "일자무식", "다다익선", "역지사지", "우이독경", "청출어람", "새옹지마" };
	String list8[] = { "그리스", "포르투갈", "미국", "베트남", "브라질", "일본", "이집트", "독일", "영국", "인도" };
	String list9[] = { "넥슨", "네이버", "구글", "농심", "씨유", "페이스북", "맥도날드", "애플", "코카콜라", "카카오" };
	String list10[] = { "이즈리얼", "신지드", "갱플랭크", "야스오", "요네", "노틸러스", "비에고", "가렌", "티모", "제라스" };

	String question1 = "그대 기억이 지난 사랑이 내 안을 파고드는 가시가 되어"; // 카테고리가 10개이고, 1카테고리당 10문제씩, 총question은 100개입니다.
	String question2 = "붉은색 푸른색 그사이 3초 그 짧은 시간";
	String question3 = "이 바보야 진짜 아니야";
	String question4 = "나도 알아 나의 문제가 무엇인지";
	String question5 = "사랑 노래 함께 불러요 둘이서 라라라";
	String question6 = "I’m so sorry but I love you 다 거짓말";
	String question7 = "좁은 골목길 사이 혼자 눈물";
	String question8 = "내 곁에만 머물러요 떠나면 안 돼요";
	String question9 = "나는 낭만고양이~";
	String question10 = "나는 겁쟁이랍니다~";

	String question11 = "치킨은 이것으로 만든다";
	String question12 = "O 3마리가 한집에 있어";
	String question13 = "토끼와 OOO";
	String question14 = "밀림의 왕";
	String question15 = "몸에 가시가 있는 동물";
	String question16 = "코가 긴 동물";
	String question17 = "뚱뚱한 사람을 이 동물이라고 한다";
	String question18 = "꽥꽥 하며 우는 동물";
	String question19 = "연예인 이광수의 동물 별명은?";
	String question20 = "강아지 다음으로 인기 있는 동물";

	String question21 = "런닝맨의 메인 MC";
	String question22 = "좋은 날을 부른 가수";
	String question23 = "OOO의 골목 식당";
	String question24 = "미쓰에이의 멤버";
	String question25 = "JYP";
	String question26 = "가장 많은 사람을 재운 가수";
	String question27 = "테스형!";
	String question28 = "농구하다 예능계로 온 사람";
	String question29 = "무한도전의 2인자";
	String question30 = "디올의 앰버서더";

	String question31 = "4년마다 월드컵을 하는 스포츠 종목";
	String question32 = "서장훈";
	String question33 = "류현진";
	String question34 = "우리나라의 심신단련 스포츠";
	String question35 = "헤드셋을 낀 박태환";
	String question36 = "이 종목은 우리나라가 세계 최강";
	String question37 = "말을 타는 종목";
	String question38 = "김연아";
	String question39 = "자전거를 타는 종목";
	String question40 = "한 겨울에 연인과 함께 타는 스포츠";

	String question41 = "솔빛관과 함지관 사이에 위치한 기숙사";
	String question42 = "한기대 공식 포털사이트 이름";
	String question43 = "한기대 도서관 이름";
	String question44 = "노래를 부르기 좋아하면 들어가는 동아리";
	String question45 = "GS25 편의점이 있는 건물. 다산정보관 옆";
	String question46 = "한기대는 OO면에 있다.";
	String question47 = "한기대 카페 이름";
	String question48 = "공식 기숙사 공지 포털사이트 이름";
	String question49 = "다산 OOO. 조선 후기 실학 연구";
	String question50 = "가장 높은 성적 커트라인의 기숙사";

	String question51 = "지우가 데리고 다니는 영원히 진화 못하는 포켓몬";
	String question52 = "파이리가 진화하면?";
	String question53 = "땅 속에 사는, 머리가 3개인 포켓몬";
	String question54 = "피죤이 진화하면?";
	String question55 = "피카츄 라이츄 파이리 OOO";
	String question56 = "이중 풀타입 포켓몬은?";
	String question57 = "피카츄가 진화하면?";
	String question58 = "비행/독 타입 포켓몬";
	String question59 = "유일하게 사람과 대화 가능한 포켓몬";
	String question60 = "동물 말을 모티브로 만든 포켓몬";

	String question61 = "어릴 때부터 함께 커온 오랜 친구";
	String question62 = "쓸모는 없으나 버리기엔 아까운 것";
	String question63 = "지나친 것은 미치지 못한 것과 같다는 뜻";
	String question64 = "출세를 하여 고향에 돌아간다는 뜻";
	String question65 = "한 글자도 모르는, 아주 무식함을 이르는 말";
	String question66 = "많으면 많을수록 좋다는 뜻";
	String question67 = "처지를 서로 바꾸어 생각함이라는 뜻";
	String question68 = "쇠 귀에 경 읽기";
	String question69 = "제자가 스승보다 낫다는 뜻";
	String question70 = "인생의 길흉화복은 예측할 수 없음";

	String question71 = "OOO 로마 신화";
	String question72 = "호날두는 이 나라의 축구 선수";
	String question73 = "조 바이든이 대통령인 나라";
	String question74 = "박항서가 축구 감독으로 있는 나라";
	String question75 = "네이마르는 이 나라의 축구 선수";
	String question76 = "우리나라 근방에 위치한 섬 나라";
	String question77 = "피라미드";
	String question78 = "베를린이 수도인 나라";
	String question79 = "런던이 수도인 나라";
	String question80 = "세계 인구 2위의 나라";

	String question81 = "메이플스토리를 만든 게임 회사";
	String question82 = "초록창";
	String question83 = "래리 페이지 & 세르게이 브린";
	String question84 = "라면 만드는 기업";
	String question85 = "편의점";
	String question86 = "마크 주커버그";
	String question87 = "햄버거 프랜차이즈 기업";
	String question88 = "스티브 잡스";
	String question89 = "콜라를 만드는 기업";
	String question90 = "OOO톡";

	String question91 = "많고 많은~ 많고 많은~ 많고 많은~";
	String question92 = "섞고 섞고 돌리고 섞고";
	String question93 = "w 스킬이 괴혈병 치료인 챔피언";
	String question94 = "과학, 그 자체";
	String question95 = "수학을 담당하고 있는 챔피언";
	String question96 = "물이 깊으니 조심해";
	String question97 = "남의 궁극기 뺏어다가 쓰는 챔피언";
	String question98 = "가붕이";
	String question99 = "헛 둘 셋 넷!";
	String question100 = "서폿인데 견제하는 척 원딜 cs 뺏어먹는 챔피언";

	String question[] = { "", "", "", "", "", "", "", "", "", "" }; // selectcategory가 0일때의 질문입니다.
	String questionA[] = { question1, question2, question3, question4, question5, question6, question7, question8,
			question9, question10 }; // selectcategory가 1일때의 질문입니다. 계속 이어집니다.
	String questionB[] = { question11, question12, question13, question14, question15, question16, question17,
			question18, question19, question20 };
	String questionC[] = { question21, question22, question23, question24, question25, question26, question27,
			question28, question29, question30 };
	String questionD[] = { question31, question32, question33, question34, question35, question36, question37,
			question38, question39, question40 };
	String questionE[] = { question41, question42, question43, question44, question45, question46, question47,
			question48, question49, question50 };
	String questionF[] = { question51, question52, question53, question54, question55, question56, question57,
			question58, question59, question60 };
	String questionG[] = { question61, question62, question63, question64, question65, question66, question67,
			question68, question69, question70 };
	String questionH[] = { question71, question72, question73, question74, question75, question76, question77,
			question78, question79, question80 };
	String questionI[] = { question81, question82, question83, question84, question85, question86, question87,
			question88, question89, question90 };
	String questionJ[] = { question91, question92, question93, question94, question95, question96, question97,
			question98, question99, question100 };

	JLabel l2;// 스코어 표시 레이블을 멤버 변수로 설정하여 생성자가 아닌 다른 곳에서도 접근하여 수정할 수 있도록.
	JLabel l4;// 라이프 표시 레이블

	JPanel face = new JPanel();
	int life = 5; // life 의 초깃값은 5
	int score; // 스코어
	double correctword = 0; // 문제를 맞추면 correctword가 1 올라갑니다. 초깃값은 0.0
	int correctanswer = 0; // correctanswer의 초깃값은 0
	double incorrectword = 0; // 문제를 틀리면 incorrectword가 1 올라갑니다. 초깃값은 0.0
	String realanswer = "정답"; // realanswer의 초깃값은 "정답"

	int remainingword = list.length; // 남은 단어가 몇개인지 알기위해서, 초깃값은 list.length인 10개입니다.
	int v[] = new int[list.length]; // v 배열 선언
	String answer[] = new String[list.length]; // answer 배열 선언.
	String realquestion[] = new String[list.length]; // realquestion 배열 선언.
	int answeranswer = 0; // answeranswer은 초깃밗 0
	int number = 0; // number의 초깃값은 0

	public WordGame2() {

		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 4, (windowSize.height - frameSize.height) / 4); // 화면 중앙에 띄우기
		setSize(1300, 870); // 창의 크기 지정
		// 필요한 컴포넌트 배치
		setLayout(new BorderLayout()); // 배치 방식을 지정
		Panel info = new Panel(new GridLayout(2, 1)); // 1행 4열 상단 패널 준비

		JPanel Fir = new JPanel(new GridLayout(1, 5));
		JPanel Sec = new JPanel(new FlowLayout());

		JLabel QnA = new JLabel("문제 나오는 칸", JLabel.CENTER); // 텍스트 오른쪽으로 배치

		JLabel l1 = new JLabel("Score:", JLabel.RIGHT); // 텍스트 오른쪽으로 배치
		l2 = new JLabel("0", JLabel.LEFT); // 텍스트를 왼쪽으로, 멤버변수로 설정된 변수 값을 설정한 것임
		JLabel l3 = new JLabel("Life:", JLabel.CENTER); // 텍스트를 가운데
		l4 = new JLabel("" + life, JLabel.LEFT); // 텍스트를 왼쪽에
		JButton btn = new JButton("ㅣㅣ"); // 정지, 시작버튼을 설정해주기 위한 버튼. 처음에는 ||(정지) 입니다.
		JMenuBar mb = new JMenuBar();
		JButton btnstart = new JButton("시작"); // btnstart 버튼을 만듭니다. 처음은 "시작"

		JMenu level = new JMenu("난이도"); // 메뉴바에 난이도를 추가합니다.
		JMenu category = new JMenu("카테고리"); // 메뉴바에 카테고리를 추가합니다.

		ImageIcon imageIcon1 = new ImageIcon("./image/Back2.png");
		Back2 = imageIcon1.getImage().getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH); // 배경화면

		ImageIcon imageIcon2 = new ImageIcon("./image/Win.png");
		Win = imageIcon2.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // 단어를 맞추고 있을때의 이미지

		ImageIcon imageIcon3 = new ImageIcon("./image/Lose.png");
		Lose = imageIcon3.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // 단어를 틀렸을 때의 이미지

		l3.setFont(new Font("Verdana", Font.BOLD, 20)); // 레이블의 폰트 지정
		l3.setPreferredSize(new Dimension(100, 40)); // 레이블의 크기 지정
		l3.setForeground(Color.CYAN); // 텍스트 컬러 지정
		l3.setBackground(Color.BLUE); // 백그라운드 컬러 지정
		l3.setOpaque(true); // 백그라운드 색상이 적용되려면 필요

		info.add(Fir);
		info.add(Sec);

		Fir.add(btnstart); // 시작 버튼 추가
		Fir.add(l1); // 상단 패널에 레이블 순서대로 추가 (점수와 생명 등 확인용)
		Fir.add(l2);
		Fir.add(l3);
		Fir.add(l4);

		Fir.add(btn);
		Sec.add(QnA);

		l1.setVisible(false); // 처음에는 보이지 않습니다.
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);

		btnstart.setBackground(Color.WHITE); // 시작버튼의 색은 흰색

		JMenuItem item1 = new JMenuItem("1단계"); // 1단계 ~ 10단계를 추가합니다.
		JMenuItem item2 = new JMenuItem("2단계");
		JMenuItem item3 = new JMenuItem("3단계");
		JMenuItem item4 = new JMenuItem("4단계");
		JMenuItem item5 = new JMenuItem("5단계");
		JMenuItem item6 = new JMenuItem("6단계");
		JMenuItem item7 = new JMenuItem("7단계");
		JMenuItem item8 = new JMenuItem("8단계");
		JMenuItem item9 = new JMenuItem("9단계");
		JMenuItem item10 = new JMenuItem("10단계");

		level.add(item1); // 추가한 1~10단계를 ,level 메뉴바에 놓습니다.
		level.add(item2);
		level.add(item3);
		level.add(item4);
		level.add(item5);
		level.add(item6);
		level.add(item7);
		level.add(item8);
		level.add(item9);
		level.add(item10);

		JMenuItem tem1 = new JMenuItem("음악"); // 음악 ~ 리그오브레전드까지의 카테고리를 메뉴바에 놓습니다.
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
		panel.add(new JLabel(new ImageIcon(Back2)));
		panel.setPreferredSize(new Dimension(300, 300));
		add(panel, BorderLayout.CENTER); // 프레임의 중앙에 배치
		JTextField msgInput = new JTextField(); // 텍스트 입력 콤포넌트
		add(msgInput, BorderLayout.SOUTH); // 프레임 남쪽에 텍스트 입력 필드 배치
		btn.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여.(정지버튼)
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.length; i++) { // 배열 길이만큼 반복
					if (e.getActionCommand().equals("ㅣㅣ")) { // 만약 버튼이 ||상태면
						btn.setText("▶"); // 버튼을 ▶ 로 보이게 하고
						words[i].suspend(); // 단어를 멈추게합니다.
						repaint(); // 리페인트
						msgInput.setVisible(false); // 단어가 멈춘 상태에서는 타이핑을 하지 못하게 합니다.
					} else { // 만약 버튼이 ||상태가 아닌 경우라면
						btn.setText("ㅣㅣ"); // 버튼은 ||이 되고
						words[i].resume(); // 쓰레드 객체를 시작하도록 하는 명령
						repaint();
						msgInput.setVisible(true); // 다시 시작하면, 그 후로는 타이핑을 할 수 있습니다.
					}
				}
			}
		});

		msgInput.addActionListener(new ActionListener() { // 이벤트 처리 기능 부여. 키보드가 입력되면
			@Override
			public void actionPerformed(ActionEvent e) {
				msgInput.getText();
				int t = 0; // t의 초깃값은 0

				int a = msgInput.getText().equals("") ? 1 : 0; // 입력에 ""를 포함하고 있나? 맞다면 a는 1 아니면 0

				switch (number) { // 스위치문. number가 가변되는데, 가변되는 값에 따라서 t의 조건을 다르게 함.
				case 0:
					t = answer[0].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 1:
					t = answer[1].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 2:
					t = answer[2].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 3:
					t = answer[3].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 4:
					t = answer[4].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 5:
					t = answer[5].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 6:
					t = answer[6].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 7:
					t = answer[7].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 8:
					t = answer[8].equals(msgInput.getText()) ? 1 : 0;
					break;
				case 9:
					t = answer[9].equals(msgInput.getText()) ? 1 : 0;
					break;
				}

				for (int i = 0; i < words.length; i++) { // 배열 words의 길이만큼 반복

					if (t == 1 && a != 1) { // 만약 t가 1이고 a가 1이 아니라면
						System.out.println("정답입니다."); // 정답입니다. 를 출력합니다.
						number++; // 여기서 number가 가변됩니다. ( 정답일 때마다)
						facestate = true; // 이미지는 웃는 얼굴
						switch (number) { // 가변된 number가 1~9냐에 따라서 질문을 다르게 합니다.
						case 0:
							QnA.setText("" + realquestion[0]);
							break;
						case 1:
							QnA.setText("" + realquestion[1]);
							break;
						case 2:
							QnA.setText("" + realquestion[2]);
							break;
						case 3:
							QnA.setText("" + realquestion[3]);
							break;
						case 4:
							QnA.setText("" + realquestion[4]);
							break;
						case 5:
							QnA.setText("" + realquestion[5]);
							break;
						case 6:
							QnA.setText("" + realquestion[6]);
							break;
						case 7:
							QnA.setText("" + realquestion[7]);
							break;
						case 8:
							QnA.setText("" + realquestion[8]);
							break;
						case 9:
							QnA.setText("" + realquestion[9]);
							break;
						}

						remainingword--; // 처음에 50개로 선언된 remainingword에서 1개 뺌.
						switch (selectlevel) { // 메뉴바에서 가변한 selectlevel이 1~10이냐에 따라 점수가 다르게 오릅니다.
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

						l2.setText("" + score); // 스코어를 화면에 출력되게 합니다
						msgInput.setText(""); // 입력한 문자를 지워줍니다.
						correctword++; // correctanswer가 오릅니다
						answeranswer++; // answeranswer가 오릅니다.
						break;
					}
				}

				if (t == 0) { // 만약 t가 1이 아니라면 (입력한 단어가 배열 중에 없다면)
					for (int j = 0; j < words.length; j++) { // words의 길이만큼 반복
						int r = words[j].word.equals(msgInput.getText()) ? 1 : 0;
						// r은 변수 t의 기능과 동일합니다
						r += r;// 모든 r을 더하고, 하나라도 같다면 1이 나와야 합니다.( 모두 틀렸다면 0이 나옵니다.)
						if (life > 0) {
							if (r == 0) { // 만약 r이 0이라면(모든 r을 더해봐도 1이 되지 않았다면)
								life--; // 틀린 값을 입력했다고 간주하고 스코어를 깎습니다.
								l4.setText("" + life); // 스코어를 화면에 출력되게 합니다.
								msgInput.setText(""); // 입력한 문자를 지워줍니다.
								incorrectword++; // incorrectword가 오릅니다.

								System.out.println("틀렸습니다"); // 틀렸습니다. 출력
								facestate = false; // 이미지파일 찡그린 얼굴
								break;
							}
						} else {
							msgInput.setText(""); // 아니어도, 일단 입력한 단어를 지워줍니다.
						}
					}
				}
			}
		});
		btnstart.addActionListener(new ActionListener() { // 시작버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
				generateWords(); // 단어를 생성합니다.
				QnA.setText("" + realquestion[0]); // realquestion의 0번째 원소로 화면 중앙에 띄웁니다.
				level.setVisible(false);
				category.setVisible(false); // 레벨,카테고리 메뉴바가 이제 필요없으니 보이지 않게 하고
				l1.setVisible(true); // score, life등을 보이게 합니다.
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				remainingword = list.length; // 남은 단어의 개수는 list배열의 길이
				timer = new Timer(1000, new PeriodicTask()); // 1초 주기 타이머 객체 생성
				timer.start(); // 타이머 시작
			}
		});
		if (selectlevel >= 1 && selectcategory >= 1) { // selectlevel이 1이상이고, selectcategory가 1이상이면
			generateWords(); // 단어 생성
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우(프레임) 종료 버튼에 창닫기 기능 부여
		setVisible(true); // 창의 화면에 나타나도록
	}

	private class PeriodicTask implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 주기적 타이머 이벤트 발생시마다 호출되는 메소드
			if (elapsed > 300 || correctword >= 10 || life <= 0) {
				timer.stop(); // 타이머가 멈추는 조건
				System.out.println("타이머 종료");
			}
			// 여러가지 작업을 할 수 있겠지만, 단순히 주기마다 숫자 올라갑니다.
			elapsed++;
			repaint();
			System.out.println(elapsed);
		}

	}

	void generateWords() {

		switch (selectcategory) { // selectcatory가 1~10이냐에 따라서, 어떤 답일지와, 어떤 질문일지가 결정됩니다.
		case 1:
			list = list1;
			question = questionA;
			break;
		case 2:
			list = list2;
			question = questionB;
			break;
		case 3:
			list = list3;
			question = questionC;
			break;
		case 4:
			list = list4;
			question = questionD;
			break;
		case 5:
			list = list5;
			question = questionE;
			break;
		case 6:
			list = list6;
			question = questionF;
			break;
		case 7:
			list = list7;
			question = questionG;
			break;
		case 8:
			list = list8;
			question = questionH;
			break;
		case 9:
			list = list9;
			question = questionI;
			break;
		case 10:
			list = list10;
			question = questionJ;
			break;
		}

		for (int i = 0; i < v.length; i++) {
			v[i] = (int) (Math.random() * list.length + 1);
			for (int j = 0; j < i; j++) {
				if (v[i] == v[j]) {
					i--;
				}
			}
		}
		for (int k = 0; k < v.length; k++) {
			answer[k] = list[v[k] - 1];
			realquestion[k] = question[v[k] - 1];
		} // 질문이 랜덤하게 나오는데, 이전에 했던 질문이 겹칠수도 있습니다. 이전에 이미 한 질문은 더 질문하지 않도록 설정합니다.

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
			Font font = new Font("SansSerif", Font.BOLD, 20); // 폰트 지정
			g2.setFont(font);
			Graphics2D g3 = (Graphics2D) g;
			Font font3 = new Font("SansSerif", Font.BOLD, 20);
			g3.setFont(font3);
			g3.setColor(Color.BLACK);
			g3.drawString("Elapsed Time: " + elapsed, 1000, 30);
			if (facestate == true) { // 현재 단어를 맞추고 있는 상태라면 웃고 있는 이미지
				ImageIcon imageIcon1 = new ImageIcon("./image/Win.png");
				Image image = imageIcon1.getImage();
				g.setColor(Color.WHITE);
				g2.drawImage(image, 65, 200, this);
			} else { // 아니라면 얼굴을 찡그리고 있는 이미지
				ImageIcon imageIcon2 = new ImageIcon("./image/Lose.png");
				Image image = imageIcon2.getImage();
				g2.drawImage(image, 65, 200, this);
			}
			if (words == null)
				return; // 아직 words 가 없다면, 다시 리턴

			for (int i = 0; i < list.length; i++) { // 흰 색으로 단어를 그립니다.
				g.setColor(Color.WHITE);
				g2.drawString(words[i].word, words[i].x, words[i].y);
			}
			;

			if (life <= 0 || correctword >= 10) {
				// 종료 조건. 종료조건을 life가 0이 되었을 때 , 단어를 10개 이상 맞췄을 때

				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				g2.setFont(font1);
				FontMetrics fm = getFontMetrics(font1);
				int width = fm.stringWidth("Game Over"); // 게임 오버.
				int realscore = score * ((300 - elapsed) / 100); // 경과된 시간에 따라서 점수를 다르게ㅔ
				System.out.println(realscore);
				if (life >= 1) { // 라이프가 1 이상이면 , 축하한다며 당신의 스코어는 realscore
					g2.drawString("Congratulations!", (getWidth() - width) / 2, 210);
					g2.drawString("Game Clear! your score is " + realscore, 600, 250);
				} else { // 라이프가 0이 되었다면, game over, 단신의 스코어는 realscore
					g2.drawString("Game Over, your score is " + realscore, 600, 250);
				}
				double accuracy = correctword / (incorrectword + correctword) * 100; // 정확도 측정
				double word = correctword + incorrectword; // 총 입력한 단어의 개수
				g2.drawString("당신이 입력한 단어 수는" + (int) word + "개", (getWidth() - width) / 2, 290); // 총 입력한 단어의 개수
				g2.drawString("이중 정확히 입력한 단어는" + (int) correctword + "개", (getWidth() - width) / 2, 310); // 맞춘 단어의 개수
				g2.drawString("틀리게 입력한 단어는" + (int) incorrectword + "개", (getWidth() - width) / 2, 330); // 틀린 단어의 개수
				g2.drawString("따라서 정확도는" + (int) accuracy + "퍼센트", (getWidth() - width) / 2, 350); // 정확도

			}
		}
	}

	class MovingWord extends Thread { // 나만의 움직이는 문자열
		String word = "코리아텍"; // 문자열 초깃값
		int random = (int) (Math.random() * 20); // random이라는 변수로 랜덤한 값을 지정합니다.
		int x = 350 + random * 25, y = 0; // 문자열 좌표
		int time = (int) (Math.random() * 7000); // time이라는 변수로 랜덤한 값을 지정합니다.

		@Override
		public void run() {
			// 랜덤하게 대기
			try {
				sleep(time + 2000); // 대기
				while (true) { // 무한루프
					y++; // 계속 아래로 이동
					int k = (word.equals("")) ? 1 : 2;
					// k라는 변수로 정답 처리 되어서 ""로 떨어지는 중인 word가 ""를 포함하고 있다면 1, 아니면 2로 합니다.
					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {
						// k가 2일때의 조건을 추가합니다.(만약 정답이 아닌 채로 끝까지 떨어졌다면)
						y = 0;
						remainingword--; // 남은 단어개수 줄이기

					}
					if (life <= 0 || correctword >= 10) {
						// 만약 life가 0이 되거나 단어를 10개 이상 맞추면
						break; // 멈춥니다.
					}
					switch (selectlevel) { // selectlevel에 따라서 속도 가변
					case 1:
						sleep(30);
						repaint();
						break;
					case 2:
						sleep(25);
						repaint();
						break;
					case 3:
						sleep(20);
						repaint();
						break;
					case 4:
						sleep(18);
						repaint();
						break;
					case 5:
						sleep(16);
						repaint();
						break;
					case 6:
						sleep(14);
						repaint();
						break;
					case 7:
						sleep(12);
						repaint();
						break;
					case 8:
						sleep(10);
						repaint();
						break;
					case 9:
						sleep(8);
						repaint();
						break;
					case 10:
						sleep(6);
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
		new WordGame2();
	}
}