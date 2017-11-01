package face;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import almanc.Almanac;
import almanc.AlmanacUtil;
import idcard.Identitycard;
import robot.Robot;

/**
 * @author 寇爽
 * @Description: ${TODO}(主要界面和功能添加类)
 */
public class MainFace {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFace window = new MainFace();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFace() {
		initialize();
	}

	/**
	 * 修改窗口 
	 */
	private void initialize() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;  
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF(); 
            UIManager.put("RootPane.setupButtonVisible",false);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame = new JFrame("Java练习");
		frame.setBounds(100, 100, 516, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u516C\u5386\u65F6\u95F4\uFF1A");
		label.setFont(new Font("华文隶书", Font.PLAIN, 19));
		label.setBounds(10, 39, 95, 19);
		frame.getContentPane().add(label);

		Almanac almanac = AlmanacUtil.getAlmanac();

		JLabel label_1 = new JLabel("\u519C\u5386\u65F6\u95F4\uFF1A");
		label_1.setFont(new Font("华文隶书", Font.PLAIN, 19));
		label_1.setBounds(10, 94, 95, 19);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u5929\u5E72\u5730\u652F\uFF1A");
		label_2.setFont(new Font("华文隶书", Font.PLAIN, 19));
		label_2.setBounds(10, 140, 95, 19);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u5B9C\uFF1A");
		label_3.setFont(new Font("华文隶书", Font.PLAIN, 19));
		label_3.setBounds(10, 181, 95, 19);
		frame.getContentPane().add(label_3);

		JLabel label_5 = new JLabel("\u8282\u65E5\uFF1A");
		label_5.setFont(new Font("华文隶书", Font.PLAIN, 19));
		label_5.setBounds(10, 274, 95, 19);
		frame.getContentPane().add(label_5);

		JLabel label_4 = new JLabel("\u5FCC\uFF1A");
		label_4.setFont(new Font("华文隶书", Font.BOLD, 19));
		label_4.setBounds(10, 226, 95, 19);
		frame.getContentPane().add(label_4);
		// 公历时间
		JTextArea textArea = new JTextArea();
		textArea.setBounds(134, 39, 315, 24);
		frame.getContentPane().add(textArea);
		textArea.setEnabled(false);
		textArea.setText(almanac.getSolar());
		textArea.setFont(new Font("华文隶书", Font.BOLD, 19));

		// 阴历时间
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(134, 89, 315, 24);
		frame.getContentPane().add(textArea_1);
		textArea_1.setEnabled(false);
		textArea_1.setText(almanac.getLunar());
		textArea_1.setFont(new Font("华文隶书", Font.BOLD, 19));

		// 天干地支
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(134, 135, 315, 24);
		frame.getContentPane().add(textArea_2);
		textArea_2.setEnabled(false);
		textArea_2.setText(almanac.getChineseAra());
		textArea_2.setFont(new Font("华文隶书", Font.BOLD, 19));

		// 宜
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(134, 181, 315, 24);
		frame.getContentPane().add(textArea_3);
		textArea_3.setEnabled(false);
		textArea_3.setText(almanac.getShould());
		textArea_3.setFont(new Font("华文隶书", Font.BOLD, 19));

		// 忌
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(134, 226, 315, 24);
		frame.getContentPane().add(textArea_4);
		textArea_4.setEnabled(false);
		textArea_4.setText(almanac.getAvoid());
		textArea_4.setFont(new Font("华文隶书", Font.BOLD, 19));

		// 节日
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(134, 274, 315, 24);
		frame.getContentPane().add(textArea_5);
		textArea_5.setEnabled(false);
		textArea_5.setText(almanac.getFestival());
		textArea_5.setFont(new Font("华文隶书", Font.BOLD, 19));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 105, 21);
		frame.getContentPane().add(menuBar);

		JMenu moreFunction = new JMenu("点我更多功能");
		menuBar.add(moreFunction);

		JMenuItem robot = new JMenuItem("聊天对话机器人");
		moreFunction.add(robot);
		
		JMenuItem IDcard = new JMenuItem("身份证信息查询");
		moreFunction.add(IDcard);
		// 聊天机器人
		robot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Robot dialog = new Robot();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// 身份证信息查询
		IDcard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Identitycard dialog = new Identitycard();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
