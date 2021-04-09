package javaMemo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemo jm;
	
	//������Ŭ������ �̺�ƮŬ������ has a ����� �����ϴ� ������
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}//JavaMemoEvt
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}//windowClosing


	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� �߻����� �� ���� ������ �ڵ�
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
		//"����"�� Ŭ���ϸ� JTextArea�� ������ �����.
		jm.getJtaMemo().setText("");
	}//newMemo
	
	
	private void openMemo() {
//		"����"�� Ŭ���ϸ� FileDialog�� ������� ����.
//		FileDialog���� ���ϸ��� �ԷµǸ� Ÿ��Ʋ�ٿ� "�ڹ�-�޸���[���� : ���ϸ�]"�� �����Ѵ�
		FileDialog fdOpen = new FileDialog(jm,"����",FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		if (fdOpen.getFile() != null) {
			jm.setTitle("�ڹ�-�޸��� [���� : " + fdOpen.getFile() + "]");
		}//if
	}//saveMemo
	
	
	private void saveMemo() {
//		"����"�� Ŭ���ϸ� FileDialog�� ������� ����.
//		FileDialog���� ���ϸ��� �ԷµǸ� Ÿ��Ʋ�ٿ� "�ڹ�-�޸���[���� : ���ϸ�]"�� �����Ѵ�
		FileDialog fdSave = new FileDialog(jm,"����",FileDialog.SAVE);
		fdSave.setVisible(true);
		
		if (fdSave.getFile() != null) {
			jm.setTitle("�ڹ�-�޸��� [���� : " + fdSave.getFile() + "]");
		}//if
	}//saveMemo
	
	
	private void saveNewMemo() {
//		"���̸�����"�� Ŭ���ϸ� FileDialog�� ������� ����.
//		FileDialog���� ���ϸ��� �ԷµǸ� Ÿ��Ʋ�ٿ� "�ڹ�-�޸���[���� : ���ϸ�]"�� �����Ѵ�
		FileDialog fdSaveNew = new FileDialog(jm,"���̸����� ����",FileDialog.SAVE);
		fdSaveNew.setVisible(true);
		
		if (fdSaveNew.getFile() != null) {
			jm.setTitle("�ڹ�-�޸��� [���� : " + fdSaveNew.getFile() + "]");
		}//if
	}//saveNewMemo
	
	
	private void memoClose() {
//		�ݱ⸦ ������ ���α׷��� �����Ѵ�.	
		jm.dispose();
	}//memoClose
	
	
	private void openFont() {
//		"�۲�"�� Ŭ���ϸ� �۲� ���̾�α׸� ����. 
//		(JTextField�� ������ JTextArea�� �۲� ������ �����Ͽ� ����.)
		new MemoFont(jm);
	}//openFont
	
	
	private void openMemoInfo() {
//		"�޸�������"�� Ŭ���ϸ� �޸������� ���̾�α׸� ����.
		new JavaMemoInfo(jm);
	}//openMemoInfo
	
}//class
