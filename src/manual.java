import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class manual extends JFrame {

	public manual() {

		super("설명서"); // 타이틀
		setSize(1000, 800); // 창 크기 설정

		Font font = new Font("Serif", Font.BOLD, 18); // 폰트 크기 지정

		JPanel all = new JPanel(new GridLayout(30, 5)); // 판넬 생성
		all.setFont(font);

		JLabel manu1 = new JLabel("<게임 방법>");
		all.add(manu1, BorderLayout.CENTER);
		manu1.setFont(font);
		JLabel manual0 = new JLabel("이  게임은  산성비  게임으로  3가지의  모드가  존재합니다. ");
		all.add(manual0, BorderLayout.CENTER);
		manual0.setFont(font);
		JLabel manual01 = new JLabel("먼저  모드를  선택하고,  게임화면이  뜨면  왼쪽  위  상단바의  메뉴와  난이도를  선택하세요.");
		all.add(manual01, BorderLayout.CENTER);
		manual01.setFont(font);
		JLabel manual02 = new JLabel(" 시작 버튼을 누르면 게임이 시작됩니다.");
		all.add(manual02, BorderLayout.CENTER);
		manual02.setFont(font);
		JLabel blank1 = new JLabel();
		all.add(blank1, BorderLayout.CENTER);

		JLabel manual03 = new JLabel(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual03, BorderLayout.CENTER);
		JLabel blank2 = new JLabel();
		all.add(blank2, BorderLayout.CENTER);

		JLabel manual1 = new JLabel("MODE 1은 일반 모드로 단어의 수는 총 30개이며, 아이템을 사용할 수 있습니다");
		manual1.setPreferredSize(new Dimension(50, 50));
		all.add(manual1, BorderLayout.CENTER);
		manual1.setFont(font);

		JLabel manual11 = new JLabel(
				"아이템 1: 라이프 1증가                                                                             (스코어 차감 300점, 1번 사용 가능)");
		all.add(manual11, BorderLayout.CENTER);
		manual11.setFont(font);

		JLabel manual12 = new JLabel(
				"아이템 2: 5초동안 피버타임<점수 2배>                                                  (스코어 차감 500점, 1번 사용 가능)");
		all.add(manual12, BorderLayout.CENTER);
		manual12.setFont(font);
		JLabel manual13 = new JLabel(
				"아이템 3: 5초동안 잠시 멈춤                                                                     (스코어 차감 700점, 1번 사용 가능)");
		all.add(manual13, BorderLayout.CENTER);
		manual13.setFont(font);
		JLabel manual14 = new JLabel("아이템 4: 멀티샷 <5초동안 단어 맞출 시 일정확률로 2개 제거>          (스코어 차감 700점, 1번 사용 가능)");
		all.add(manual14, BorderLayout.CENTER);
		manual14.setFont(font);
		JLabel manual15 = new JLabel(
				"아이템 5: 5초동안 라이프가 차감되지 않음                                            (스코어 차감 1000점, 1번 사용 가능)");
		all.add(manual15, BorderLayout.CENTER);
		manual15.setFont(font);
		JLabel manual16 = new JLabel();
		all.add(manual16, BorderLayout.CENTER);
		JLabel manual17 = new JLabel(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual17, BorderLayout.CENTER);
		JLabel manual18 = new JLabel();
		all.add(manual18, BorderLayout.CENTER);

		JLabel manual2 = new JLabel("MODE 2는 스페셜 모드로 문제를 맞추는 게임입니다.");
		all.add(manual2, BorderLayout.CENTER);
		manual2.setFont(font);
		manual12.setFont(font);
		JLabel manual21 = new JLabel("문제의 답은 떨어지는 단어중에 있으며 단어가 떨어져도 라이프는 차감되지 않습니다.");
		all.add(manual21, BorderLayout.CENTER);
		manual21.setFont(font);
		JLabel blank3 = new JLabel();
		all.add(blank3, BorderLayout.CENTER);

		JLabel manual22 = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual22, BorderLayout.CENTER);
		JLabel blank4 = new JLabel();
		all.add(blank4, BorderLayout.CENTER);

		JLabel manual3 = new JLabel("MODE 3은 컴퓨터와의 대결 모드로 컴퓨터보다 더 많은 단어를 맞추면 승리합니다.");
		all.add(manual3, BorderLayout.CENTER);
		manual3.setFont(font);
		JLabel blank5 = new JLabel();
		all.add(blank5, BorderLayout.CENTER);
		JLabel manual23 = new JLabel(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual23, BorderLayout.CENTER);
		JLabel blank6 = new JLabel();
		all.add(blank6, BorderLayout.CENTER);
		JLabel manual24 = new JLabel("Good Luck");
		all.add(manual24, BorderLayout.CENTER);
		manual24.setFont(font);

		// 필요한 라벨을 위치와 폰트를 지정해준 후 판넬에 붙여줌.

		add(all, BorderLayout.NORTH); // 상단 패널을 프레임 북쪽에 배치

		all.setVisible(true); // 보이게 하기
		JButton btn1 = new JButton("확인"); // 버튼 생성
		add(btn1, BorderLayout.SOUTH); // 프레임 남쪽에 텍스트 입력 필드 배치
		add(all, BorderLayout.CENTER); // 프레임 센터에 텍스트 입력 필드 배치

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료설정
		setVisible(true);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MODE(); // MODE 클래스로 넘어가도록 하기
				setVisible(false); // 창 안보이게 하기
			}
		});

	}

	public static void main(String[] args) {
		new manual(); // manual 클래스 실행
	}
}