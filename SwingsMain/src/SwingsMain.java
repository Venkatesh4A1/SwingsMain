

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class SwingsMain implements ActionListener
{

	public static JFrame jframe;
	private JMenuBar jMenuBar;
	private JMenu jMenu;
	private JMenuItem jMenuItem;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JPanel jPanel;
	private JLabel jLabel1;
	private JTextArea jTextArea1;
	private JLabel jLabel2;
	private JTextArea jTextArea2;
	private JLabel jLabel3;
	private JTextArea jTextArea3;
	private JPasswordField jPasswordField;
	private JLabel jLabel4;
	private JFrame jFrame;
	private java.sql.Connection con;
	private Statement st;
	private JButton submit;
	
	
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException 
	{
		SwingsMain s = new SwingsMain();
		
		s.Registration();
		
	}
	
	
	public void Connection() throws ClassNotFoundException, SQLException 
	{
		System.err.println("database connectio fun...s");
		
		Class.forName("org.h2.Driver");
		con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		System.out.println("database is connected........!");
		st = (Statement) con.createStatement();
		String str="insert into registration values('"+ jTextArea1.getText()+"', '"+jTextArea2.getText()+"' , '" +jTextArea3.getText()+"' ,'"+jPasswordField.getText()+"')";
		st = con.createStatement();
		st.execute(str);
		
	}
	


	public void Registration() 
	{
		jFrame = new JFrame("Swings Demo");
		
		setJmenuBartoFrame();
		
		setjPanalData();
		
		addComponentToJframe();
	}
	
	private void addComponentToJframe() 
	{
	
		jFrame.setJMenuBar(jMenuBar);

		jFrame.add(jPanel);	
		
		jFrame.setSize(1000, 1000);
		jFrame.setLayout(null);

		jFrame.setVisible(true);

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void setjPanalData() 
	{
	
		jPanel = new JPanel();
		jPanel.setBounds(20, 20, 1000, 1000);
		jPanel.setBackground(Color.pink);
		
		jLabel1 = new JLabel("First Name");
		jLabel1.setBounds(310, 10, 150, 20);
		
		jTextArea1 = new JTextArea();
		jTextArea1.setBounds(380, 10, 150, 20);
		
		jLabel2 = new JLabel("Last Name");
		jLabel2.setBounds(310, 50, 150, 20);
		
		jTextArea2 = new JTextArea();
		jTextArea2.setBounds(380, 50, 150, 20);
		
		jLabel3 = new JLabel("User Name");
		jLabel3.setBounds(310, 90, 150, 20);
		
		jTextArea3 = new JTextArea();
		jTextArea3.setBounds(380, 90, 150, 20);
		
		jLabel4 = new JLabel("Password");
		jLabel4.setBounds(310, 130, 150, 20);
		
		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(380, 130, 150, 20);
		
		submit = new JButton("Submit");
		submit.setBounds(310, 170, 150,20);
		submit.addActionListener(this);
		
		
		jPanel.setLayout(null);
		
		jPanel.add(jLabel1);
		jPanel.add(jLabel2);
		jPanel.add(jLabel3);
		jPanel.add(jLabel4);
		jPanel.add(jTextArea1);
		jPanel.add(jTextArea2);
		jPanel.add(jTextArea3);
		jPanel.add(jPasswordField);
		jPanel.add(submit);
		
	}

	

	private void setJmenuBartoFrame() 
	{
		
		jMenuBar = new JMenuBar();
		
		jMenu = new JMenu("Field");
		
		jMenuItem = new JMenuItem("New");
		jMenuItem1 = new JMenuItem("Update");
		jMenuItem2 = new JMenuItem("Delete");
		jMenuItem3 = new JMenuItem("EXit");
		
		jMenuItem.addActionListener(this);
		jMenuItem1.addActionListener(this);
		jMenuItem2.addActionListener(this);
		
		jMenu.add(jMenuItem);
		jMenu.add(jMenuItem1);
		jMenu.add(jMenuItem2);
		jMenu.add(jMenuItem3);
		
		jMenuBar.add(jMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Got: " + e.getSource());
		if (e.getSource() == jMenuItem) 
		{
			int i = JOptionPane.showConfirmDialog(jframe, "Done");

			if (JOptionPane.YES_OPTION == i) 
			{
				System.exit(0);
			}
		}
		if(e.getSource() == submit)
		{
			try 
			{
				Connection();
			} 
			catch (ClassNotFoundException e1) 
			{
			
				e1.printStackTrace();
			} 
			catch (SQLException e1) 
			{
			
				e1.printStackTrace();
			}
		}
	}
	

	
}