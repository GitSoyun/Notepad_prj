package javaMemo;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MemoFontEvt extends MouseAdapter implements WindowListener {
	
	private MemoFont mf;
	
	// 폰트의 성격을 저장하기 위함
	private Font statusFont;
	
	public MemoFontEvt(MemoFont mf) {
		this.mf = mf;
	}//MemoFontEvt

	
	@Override
	public void windowClosing(WindowEvent e) {
		mf.dispose();
	}

	
	public void mouseClicked(MouseEvent e) {
//		System.out.println("클릭");
		if(e.getSource() == mf.getJlFont()) {
			setFont();
		}
		
		if(e.getSource() == mf.getJlStyle()) {
			setStyle();
		}
		
		if(e.getSource() == mf.getJlSize()) {
			setSize();
		}
		
		if(e.getSource() == mf.getJcbScript()) {
			setScript();
		}
		
		if(e.getSource() == mf.getJbtApply()) {
			fontApply();
		}
		
		if(e.getSource() == mf.getJbtClose()) {
			fontClose();
		}

	}//mouseClicked
	
	
	private void setFont() {
		//글꼴 JList의 아이템을 클릭하면
		//선택한 아이템 값을 JTextField설정한다.
		mf.getJtfFont().setText(mf.getJlFont().getSelectedValue());
		
		setPreview(); // 미리보기 바꾸기
	}//setFont
	
	
	private void setStyle() {
		//스타일 JList의 아이템을 클릭하면
		//선택한 아이템 값을 JTextField설정한다.
		mf.getJtfStyle().setText(mf.getJlStyle().getSelectedValue());
		
		setPreview(); // 미리보기 바꾸기
	}//setStyle
	
	
	private void setSize() {
		//크기 JList의 아이템을 클릭하면
		//선택한 아이템 값을 JTextField설정한다.
		mf.getJtfSize().setText(mf.getJlSize().getSelectedValue());
		
		setPreview(); // 미리보기 바꾸기
	}//setSize
	
	
	private void setPreview() {
		//글꼴, 스타일, 사이즈 클릭할 때마다 
		//미리보기에 실시간 적용이 되어야한다.
		
		// 단, JList중 어느 하나라도 선택하지 않은 상태인 경우 아무것도 하지 않고 리턴
		if (mf.getJlFont().isSelectionEmpty() ||
			mf.getJlStyle().isSelectionEmpty() ||
			mf.getJlSize().isSelectionEmpty())
			return;
		
		// 글꼴과 스타일
		String lFont = mf.getJlFont().getSelectedValue();
		String lStyle = mf.getJlStyle().getSelectedValue();
		// 사이즈
		int lSize = Integer.parseInt(mf.getJlSize().getSelectedValue());
		
		
		// 폰트의 상태값은 문자열이 아닌 정해진 상수(정수)로 되어 있기에 바꿔줌
		int lFontStyle = 0; // 폰트의 상태 값을 저장
		switch(lStyle) {
			case "일반":
				lFontStyle = Font.PLAIN;
				break;
			case "굵게":
				lFontStyle = Font.BOLD;
				break;
			case "기울임꼴":
				lFontStyle = Font.ITALIC;
				break;
			case "굵은기울임꼴":
				lFontStyle = Font.BOLD + Font.ITALIC;
				break;
		}//switch
		
		
		statusFont = new Font(lFont, lFontStyle, lSize); // 폰트의 성격을 만들고 (객체)
		
		mf.setJlblPreview(statusFont);
	}//setPreview
	
	
	private void setScript() {
		//스크립트를 변경하면 영어인 경우 미리보기에 "AaBbYyZz"로 설정되고
		//한글인 경우 "AbBbYyZz 가나다" 로 설정된다.
		if (mf.getDcbmScript().getSelectedItem() == "영어") {
//			System.out.println("영어");
			mf.setjlblPreviewText("AbBbYyZz");
			
		} else if (mf.getDcbmScript().getSelectedItem() == "한글") {
//			System.out.println("한글");
			mf.setjlblPreviewText("AbBbYyZz 가나다");
		}//else if
	}//setScript
	
	
	private void fontApply() {
		//"적용"을 클릭하면 부모창에 JTextArea 미리보기 라벨의 Font정보가 설정되고 JDialog가 닫힌다.
		mf.getJm().setJtaMemo(statusFont);
	}//fontApply
	
	private void fontClose() {
		//"닫기"를 클릭하면 JDialog가 닫힌다.
		mf.dispose();
	}//fontClose
	
	
	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
}//class
