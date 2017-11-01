package robot;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
/**
 * @author 寇爽
 * @Description: ${TODO}(聊天机器人功能类) 
 */
@SuppressWarnings("serial")
public class Robot extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public Robot() {
		setBounds(100, 100, 396, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{  
			JLabel question = new JLabel("\u6211\u7684\u95EE\u9898\uFF1A");
			question.setBounds(10, 146, 92, 15);
			contentPanel.add(question);
		}
       //机器人回答
		JLabel answer = new JLabel("\u673A\u5668\u4EBA\u56DE\u7B54\uFF1A");
		answer.setBounds(10, 46, 92, 15);
		contentPanel.add(answer);

		//机器人回答内容
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 30, 198, 73);
		contentPanel.add(scrollPane);

		JTextArea answercontent = new JTextArea(3, 33);
		answercontent.setLineWrap(true);
		answercontent.setEnabled(false);
		scrollPane.setViewportView(answercontent);
		//输入问题
		JTextArea enterquestion = new JTextArea();
		enterquestion.setBounds(136, 142, 198, 24);
		contentPanel.add(enterquestion);
		//提交按钮
		JButton submit = new JButton("\u63D0\u4EA4\u95EE\u9898");
		submit.setBounds(115, 196, 93, 23);
		contentPanel.add(submit);
 
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = new String();
				// 获取输入的问题
				String q = enterquestion.getText();
				try {
					answer = machine(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				answercontent.setText(answer);
			}
		});

		answercontent.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10 || e.getKeyCode() == 38) {
					String answer = new String();
					String q = enterquestion.getText();
					try {
						answer = machine(q);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					answercontent.setText(answer);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

	private static String machine(String quesiton) throws IOException {
		// 接入机器人，输入问题
		String APIKEY = "401415ff3f1245e1a487a82974bb7307";
		String INFO = URLEncoder.encode(quesiton, "utf-8");// 这里可以输入问题
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();

		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		// 断开连接
		connection.disconnect();
		String[] ss = new String[10];
		String s = sb.toString();
		String answer;
		ss = s.split(":");
		answer = ss[ss.length - 1];
		answer = answer.substring(1, answer.length() - 2);
		return answer;
	}
}
