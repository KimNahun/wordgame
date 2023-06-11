import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MODE extends JFrame {

	public MODE() {

		super("모드 선택"); // 타이틀
		JPanel jPanel = new JPanel(); // 판넬 생성
		JButton btn1 = new JButton("일반모드");
		JButton btn2 = new JButton("스페셜모드");
		JButton btn3 = new JButton("컴퓨터와 대결"); // 버튼 3개 생성
		setSize(300, 200); // 창 크기 설정
		jPanel.add(btn1);
		jPanel.add(btn2);
		jPanel.add(btn3); // 버튼을 판넬에 붙여여주기
		add(jPanel); // 판넬을 프레임에 붙이기
		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 설정
		setVisible(true); // 화면이 보이도록 하기

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame1();
				setVisible(false); // 창 안보이게 하기
			}
		}); // 버튼 1번을 눌렀을 때는 WordGame1클래스로 가도록 하기
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame2();
				setVisible(false); // 창 안보이게 하기
			}
		}); // 버튼 2번을 눌렀을 때는 WordGame2클래스로 가도록 하기
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame3();
				setVisible(false); // 창 안보이게 하기
			}
		}); // 버튼 3번을 눌렀을 때는 WordGame3클래스로 가도록 하기
	}

	public static void main(String[] args) {
		new MODE(); // MODE 클래스 실행
	}
}