import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.io.*; //import 

public class WordGame2 extends JFrame { // JFrame�� ��� �޽��ϴ�.

	Image Back2; // WordGame2�� ���ȭ��
	Image Win; // �ܾ ������ ������ �̹���
	Image Lose; // �ܾ Ʋ���� ���� �̹���
	boolean facestate = true;
	int elapsed; // Ÿ�̸��� �ð��� �˷��� ����
	private Timer timer; // �ð��� ������ Ÿ�̸�

	MovingWord words[];
	GamePanel panel; // ������ ����Ǵ� �г��̸�, ��� ������Ʈ
	int selectlevel = 0; // �޴��ٿ��� ������ ������ �� �ִµ�, �ʱ갪�� 0�����մϴ�.
	int selectcategory = 0; // �޴��ٿ��� ī�װ��� ������ �� �ִµ�, �ʱ���� 0���� �մϴ�.

	String list[] = { "", "", "", "", "", "", "", "", "", "" }; // selectcategory�� 0�϶��� list
	String list1[] = { "����", "��ȣ��", "���޽�", "����Ŀ", "����", "������", "����", "�ҳ�", "���������", "������" }; // selectcategory�� 1�϶���
	// list...��� �̾����ϴ�.
	String list2[] = { "��", "��", "�ź���", "����", "����ġ", "�ڳ���", "����", "����", "�⸰", "�����" };
	String list3[] = { "���缮", "������", "������", "����", "������", "���ð�", "���ƾ�", "������", "�ڸ��", "����" };
	String list4[] = { "�౸", "��", "�߱�", "�±ǵ�", "����", "���", "�¸�", "�ǰ�", "����Ŭ", "��Ű" };
	String list5[] = { "�ѿ��", "�ƿ촩��", "�ٻ�������", "�ҿ����Ʈ", "������", "��õ", "����", "�ƿ�̸�", "�����", "�ֺ���" };
	String list6[] = { "��ī��", "���ڵ�", "��Ʈ����", "������", "���α�", "�̻��ؾ�", "������", "�ֹ�", "����", "����Ÿ" };
	String list7[] = { "�׸����", "�踤", "�����ұ�", "����ȯ��", "���ڹ���", "�ٴ��ͼ�", "��������", "���̵���", "û����", "��������" };
	String list8[] = { "�׸���", "��������", "�̱�", "��Ʈ��", "�����", "�Ϻ�", "����Ʈ", "����", "����", "�ε�" };
	String list9[] = { "�ؽ�", "���̹�", "����", "���", "����", "���̽���", "�Ƶ�����", "����", "��ī�ݶ�", "īī��" };
	String list10[] = { "�����", "������", "���÷�ũ", "�߽���", "���", "��ƿ����", "�񿡰�", "����", "Ƽ��", "����" };

	String question1 = "�״� ����� ���� ����� �� ���� �İ��� ���ð� �Ǿ�"; // ī�װ��� 10���̰�, 1ī�װ��� 10������, ��question�� 100���Դϴ�.
	String question2 = "������ Ǫ���� �׻��� 3�� �� ª�� �ð�";
	String question3 = "�� �ٺ��� ��¥ �ƴϾ�";
	String question4 = "���� �˾� ���� ������ ��������";
	String question5 = "��� �뷡 �Բ� �ҷ��� ���̼� ����";
	String question6 = "I��m so sorry but I love you �� ������";
	String question7 = "���� ���� ���� ȥ�� ����";
	String question8 = "�� �翡�� �ӹ����� ������ �� �ſ�";
	String question9 = "���� ���������~";
	String question10 = "���� �����̶��ϴ�~";

	String question11 = "ġŲ�� �̰����� �����";
	String question12 = "O 3������ ������ �־�";
	String question13 = "�䳢�� OOO";
	String question14 = "�и��� ��";
	String question15 = "���� ���ð� �ִ� ����";
	String question16 = "�ڰ� �� ����";
	String question17 = "�׶��� ����� �� �����̶�� �Ѵ�";
	String question18 = "�в� �ϸ� ��� ����";
	String question19 = "������ �̱����� ���� ������?";
	String question20 = "������ �������� �α� �ִ� ����";

	String question21 = "���׸��� ���� MC";
	String question22 = "���� ���� �θ� ����";
	String question23 = "OOO�� ��� �Ĵ�";
	String question24 = "�̾������� ���";
	String question25 = "JYP";
	String question26 = "���� ���� ����� ��� ����";
	String question27 = "�׽���!";
	String question28 = "���ϴ� ���ɰ�� �� ���";
	String question29 = "���ѵ����� 2����";
	String question30 = "����� �ڹ�����";

	String question31 = "4�⸶�� �������� �ϴ� ������ ����";
	String question32 = "������";
	String question33 = "������";
	String question34 = "�츮������ �ɽŴܷ� ������";
	String question35 = "������ �� ����ȯ";
	String question36 = "�� ������ �츮���� ���� �ְ�";
	String question37 = "���� Ÿ�� ����";
	String question38 = "�迬��";
	String question39 = "�����Ÿ� Ÿ�� ����";
	String question40 = "�� �ܿ￡ ���ΰ� �Բ� Ÿ�� ������";

	String question41 = "�ֺ����� ������ ���̿� ��ġ�� �����";
	String question42 = "�ѱ�� ���� ���л���Ʈ �̸�";
	String question43 = "�ѱ�� ������ �̸�";
	String question44 = "�뷡�� �θ��� �����ϸ� ���� ���Ƹ�";
	String question45 = "GS25 �������� �ִ� �ǹ�. �ٻ������� ��";
	String question46 = "�ѱ��� OO�鿡 �ִ�.";
	String question47 = "�ѱ�� ī�� �̸�";
	String question48 = "���� ����� ���� ���л���Ʈ �̸�";
	String question49 = "�ٻ� OOO. ���� �ı� ���� ����";
	String question50 = "���� ���� ���� ĿƮ������ �����";

	String question51 = "���찡 ������ �ٴϴ� ������ ��ȭ ���ϴ� ���ϸ�";
	String question52 = "���̸��� ��ȭ�ϸ�?";
	String question53 = "�� �ӿ� ���, �Ӹ��� 3���� ���ϸ�";
	String question54 = "������ ��ȭ�ϸ�?";
	String question55 = "��ī�� ������ ���̸� OOO";
	String question56 = "���� ǮŸ�� ���ϸ���?";
	String question57 = "��ī�� ��ȭ�ϸ�?";
	String question58 = "����/�� Ÿ�� ���ϸ�";
	String question59 = "�����ϰ� ����� ��ȭ ������ ���ϸ�";
	String question60 = "���� ���� ��Ƽ��� ���� ���ϸ�";

	String question61 = "� ������ �Բ� Ŀ�� ���� ģ��";
	String question62 = "����� ������ �����⿣ �Ʊ�� ��";
	String question63 = "����ģ ���� ��ġ�� ���� �Ͱ� ���ٴ� ��";
	String question64 = "�⼼�� �Ͽ� ���⿡ ���ư��ٴ� ��";
	String question65 = "�� ���ڵ� �𸣴�, ���� �������� �̸��� ��";
	String question66 = "������ �������� ���ٴ� ��";
	String question67 = "ó���� ���� �ٲپ� �������̶�� ��";
	String question68 = "�� �Ϳ� �� �б�";
	String question69 = "���ڰ� ���º��� ���ٴ� ��";
	String question70 = "�λ��� ����ȭ���� ������ �� ����";

	String question71 = "OOO �θ� ��ȭ";
	String question72 = "ȣ���δ� �� ������ �౸ ����";
	String question73 = "�� ���̵��� ������� ����";
	String question74 = "���׼��� �౸ �������� �ִ� ����";
	String question75 = "���̸����� �� ������ �౸ ����";
	String question76 = "�츮���� �ٹ濡 ��ġ�� �� ����";
	String question77 = "�Ƕ�̵�";
	String question78 = "�������� ������ ����";
	String question79 = "������ ������ ����";
	String question80 = "���� �α� 2���� ����";

	String question81 = "�����ý��丮�� ���� ���� ȸ��";
	String question82 = "�ʷ�â";
	String question83 = "���� ������ & �������� �기";
	String question84 = "��� ����� ���";
	String question85 = "������";
	String question86 = "��ũ ��Ŀ����";
	String question87 = "�ܹ��� ���������� ���";
	String question88 = "��Ƽ�� �⽺";
	String question89 = "�ݶ� ����� ���";
	String question90 = "OOO��";

	String question91 = "���� ����~ ���� ����~ ���� ����~";
	String question92 = "���� ���� ������ ����";
	String question93 = "w ��ų�� ������ ġ���� è�Ǿ�";
	String question94 = "����, �� ��ü";
	String question95 = "������ ����ϰ� �ִ� è�Ǿ�";
	String question96 = "���� ������ ������";
	String question97 = "���� �ñر� ����ٰ� ���� è�Ǿ�";
	String question98 = "������";
	String question99 = "�� �� �� ��!";
	String question100 = "�����ε� �����ϴ� ô ���� cs ����Դ� è�Ǿ�";

	String question[] = { "", "", "", "", "", "", "", "", "", "" }; // selectcategory�� 0�϶��� �����Դϴ�.
	String questionA[] = { question1, question2, question3, question4, question5, question6, question7, question8,
			question9, question10 }; // selectcategory�� 1�϶��� �����Դϴ�. ��� �̾����ϴ�.
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

	JLabel l2;// ���ھ� ǥ�� ���̺��� ��� ������ �����Ͽ� �����ڰ� �ƴ� �ٸ� �������� �����Ͽ� ������ �� �ֵ���.
	JLabel l4;// ������ ǥ�� ���̺�

	JPanel face = new JPanel();
	int life = 5; // life �� �ʱ갪�� 5
	int score; // ���ھ�
	double correctword = 0; // ������ ���߸� correctword�� 1 �ö󰩴ϴ�. �ʱ갪�� 0.0
	int correctanswer = 0; // correctanswer�� �ʱ갪�� 0
	double incorrectword = 0; // ������ Ʋ���� incorrectword�� 1 �ö󰩴ϴ�. �ʱ갪�� 0.0
	String realanswer = "����"; // realanswer�� �ʱ갪�� "����"

	int remainingword = list.length; // ���� �ܾ ����� �˱����ؼ�, �ʱ갪�� list.length�� 10���Դϴ�.
	int v[] = new int[list.length]; // v �迭 ����
	String answer[] = new String[list.length]; // answer �迭 ����.
	String realquestion[] = new String[list.length]; // realquestion �迭 ����.
	int answeranswer = 0; // answeranswer�� �ʱ�� 0
	int number = 0; // number�� �ʱ갪�� 0

	public WordGame2() {

		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 4, (windowSize.height - frameSize.height) / 4); // ȭ�� �߾ӿ� ����
		setSize(1300, 870); // â�� ũ�� ����
		// �ʿ��� ������Ʈ ��ġ
		setLayout(new BorderLayout()); // ��ġ ����� ����
		Panel info = new Panel(new GridLayout(2, 1)); // 1�� 4�� ��� �г� �غ�

		JPanel Fir = new JPanel(new GridLayout(1, 5));
		JPanel Sec = new JPanel(new FlowLayout());

		JLabel QnA = new JLabel("���� ������ ĭ", JLabel.CENTER); // �ؽ�Ʈ ���������� ��ġ

		JLabel l1 = new JLabel("Score:", JLabel.RIGHT); // �ؽ�Ʈ ���������� ��ġ
		l2 = new JLabel("0", JLabel.LEFT); // �ؽ�Ʈ�� ��������, ��������� ������ ���� ���� ������ ����
		JLabel l3 = new JLabel("Life:", JLabel.CENTER); // �ؽ�Ʈ�� ���
		l4 = new JLabel("" + life, JLabel.LEFT); // �ؽ�Ʈ�� ���ʿ�
		JButton btn = new JButton("�Ӥ�"); // ����, ���۹�ư�� �������ֱ� ���� ��ư. ó������ ||(����) �Դϴ�.
		JMenuBar mb = new JMenuBar();
		JButton btnstart = new JButton("����"); // btnstart ��ư�� ����ϴ�. ó���� "����"

		JMenu level = new JMenu("���̵�"); // �޴��ٿ� ���̵��� �߰��մϴ�.
		JMenu category = new JMenu("ī�װ�"); // �޴��ٿ� ī�װ��� �߰��մϴ�.

		ImageIcon imageIcon1 = new ImageIcon("./image/Back2.png");
		Back2 = imageIcon1.getImage().getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH); // ���ȭ��

		ImageIcon imageIcon2 = new ImageIcon("./image/Win.png");
		Win = imageIcon2.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // �ܾ ���߰� �������� �̹���

		ImageIcon imageIcon3 = new ImageIcon("./image/Lose.png");
		Lose = imageIcon3.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // �ܾ Ʋ���� ���� �̹���

		l3.setFont(new Font("Verdana", Font.BOLD, 20)); // ���̺��� ��Ʈ ����
		l3.setPreferredSize(new Dimension(100, 40)); // ���̺��� ũ�� ����
		l3.setForeground(Color.CYAN); // �ؽ�Ʈ �÷� ����
		l3.setBackground(Color.BLUE); // ��׶��� �÷� ����
		l3.setOpaque(true); // ��׶��� ������ ����Ƿ��� �ʿ�

		info.add(Fir);
		info.add(Sec);

		Fir.add(btnstart); // ���� ��ư �߰�
		Fir.add(l1); // ��� �гο� ���̺� ������� �߰� (������ ���� �� Ȯ�ο�)
		Fir.add(l2);
		Fir.add(l3);
		Fir.add(l4);

		Fir.add(btn);
		Sec.add(QnA);

		l1.setVisible(false); // ó������ ������ �ʽ��ϴ�.
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);

		btnstart.setBackground(Color.WHITE); // ���۹�ư�� ���� ���

		JMenuItem item1 = new JMenuItem("1�ܰ�"); // 1�ܰ� ~ 10�ܰ踦 �߰��մϴ�.
		JMenuItem item2 = new JMenuItem("2�ܰ�");
		JMenuItem item3 = new JMenuItem("3�ܰ�");
		JMenuItem item4 = new JMenuItem("4�ܰ�");
		JMenuItem item5 = new JMenuItem("5�ܰ�");
		JMenuItem item6 = new JMenuItem("6�ܰ�");
		JMenuItem item7 = new JMenuItem("7�ܰ�");
		JMenuItem item8 = new JMenuItem("8�ܰ�");
		JMenuItem item9 = new JMenuItem("9�ܰ�");
		JMenuItem item10 = new JMenuItem("10�ܰ�");

		level.add(item1); // �߰��� 1~10�ܰ踦 ,level �޴��ٿ� �����ϴ�.
		level.add(item2);
		level.add(item3);
		level.add(item4);
		level.add(item5);
		level.add(item6);
		level.add(item7);
		level.add(item8);
		level.add(item9);
		level.add(item10);

		JMenuItem tem1 = new JMenuItem("����"); // ���� ~ ���׿��극��������� ī�װ��� �޴��ٿ� �����ϴ�.
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
		panel.add(new JLabel(new ImageIcon(Back2)));
		panel.setPreferredSize(new Dimension(300, 300));
		add(panel, BorderLayout.CENTER); // �������� �߾ӿ� ��ġ
		JTextField msgInput = new JTextField(); // �ؽ�Ʈ �Է� ������Ʈ
		add(msgInput, BorderLayout.SOUTH); // ������ ���ʿ� �ؽ�Ʈ �Է� �ʵ� ��ġ
		btn.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�.(������ư)
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.length; i++) { // �迭 ���̸�ŭ �ݺ�
					if (e.getActionCommand().equals("�Ӥ�")) { // ���� ��ư�� ||���¸�
						btn.setText("��"); // ��ư�� �� �� ���̰� �ϰ�
						words[i].suspend(); // �ܾ ���߰��մϴ�.
						repaint(); // ������Ʈ
						msgInput.setVisible(false); // �ܾ ���� ���¿����� Ÿ������ ���� ���ϰ� �մϴ�.
					} else { // ���� ��ư�� ||���°� �ƴ� �����
						btn.setText("�Ӥ�"); // ��ư�� ||�� �ǰ�
						words[i].resume(); // ������ ��ü�� �����ϵ��� �ϴ� ���
						repaint();
						msgInput.setVisible(true); // �ٽ� �����ϸ�, �� �ķδ� Ÿ������ �� �� �ֽ��ϴ�.
					}
				}
			}
		});

		msgInput.addActionListener(new ActionListener() { // �̺�Ʈ ó�� ��� �ο�. Ű���尡 �ԷµǸ�
			@Override
			public void actionPerformed(ActionEvent e) {
				msgInput.getText();
				int t = 0; // t�� �ʱ갪�� 0

				int a = msgInput.getText().equals("") ? 1 : 0; // �Է¿� ""�� �����ϰ� �ֳ�? �´ٸ� a�� 1 �ƴϸ� 0

				switch (number) { // ����ġ��. number�� �����Ǵµ�, �����Ǵ� ���� ���� t�� ������ �ٸ��� ��.
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

				for (int i = 0; i < words.length; i++) { // �迭 words�� ���̸�ŭ �ݺ�

					if (t == 1 && a != 1) { // ���� t�� 1�̰� a�� 1�� �ƴ϶��
						System.out.println("�����Դϴ�."); // �����Դϴ�. �� ����մϴ�.
						number++; // ���⼭ number�� �����˴ϴ�. ( ������ ������)
						facestate = true; // �̹����� ���� ��
						switch (number) { // ������ number�� 1~9�Ŀ� ���� ������ �ٸ��� �մϴ�.
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

						remainingword--; // ó���� 50���� ����� remainingword���� 1�� ��.
						switch (selectlevel) { // �޴��ٿ��� ������ selectlevel�� 1~10�̳Ŀ� ���� ������ �ٸ��� �����ϴ�.
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

						l2.setText("" + score); // ���ھ ȭ�鿡 ��µǰ� �մϴ�
						msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.
						correctword++; // correctanswer�� �����ϴ�
						answeranswer++; // answeranswer�� �����ϴ�.
						break;
					}
				}

				if (t == 0) { // ���� t�� 1�� �ƴ϶�� (�Է��� �ܾ �迭 �߿� ���ٸ�)
					for (int j = 0; j < words.length; j++) { // words�� ���̸�ŭ �ݺ�
						int r = words[j].word.equals(msgInput.getText()) ? 1 : 0;
						// r�� ���� t�� ��ɰ� �����մϴ�
						r += r;// ��� r�� ���ϰ�, �ϳ��� ���ٸ� 1�� ���;� �մϴ�.( ��� Ʋ�ȴٸ� 0�� ���ɴϴ�.)
						if (life > 0) {
							if (r == 0) { // ���� r�� 0�̶��(��� r�� ���غ��� 1�� ���� �ʾҴٸ�)
								life--; // Ʋ�� ���� �Է��ߴٰ� �����ϰ� ���ھ ����ϴ�.
								l4.setText("" + life); // ���ھ ȭ�鿡 ��µǰ� �մϴ�.
								msgInput.setText(""); // �Է��� ���ڸ� �����ݴϴ�.
								incorrectword++; // incorrectword�� �����ϴ�.

								System.out.println("Ʋ�Ƚ��ϴ�"); // Ʋ�Ƚ��ϴ�. ���
								facestate = false; // �̹������� ���׸� ��
								break;
							}
						} else {
							msgInput.setText(""); // �ƴϾ, �ϴ� �Է��� �ܾ �����ݴϴ�.
						}
					}
				}
			}
		});
		btnstart.addActionListener(new ActionListener() { // ���۹�ư �̺�Ʈ ó��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �ڵ� ������ �޼ҵ� ����
				generateWords(); // �ܾ �����մϴ�.
				QnA.setText("" + realquestion[0]); // realquestion�� 0��° ���ҷ� ȭ�� �߾ӿ� ���ϴ�.
				level.setVisible(false);
				category.setVisible(false); // ����,ī�װ� �޴��ٰ� ���� �ʿ������ ������ �ʰ� �ϰ�
				l1.setVisible(true); // score, life���� ���̰� �մϴ�.
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				remainingword = list.length; // ���� �ܾ��� ������ list�迭�� ����
				timer = new Timer(1000, new PeriodicTask()); // 1�� �ֱ� Ÿ�̸� ��ü ����
				timer.start(); // Ÿ�̸� ����
			}
		});
		if (selectlevel >= 1 && selectcategory >= 1) { // selectlevel�� 1�̻��̰�, selectcategory�� 1�̻��̸�
			generateWords(); // �ܾ� ����
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������(������) ���� ��ư�� â�ݱ� ��� �ο�
		setVisible(true); // â�� ȭ�鿡 ��Ÿ������
	}

	private class PeriodicTask implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// �ֱ��� Ÿ�̸� �̺�Ʈ �߻��ø��� ȣ��Ǵ� �޼ҵ�
			if (elapsed > 300 || correctword >= 10 || life <= 0) {
				timer.stop(); // Ÿ�̸Ӱ� ���ߴ� ����
				System.out.println("Ÿ�̸� ����");
			}
			// �������� �۾��� �� �� �ְ�����, �ܼ��� �ֱ⸶�� ���� �ö󰩴ϴ�.
			elapsed++;
			repaint();
			System.out.println(elapsed);
		}

	}

	void generateWords() {

		switch (selectcategory) { // selectcatory�� 1~10�̳Ŀ� ����, � ��������, � ���������� �����˴ϴ�.
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
		} // ������ �����ϰ� �����µ�, ������ �ߴ� ������ ��ĥ���� �ֽ��ϴ�. ������ �̹� �� ������ �� �������� �ʵ��� �����մϴ�.

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
			Font font = new Font("SansSerif", Font.BOLD, 20); // ��Ʈ ����
			g2.setFont(font);
			Graphics2D g3 = (Graphics2D) g;
			Font font3 = new Font("SansSerif", Font.BOLD, 20);
			g3.setFont(font3);
			g3.setColor(Color.BLACK);
			g3.drawString("Elapsed Time: " + elapsed, 1000, 30);
			if (facestate == true) { // ���� �ܾ ���߰� �ִ� ���¶�� ���� �ִ� �̹���
				ImageIcon imageIcon1 = new ImageIcon("./image/Win.png");
				Image image = imageIcon1.getImage();
				g.setColor(Color.WHITE);
				g2.drawImage(image, 65, 200, this);
			} else { // �ƴ϶�� ���� ���׸��� �ִ� �̹���
				ImageIcon imageIcon2 = new ImageIcon("./image/Lose.png");
				Image image = imageIcon2.getImage();
				g2.drawImage(image, 65, 200, this);
			}
			if (words == null)
				return; // ���� words �� ���ٸ�, �ٽ� ����

			for (int i = 0; i < list.length; i++) { // �� ������ �ܾ �׸��ϴ�.
				g.setColor(Color.WHITE);
				g2.drawString(words[i].word, words[i].x, words[i].y);
			}
			;

			if (life <= 0 || correctword >= 10) {
				// ���� ����. ���������� life�� 0�� �Ǿ��� �� , �ܾ 10�� �̻� ������ ��

				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				g2.setFont(font1);
				FontMetrics fm = getFontMetrics(font1);
				int width = fm.stringWidth("Game Over"); // ���� ����.
				int realscore = score * ((300 - elapsed) / 100); // ����� �ð��� ���� ������ �ٸ��Ԥ�
				System.out.println(realscore);
				if (life >= 1) { // �������� 1 �̻��̸� , �����Ѵٸ� ����� ���ھ�� realscore
					g2.drawString("Congratulations!", (getWidth() - width) / 2, 210);
					g2.drawString("Game Clear! your score is " + realscore, 600, 250);
				} else { // �������� 0�� �Ǿ��ٸ�, game over, �ܽ��� ���ھ�� realscore
					g2.drawString("Game Over, your score is " + realscore, 600, 250);
				}
				double accuracy = correctword / (incorrectword + correctword) * 100; // ��Ȯ�� ����
				double word = correctword + incorrectword; // �� �Է��� �ܾ��� ����
				g2.drawString("����� �Է��� �ܾ� ����" + (int) word + "��", (getWidth() - width) / 2, 290); // �� �Է��� �ܾ��� ����
				g2.drawString("���� ��Ȯ�� �Է��� �ܾ��" + (int) correctword + "��", (getWidth() - width) / 2, 310); // ���� �ܾ��� ����
				g2.drawString("Ʋ���� �Է��� �ܾ��" + (int) incorrectword + "��", (getWidth() - width) / 2, 330); // Ʋ�� �ܾ��� ����
				g2.drawString("���� ��Ȯ����" + (int) accuracy + "�ۼ�Ʈ", (getWidth() - width) / 2, 350); // ��Ȯ��

			}
		}
	}

	class MovingWord extends Thread { // ������ �����̴� ���ڿ�
		String word = "�ڸ�����"; // ���ڿ� �ʱ갪
		int random = (int) (Math.random() * 20); // random�̶�� ������ ������ ���� �����մϴ�.
		int x = 350 + random * 25, y = 0; // ���ڿ� ��ǥ
		int time = (int) (Math.random() * 7000); // time�̶�� ������ ������ ���� �����մϴ�.

		@Override
		public void run() {
			// �����ϰ� ���
			try {
				sleep(time + 2000); // ���
				while (true) { // ���ѷ���
					y++; // ��� �Ʒ��� �̵�
					int k = (word.equals("")) ? 1 : 2;
					// k��� ������ ���� ó�� �Ǿ ""�� �������� ���� word�� ""�� �����ϰ� �ִٸ� 1, �ƴϸ� 2�� �մϴ�.
					if (panel.getHeight() != 0 && y >= panel.getHeight() && k == 2) {
						// k�� 2�϶��� ������ �߰��մϴ�.(���� ������ �ƴ� ä�� ������ �������ٸ�)
						y = 0;
						remainingword--; // ���� �ܾ�� ���̱�

					}
					if (life <= 0 || correctword >= 10) {
						// ���� life�� 0�� �ǰų� �ܾ 10�� �̻� ���߸�
						break; // ����ϴ�.
					}
					switch (selectlevel) { // selectlevel�� ���� �ӵ� ����
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