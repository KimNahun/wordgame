import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class manual extends JFrame {

	public manual() {

		super("����"); // Ÿ��Ʋ
		setSize(1000, 800); // â ũ�� ����

		Font font = new Font("Serif", Font.BOLD, 18); // ��Ʈ ũ�� ����

		JPanel all = new JPanel(new GridLayout(30, 5)); // �ǳ� ����
		all.setFont(font);

		JLabel manu1 = new JLabel("<���� ���>");
		all.add(manu1, BorderLayout.CENTER);
		manu1.setFont(font);
		JLabel manual0 = new JLabel("��  ������  �꼺��  ��������  3������  ��尡  �����մϴ�. ");
		all.add(manual0, BorderLayout.CENTER);
		manual0.setFont(font);
		JLabel manual01 = new JLabel("����  ��带  �����ϰ�,  ����ȭ����  �߸�  ����  ��  ��ܹ���  �޴���  ���̵���  �����ϼ���.");
		all.add(manual01, BorderLayout.CENTER);
		manual01.setFont(font);
		JLabel manual02 = new JLabel(" ���� ��ư�� ������ ������ ���۵˴ϴ�.");
		all.add(manual02, BorderLayout.CENTER);
		manual02.setFont(font);
		JLabel blank1 = new JLabel();
		all.add(blank1, BorderLayout.CENTER);

		JLabel manual03 = new JLabel(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual03, BorderLayout.CENTER);
		JLabel blank2 = new JLabel();
		all.add(blank2, BorderLayout.CENTER);

		JLabel manual1 = new JLabel("MODE 1�� �Ϲ� ���� �ܾ��� ���� �� 30���̸�, �������� ����� �� �ֽ��ϴ�");
		manual1.setPreferredSize(new Dimension(50, 50));
		all.add(manual1, BorderLayout.CENTER);
		manual1.setFont(font);

		JLabel manual11 = new JLabel(
				"������ 1: ������ 1����                                                                             (���ھ� ���� 300��, 1�� ��� ����)");
		all.add(manual11, BorderLayout.CENTER);
		manual11.setFont(font);

		JLabel manual12 = new JLabel(
				"������ 2: 5�ʵ��� �ǹ�Ÿ��<���� 2��>                                                  (���ھ� ���� 500��, 1�� ��� ����)");
		all.add(manual12, BorderLayout.CENTER);
		manual12.setFont(font);
		JLabel manual13 = new JLabel(
				"������ 3: 5�ʵ��� ��� ����                                                                     (���ھ� ���� 700��, 1�� ��� ����)");
		all.add(manual13, BorderLayout.CENTER);
		manual13.setFont(font);
		JLabel manual14 = new JLabel("������ 4: ��Ƽ�� <5�ʵ��� �ܾ� ���� �� ����Ȯ���� 2�� ����>          (���ھ� ���� 700��, 1�� ��� ����)");
		all.add(manual14, BorderLayout.CENTER);
		manual14.setFont(font);
		JLabel manual15 = new JLabel(
				"������ 5: 5�ʵ��� �������� �������� ����                                            (���ھ� ���� 1000��, 1�� ��� ����)");
		all.add(manual15, BorderLayout.CENTER);
		manual15.setFont(font);
		JLabel manual16 = new JLabel();
		all.add(manual16, BorderLayout.CENTER);
		JLabel manual17 = new JLabel(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual17, BorderLayout.CENTER);
		JLabel manual18 = new JLabel();
		all.add(manual18, BorderLayout.CENTER);

		JLabel manual2 = new JLabel("MODE 2�� ����� ���� ������ ���ߴ� �����Դϴ�.");
		all.add(manual2, BorderLayout.CENTER);
		manual2.setFont(font);
		manual12.setFont(font);
		JLabel manual21 = new JLabel("������ ���� �������� �ܾ��߿� ������ �ܾ �������� �������� �������� �ʽ��ϴ�.");
		all.add(manual21, BorderLayout.CENTER);
		manual21.setFont(font);
		JLabel blank3 = new JLabel();
		all.add(blank3, BorderLayout.CENTER);

		JLabel manual22 = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		all.add(manual22, BorderLayout.CENTER);
		JLabel blank4 = new JLabel();
		all.add(blank4, BorderLayout.CENTER);

		JLabel manual3 = new JLabel("MODE 3�� ��ǻ�Ϳ��� ��� ���� ��ǻ�ͺ��� �� ���� �ܾ ���߸� �¸��մϴ�.");
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

		// �ʿ��� ���� ��ġ�� ��Ʈ�� �������� �� �ǳڿ� �ٿ���.

		add(all, BorderLayout.NORTH); // ��� �г��� ������ ���ʿ� ��ġ

		all.setVisible(true); // ���̰� �ϱ�
		JButton btn1 = new JButton("Ȯ��"); // ��ư ����
		add(btn1, BorderLayout.SOUTH); // ������ ���ʿ� �ؽ�Ʈ �Է� �ʵ� ��ġ
		add(all, BorderLayout.CENTER); // ������ ���Ϳ� �ؽ�Ʈ �Է� �ʵ� ��ġ

		Dimension frameSize = getSize();

		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // ȭ�� �߾ӿ� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���ἳ��
		setVisible(true);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MODE(); // MODE Ŭ������ �Ѿ���� �ϱ�
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		});

	}

	public static void main(String[] args) {
		new manual(); // manual Ŭ���� ����
	}
}