package javaMemo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JavaMemoInfo extends JDialog {
	
	private JButton jbtClose;
	
	public JavaMemoInfo(JavaMemo jm) {
		super(jm, "�޸�������",  true);
		
		//�̹��� ������Ʈ
		ImageIcon icon = new ImageIcon("C:/dev/workspace/JavaMemo/src/javaMemo/memo_icon_pink.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel jlblIcon = new JLabel(changeIcon);
		
		//���� ������Ʈ
		JLabel jlblTitle = new JLabel("�ڹٸ޸���");
		JLabel jlblVersion = new JLabel("Version 1.0");
		JLabel jlblProd = new JLabel("������ : ������");
		JLabel jlblLicense = new JLabel("License : HPL");
		JLabel jlblInfo = new JLabel("�� �޸����� �ڹٷ� ������� �޸�������,");
		JLabel jlblInfo2 = new JLabel("�ƹ��� �����Ӱ� ��� �����մϴ�.");
		
		//��ư ������Ʈ
		jbtClose = new JButton("�ݱ�");
		
		//��ġ������ ����
		setLayout(null);
		
		//��ġ�� ũ�� ���� ����
		jlblIcon.setBounds(50,30,100,100);
		jlblTitle.setBounds(195,30,130,25);
		jlblVersion.setBounds(195,55,130,25);
		jlblProd.setBounds(195,80,130,25);
		jlblLicense.setBounds(195,105,130,25);
		jlblInfo.setBounds(55,150,300,25);
		jlblInfo2.setBounds(75,175,300,25);
		jbtClose.setBounds(125, 220, 80, 25);
		
		//��ġ
		add(jlblIcon);
		add(jlblTitle);
		add(jlblVersion);
		add(jlblProd);
		add(jlblLicense);
		add(jlblInfo);
		add(jlblInfo2);
		add(jbtClose);
		
		//�̺�Ʈó�� ��ü ����
		JavaMemoInfoEvt jmiEvt = new JavaMemoInfoEvt(this);
	
		addWindowListener(jmiEvt);
		jbtClose.addActionListener(jmiEvt);
		
		setBounds(300,300,350,300);
		setVisible(true);
//		setResizable(false); //������ ũ������ ����
//		setLocationRelativeTo(null); //ȭ�� ����� â �߰� ����
		
	}//JavaMemoInfo
	
	
	public JButton getJbtClose() {
		return jbtClose;
	}
	

}//class
