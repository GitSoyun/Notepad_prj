package javaMemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoInfoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemoInfo jmi;
	
	public JavaMemoInfoEvt(JavaMemoInfo jmi) {
//		System.out.print("생성자 ");
		this.jmi = jmi;
	}//JavaMemoInfoEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
//		System.out.print("닫기 ");
		jmi.dispose();
	}//WindowClosing
	
	public void actionPerformed(ActionEvent e) {
//		System.out.print("버튼 ");
		if(e.getSource() == jmi.getJbtClose()) {
			setClose();
		}//if
	}
	
	private void setClose() {
//		System.out.print("작동 ");
		jmi.dispose();
	}
	
}//class
