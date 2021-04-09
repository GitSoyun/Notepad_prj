package javaMemo;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MemoFontEvt extends MouseAdapter implements WindowListener {
	
	private MemoFont mf;
	
	// ��Ʈ�� ������ �����ϱ� ����
	private Font statusFont;
	
	public MemoFontEvt(MemoFont mf) {
		this.mf = mf;
	}//MemoFontEvt

	
	@Override
	public void windowClosing(WindowEvent e) {
		mf.dispose();
	}

	
	public void mouseClicked(MouseEvent e) {
//		System.out.println("Ŭ��");
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
		//�۲� JList�� �������� Ŭ���ϸ�
		//������ ������ ���� JTextField�����Ѵ�.
		mf.getJtfFont().setText(mf.getJlFont().getSelectedValue());
		
		setPreview(); // �̸����� �ٲٱ�
	}//setFont
	
	
	private void setStyle() {
		//��Ÿ�� JList�� �������� Ŭ���ϸ�
		//������ ������ ���� JTextField�����Ѵ�.
		mf.getJtfStyle().setText(mf.getJlStyle().getSelectedValue());
		
		setPreview(); // �̸����� �ٲٱ�
	}//setStyle
	
	
	private void setSize() {
		//ũ�� JList�� �������� Ŭ���ϸ�
		//������ ������ ���� JTextField�����Ѵ�.
		mf.getJtfSize().setText(mf.getJlSize().getSelectedValue());
		
		setPreview(); // �̸����� �ٲٱ�
	}//setSize
	
	
	private void setPreview() {
		//�۲�, ��Ÿ��, ������ Ŭ���� ������ 
		//�̸����⿡ �ǽð� ������ �Ǿ���Ѵ�.
		
		// ��, JList�� ��� �ϳ��� �������� ���� ������ ��� �ƹ��͵� ���� �ʰ� ����
		if (mf.getJlFont().isSelectionEmpty() ||
			mf.getJlStyle().isSelectionEmpty() ||
			mf.getJlSize().isSelectionEmpty())
			return;
		
		// �۲ð� ��Ÿ��
		String lFont = mf.getJlFont().getSelectedValue();
		String lStyle = mf.getJlStyle().getSelectedValue();
		// ������
		int lSize = Integer.parseInt(mf.getJlSize().getSelectedValue());
		
		
		// ��Ʈ�� ���°��� ���ڿ��� �ƴ� ������ ���(����)�� �Ǿ� �ֱ⿡ �ٲ���
		int lFontStyle = 0; // ��Ʈ�� ���� ���� ����
		switch(lStyle) {
			case "�Ϲ�":
				lFontStyle = Font.PLAIN;
				break;
			case "����":
				lFontStyle = Font.BOLD;
				break;
			case "����Ӳ�":
				lFontStyle = Font.ITALIC;
				break;
			case "��������Ӳ�":
				lFontStyle = Font.BOLD + Font.ITALIC;
				break;
		}//switch
		
		
		statusFont = new Font(lFont, lFontStyle, lSize); // ��Ʈ�� ������ ����� (��ü)
		
		mf.setJlblPreview(statusFont);
	}//setPreview
	
	
	private void setScript() {
		//��ũ��Ʈ�� �����ϸ� ������ ��� �̸����⿡ "AaBbYyZz"�� �����ǰ�
		//�ѱ��� ��� "AbBbYyZz ������" �� �����ȴ�.
		if (mf.getDcbmScript().getSelectedItem() == "����") {
//			System.out.println("����");
			mf.setjlblPreviewText("AbBbYyZz");
			
		} else if (mf.getDcbmScript().getSelectedItem() == "�ѱ�") {
//			System.out.println("�ѱ�");
			mf.setjlblPreviewText("AbBbYyZz ������");
		}//else if
	}//setScript
	
	
	private void fontApply() {
		//"����"�� Ŭ���ϸ� �θ�â�� JTextArea �̸����� ���� Font������ �����ǰ� JDialog�� ������.
		mf.getJm().setJtaMemo(statusFont);
	}//fontApply
	
	private void fontClose() {
		//"�ݱ�"�� Ŭ���ϸ� JDialog�� ������.
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
