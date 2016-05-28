package BusinessLogic.ConnectionStates;

import BusinessLogic.ActualConnection;
import BusinessLogic.PhoneBook;

public class ContactState implements ConnectionState {
 
	@Override
	public void dial(String key, ActualConnection connection) {
		if(key.equals("1")){
			connection.speakToAllUIs(connection.showAllContacts()+connection.CONTACT_MENU);
		}else if(key.equals("2")){
			connection.speakToAllUIs("Enter new contact 'name-number' and press S to save");
		}else if(key.equals("3")){
			connection.speakToAllUIs(connection.showAllContacts()+"Enter number of contact you want to delete");
		}else if(key.equals("4")){
			connection.currentState = new MailBoxMenuState();
			connection.speakToAllUIs(connection.MAILBOX_MENU_TEXT);
		}

	}

	@Override
	public int getState() {
		return 8;
	}

}
