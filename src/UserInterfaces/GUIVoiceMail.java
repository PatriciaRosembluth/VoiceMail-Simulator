package UserInterfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.sql.*;

import Adapter.SqliteConnection;
import BusinessLogic.ActualConnection;
import java.awt.Color;

public class GUIVoiceMail extends UserInterface {

	private JFrame frmTelephone;
	private JTextField textFieldSpeak;
	private JTextPane textFieldListen;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnHashTag, btnH, btnSC, btnDL;
	private ActualConnection conn;
	private String data = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVoiceMail window = new GUIVoiceMail();
					window.frmTelephone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	Connection connection = null;
	private JButton btnDeleteContact;
	/**
	 * Create the application.
	 */
	public GUIVoiceMail() {
		initialize();
//		connection = SqliteConnection.dbConnector(); 
	}
	
	public void speak(String output) {
		textFieldListen.setText(output);
	}
	
	 public void run(ActualConnection c) {
		 conn = c;
		 frmTelephone.setVisible(true);
		 buttonAction();
		
	}
	  
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelephone = new JFrame();
		frmTelephone.setForeground(Color.BLACK);
		frmTelephone.setTitle("Telephone");
		frmTelephone.setBounds(100, 100, 467, 410);
		frmTelephone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelephone.getContentPane().setLayout(null);
		
		btn1 = new JButton("1");
		btn1.setBounds(10, 239, 77, 23);
		frmTelephone.getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(97, 239, 77, 23);
		frmTelephone.getContentPane().add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(184, 239, 77, 23);
		frmTelephone.getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(10, 273, 77, 23);
		frmTelephone.getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(97, 273, 77, 23);
		frmTelephone.getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(184, 273, 77, 23);
		frmTelephone.getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(10, 307, 77, 23);
		frmTelephone.getContentPane().add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(97, 307, 77, 23);
		frmTelephone.getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(184, 307, 77, 23);
		frmTelephone.getContentPane().add(btn9);
		
		btnHashTag = new JButton("#");
		btnHashTag.setBounds(10, 341, 77, 23);
		frmTelephone.getContentPane().add(btnHashTag);
		
		btn0 = new JButton("0");
		btn0.setBounds(97, 341, 77, 23);
		frmTelephone.getContentPane().add(btn0);
		
		btnH = new JButton("H");
		btnH.setBounds(184, 341, 77, 23);
		frmTelephone.getContentPane().add(btnH);
		
		btnSC = new JButton("Save Contact");
		btnSC.setBounds(271, 239, 170, 23);
		frmTelephone.getContentPane().add(btnSC);
		
		btnDL = new JButton("Delete Contact");
		btnDL.setBounds(271, 273, 170, 23);
		frmTelephone.getContentPane().add(btnDL);
		
		textFieldSpeak = new JTextField();
		textFieldSpeak.setBounds(271, 307, 174, 57);
		frmTelephone.getContentPane().add(textFieldSpeak);
		textFieldSpeak.setColumns(10);
		
		textFieldListen = new JTextPane();
		textFieldListen.setBounds(10, 11, 431, 217);
		frmTelephone.getContentPane().add(textFieldListen);
		
	}

	private void buttonAction() {
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("1");
				conn.dial(textFieldSpeak.getText());
				data+="1";
				textFieldSpeak.setText("");
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("2");
				conn.dial(textFieldSpeak.getText());
				data+="2";
				textFieldSpeak.setText("");
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("3");
				conn.dial(textFieldSpeak.getText());
				data+="3";
				textFieldSpeak.setText("");
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("4");
				conn.dial(textFieldSpeak.getText());
				data+="4";
				textFieldSpeak.setText("");
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("5");
				conn.dial(textFieldSpeak.getText());
				data+="5";
				textFieldSpeak.setText("");
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("6");
				conn.dial(textFieldSpeak.getText());
				data+="6";
				textFieldSpeak.setText("");
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("7");
				conn.dial(textFieldSpeak.getText());
				data+="7";
				textFieldSpeak.setText("");
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("8");
				conn.dial(textFieldSpeak.getText());
				data+="8";
				textFieldSpeak.setText("");
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("9");
				conn.dial(textFieldSpeak.getText());
				data+="9";
				textFieldSpeak.setText("");
			}
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("0");
				conn.dial(textFieldSpeak.getText());
				data+="0";
				textFieldSpeak.setText("");
			}
		});
		btnHashTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("#");
				conn.dial(textFieldSpeak.getText());
				data+="#";
				textFieldSpeak.setText("");
			}
		});
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.record(textFieldSpeak.getText());
				conn.hangup();
				conn.insertMessage(data,textFieldSpeak.getText());
				textFieldSpeak.setText("");
			}
		});
		btnSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				conn.record(textFieldSpeak.getText());
//				conn.saveContact(conn.currentRecording);
//				conn.currentRecording = "";
				conn.insertContact(textFieldSpeak.getText());
				conn.speakToAllUIs(ActualConnection.CONTACT_MENU);
			}
		});
		
		btnDL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.record(textFieldSpeak.getText());
				conn.removeContact(conn.currentRecording);
				conn.currentRecording = "";
				conn.speakToAllUIs(ActualConnection.CONTACT_MENU);
			}
		});
	}
}
