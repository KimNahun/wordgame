import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MODE extends JFrame {

	public MODE() {

		super("��� ����"); // Ÿ��Ʋ
		JPanel jPanel = new JPanel(); // �ǳ� ����
		JButton btn1 = new JButton("�Ϲݸ��");
		JButton btn2 = new JButton("����ȸ��");
		JButton btn3 = new JButton("��ǻ�Ϳ� ���"); // ��ư 3�� ����
		setSize(300, 200); // â ũ�� ����
		jPanel.add(btn1);
		jPanel.add(btn2);
		jPanel.add(btn3); // ��ư�� �ǳڿ� �ٿ����ֱ�
		add(jPanel); // �ǳ��� �����ӿ� ���̱�
		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // ȭ�� �߾ӿ� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� ����
		setVisible(true); // ȭ���� ���̵��� �ϱ�

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame1();
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		}); // ��ư 1���� ������ ���� WordGame1Ŭ������ ������ �ϱ�
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame2();
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		}); // ��ư 2���� ������ ���� WordGame2Ŭ������ ������ �ϱ�
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WordGame3();
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		}); // ��ư 3���� ������ ���� WordGame3Ŭ������ ������ �ϱ�
	}

	public static void main(String[] args) {
		new MODE(); // MODE Ŭ���� ����
	}
}