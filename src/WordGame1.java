import java.awt.*; //awt ���� ��� ���� ����ϴ� Ŭ���� import

import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.TimerTask;
import java.util.Timer;

// �ڹ� ���� swing

public class WordGame1 extends JFrame {
	// ����
	// �Լ�
	// ������
	// MovingWord w1; //�����̴� �ܾ� 1�� ����
	Image Back1; // ���ȭ��
	Image Win; // �ܾ ������ ���� �̹���
	Image Lose; // �ܾ Ʋ���� ���� �̹���
	Image recovery; // ������ 5���� �̹���
	Image fever;
	Image delay;
	Image shot;
	Image Shield;
	Image use; // �̹� ����� ������ ǥ�� �̹���

	boolean facestate = true;
	MovingWord words[];
	GamePanel panel; // ������ ����Ǵ� �г��̸�, ��� ������Ʈ
	int selectlevel = 0; // �޴��ٿ��� ������ ������ �� �ִµ�, �ʱ갪�� 0�����մϴ�.
	int selectcategory = 0; //// �޴��ٿ��� ī�װ��� ������ �� �ִµ�, �ʱ���� 0���� �մϴ�.
	String[] list = { "�ڸ�����", "�߹�����", "�츮����", "������Ʈ", "�������α׷���", "���̵���", "īī��", "����", "�Ѹ���", "�ƹ�����", "������" }; // list
	// �迭��
	// �ʱ갪
	String[] list1 = { "����", "����", "����", "��𿡵�", "��ȣ��", "���帶��", "ü��", "���޽�", "ģ��", "�Ʒ���", "����Ŀ", "�ʿ��ٸ�", "����", "�����",
			"�̾���", "Ǫ����", "����", "�񰡿�", "�ȷ�Ʈ", "�Ѿ��", "���", "���", "����", "������", "�عٶ��", "����", "�����", "�ҳ�", "���ӿ���",
	"�����" };
	String[] list2 = { "�����", "������", "�ź���", "�䳢", "��", "����", "ȣ����", "ǥ��", "ġŸ", "���̿���", "�⸰", "�ڳ���", "�ڻԼ�", "�ϸ�", "�Ǿ�",
			"���", "�ξ���", "�û���", "��", "����", "��", "��", "������", "Ÿ��", "����", "������ź", "ħ����", "������", "�ھ˶�", "Ļ�ŷ�" };
	String[] list3 = { "����", "����", "����", "����", "��", "����", "����", "��", "����", "����", "������", "�ӿ���", "���缮", "��Ź", "����", "����",
			"���", "�糪", "��ȿ", "�̳�", "����", "����", "������", "�ڼ���", "�̹�ȣ", "������", "������", "�����", "����", "������" };
	String[] list4 = { "�౸", "��", "�豸", "�ڵ庼", "�߱�", "����", "�̽��౸", "�籸", "����", "Ƽ��", "����", "������", "Ź��", "����", "����",
			"�±ǵ�", "����", "����", "����", "ű����", "������", "�Ⱦ���", "������", "���", "�¸�", "�ǰ�", "��ƮƮ��", "��Ű", "��Ű", "����Ŭ" };
	String[] list5 = { "�ؿ��", "������", "������", "�ټְ�", "�ѿ��", "������", "û�ְ�", "����", "���ְ�", "���ְ�", "�ֺ���", "������", "�ƿ촩��",
			"�ƿ�̸�", "�ƿ쳻��", "�����", "ȫ����", "������а�", "�ٻ�������", "������", "���ɽ�Ʈ��", "���", "����", "�ҿ����Ʈ", "�ѼҸ�", "�������", "����",
			"��", "��", "��������", };
	String[] list6 = { "�̻��ؾ�", "�̻���Ǯ", "�̻��ز�", "���̸�", "���ڵ�", "���ڸ�", "���α�", "��Ϻα�", "�źϿ�", "ĳ����", "����Ǯ", "����", "����",
			"������", "����", "��Ʈ��", "������", "�ƺ�ũ", "��ī��", "������", "�𷡵���", "�ϵ己", "�ϵ�ŷ", "�ϵ���", "�߻�", "�Ƚ�", "�Ľ�����", "��������",
			"Ǫ��", "Ǫũ��" };
	String[] list7 = { "�׸����", "��������", "���񳭸�", "��������", "���", "�ݼ�����", "�����ö", "�������", "�踤", "��鼭��", "������õ", "��������",
			"ȯ��Ż��", "������", "�����ұ�", "��ȭ����", "���м���", "����ȯ��", "��ҽ���", "���ڹ���", "����ʻ�", "�ݻ�÷ȭ", "�ϼ�����", "�ٴ��ͼ�", "��������",
			"�ְ�����", "��⸸��", "��α���", "ǥ���ε�", "�뵿����" };
	String[] list8 = { "����", "����", "�׸���", "����������", "������", "����", "�븣����", "��������", "����", "���þ�", "���ٳ�", "�縶�Ͼ�", "�����̽þ�",
			"�߽���", "�����", "����", "�̱�", "�ٷ���", "��Ʈ��", "�����", "������", "������", "������", "�ø���", "������", "���⵵��", "����", "������",
			"��ũ���̳�", "�̶�ũ" };
	String[] list9 = { "����", "����Ű", "����", "���̹�", "�ݸ���", "�ؽ�", "���", "�λ�", "��Ʈ�����", "�Ե�", "���̺���", "����ũ�μ���Ʈ", "������ī��",
			"�Ƶ�����", "����", "�Ｚ", "�ý���", "�Ҵ�", "�����Ϸ���", "����", "����", "�Ƹ���", "����Ʈ", "�˸��ٹ�", "���", "�Ƶ�ٽ�", "����", "�߸���",
			"���ĺ�", "����" };
	String[] list10 = { "����", "�񿡰�", "����", "����ũ��ũ", "������", "����", "���ֳ̾�", "¡ũ��", "�ٸ��콺", "����Ʋ��", "��Ʈ", "ī����", "������Ʈ",
			"������", "����", "�ϴ޸�", "�ֽ�", "���", "����", "ī����", "�𸣰���", "���÷�ũ", "����ũ", "īŸ����", "����", "�����", "�轺", "Ƽ��", "����",
	"������" };
	// 30��¥�� �迭 10�� ����

	JLabel l2; // ���ھ� ǥ�� ���̺��� ��� ������ �����Ͽ� �����ڰ� �ƴ� �ٸ� �������� �����Ͽ� ������ �� �ֵ���.
	JLabel l4;// ������ ǥ�� ���̺�
	JLabel l5;
	int life = 5; // life �� �ʱ갪�� 5
	int score; // score
	double correctword = 0; // correctword �ʱ갪 0.0
	double incorrectword = 0; // incorrectword �ʱ갪 0.0
	int combo = 0; // �޺� �ʱ갪 0
	int maxcombo = 0; // �ƽ��޺� �ʱ갪 0
	int remainingword = list.length; // ���� �ܾ��� ������ �迭�� ����
	int item = 0; // ���� �Է��� �ܾ item���� �Ǵ��� ���� ����
	JButton resultbtn; // ��� ��ư
	int itemtimestop = 1; // ���⼭���ʹ� ������. itemtimestop�� �ʱ갪 1 (item�� ����ϸ� 1�� �پ���, ��� �������� �ʱ갪�� 1�̱⶧���� ����
	// 1������ ��밡��)
	int itemlifeplus = 1;
	int itemshield = 1;
	int shield = 0; // shield�� itemshield�� ����� �����ϱ� ����. �ڿ��� �ٽ� ����.
	int itemdoubleshot = 1;
	int doubleshot = 0; // doubleshot�� itemdoubleshot�� ����� �����ϱ� ����.
	int itemfevertime = 1;
	int fevertime = 0; // fevertime�� itemfevertime�� ����� �����ϱ� ����.
	int once = 0;

	public WordGame1() {
		setSize(1300, 870); // â�� ũ�� ����
		// �ʿ��� ������Ʈ ��ġ

		setLayout(new BorderLayout()); // ��ġ ����� ����
		Panel info = new Panel(new GridLayout(1, 8)); // 1�� 4�� ��� �г� �غ�
		JLabel l1 = new JLabel("Score:", JLabel.RIGHT); // �ؽ�Ʈ ���������� ��ġ
		l2 = new JLabel("0", JLabel.LEFT); // �ؽ�Ʈ�� ��������, ��������� ������ ���� ���� ������ ����
		JLabel l3 = new JLabel("Life:", JLabel.CENTER); // �ؽ�Ʈ�� ���
		l4 = new JLabel("" + life, JLabel.LEFT); // �ؽ�Ʈ�� ���ʿ�
		l5 = new JLabel("�����޺�:" + combo, JLabel.LEFT);
		JButton btn = new JButton("�Ӥ�"); // ���� ��ư
		JMenuBar mb = new JMenuBar(); // �޴���
		JButton btnstart = new JButton("����"); // ���۹�ư
		resultbtn = new JButton("���"); // ��� ��ư
		JMenu level = new JMenu("���̵�"); // ���̵� ���� �޴���
		JMenu category = new JMenu("ī�װ�"); // ī�װ� ���� �޴���

		l3.setFont(new Font("Verdana", Font.BOLD, 20)); // ���̺��� ��Ʈ ����
		l3.setPreferredSize(new Dimension(100, 40)); // ���̺��� ũ�� ����
		l3.setForeground(Color.CYAN); // �ؽ�Ʈ �÷� ����
		l3.setBackground(Color.BLUE); // ��׶��� �÷� ����
		l3.setOpaque(true); // ��׶��� ������ ����Ƿ��� �ʿ�

		info.add(btnstart);
		info.add(l1); // ��� �гο� ���̺� ������� �߰� (������ ���� �� Ȯ�ο�)
		info.add(l2);
		info.add(l3);
		info.add(l4);
		info.add(l5);
		info.add(btn);
		info.add(resultbtn);

		l1.setVisible(false); // ó������ ������, ���ھ� ���� �Ⱥ���
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		resultbtn.setVisible(false);

		btnstart.setBackground(Color.WHITE); // ���� ��ư�� ���� �� ��

		JMenuItem item1 = new JMenuItem("1�ܰ�"); //// 1�ܰ� ~ 10�ܰ踦 �߰��մϴ�.
		JMenuItem item2 = new JMenuItem("2�ܰ�");
		JMenuItem item3 = new JMenuItem("3�ܰ�");
		JMenuItem item4 = new JMenuItem("4�ܰ�");
		JMenuItem item5 = new JMenuItem("5�ܰ�");
		JMenuItem item6 = new JMenuItem("6�ܰ�");
		JMenuItem item7 = new JMenuItem("7�ܰ�");
		JMenuItem item8 = new JMenuItem("8�ܰ�");
		JMenuItem item9 = new JMenuItem("9�ܰ�");
		JMenuItem item10 = new JMenuItem("10�ܰ�");

		level.add(item1); // //�߰��� 1~10�ܰ踦 ,level �޴��ٿ� �����ϴ�.
		level.add(item2);
		level.add(item3);
		level.add(item4);
		level.add(item5);
		level.add(item6);
		level.add(item7);
		level.add(item8);
		level.add(item9);
		level.add(item10);

		JMenuItem tem1 = new JMenuItem("����"); //// ���� ~ ���׿��극��������� ī�װ��� �޴��ٿ� �����ϴ�.
		JMenuItem tem2 = new JMenuItem("����");
		JMenuItem tem3 = new JMenuItem("������");
		JMenuItem tem4 = new JMenuItem("������");
		JMenuItem tem5 = new JMenuItem("�ѱ��");
		JMenuItem tem6 = new JMenuItem("���ϸ�");
		JMenuItem tem7 = new JMenuItem("��缺��");
		JMenuItem tem8 = new JMenuItem("���� �̸�");
		JMenuItem tem9 = new JMenuItem("���� ���");
		JMenuItem tem10 = new JMenuItem("���� ���� ������");

		category.add(tem1); // �߰��� ī�װ��� �޴��ٿ� �����ϴ�.
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
		// ���ȭ�� �̹���

		ImageIcon imageIcon2 = new ImageIcon("./image/Win.png");
		Win = imageIcon2.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // �ܾ ������ ���� �̹���

		ImageIcon imageIcon3 = new ImageIcon("./image/Lose.png");
		Lose = imageIcon3.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // �ܾ Ʋ���� ���� �̹���

		ImageIcon imageIcon5 = new ImageIcon("./image/recovery.png");
		recovery = imageIcon5.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // ������ 'ȸ��' �̹���

		ImageIcon imageIcon6 = new ImageIcon("./image/fever.png");
		fever = imageIcon6.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // ������ '�ǹ�Ÿ��' �̹���

		ImageIcon imageIcon7 = new ImageIcon("./image/delay.png");
		delay = imageIcon7.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // ������ '�ð� ����' �̹���

		ImageIcon imageIcon8 = new ImageIcon("./image/shot.png");
		shot = imageIcon8.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // ������ '���� ��' �̹���

		ImageIcon imageIcon9 = new ImageIcon("./image/Shield.png");
		Shield = imageIcon9.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // ������ '�ǵ�' �̹���

		ImageIcon imageIcon10 = new ImageIcon("./image/use.png");
		use = imageIcon10.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // �̹� ����� ������ ǥ�� �̹���

		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1�ܰ�":
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
					selectlevel = 10;
					level.setText("10�ܰ�");
					break;
				}
			}
		});
		// �޴��ٿ��� item1~10��, 1~10�ܰ踦 ����ٸ�, selectlevel ������ 1~10���� �����ǰ�, �޴��ٰ� 1~10�ܰ�� ������
		// ���̰��մϴ�.

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
				case "���ϸ�":
					selectcategory = 6;
					category.setText("���ϸ�");
					;
					break;
				}
			}
		});
		tem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "��缺��":
					selectcategory = 7;
					category.setText("��缺��");
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
				case "���� ���":
					selectcategory = 9;
					category.setText("���� ���");
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
		});
		// �޴��ٿ��� tem1~10��, ����~���׿��극���带 ����ٸ�, selectcategory ������ 1~10���� �����ǰ�, �޴��ٰ�
		// ����~���׿��극����� ������ ���̰� �մϴ�.

		add(info, BorderLayout.NORTH); // ��� �г��� ������ ���ʿ� ��ġ
		panel = new GamePanel(); // JPanel�� ��ӹ��� ������ �ǳ�. ȭ�� �߾� �г�
		panel.setPreferredSize(new Dimension(300, 300));

		add(panel, BorderLayout.CENTER); // �������� �߾ӿ� ��ġ
		panel.add(new JLabel(new ImageIcon(Back1)));

		JTextField msgInput = new JTextField(); // �ؽ�Ʈ �Է� ������Ʈ
		add(msgInput, BorderLayout.SOUTH); // ������ ���ʿ� �ؽ�Ʈ �Է� �ʵ� ��ġ
		btn.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.length; i++) {
					if (e.getActionCommand().equals("�Ӥ�")) {
						btn.setText("��");
						words[i].suspend();
						repaint();
						msgInput.setVisible(false);
					} else {
						btn.setText("�Ӥ�");
						words[i].resume(); // ������ ��ü�� �����ϵ��� �ϴ� ���
						repaint();
						msgInput.setVisible(true);
					}
				}
			}
		});
		resultbtn.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�. �����ư�� ������
			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(20, 20); // ������� 20,20���� �۾���.
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ� ��ư
				frame.setSize(500, 400); // ������
				frame.setLocationRelativeTo(null);
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel);
				int b[] = { 0, 0, 0, 0, 0 }; // ��ũ�� ���� b[]�迭
				try {
					FileInputStream fin = new FileInputStream("C://Temp//test14.out"); // test14 ������ �н��ϴ�.
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
					FileOutputStream fout = new FileOutputStream("C://Temp//test14.out"); // test14 ���Ͽ��ٰ� ���ϴ�.
					if ((score / 100) >= b[b.length - 1]) { // ���ھ� �迭 ���� ����. ���ο� score�� �迭�� �ִ� ������ ũ��, �� score�� ���.
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
					System.out.print("����¿���");
				}
				try {
					FileInputStream fin = new FileInputStream("C://Temp//test14.out"); // test 14������ �ٽ� �н��ϴ�.
					int n = 0;
					int c = 0;
					while ((c = fin.read()) != -1) {
						b[n] = (int) c; // �о b[n] �迭�� ����ϴ�.
						n++;
					}
					fin.close();
				} catch (IOException y) {
				}
				double accuracy = correctword / (incorrectword + correctword) * 100; // ��Ȯ��
				double word = correctword + incorrectword; // �Է��� �ܾ��� ����
				JLabel yourscore = new JLabel("SCORE " + score + "��"); // ������� ���ھ�
				JLabel data = new JLabel("����� ������ �м�"); // ������� ������
				JLabel yourinput = new JLabel("����� �Է��� �ܾ�� " + (int) word + "��"); // ����� �Է��� �ܾ� ����
				JLabel yourcorrect = new JLabel("���� ��Ȯ�� �Է��� �ܾ��" + (int) +correctword + "��"); // ����� ��Ȯ�� �Է��� �ܾ� ����
				JLabel yourincorrect = new JLabel("���� Ʋ���� �Է��� �ܾ��" + (int) +incorrectword + "��"); // ����� Ʋ���� �Է��� �ܾ� ����
				JLabel youraccuracy = new JLabel("���� ��Ȯ���� " + (int) accuracy + "%"); // ����� ��Ȯ��
				JLabel yourmaxcombo = new JLabel("����� max combo�� " + maxcombo); // ����� maxcombo
				JLabel la0 = new JLabel("���� ��ŷ ����");
				JLabel la1 = new JLabel("1��:" + (b[0] * 100) + "��");
				JLabel la2 = new JLabel("2��:" + (b[1] * 100) + "��");
				JLabel la3 = new JLabel("3��:" + (b[2] * 100) + "��");
				JLabel la4 = new JLabel("4��:" + (b[3] * 100) + "��");
				JLabel la5 = new JLabel("5��:" + (b[4] * 100) + "��");
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
				blank.setSize(130, 70);// ��ġ, ũ�� �����մϴ�.
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
				frame.setVisible(true); // frame�� �߰��� ��, frame�� ���̰� �մϴ�.

			}
		});

		msgInput.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�
			@Override
			public void actionPerformed(ActionEvent e) {
				msgInput.getText();
				System.out.println("Ű���� ����Ű ������");
				System.out.println("�װ� �Է��� ����:" + msgInput.getText());
				int t = 0; // t�� 0
				int a = msgInput.getText().equals("") ? 1 : 0;
				if ((msgInput.getText().equals("3")) || msgInput.getText().equals("1") || msgInput.getText().equals("5")
						|| msgInput.getText().equals("4") || msgInput.getText().equals("2")) {
					item = 1; // item�� ����ߴٰ� �����ϴ� ����, ����� �Է��� 1,2,3,4,5��� item�� ����Ϸ��� �ߴٰ� ����. item������ 1�� �˴ϴ�.
				}

				if (msgInput.getText().equals("3")) { // 3�� �Է����� ��
					if (score >= 700 && itemtimestop >= 1) { // ���ھ 700�� �Ѱ� '�ð�����'�������� 1�� �̻��̸�
						score -= 700; // ���ھ� 700�� ����
						l2.setText("" + score); // ���ŵ� ���ھ ���̰�
						itemtimestop--; // '�ð�����'������ ���� 1�� ����
						for (int i = 0; i < list.length; i++) {
							words[i].suspend(); // ��� �ܾ� ����
						}
						m_timer.schedule(m_task, 5000); // 5�ʵ���
					} else if (score < 700) { // ���ھ 700���� ���ٸ�
						System.out.println("score����"); // ���ھ �����ϴٰ� ���ɴϴ�.
					} else if (itemtimestop == 0) { // '�ð�����'�������� 0�����
						System.out.println("�ش� �������� �̹� ��� ���"); // �ش�������� �̹� ��� ����ߴٰ� ���ɴϴ�.
					}
				}
				if (msgInput.getText().equals("5")) { // 5�� �Է����� ��
					if (score >= 1000 && itemshield >= 1) {// ���ھ 1000�� �Ѱ� '�ð�����'�������� 1�� �̻��̸�
						shield = 1; // shield ������ 1�� �˴ϴ�.
						score -= 1000; // ���ھ� 1000�� ����
						l2.setText("" + score);// ���ŵ� ���ھ� ���̰�

						n_timer.schedule(n_task, 5000); // 5�ʵ���
						itemshield--; // '�ǵ�'������ 1�� ����
						System.out.println("�����ۻ��");
					} else if (score < 1000) {
						System.out.println("score ����"); // ���ھ 1000���� ������ ���ھ �����ϴٰ� ���ɴϴ�.
					} else if (itemshield == 0) {
						System.out.println("�ش� �������� �̹� ��� ���");
					}
				}

				if (msgInput.getText().equals("4")) { // 4�� �Է����� ��
					if (score >= 700 && itemdoubleshot >= 1) {// ���ھ 700�� �Ѱ� '����'�������� 1�� �̻��̸�
						doubleshot = 1; // ���� ������ 1�̵ǰ�
						score -= 700; // ���ھ� 700�� ����
						l2.setText("" + score);
						p_timer.schedule(p_task, 5000); // 5�ʵ���
						itemdoubleshot--; // ���� ������ 1�� ����
						System.out.println("�����ۻ��");
					} else if (score < 700) {
						System.out.println("score ����"); // ���ھ 700���� ������ ���ھ���� �����ϴٰ� ���ɴϴ�.
					} else if (itemshield == 0) {
						System.out.println("�ش� �������� �̹� ��� ���");
					}
				}

				if (msgInput.getText().equals("2")) { // 2�� �Է����� ��
					if (score >= 500 && itemfevertime >= 1) { // ���ھ 500�� �Ѱ� �ǹ�Ÿ�� �������� 1�̻��̸�
						fevertime = 1; // �ǹ�Ÿ�� ������ 1�̵ǰ�
						score -= 500; // ������ 500�� ���Դϴ�.
						l2.setText("" + score);
						o_timer.schedule(o_task, 5000); // 5�ʵ���
						itemfevertime--; // �ǹ�Ÿ�� ������ 1�� ����
						System.out.println("�����ۻ��");
					} else if (score < 500) {
						System.out.println("score ����"); // ������ 500���� ������ ���ھ���� �����ϴٰ� ���ɴϴ�.
					} else if (itemshield == 0) {
						System.out.println("�ش� �������� �̹� ��� ���");
					}
				}
				if (msgInput.getText().equals("1")) { // 1�� �Է����� ��
					if (score >= 300 && itemlifeplus >= 1) { // ���ھ 300�� �Ѱ� �������÷��� �������� 1���̻��̸�
						score -= 300; // ���ھ� 300���
						life++; // ������ ����
						itemlifeplus--; // �������÷��� ������ 1�� ����
						l2.setText("" + score); // ���ھ ȭ�鿡 ��µǰ� �մϴ�
						l4.setText("" + life); // �������� ȭ�鿡 ��µǰ�

					} else if (score < 300) {
						System.out.println("score ����"); // ���ھ 300���� ������ ���ھ���� �����ϴٰ� ���ɴϴ�.
					} else if (itemtimestop <= 0) {
						System.out.println("�ش� �������� �̹� ��� ���"); // �������÷����������� 0����, �ش�������� �̹� ��� ����ߴٰ� ���ɴϴ�.
					}
				}

				for (int i = 0; i < words.length; i++) { // �迭 words�� ���̸�ŭ �ݺ�
					t = words[i].word.equals(msgInput.getText()) ? 1 : 0; // ����ڰ� �Է��� �ܾ �ִ��� �Ǵ��ϱ� ���� ���� t
					// �Է��� �ܾ �迭 �߿� �ִ°�? �ִٸ� 1 �ƴϸ� 0 ���� t�� �����մϴ�
					if (t == 1 && a != 1) { // ���� t�� 1�̰� a�� 1�� �ƴϸ�
						System.out.println("�����Դϴ�."); // �����Դϴ�. �� ����մϴ�.
						combo++;// �޺� ����
						facestate = true; // ���� ��
						if (doubleshot == 0) { // ���� doubleshot�� 0�̸� �ܾ 1�� ����
							words[i].word = "";
						} // �׸��� ���� ó���� �ܾ�� �������� �ٲ�ϴ�.(���� ������� �ƴϰ� �������� ��� �������ϴ�.)
						else if (doubleshot == 1) { // ���� doubleshot�� 1���� �ܾ 1�� ���ŵǰ� �׺��� 1�� �� ū ������ �ܾ ����(�ܾ ����Ȯ���� 2��
							// ���ŵ�)
							words[i].word = "";
							words[i + 1].word = "";
						}

						if (fevertime == 0) { // fevertime�� 0�̸�
							switch (selectlevel) { // ������ ���� 100~1000���� ���� ����
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
						if (fevertime == 1) { // fevertime�� 1�̸�
							switch (selectlevel) { // ������ ���� 200~2000�� ���� ����
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

						if (combo % 10 == 0 && combo != 0) { // 10�� ����� �޺��� �޼��ϸ�
							score += 100 * selectlevel; // ������ ����� ���ھ� ���� �߰�
							System.out.println(combo + "�޺� �޼�!" + 100 * selectlevel + "�� �߰�");
						}
						if (combo >= maxcombo) { // combo�� maxcombo���� ũ��, maxcombo ����
							maxcombo = combo;
						}
						l2.setText("" + score); // ���ھ ȭ�鿡 ��µǰ� �մϴ�
						l5.setText("�����޺�:" + combo);
						msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.
						correctword++; // ��Ȯ�� �Է��� �ܾ� 1�� ����
						break;
					}
				}
				if (t == 0 && item == 0) { // ���� t�� 0�̰� item�� 0�̶�� (�Է��� �ܾ �迭 �߿� ����, �������� ����Ϸ��� �ߴ� ���� �ƴ϶��)
					for (int j = 0; j < words.length; j++) { // words�� ���̸�ŭ �ݺ�
						int r = words[j].word.equals(msgInput.getText()) ? 1 : 0; // ����ڰ� �Է��Ϸ��� �� �ܾ �迭�� �ִ��� �Ǵ�.
						// r�� ���� t�� ��ɰ� �����մϴ�
						r += r;// ��� r�� ���ϰ�, �ϳ��� ���ٸ� 1�� ���;� �մϴ�.( ��� Ʋ�ȴٸ� 0�� ���ɴϴ�.)
						if (life > 0) { // �������� 1�̻��̸�
							if (r == 0 || a == 1) { // ���� r�� 0�̰ų�(��� r�� ���غ��� 1�� ���� �ʾҴٸ�), a�� 1�̶��)
								if (shield == 0) { // shield �������� ������� �ƴ϶��
									life--; // Ʋ�� ���� �Է��ߴٰ� �����ϰ� ���ھ ����ϴ�.
									facestate = false; // ���׸� ��
									l4.setText("" + life); // ���ھ ȭ�鿡 ��µǰ� �մϴ�.
									msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.
									incorrectword++; // Ʋ���� �Է��� �ܾ� �߰�
									combo = 0; // �޺��� 0�̵�
									l5.setText("�����޺�:" + combo);
									break;
								}

							}
						} else {
							msgInput.setText(""); // �Է��� �ܾ� ������
						}
					}
				} else {
					msgInput.setText(""); // �Է��� �ܾ� ������
				}
				if (item >= 1) { // �������� ����Ϸ��� �ߴ� ���̾���, item�� 1�� �Ǿ��������,
					item--; // ���� item�� �� ����� �������Ƿ� �ٽ� 0���� ���ݴϴ�.
				}
			}

		});
		btnstart.addActionListener(new ActionListener() { // ���۹�ư �̺�Ʈ ó��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �ڵ� ������ �޼ҵ� ����
				generateWords(); // �ܾ� ����
				level.setVisible(false); // ���� �޴��� �Ⱥ�����
				category.setVisible(false); // ī�װ� �޴��� �Ⱥ��̰�
				l1.setVisible(true); // ���ھ�,������, �޺� �� ���� ���̰�
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				remainingword = list.length; // ���� �ܾ�� list�� ����
			}
		});
		if (selectlevel >= 1 && selectcategory >= 1) { // ���� 1�̻�, ī�װ��� �� ���¶��
			generateWords(); // �ܾ� ����
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������(������) ���� ��ư�� â�ݱ� ��� �ο�
		setVisible(true); // â�� ȭ�鿡 ��Ÿ������
	}

	void generateWords() {
		switch (selectcategory) { // ������ ī�װ��� ���� �迭 �޶���
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
			words[i].start(); // ������ ��ü�� �����ϵ��� �ϴ� ���

		}
	}

	Timer m_timer = new Timer(); // m Ÿ�̸�. �ð����� ��ư���� �ٽ� �ܾ �����̰� ��
	TimerTask m_task = new TimerTask() {
		@Override
		public void run() {
			for (int i = 0; i < list.length; i++) {
				words[i].resume();
			}
		}
	};
	Timer n_timer = new Timer(); // n Ÿ�̸�. shield ������ ���ӽð� 5�� ��. shield ������ 0
	TimerTask n_task = new TimerTask() {
		@Override
		public void run() {
			shield = 0;
		}
	};
	Timer p_timer = new Timer(); // p Ÿ�̸�. doubleshot ������ ���ӽð� 5�� ��. doubleshot ������ 0
	TimerTask p_task = new TimerTask() {
		@Override
		public void run() {
			doubleshot = 0;
		}
	};
	Timer o_timer = new Timer(); // o Ÿ�̸�. �ǹ�Ÿ�� ������ ���ӽð� 5�� ��. fevertime ������ 0
	TimerTask o_task = new TimerTask() {
		@Override
		public void run() {
			fevertime = 0;
		}
	};

	class GamePanel extends JPanel {
		@Override
		public void paint(Graphics g) { // repaint()�� ������ ȣ���

			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Font font = new Font("SansSerif", Font.BOLD, 20);
			g2.setFont(font);
			ImageIcon imageIcon5 = new ImageIcon(recovery); // ȸ�� ������ �̹���
			Image image5 = imageIcon5.getImage();
			g2.drawImage(image5, 1000, 10, this);

			ImageIcon imageIcon6 = new ImageIcon(fever); // �ǹ�Ÿ�� ������ �̹���
			Image image6 = imageIcon6.getImage();
			g2.drawImage(image6, 1000, 160, this);

			ImageIcon imageIcon7 = new ImageIcon(delay); // �ð� ���� ������ �̹���
			Image image7 = imageIcon7.getImage();
			g2.drawImage(image7, 1000, 310, this);

			ImageIcon imageIcon8 = new ImageIcon(shot); // ���� ������ �̹���
			Image image8 = imageIcon8.getImage();
			g2.drawImage(image8, 1000, 460, this);

			ImageIcon imageIcon9 = new ImageIcon(Shield); // �ǵ� ������ �̹���
			Image image9 = imageIcon9.getImage();
			g2.drawImage(image9, 1000, 610, this);

			if (itemtimestop == 0) { // �������� 0���� �Ǹ�, �ٽ�ٴ� ǥ�ð� ��������
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 320, this);
			}
			if (itemshield == 0) {// �������� 0���� �Ǹ�, �ٽ�ٴ� ǥ�ð� ��������
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 620, this);
			}
			if (itemdoubleshot == 0) {// �������� 0���� �Ǹ�, �ٽ�ٴ� ǥ�ð� ��������
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 470, this);
			}
			if (itemfevertime == 0) {// �������� 0���� �Ǹ�, �ٽ�ٴ� ǥ�ð� ��������
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 170, this);
			}
			if (itemlifeplus == 0) {// �������� 0���� �Ǹ�, �ٽ�ٴ� ǥ�ð� ��������
				ImageIcon imageIcon10 = new ImageIcon(use);
				Image image10 = imageIcon10.getImage();
				g2.drawImage(image10, 1030, 20, this);
			}

			if (facestate == true) { // �ܾ ���߰� �ִ� ���¸�
				ImageIcon imageIcon1 = new ImageIcon("./image/Win.png"); // ���� �̹���
				Image image1 = imageIcon1.getImage();
				g2.drawImage(image1, 65, 200, this);
			} else {// �ƴ϶��
				ImageIcon imageIcon2 = new ImageIcon("./image/Lose.png"); // ���׸� �̹���
				Image image2 = imageIcon2.getImage();
				g2.drawImage(image2, 65, 200, this);
			}

			if (words == null)
				return;

			for (int k = 0; k < list.length; k++) {

				g2.drawString(words[k].word, words[k].x, words[k].y); // �ܾ� �׸�
			}
			;

			// g2.drawString(w1.word, w1.x, w1.y); //���ڿ��� �г� ���� �ش� ��ǥ�� �׷���
			if (life <= 0 || remainingword == 0) {
				// ���� ����. ���������� life�� 0�� �Ǿ��ų�, ���� �ܾ 0�����
				// ȭ�� ��� "Game Over" ǥ���ϱ�
				resultbtn.setVisible(true); // ��� ��ư�� ���̰� ��
				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				g2.setFont(font1);
				FontMetrics fm = getFontMetrics(font1);
				int width = fm.stringWidth("Game Over");
				if (remainingword == 0 && life >= 1) { // ���� �ܾ 0���̰�, �������� 1 �̻��̸�
					g2.drawString("Congratulations!", (getWidth() - width) / 2, 210); // ���� Ŭ���� ����. �����Ѵٰ� ����.
					g2.drawString("Game Clear! your score is " + score, (getWidth() - width) / 2, getHeight() / 2); // ���ھ�
					// ���
				} else {
					g2.drawString("Game Over, your score is " + score, (getWidth() - width) / 2, getHeight() / 2);
				}
			}
		}
	}

	class MovingWord extends Thread { // ������ �����̴� ���ڿ�
		String word = "�ڸ�����"; // ���ڿ� �ʱ갪
		int random = (int) (Math.random() * 30); // random�̶�� ������ ������ ���� �����մϴ�.

		int x = 350 + random * 20, y = 0; // ���ڿ� ��ǥ

		int time = (int) (Math.random() * 30000); // time�̶�� ������ ������ ���� �����մϴ�.

		@Override
		public void run() {
			// �����ϰ� ���
			try {
				sleep(time + 2000); // ���
				System.out.println(time);
				while (true) { // ���ѷ���
					y++; // ��� �Ʒ��� �̵�

					int k = (word.equals("")) ? 1 : 2;

					int c = 0; // c���� �ʱ갪 0
					for (int i = 0; i < 30; i++) { // 30������ �ݺ�
						int b = (words[i].word.equals("")) ? 0 : 1; // ������ �����ϴ��� ����, �´ٸ� 0 �ƴϸ� 1
						c += b; // �� ����(��� �����̶�� c�� 0)
					}
					if (c == 0) // c�� 0�̶�� ���� �ܾ� ������ remainingword�� 0�� ==��������.
						remainingword = 0;

					// k��� ������ ���� ó�� �Ǿ ""�� �������� ���� word�� ""�� �����ϰ� �ִٸ� 1, �ƴϸ� 2�� �մϴ�.
					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {
						// k�� 2�϶��� ������ �߰��մϴ�.(���� ������ �ƴ� ä�� ������ �������ٸ�)
						System.out.println("�ٴ� ����");
						facestate = false;
						word = ""; // �ƹ� ǥ�� ���� �ʵ���

						if (life >= 0) { // ���� �������� 0�̻��̸�
							if (shield == 0) { // ���� �ǵ� �������� Ȱ��ȭ�� ���� �ʾҴٸ�
								life--; // �������� 1 ���Դϴ�.
							}
						}
						l4.setText("" + life); // life�� ȭ�鿡 ��µǰ� �մϴ�.
						combo = 0;
					}
					if (life <= 0 || remainingword == 0) {
						// ���� life�� 0�� �ǰų� ���� �ܾ 0�����
						if (life < 0) {
							life = 0;
							l4.setText("" + life);
						}
						break; // �����.
					}
					switch (selectlevel) { // selectlevel�� ���� �ӵ� �ٸ���
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