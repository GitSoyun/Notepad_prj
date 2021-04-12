package javaMemo;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Java GUI�� �̷���� �޸����� Ʋ 
 * @author ������
 */
@SuppressWarnings("serial")
public class JavaMemo extends JFrame {
	
	// �⺻ ��Ʈ���� constant
	public static final Font FontSetup = new Font("���� ���", Font.PLAIN, 12);
	
	private JTextArea jtaMemo;
	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiSaveNew, jmiClose, jmiFont, jmiMemoInfo;
	
	public JavaMemo() {
		super("�ڹ�-�޸���");
		
		// ������Ʈ ���� �� ��ġ
		setLayout(new BorderLayout());
		jtaMemo = new JTextArea();
		add("Center", jtaMemo);
		
		// JTextArea ��ũ�ѹ� ����
		JScrollPane jsp = new JScrollPane(jtaMemo); //��ũ�ѹ� ��ü ����
		add(jsp); //��ġ
		jtaMemo.setLineWrap(true); //�ڵ��ٺ���, ���ν�ũ��X
		
		// �޴��� ����
		JMenuBar jmb = new JMenuBar();
		
		// �޴� ����
		JMenu jmFile = new JMenu(" ���� ");
		JMenu jmForm = new JMenu(" ���� ");
		JMenu jmMemoInfo = new JMenu(" ���� ");
		// ��Ʈ ����
		jmFile.setFont(FontSetup);
		jmForm.setFont(FontSetup);
		jmMemoInfo.setFont(FontSetup);
		
		//�޴������� ����
		//���� �޴�
		jmiNew = new JMenuItem(" ����");
		jmiOpen = new JMenuItem(" ����");
		jmiSave = new JMenuItem(" ����");
		jmiSaveNew = new JMenuItem(" ���̸�����");
		jmiClose = new JMenuItem(" �ݱ�");
		// ���� �޴�
		jmiFont = new JMenuItem(" �۲�");
		// ���� �޴�
		jmiMemoInfo = new JMenuItem(" �޸�������");
		
		// ��Ʈ ����
		jmiNew.setFont(FontSetup);
		jmiOpen.setFont(FontSetup);
		jmiSave.setFont(FontSetup);
		jmiSaveNew.setFont(FontSetup);
		jmiClose.setFont(FontSetup);
		jmiFont.setFont(FontSetup);
		jmiMemoInfo.setFont(FontSetup);
	
		// �̺�Ʈó�� ��ü ����
		JavaMemoEvt jme = new JavaMemoEvt(this);
	
		// ������Ʈ���� �߻��ϴ� �̺�Ʈ ó��
		addWindowListener(jme);
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiSaveNew.addActionListener(jme);
		jmiClose.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiMemoInfo.addActionListener(jme);
	
		// �޴������۵� �޴��� ��ġ
		jmFile.add(jmiNew);
		jmFile.addSeparator(); //���м�
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.add(jmiSaveNew);
		jmFile.addSeparator(); //���м�
		jmFile.add(jmiClose);
		jmForm.add(jmiFont);
		jmMemoInfo.add(jmiMemoInfo);
		
		// �޴��� �޴��ٿ� ��ġ
		jmb.add(jmFile);
		jmb.add(jmForm);
		jmb.add(jmMemoInfo);
		
		// �޴��ٸ� ������������Ʈ�� ��ġ
		setJMenuBar(jmb);
	
		setBounds(200, 200, 800, 500);
		setVisible(true);
		
	}//JavaMemo

	
	public JTextArea getJtaMemo() {
		return jtaMemo;
	}

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiSaveNew() {
		return jmiSaveNew;
	}

	public JMenuItem getJmiClose() {
		return jmiClose;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiMemoInfo() {
		return jmiMemoInfo;
	}
	
	public void setJtaMemo(Font f)
	{
		jtaMemo.setFont(f);
	}
	
	public static void main(String[] args) {
		new JavaMemo();
	}//main
	
}//class
