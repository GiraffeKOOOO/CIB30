import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	private Color backg = Color.decode("#acd3ff");
	private JButton btnLogIn, btnSignUp,btnBack,btnRegister, btnClockIn, btnClockOut;
	private JLabel lblPassword,lblFail,lblSignUp;
	private JTextField username,txtUser, txtUserV;
	private JPasswordField password, txtPass, txtPassV;
	Logic logic = new Logic();
	
	public GUI() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		frame = new JFrame("8 & a half men");
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("webicon.ico");
		frame.setIconImage(img.getImage());
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backg);
		
		frame.add(panel);
		frame.setVisible(true);
		logIn();
	}
	
	public void mainWindow(){
		panel.removeAll();
		
		btnClockIn = new JButton("Clock In");
		btnClockIn.setBounds(50, 50, 175, 175);
		btnClockIn.setFont(btnLogIn.getFont().deriveFont(30f));
		btnClockIn.addActionListener(new ClockInHandler());
		panel.add(btnClockIn);
		
		btnClockOut = new JButton("Clock Out");
		btnClockOut.setBounds(600, 50, 175, 175);
		btnClockOut.setFont(btnLogIn.getFont().deriveFont(30f));
		btnClockOut.setEnabled(false);
		btnClockOut.addActionListener(new ClockOutHandler());
		panel.add(btnClockOut);
		
		panel.revalidate();
		panel.repaint();
	}
	
	public void logIn(){
		username = new JTextField(15);
		username.setBounds(160, 50, 350, 50);
		username.setText("Username");
		username.setFont(username.getFont().deriveFont(30f));
		panel.add(username);
		
		password = new JPasswordField(15);
		password.setBounds(160, 170, 350, 50);
		password.setFont(password.getFont().deriveFont(30f));
		panel.add(password);
		
		btnLogIn = new JButton("Log In!");
		btnLogIn.setBounds(250, 400, 150, 100);
		btnLogIn.setFont(btnLogIn.getFont().deriveFont(30f));
		btnLogIn.addActionListener(new LogInHandler());
		panel.add(btnLogIn);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(400, 400, 150, 100);
		btnSignUp.setFont(btnSignUp.getFont().deriveFont(30f));
		btnSignUp.addActionListener(new SignUpHandler());
		panel.add(btnSignUp);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(0, 170, 160, 50);
		lblPassword.setFont(lblPassword.getFont().deriveFont(30f));
		lblPassword.setForeground(Color.WHITE);
		panel.add(lblPassword);
		
		panel.revalidate();
		panel.repaint();
	}
	
	public void signUp(){
		panel.removeAll();
		
		txtUser = new JTextField(15);
		txtUser.setBounds(160, 50, 350, 50);
		txtUser.setText("Username");
		txtUser.setFont(txtUser.getFont().deriveFont(30f));
		panel.add(txtUser);
		
		txtUserV = new JTextField(15);
		txtUserV.setBounds(160, 110, 350, 50);
		txtUserV.setText("Confirm Username");
		txtUserV.setFont(txtUserV.getFont().deriveFont(30f));
		panel.add(txtUserV);
		
		txtPass = new JPasswordField(15);
		txtPass.setBounds(160, 170, 350, 50);
		txtPass.setFont(txtPass.getFont().deriveFont(30f));
		panel.add(txtPass);
		
		txtPassV = new JPasswordField(15);
		txtPassV.setBounds(160, 230, 350, 50);
		txtPassV.setFont(txtPassV.getFont().deriveFont(30f));
		panel.add(txtPassV);
		
		btnRegister = new JButton("Confirm");
		btnRegister.setBounds(400, 400, 150, 100);
		btnRegister.setFont(btnSignUp.getFont().deriveFont(30f));
		btnRegister.addActionListener(new RegisterHandler());
		panel.add(btnRegister);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(250, 400, 150, 100);
		btnBack.setFont(btnBack.getFont().deriveFont(30f));
		btnBack.addActionListener(new BackHandler());
		panel.add(btnBack);
		
		lblPassword.setBounds(0,170,160,50);
		panel.add(lblPassword);
		
		panel.revalidate();
		panel.repaint();
	}
	
	class LogInHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			lblFail = new JLabel("Username/Password not found or wrong ");
			lblFail.setBounds(50, 300, 600, 50);
			lblFail.setFont(lblFail.getFont().deriveFont(30f));
			lblFail.setForeground(Color.WHITE);
			
				logic.setUser(username.getText());
				logic.setPass(String.valueOf(password.getPassword()));
				try {
					if(logic.check()){
						mainWindow();
					}
					else{
						panel.add(lblFail);
						panel.revalidate();
						panel.repaint();
					}
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
		}	
	}
	
		class SignUpHandler implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
			
		}
		
		class RegisterHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				lblSignUp = new JLabel();
				lblSignUp.setBounds(100,250,600,100);
				lblSignUp.setForeground(new Color(255,255,255));
				lblSignUp.setFont(lblSignUp.getFont().deriveFont(25f));
				panel.add(lblSignUp);
				
				logic.setUser(txtUser.getText());
				//bj.setUserNameVerify(userNameVerifySU.getText());
				logic.setPass(String.valueOf(txtPass.getPassword()));
				//bj.setPasswordVerify(passwordVerifySU.getText());
				try {
					if(logic.check()){
							lblSignUp.setText("Username in use");
					}
					else{
						lblSignUp.setText("Successful, your Username is "+txtUser.getText());
					try {
						logic.createUser();
					}
					catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					}
						}
					}
				catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		class BackHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				logIn();
				panel.revalidate();
				panel.repaint();
			}		
			
		}
		
		class ClockInHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				btnClockOut.setEnabled(true);
				btnClockIn.setEnabled(false);
				try {
					logic.clockIn();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
		class ClockOutHandler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				btnClockIn.setEnabled(true);
				btnClockOut.setEnabled(false);
				try {
					logic.clockOut();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new GUI();

	}

}
