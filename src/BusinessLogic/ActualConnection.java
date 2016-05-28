package BusinessLogic;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.ConnectionStates.ConnectedState;
import BusinessLogic.ConnectionStates.ConnectionState;
import UserInterfaces.UserInterface;

import java.sql.*;

import javax.swing.JOptionPane;

import Adapter.SqliteConnection;

public class ActualConnection
{
	   public MailSystem system;
	   public Mailbox currentMailbox;
	   public String currentRecording;
	   public String accumulatedKeys;
	   public ConnectionState currentState = null;
	   int state;
	   Connection connection = SqliteConnection.dbConnector();
	   public PhoneBook phonebook =  new PhoneBook();
	   List<UserInterface> uis= new ArrayList<UserInterface>();
	   private static final String INITIAL_PROMPT = 
	         "Enter mailbox number followed by #";      
	   public static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting\n"
	   		+ "Enter 4 to contacts menu";
	   public static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
	   public static final String CONTACT_MENU =
			 "Enter 1 to see contacts\n"
	        + "Enter 2 to add contacts\n"
	        + "Enter 3 to delete contact\n"
	        + "Enter 4 to return to the main menu";
	   
   public ActualConnection(MailSystem s)
   {
      system = s;
//      connection = SqliteConnection.dbConnector(); 
   }
   
   public void addUI(UserInterface ui){
	   uis.add(ui);	 
	   resetConnection();
   }

   public void dial(String key)
   {
      currentState.dial(key, this);
   }
   
   public void record(String voice)
   {
      if (currentState.getState() == 2 || currentState.getState() == 6 || currentState.getState()==8)
         currentRecording += voice;
   }

   public void hangup()
   {
      if (currentState.getState() == 2)
         currentMailbox.addMessage(new Message(currentRecording));
      	resetConnection();
      	//adapter.save(#mailbox,message);
   }
   
   public boolean isConnected() {
	    return currentState.getState() == 1;
	 }

	 public boolean isRecording() {
	    return currentState.getState() == 2;
	 }

	 public boolean isInMailBoxMenu() {
	    return currentState.getState() == 3;
	 }

	 public boolean isInMessageMenu() {
	    return currentState.getState() == 4;
	 }

	 public boolean isInChangePassword() {
	    return currentState.getState() == 5;
	 }

	 public boolean isInChangeGreeting() {
	    return currentState.getState() == 6;
	 }

   private void resetConnection(){
      currentRecording = "";
      accumulatedKeys = "";
      currentState = new ConnectedState();
      speakToAllUIs(INITIAL_PROMPT);
   }
   
   public void speakToAllUIs(String output) {
	   	for(UserInterface ui : uis) {
	   		ui.speak(output);
	   	}
   }

	public void saveContact(String xcontact) {
		phonebook.add(new Contact(xcontact));
		
	}
	 public String showAllContacts(){
		 String output = "You have "+phonebook.size()+" contacts :\n";
		 int num=1;
		 for (Contact contact : phonebook.contacts) {
			 output+=num+"."+contact.fullContact+"\n";
			 num++;
		 }
		 return output;
	 }

	public void removeContact(String idContact) {
		phonebook.remove(Integer.parseInt(idContact)-1 );
		speakToAllUIs("Contact delete successfully");
	}

	public void insertMessage(String mailbox, String message) {
		try {
			String query ="INSERT INTO Messages (mailbox, message) VALUES ('" + mailbox + "','" +message+"')";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.executeUpdate();
		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
	
	public void insertContact(String fullcontact){
		try {
			String query ="INSERT INTO Contacts (fullContact) VALUES ('" + fullcontact + "')";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.executeUpdate();
		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
	
	public void deleteContact(String fullname){
		try {
			String query ="DELETE FROM Contacts WHERE fullContact = '" + fullname + "'";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.executeUpdate();
		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
		}
	}
	
	public int showMessages(){
		int values;
		try {
			String query ="SELECT * FROM Messages";
			PreparedStatement pst = connection.prepareStatement(query);
			values = pst.executeUpdate();
		} catch (Exception r) {
			JOptionPane.showMessageDialog(null, r);
			values =0;
		}
		return values;
	}
	
	public void showContacts(){
		
	}
}











