package javaMemo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JavaMemoInfo extends JDialog {
	
	private JButton jbtClose;
	
	public JavaMemoInfo(JavaMemo jm) {
		super(jm, "메모장정보",  true);
		
		//이미지 컴포넌트
		ImageIcon icon = new ImageIcon("C:/dev/workspace/JavaMemo/src/javaMemo/memo_icon_pink.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel jlblIcon = new JLabel(changeIcon);
		
		//내용 컴포넌트
		JLabel jlblTitle = new JLabel("자바메모장");
		JLabel jlblVersion = new JLabel("Version 1.0");
		JLabel jlblProd = new JLabel("제작자 : 정소윤");
		JLabel jlblLicense = new JLabel("License : HPL");
		JLabel jlblInfo = new JLabel("이 메모장은 자바로 만들어진 메모장으로,");
		JLabel jlblInfo2 = new JLabel("아무나 자유롭게 사용 가능합니다.");
		
		//버튼 컴포넌트
		jbtClose = new JButton("닫기");
		
		//배치관리자 설정
		setLayout(null);
		
		//위치와 크기 수동 설정
		jlblIcon.setBounds(50,30,100,100);
		jlblTitle.setBounds(195,30,130,25);
		jlblVersion.setBounds(195,55,130,25);
		jlblProd.setBounds(195,80,130,25);
		jlblLicense.setBounds(195,105,130,25);
		jlblInfo.setBounds(55,150,300,25);
		jlblInfo2.setBounds(75,175,300,25);
		jbtClose.setBounds(125, 220, 80, 25);
		
		//배치
		add(jlblIcon);
		add(jlblTitle);
		add(jlblVersion);
		add(jlblProd);
		add(jlblLicense);
		add(jlblInfo);
		add(jlblInfo2);
		add(jbtClose);
		
		//이벤트처리 객체 생성
		JavaMemoInfoEvt jmiEvt = new JavaMemoInfoEvt(this);
	
		addWindowListener(jmiEvt);
		jbtClose.addActionListener(jmiEvt);
		
		setBounds(300,300,350,300);
		setVisible(true);
//		setResizable(false); //윈도우 크기조절 막기
//		setLocationRelativeTo(null); //화면 가운데에 창 뜨게 고정
		
	}//JavaMemoInfo
	
	
	public JButton getJbtClose() {
		return jbtClose;
	}
	

}//class
