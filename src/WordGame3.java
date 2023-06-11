import java.awt.*; //awt ���� ��� ���� ����ϴ� Ŭ���� import

import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.util.TimerTask;
import java.util.Timer;

// �ڹ� ���� swing

public class WordGame3 extends JFrame {

	Image Back3; // ��� �̹��� ����

	boolean state = true; // ���� �����ִ� �������� �ƴ��� �Ǵ��ϱ� ���� ����
	MovingWord words[];

	GamePanel panel; // ������ ����Ǵ� �г��̸�, ��� ������Ʈ

	int selectlevel = 0; // ���� ���� ����

	int selectcategory = 0; // ī�װ� ���� ����
	int n = 50; // �ʱ� ���α׷����ٸ� 50���� ����

	String[] list = { "�ڸ�����", "�߹�����", "�츮����", "������Ʈ", "�������α׷���", "���̵���", "īī��", "����", "�Ѹ���", "�ƹ�����", "������" };

	String[] list1 = { "��𿡵�", "��ȣ��", "���帶��", "ü��", "���޽�", "�Ʒ���", "����Ŀ", "�ʿ��ٸ�", "�����", "�ȷ�Ʈ", "���", "����", "����", "�ҳ�",
			"���ӿ���", "�����", "�ƽó���", "������", "�ֻ�", "���������", "����ʹ�", "è�Ǿ�", "������Ÿ��", "�ƹ���", "�����̾�", "�ѳ���", "������", "�Ÿ�����",
			"�߻�ȭ", "��������" };

	String[] list2 = { "�����", "������", "�ź���", "�䳢", "ȣ����", "ǥ��", "ġŸ", "���̿���", "�ڳ���", "�ڻԼ�", "���", "�û���", "����", "������",
			"����", "������ź", "ħ����", "������", "�ھ˶�", "Ļ�ŷ�", "ĥ����", "���ڱ���", "û����", "���߶��", "�޹���", "����Ҵ�", "�Ǵ�", "���Ҹ�", "����ġ",
			"�δ���", };

	String[] list3 = { "����", "����", "����", "����", "������", "�ӿ���", "���缮", "��Ź", "����", "����", "����", "����", "������", "�ڼ���", "������",
			"�����", "����", "������", "�տ���", "������", "���ð�", "�̽±�", "��ȿ��", "������", "��ȣ��", "�̱���", "����ȿ", "���ҹ�", "�缼��", "������" };

	String[] list4 = { "�౸", "��", "�豸", "�ڵ庼", "�߱�", "�̽��౸", "����", "������", "Ź��", "����", "����", "�±ǵ�", "����", "����", "ű����",
			"������", "�Ⱦ���", "������", "���", "�¸�", "��ƮƮ��", "������", "�ָ��ٱ�", "���̶ٱ�", "�״Ͻ�", "ǲ��", "���", "��Ű����", "���ֽ̾���", "�ø�" };

	String[] list5 = { "������", "�ؿ��", "������", "�ټְ�", "������", "û�ְ�", "���ְ�", "�ƿ촩��", "�ƿ�̸�", "�ƿ쳻��", "ȫ����", "������а�", "�ٻ�������",
			"���", "����", "�ҿ����Ʈ", "�ѼҸ�", "���ø�", "��Ÿ��", "�κ����", "������", "�ɼ���", "�ڸ�����", "����������", "��õ", "�Ѽ�", "�ι��濵��",
			"������", "�������°�", "���츮�μ���", };

	String[] list6 = { "�̻��ؾ�", "���̸�", "���α�", "ĳ����", "����Ǯ", "������", "����", "������", "�ƺ�ũ", "��ī��", "�𷡵���", "�ϵ己", "�Ƚ�",
			"�Ľ�����", "Ǫũ��", "���", "���÷��þ�", "��״�", "��Ʈ����", "����", "�丣�ÿ�", "����Ĵ�", "���", "������", "����", "ĳ�̽�", "�����", "������",
			"������", "����Ÿ" };

	String[] list7 = { "�׸����", "��������", "���񳭸�", "��������", "��鼭��", "������õ", "��������", "ȯ��Ż��", "�����ұ�", "����ȯ��", "��ҽ���", "���ڹ���",
			"����ʻ�", "�ݻ�÷ȭ", "�ϼ�����", "��������", "�ְ�����", "��⸸��", "ǥ���ε�", "�뵿����", "���̵���", "ȭ������", "��ġ�Ϲ�", "���ʱ���", "��������",
			"û����", "���л���", "��������", "���źҸ�", "��������" };

	String[] list8 = { "����", "�׸���", "����������", "����", "���þ�", "���ٳ�", "�縶�Ͼ�", "�����", "����", "��Ʈ��", "�����", "������", "������", "������",
			"���⵵��", "������", "��ũ���̳�", "�̶�ũ", "�̶�", "�̽���", "����Ʈ", "�ε�", "�ε��׽þ�", "�ڸ���ī", "ĥ��", "�ݷҺ��", "ũ�ξ�Ƽ��", "�±�",
			"��������", "�ʸ���" };

	String[] list9 = { "����", "����Ű", "���̹�", "�ݸ���", "���", "��Ʈ�����", "�Ե�", "���̺���", "����ũ�μ���Ʈ", "�Ƶ�����", "�Ｚ", "�����Ϸ���", "����",
			"�˸��ٹ�", "�Ƶ�ٽ�", "�߸���", "����Ŭ��", "��ī�ݶ�", "īī��", "����", "�׽���", "���Ÿ", "���̽���", "�ĸ��ٰ�Ʈ", "��ȭ", "�ѱ�Ÿ�̾�", "��ȣ",
			"Ʈ����", "���ø���", "�ƿ��" };

	String[] list10 = { "�����", "ī�̻�", "��þ�", "����", "�߽���", "��̶�", "��ƿ����", "Ż��", "���Ϸ���", "����", "��Į��", "����", "����", "����",
			"����ũ��ũ", "������", "���ֳ̾�", "¡ũ��", "����Ʋ��", "����", "�ϴ޸�", "ī����", "�𸣰���", "���÷�ũ", "����ũ", "īŸ����", "����", "�����",
			"�轺", "������" };
	// ����Ʈ �迭 10�� ����

	JLabel l2;

	JLabel l4;// ��ǻ�Ϳ� �� ���� ǥ�� ���̺��� ��� ������ �����Ͽ� �����ڰ� �ƴ� �ٸ� �������� �����Ͽ� ������ �� �ֵ���.
	JProgressBar progress; // ������Ȳ ��

	int comword = 0; // ��ǻ�Ͱ� ���� �ܾ�
	int myword = 0; // ���� ���� �ܾ�

	int time = 1000; // �������� �ð�

	int count; // ��ü �ܾ��� �� ī��Ʈ (�ܾ �� ������ �� ���Ḧ ����)

	public WordGame3() {

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 4, (windowSize.height - frameSize.height) / 4); // ȭ�� �߾ӿ� ����
		setSize(1300, 870); // â�� ũ�� ����

		JPanel uppan = new JPanel(new FlowLayout());
		JPanel uppan2 = new JPanel(new FlowLayout());
		JPanel uppan3 = new JPanel(new FlowLayout());

		// �ǳ� ����

		ImageIcon imageIcon = new ImageIcon("./image/Back3.png"); // �̹��� ����
		Back3 = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		// ����̹��� ũ�� ����

		progress = new JProgressBar(0, 100);
		progress.setBackground(Color.BLUE);
		progress.setForeground(Color.RED); // ���� ũ��� �� ����

		JLabel l1 = new JLabel("�� :", JLabel.RIGHT); // �ؽ�Ʈ ���������� ��ġ

		l2 = new JLabel("0", JLabel.LEFT); // �ؽ�Ʈ�� ��������, ��������� ������ ���� ���� ������ ����

		JLabel l3 = new JLabel(": ��ǻ��", JLabel.CENTER); // �ؽ�Ʈ�� ���

		l4 = new JLabel("0", JLabel.LEFT); // �ؽ�Ʈ�� ���ʿ�

		JButton btn = new JButton("�Ӥ�");
		JButton btnstart = new JButton("����"); // ���۹�ư�� �Ͻ�������ư ����

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
		progress.setVisible(false); // uppan�� l1, l2�� ���̰� �ٸ� ���� �� uppan�� uppan2, uppan3�� �ִ´�

		l1.setVisible(false);

		l2.setVisible(false);

		l3.setVisible(false);

		l4.setVisible(false);

		btn.setVisible(false); // �ʱ⿡�� �� ���̱� �Ѵ�.

		setVisible(true);

		JMenuBar mb = new JMenuBar();

		JMenu level = new JMenu("���̵�");

		JMenu category = new JMenu("ī�װ�");

		JMenuItem item1 = new JMenuItem("1�ܰ�");

		JMenuItem item2 = new JMenuItem("2�ܰ�");

		JMenuItem item3 = new JMenuItem("3�ܰ�");

		JMenuItem item4 = new JMenuItem("4�ܰ�");

		JMenuItem item5 = new JMenuItem("5�ܰ�");

		JMenuItem item6 = new JMenuItem("6�ܰ�");

		JMenuItem item7 = new JMenuItem("7�ܰ�");

		JMenuItem item8 = new JMenuItem("8�ܰ�");

		JMenuItem item9 = new JMenuItem("9�ܰ�");

		JMenuItem item10 = new JMenuItem("10�ܰ�");

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

		JMenuItem tem1 = new JMenuItem("����");

		JMenuItem tem2 = new JMenuItem("����");

		JMenuItem tem3 = new JMenuItem("������");

		JMenuItem tem4 = new JMenuItem("������");

		JMenuItem tem5 = new JMenuItem("�ѱ��");

		JMenuItem tem6 = new JMenuItem("���̸�");

		JMenuItem tem7 = new JMenuItem("���ϸ�");

		JMenuItem tem8 = new JMenuItem("���� �̸�");

		JMenuItem tem9 = new JMenuItem("�귣�� �̸�");

		JMenuItem tem10 = new JMenuItem("���� ���� ������");

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

		mb.add(category); // �޴��� �����.

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1�ܰ�":
					time = 5000;
					selectlevel = 1;
					level.setText("1�ܰ�");
					break;
				}
			}
		});

		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "2�ܰ�":
					time = 4000;
					selectlevel = 2;
					level.setText("2�ܰ�");
					break;
				}
			}
		});

		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "3�ܰ�":
					time = 3500;
					selectlevel = 3;
					level.setText("3�ܰ�");
					break;
				}
			}
		});

		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "4�ܰ�":
					time = 3000;
					selectlevel = 4;
					level.setText("4�ܰ�");
					break;
				}
			}
		});

		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "5�ܰ�":
					time = 2700;
					selectlevel = 5;
					level.setText("5�ܰ�");
					break;
				}
			}
		});

		item6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "6�ܰ�":
					time = 2500;
					selectlevel = 6;
					level.setText("6�ܰ�");
					break;
				}
			}
		});

		item7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "7�ܰ�":
					time = 2000;
					selectlevel = 7;
					level.setText("7�ܰ�");
					break;
				}
			}
		});

		item8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "8�ܰ�":
					time = 1700;
					selectlevel = 8;
					level.setText("8�ܰ�");
					break;
				}
			}
		});

		item9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "9�ܰ�":
					time = 1500;
					selectlevel = 9;
					level.setText("9�ܰ�");
					break;
				}
			}
		});

		item10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "10�ܰ�":
					time = 1000;
					selectlevel = 10;
					level.setText("10�ܰ�");
					break;
				}
			}
		}); // �� ���� �޴����� �ð��� ������ �ٸ��� ����.

		tem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "����":
					selectcategory = 1;
					category.setText("����");
					;
					break;
				}
			}
		});

		tem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "����":
					selectcategory = 2;
					category.setText("����");
					;
					break;
				}
			}
		});

		tem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "������":
					selectcategory = 3;
					category.setText("������");
					;
					break;
				}
			}
		});

		tem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "������":
					selectcategory = 4;
					category.setText("������");
					;
					break;
				}
			}
		});

		tem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "�ѱ��":
					selectcategory = 5;
					category.setText("�ѱ��");
					;
					break;
				}
			}
		});

		tem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "���̸�":
					selectcategory = 6;
					category.setText("���̸�");
					;
					break;
				}
			}
		});

		tem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "���ϸ�":
					selectcategory = 7;
					category.setText("���ϸ�");
					;
					break;
				}
			}
		});

		tem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "���� �̸�":
					selectcategory = 8;
					category.setText("���� �̸�");
					;
					break;
				}
			}
		});

		tem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "�귣�� �̸�":
					selectcategory = 9;
					category.setText("�귣�� �̸�");
					;
					break;
				}
			}
		});

		tem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "���� ���� ������":
					selectcategory = 10;
					category.setText("���� ���� ������");
					;
					break;
				}
			}
		});// �� ī�װ� �޴����� �������� �ܾ� �迭�� �ٸ��� ����.

		add(uppan, BorderLayout.NORTH); // ��� �г��� ������ ���ʿ� ��ġ

		panel = new GamePanel(); // JPanel�� ��ӹ��� ������ �ǳ�. ȭ�� �߾� �г�
		panel.add(new JLabel(new ImageIcon(Back3))); // ����̹����� �ǳڿ� ���̱�
		panel.setPreferredSize(new Dimension(300, 300)); // �ǳ� ũ�� ����

		add(panel, BorderLayout.CENTER); // �������� �߾ӿ� ��ġ

		JTextField msgInput = new JTextField(); // �ؽ�Ʈ �Է� ������Ʈ

		add(msgInput, BorderLayout.SOUTH); // ������ ���ʿ� �ؽ�Ʈ �Է� �ʵ� ��ġ

		btn.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�

			@Override

			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < list.length; i++) {

					if (e.getActionCommand().equals("�Ӥ�")) {

						btn.setText("��");
						repaint();
						words[i].suspend();
						state = false;
						msgInput.setVisible(false);

					} // �Ͻ������� ������ �� ��ư�� �̸��� �ٲ��, state = false�� ����, �Է����� ���ϵ��� ����.

					else {

						btn.setText("�Ӥ�");
						repaint();
						words[i].resume(); // ������ ��ü�� �����ϵ��� �ϴ� ���
						state = true;

						msgInput.setVisible(true);

					} // �ٽ� ����� ������ ��ư�� �̸��� �ٲ�� state = true�� ����, �Է�â �ٽ� ����.

				}

			}

		});

		msgInput.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�

			@Override

			public void actionPerformed(ActionEvent e) {

				msgInput.getText();

				System.out.println("Ű���� ����Ű ������");

				System.out.println("�װ� �Է��� ����:" + msgInput.getText());

				int t = 0; // ���� ó�� ����, �ʱ� t���� 0

				int a = msgInput.getText().equals("") ? 1 : 0; // ���� �ܾ� Ȯ��

				for (int i = 0; i < words.length; i++) { // �迭 words�� ���̸�ŭ �ݺ�

					t = words[i].word.equals(msgInput.getText()) ? 1 : 0;

					// �Է��� �ܾ �迭 �߿� �ִ°�? �ִٸ� 1 �ƴϸ� 0 ���� t�� �����մϴ�

					if (t == 1 && a != 1) { // ���� t�� 1�̶��

						System.out.println("�����Դϴ�."); // �����Դϴ�. �� ����մϴ�.

						words[i].word = ""; // �׸��� ���� ó���� �ܾ�� �������� �ٲ�ϴ�.(���� ������� �ƴϰ� �������� ��� �������ϴ�.)

						switch (selectlevel) {

						case 1:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 2:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 3:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 4:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 5:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 6:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 7:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 8:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 9:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						case 10:

							count--;
							myword++;
							n += 3.225806452;
							repaint();
							System.out.println("ī��Ʈ ���� " + count);
							break;

						} // ���� ������ ���߸� count���� �ٰ�, ���� ���� �ܾ��� myword ����.

						l2.setText("" + myword); // ���ھ ȭ�鿡 ��µǰ� �մϴ�
						progress.setValue(n);
						msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.
						break;

					}

				}

				if (t == 0) { // ���� t�� 1�� �ƴ϶�� (�Է��� �ܾ �迭 �߿� ���ٸ�)

					msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.

				}

			}

		});

		btnstart.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO �ڵ� ������ �޼ҵ� ����

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

		}); // ���� ��ư�� ������ �޴��� ������ �ʰ�, �󺧰� �ٰ� ���̵��� ����, Ÿ�̸ӵ� 2�� �� �����ϵ��� ����.

		if (selectlevel >= 1 && selectcategory >= 1) {

			generateWords(); // ������ ī�װ� ���� �� ���� ����

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������(������) ���� ��ư�� â�ݱ� ��� �ο�

		setVisible(true); // â�� ȭ�鿡 ��Ÿ������

	}

	void generateWords() {

		switch (selectcategory) {

		case 1:
			list = list1;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 2:
			list = list2;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 3:
			list = list3;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 4:
			list = list4;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 5:
			list = list5;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 6:
			list = list6;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 7:
			list = list7;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 8:
			list = list8;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 9:
			list = list9;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		case 10:
			list = list10;
			count = list.length;
			System.out.println("ī��Ʈ ���� " + count);
			break;

		} // �� ����Ʈ �޴��� �ٸ� �迭�� �־���

		words = new MovingWord[list.length];

		for (int i = 0; i < list.length; i++) {

			words[i] = new MovingWord();

			words[i].word = list[i];

			words[i].start(); // ������ ��ü�� �����ϵ��� �ϴ� ���

		}

	}

	class GamePanel extends JPanel {

		@Override

		public void paint(Graphics g) { // repaint()�� ������ ȣ���

			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Font font = new Font("SansSerif", Font.BOLD, 20); // font�� ��Ʈ ����
			g2.setFont(font);

			if (words == null)
				return;
			for (int i = 0; i < list.length; i++) {
				g.setColor(Color.WHITE); // g2�� �̿��� �������� �ܾ ������� ĥ����

				g2.drawString(words[i].word, words[i].x, words[i].y);

			}

			// g2.drawString(w1.word, w1.x, w1.y); //���ڿ��� �г� ���� �ش� ��ǥ�� �׷���

			if (count <= 0) {

				// ���� ����. ���������� life�� 0�� �Ǿ��� ��

				// ȭ�� ��� "Game Over" ǥ���ϱ�

				Font font1 = new Font("SansSerif", Font.BOLD, 20);

				g2.setFont(font1);

				if (n > 50 && count == 0) {

					g2.drawString("Congratulations! You Win", 530, getHeight() / 2);

				} // �ܾ �� ������� ��, ���� �� ���� ���߸� Win

				else {

					g2.drawString("Game Over, your Lose ", 530, getHeight() / 2);

				} // �ܾ �� ������� ��, ��ǻ�Ͱ� �� ���� ���߸� Lose

			}

		}

	}

	Timer m_timer = new Timer();
	TimerTask m_task = new TimerTask() {

		@Override
		public void run() {
			if (count <= 0 || state == false) {

				System.out.println("��ǻ�� ������");
			} // �ܾ �� ������ų�, ���� ���°� �Ǹ� ��ǻ�Ͱ� �Է��� ����
			else
				for (int i = 0; i < list.length - 1; i++) {
					double com = Math.random() * 30;
					int com2 = (int) com;
					System.out.println("��ǻ�� �Է�" + com);
					if (words[(int) com].word.equals("")) {

						break;
					} // ����� �ܾ �� ���߸� �ƹ��͵� ���� �� ��.
					else
						words[com2].word = ""; // ��ǻ�Ͱ� ���� �ܾ ����ó��
					count--; // ��ü �ܾ� �� �ϳ� ����.
					n -= 3.225806452; // ���� �������� ��ǻ�������� 3��ŭ �ö�
					System.out.println("ī��Ʈ ���� " + count);
					comword++; // ��ǻ�Ͱ� ���� �ܾ� �� ����
					l4.setText("" + comword); // ��ǻ�Ͱ� ���� �ܾ ȭ�鿡 ��µǰ� �մϴ�.
					progress.setValue(n); // �� ����
					break;
				}

		}

	};

	class MovingWord extends Thread { // ������ �����̴� ���ڿ�

		String word = "�ڸ�����"; // ���ڿ� �ʱ갪

		int random = (int) (Math.random() * 20); // random�̶�� ������ ������ ���� �����մϴ�.

		int x = random * 55, y = 0; // ���ڿ� ��ǥ

		int time = (int) (Math.random() * 13000); // time�̶�� ������ ������ ���� �����մϴ�.

		@Override

		public void run() {

			// �����ϰ� ���

			try {

				sleep(time); // ���

				System.out.println(time);

				while (true) { // ���ѷ���

					y++; // ��� �Ʒ��� �̵�

					int k = (word.equals("")) ? 1 : 2;

					// k��� ������ ���� ó�� �Ǿ ""�� �������� ���� word�� ""�� �����ϰ� �ִٸ� 1, �ƴϸ� 2�� �մϴ�.

					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {

						// k�� 2�϶��� ������ �߰��մϴ�.(���� ������ �ƴ� ä�� ������ �������ٸ�)

						System.out.println("�ٴ� ����");

						word = ""; // �ƹ� ǥ�� ���� �ʵ���
						count--;
						System.out.println("ī��Ʈ ���� " + count);

						break;

					}

					if (count <= 0) {

						// ���� life�� 0�� �Ǹ� ��� �ܾ ���߰� �մϴ�.

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

					} // ������ ���� sleepŸ���� �ٸ��� �����Ͽ� ���̵� ����

				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		new WordGame3(); // WordGame3 ����

	}
}