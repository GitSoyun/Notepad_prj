package javaMemo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemo jm;
	
	//디자인클래스와 이벤트클래스를 has a 관계로 설정하는 생성자
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}//JavaMemoEvt
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}//windowClosing


	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생했을 때 비교할 목적의 코드
		if(e.getSource() == jm.getJmiNew()) {
			newMemo();
		}
		
		if(e.getSource() == jm.getJmiOpen()) {
			openMemo();
		}
		
		if(e.getSource() == jm.getJmiSave()) {
			saveMemo();
		}
		
		if(e.getSource() == jm.getJmiSaveNew()) {
			saveNewMemo();
		}
		
		if(e.getSource() == jm.getJmiClose()) {
			memoClose();
		}
		
		if(e.getSource() == jm.getJmiFont()) {
			openFont();
		}
		
		if(e.getSource() == jm.getJmiMemoInfo()) {
			openMemoInfo();
		}
		
	}//actionPerformed
	
	
	private void newMemo() {
		//"새글"을 클릭하면 JTextArea의 내용을 지운다.
		jm.getJtaMemo().setText("");
	}//newMemo
	
	
	private void openMemo() {
//		"열기"를 클릭하면 FileDialog를 열기모드로 연다.
//		FileDialog에서 파일명이 입력되면 타이틀바에 "자바-메모장[열기 : 파일명]"을 설정한다
		FileDialog fdOpen = new FileDialog(jm,"열기",FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		if (fdOpen.getFile() != null) {
			jm.setTitle("자바-메모장 [열기 : " + fdOpen.getFile() + "]");
		}//if
	}//saveMemo
	
	
	private void saveMemo() {
//		"저장"을 클릭하면 FileDialog를 저장모드로 연다.
//		FileDialog에서 파일명이 입력되면 타이틀바에 "자바-메모장[저장 : 파일명]"을 설정한다
		FileDialog fdSave = new FileDialog(jm,"저장",FileDialog.SAVE);
		fdSave.setVisible(true);
		
		if (fdSave.getFile() != null) {
			jm.setTitle("자바-메모장 [저장 : " + fdSave.getFile() + "]");
		}//if
	}//saveMemo
	
	
	private void saveNewMemo() {
//		"새이름으로"를 클릭하면 FileDialog를 저장모드로 연다.
//		FileDialog에서 파일명이 입력되면 타이틀바에 "자바-메모장[저장 : 파일명]"을 설정한다
		FileDialog fdSaveNew = new FileDialog(jm,"새이름으로 저장",FileDialog.SAVE);
		fdSaveNew.setVisible(true);
		
		if (fdSaveNew.getFile() != null) {
			jm.setTitle("자바-메모장 [저장 : " + fdSaveNew.getFile() + "]");
		}//if
	}//saveNewMemo
	
	
	private void memoClose() {
//		닫기를 누르면 프로그램을 종료한다.	
		jm.dispose();
	}//memoClose
	
	
	private void openFont() {
//		"글꼴"을 클릭하면 글꼴 다이얼로그를 띄운다. 
//		(JTextField의 내용을 JTextArea의 글꼴 정보로 설정하여 띄운다.)
		new MemoFont(jm);
	}//openFont
	
	
	private void openMemoInfo() {
//		"메모장정보"를 클릭하면 메모장정보 다이얼로그를 띄운다.
		new JavaMemoInfo(jm);
	}//openMemoInfo
	
}//class
