package javaMemo;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MemoFont extends JDialog {
	
	private JTextField jtfFont, jtfStyle, jtfSize;
	private JLabel jlblPreview;
	private JComboBox<String> jcbScript;
	private DefaultComboBoxModel<String> dcbmScript;
	private JList<String> jlFont, jlStyle, jlSize;
	private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
	private JButton jbtApply, jbtClose;

	private JavaMemo jm;
	
		public MemoFont(JavaMemo jm) {
			super(jm, "�۲�", true);
			this.jm = jm;
			
		//�۲� ���� ������Ʈ
		JLabel jlblFont = new JLabel("�۲�");
		jtfFont = new JTextField(10);
		
		//�۲� ����Ʈ
		//Model ��ü ����
		dlmFont = new DefaultListModel<String>();
		//����Ʈ ��
		dlmFont.addElement("Dialog");
		dlmFont.addElement("DialogInput");
		dlmFont.addElement("Serif");
		dlmFont.addElement("SansSerif");
		dlmFont.addElement("Monospaced");
		
		//View ��ü ����
		jlFont = new JList<String>(dlmFont); 
		//��ũ�ѹ�
		JScrollPane jspFont = new JScrollPane(jlFont);
		
		
		//�۲� ��Ÿ�� ���� ������Ʈ
		JLabel jlblStyle = new JLabel("�۲� ��Ÿ��");
		jtfStyle = new JTextField(10);
		
		//�۲� ��Ÿ�� ����Ʈ
		//Model ��ü ����
		dlmStyle = new DefaultListModel<String>();
		//����Ʈ ��
		dlmStyle.addElement("�Ϲ�");
		dlmStyle.addElement("����");
		dlmStyle.addElement("����Ӳ�");
		dlmStyle.addElement("��������Ӳ�");
		
		//View ��ü ����
		jlStyle = new JList<String>(dlmStyle); 
		//��ũ�ѹ�
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		
		
		//ũ�� ���� ������Ʈ
		JLabel jlblSize = new JLabel("ũ��");
		jtfSize = new JTextField(5);
		
		//ũ�� ����Ʈ
		//Model ��ü ����
		dlmSize = new DefaultListModel<String>();
		//����Ʈ �� : 8~100
		for (int i = 8; i < 101; i++) {
			dlmSize.addElement(i+"");
		}//for
		
		//View ��ü ����
		jlSize = new JList<String>(dlmSize); 
		//��ũ�ѹ�
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		
		//�̸����� ���� ������Ʈ
		jlblPreview = new JLabel("AaBbYyZz");
		jlblPreview.setHorizontalAlignment(JLabel.CENTER);
		
		
		//Ÿ��Ʋ���� ����
		jlblPreview.setBorder(new TitledBorder("�̸�����"));
		
		
		//��ũ��Ʈ ���� ������Ʈ
		JLabel jlblScript = new JLabel("��ũ��Ʈ");
		
		//Model ��ü ����
		String[] scriptValue = {"����","�ѱ�"};
		dcbmScript = new DefaultComboBoxModel<String>(scriptValue);
		
		//View ��ü ����
		jcbScript = new JComboBox<String>(dcbmScript);
		
		
		//��ư ���� ������Ʈ
		jbtApply = new JButton("����");
		jbtClose = new JButton("�ݱ�");
		
		
		//��ġ������ ���� : ������ġ
		setLayout(null); 
		
		//������Ʈ�� ��ġ�� ũ�� ���� ����
		jlblFont.setBounds(20, 10, 145, 35);
		jtfFont.setBounds(20, 40, 145, 25);
		jspFont.setBounds(20, 65, 145, 120);
		
		jlblStyle.setBounds(180, 10, 120, 35);
		jtfStyle.setBounds(180, 40, 120, 25);
		jspStyle.setBounds(180, 65, 120, 120);
		
		jlblSize.setBounds(315, 10, 75, 35);
		jtfSize.setBounds(315, 40, 75, 25);
		jspSize.setBounds(315, 65, 75, 120);
		
		jlblPreview.setBounds(180, 200, 210, 90);
		jlblScript.setBounds(180, 290, 210, 35);
		jcbScript.setBounds(180, 317, 210, 25);
		
		jbtApply.setBounds(220, 400, 80, 25);
		jbtClose.setBounds(310, 400, 80, 25);
		
		//��ġ
		add(jlblFont);
		add(jtfFont);
		add(jspFont);
		
		add(jlblStyle);
		add(jtfStyle);
		add(jspStyle);
		
		add(jlblSize);
		add(jtfSize);
		add(jspSize);
		
		add(jlblPreview);
		add(jlblScript);
		add(jcbScript);
		add(jbtApply);
		add(jbtClose);
		
		//�̺�Ʈó�� ��ü ����
		MemoFontEvt mfEvt = new MemoFontEvt(this);
		
		addMouseListener(mfEvt);
		jbtClose.addMouseListener(mfEvt);
		jbtApply.addMouseListener(mfEvt);
		jlFont.addMouseListener(mfEvt);
		jlStyle.addMouseListener(mfEvt);
		jlSize.addMouseListener(mfEvt);
		jcbScript.addMouseListener(mfEvt);
//		dcbmScript.addMouseListener(mfEvt); �ܾʵ�?
		
		
		//ũ�⼳��
		setBounds(300, 300, 430, 480);
		setVisible(true);
		
	}//MemoFont
	
	public JTextField getJtfFont() {
		return jtfFont;
	}
	
	public JTextField getJtfStyle() {
		return jtfStyle;
	}
	
	public JTextField getJtfSize() {
		return jtfSize;
	}
	
	public JComboBox<String> getJcbScript() {
		return jcbScript;
	}
	
	public JList<String> getJlFont() {
		return jlFont;
	}
	
	public JList<String> getJlStyle() {
		return jlStyle;
	}
	
	public JList<String> getJlSize() {
		return jlSize;
	}
	
	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}
	
	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}
	
	public DefaultListModel<String> getDlmSize() {
		return dlmSize;
	}
	
	public JButton getJbtApply() {
		return jbtApply;
	}
	
	public JButton getJbtClose() {
		return jbtClose;
	}
	
	public JavaMemo getJm() {
		return jm;
	}
	
	public DefaultComboBoxModel<String> getDcbmScript() {
		return dcbmScript;
	}
	
	// �̸������� �۲� ���¸� ���������
	public void setJlblPreview(Font pFont) {
		jlblPreview.setFont(pFont); // �� �������� ��Ʈ�� �ٲ���
	}//setJlblPreview
	
	
	public void setjlblPreviewText(String pString) {
		this.jlblPreview.setText(pString);
	}
	
}//class


