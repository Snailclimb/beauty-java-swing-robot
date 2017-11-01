package idcard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author 寇爽 
 * @Description: ${TODO}(身份证信息查询主界面以及处理事件的实现) 
 */
@SuppressWarnings("serial")
public class Identitycard extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Identitycard() {
		setBounds(100, 100, 493, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel sex = new JLabel("\u6027\u522B\uFF1A");
			sex.setBounds(10, 38, 57, 30);
			sex.setFont(new Font("华文行楷", Font.PLAIN, 19));
			contentPanel.add(sex);
		}

		//年龄
		JLabel age = new JLabel("\u5E74\u9F84\uFF1A");
		age.setBounds(10, 78, 57, 30);
		age.setFont(new Font("华文行楷", Font.PLAIN, 19));
		contentPanel.add(age);

		//出生日期
		JLabel birthday = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		birthday.setBounds(10, 118, 95, 30);
		birthday.setFont(new Font("华文行楷", Font.PLAIN, 19));
		contentPanel.add(birthday);

		//所在省份
		JLabel province = new JLabel("\u6240\u5728\u7701\u4EFD\uFF1A");
		province.setBounds(10, 158, 95, 30);
		province.setFont(new Font("华文行楷", Font.PLAIN, 19));
		contentPanel.add(province);
       
		//显示性别
		JTextArea sex1 = new JTextArea();
		sex1.setBounds(145, 42, 267, 24);
		contentPanel.add(sex1);
		sex1.setEditable(false);
        
		//显示年龄
		JTextArea age1 = new JTextArea();
		age1.setBounds(145, 82, 267, 24);
		contentPanel.add(age1);
		age1.setEnabled(false);
         
	    //显示出生日期
		JTextArea birthday1 = new JTextArea();
		birthday1.setBounds(145, 122, 267, 24);
		contentPanel.add(birthday1);
		birthday1.setEnabled(false);

		//显示所在省份
		JTextArea province1 = new JTextArea();
		province1.setBounds(145, 162, 267, 24);
		contentPanel.add(province1);
		province1.setEnabled(false);
        
		//输入身份证
		JLabel idcard = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		idcard.setFont(new Font("华文行楷", Font.PLAIN, 19));
		idcard.setBounds(10, 211, 164, 30);
		contentPanel.add(idcard);

		//输入身份证的文本区域
		JTextArea idcard1 = new JTextArea();
		idcard1.setBounds(170, 215, 242, 26);
		contentPanel.add(idcard1);

		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(147, 260, 93, 23);
		contentPanel.add(submit);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		// 提交按钮处理时间
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 获取输入的身份证
				String q = idcard1.getText();
				IdcardValidator validator = new IdcardValidator();
				//循环语句判断输入的身份证是否正确
				if (validator.isValidatedAllIdcard(q))
				// 通过带一个参数的构造方法初始化一个对象并且执行构造方法中的相关方法
				{
					IdcardInfoExtractor ie = new IdcardInfoExtractor(q);
					sex1.setText(ie.getGender());
					province1.setText(ie.getProvince());

					// int类型数据年龄转换为string类型
					String s = "";
					s = ie.getAge() + "";
					age1.setText(s);

					// Date数据类型出生日期转换为string类型
					String sdate;
					sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(ie.getBirthday());
					birthday1.setText(sdate);
				}
				else {
					idcard1.setText("输入的身份证号不正确");
				}
			}
		});
	}
}
