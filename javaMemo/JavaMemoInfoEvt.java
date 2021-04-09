package javaMemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoInfoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemoInfo jmi;
	
	public JavaMemoInfoEvt(JavaMemoInfo jmi) {
//		System.out.print("������ ");
		this.jmi = jmi;
	}//JavaMemoInfoEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
//		System.out.print("�ݱ� ");
		jmi.dispose();
	}//WindowClosing
	
	public void actionPerformed(ActionEvent e) {
//		System.out.print("��ư ");
		if(e.getSource() == jmi.getJbtClose()) {
			setClose();
		}//if
	}
	
	private void setClose() {
//		System.out.print("�۵� ");
		jmi.dispose();
	}
	
}//class
