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
 * Java GUI로 이루어진 메모장의 틀 
 * @author 정소윤
 */
@SuppressWarnings("serial")
public class JavaMemo extends JFrame {
	
	// 기본 폰트설정 constant
	public static final Font FontSetup = new Font("맑은 고딕", Font.PLAIN, 12);
	
	private JTextArea jtaMemo;
	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiSaveNew, jmiClose, jmiFont, jmiMemoInfo;
	
	public JavaMemo() {
		super("자바-메모장");
		
		// 컴포넌트 생성 후 배치
		setLayout(new BorderLayout());
		jtaMemo = new JTextArea();
		add("Center", jtaMemo);
		
		// JTextArea 스크롤바 설정
		JScrollPane jsp = new JScrollPane(jtaMemo); //스크롤바 객체 생성
		add(jsp); //배치
		jtaMemo.setLineWrap(true); //자동줄변경, 가로스크롤X
		
		// 메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		
		// 메뉴 생성
		JMenu jmFile = new JMenu(" 파일 ");
		JMenu jmForm = new JMenu(" 서식 ");
		JMenu jmMemoInfo = new JMenu(" 도움말 ");
		// 폰트 적용
		jmFile.setFont(FontSetup);
		jmForm.setFont(FontSetup);
		jmMemoInfo.setFont(FontSetup);
		
		//메뉴아이템 생성
		//파일 메뉴
		jmiNew = new JMenuItem(" 새글");
		jmiOpen = new JMenuItem(" 열기");
		jmiSave = new JMenuItem(" 저장");
		jmiSaveNew = new JMenuItem(" 새이름으로");
		jmiClose = new JMenuItem(" 닫기");
		// 서식 메뉴
		jmiFont = new JMenuItem(" 글꼴");
		// 도움말 메뉴
		jmiMemoInfo = new JMenuItem(" 메모장정보");
		
		// 폰트 적용
		jmiNew.setFont(FontSetup);
		jmiOpen.setFont(FontSetup);
		jmiSave.setFont(FontSetup);
		jmiSaveNew.setFont(FontSetup);
		jmiClose.setFont(FontSetup);
		jmiFont.setFont(FontSetup);
		jmiMemoInfo.setFont(FontSetup);
	
		// 이벤트처리 객체 생성
		JavaMemoEvt jme = new JavaMemoEvt(this);
	
		// 컴포넌트에서 발생하는 이벤트 처리
		addWindowListener(jme);
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiSaveNew.addActionListener(jme);
		jmiClose.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiMemoInfo.addActionListener(jme);
	
		// 메뉴아이템들 메뉴에 배치
		jmFile.add(jmiNew);
		jmFile.addSeparator(); //구분선
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.add(jmiSaveNew);
		jmFile.addSeparator(); //구분선
		jmFile.add(jmiClose);
		jmForm.add(jmiFont);
		jmMemoInfo.add(jmiMemoInfo);
		
		// 메뉴를 메뉴바에 배치
		jmb.add(jmFile);
		jmb.add(jmForm);
		jmb.add(jmMemoInfo);
		
		// 메뉴바를 윈도우컴포넌트에 배치
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
