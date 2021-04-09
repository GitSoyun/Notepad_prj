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
			super(jm, "글꼴", true);
			this.jm = jm;
			
		//글꼴 영역 컴포넌트
		JLabel jlblFont = new JLabel("글꼴");
		jtfFont = new JTextField(10);
		
		//글꼴 리스트
		//Model 객체 생성
		dlmFont = new DefaultListModel<String>();
		//리스트 값
		dlmFont.addElement("Dialog");
		dlmFont.addElement("DialogInput");
		dlmFont.addElement("Serif");
		dlmFont.addElement("SansSerif");
		dlmFont.addElement("Monospaced");
		
		//View 객체 생성
		jlFont = new JList<String>(dlmFont); 
		//스크롤바
		JScrollPane jspFont = new JScrollPane(jlFont);
		
		
		//글꼴 스타일 영역 컴포넌트
		JLabel jlblStyle = new JLabel("글꼴 스타일");
		jtfStyle = new JTextField(10);
		
		//글꼴 스타일 리스트
		//Model 객체 생성
		dlmStyle = new DefaultListModel<String>();
		//리스트 값
		dlmStyle.addElement("일반");
		dlmStyle.addElement("굵게");
		dlmStyle.addElement("기울임꼴");
		dlmStyle.addElement("굵은기울임꼴");
		
		//View 객체 생성
		jlStyle = new JList<String>(dlmStyle); 
		//스크롤바
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		
		
		//크기 영역 컴포넌트
		JLabel jlblSize = new JLabel("크기");
		jtfSize = new JTextField(5);
		
		//크기 리스트
		//Model 객체 생성
		dlmSize = new DefaultListModel<String>();
		//리스트 값 : 8~100
		for (int i = 8; i < 101; i++) {
			dlmSize.addElement(i+"");
		}//for
		
		//View 객체 생성
		jlSize = new JList<String>(dlmSize); 
		//스크롤바
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		
		//미리보기 영역 컴포넌트
		jlblPreview = new JLabel("AaBbYyZz");
		jlblPreview.setHorizontalAlignment(JLabel.CENTER);
		
		
		//타이틀보더 설정
		jlblPreview.setBorder(new TitledBorder("미리보기"));
		
		
		//스크립트 영역 컴포넌트
		JLabel jlblScript = new JLabel("스크립트");
		
		//Model 객체 생성
		String[] scriptValue = {"영어","한글"};
		dcbmScript = new DefaultComboBoxModel<String>(scriptValue);
		
		//View 객체 생성
		jcbScript = new JComboBox<String>(dcbmScript);
		
		
		//버튼 영역 컴포넌트
		jbtApply = new JButton("적용");
		jbtClose = new JButton("닫기");
		
		
		//배치관리자 설정 : 수동배치
		setLayout(null); 
		
		//컴포넌트의 위치와 크기 수동 설정
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
		
		//배치
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
		
		//이벤트처리 객체 생성
		MemoFontEvt mfEvt = new MemoFontEvt(this);
		
		addMouseListener(mfEvt);
		jbtClose.addMouseListener(mfEvt);
		jbtApply.addMouseListener(mfEvt);
		jlFont.addMouseListener(mfEvt);
		jlStyle.addMouseListener(mfEvt);
		jlSize.addMouseListener(mfEvt);
		jcbScript.addMouseListener(mfEvt);
//		dcbmScript.addMouseListener(mfEvt); 외않되?
		
		
		//크기설정
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
	
	// 미리보기의 글꼴 상태를 변경시켜줌
	public void setJlblPreview(Font pFont) {
		jlblPreview.setFont(pFont); // 그 성격으로 폰트를 바꿔줌
	}//setJlblPreview
	
	
	public void setjlblPreviewText(String pString) {
		this.jlblPreview.setText(pString);
	}
	
}//class


