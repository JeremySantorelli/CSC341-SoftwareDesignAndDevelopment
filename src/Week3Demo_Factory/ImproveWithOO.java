package Week3Demo_Factory;

public class ImproveWithOO {

	public static void main(String[] args) {
		Controller control = new Controller();
		control.run();
	}
}

class Controller{
	View view = new View();
	DataHandler handler = new DataHandler();
	AddressBook book = new AddressBook();
	
	IAction actor;
	
	public void run() {
		String input = view.getInput("Add (a), Retrieve (r) an address, or quit (q)? ");
		actor = ActionFactory.getActor(input.charAt(0));
		actor.takeAction();
		/*
		do{
			String input = view.getInput("Add (a), Retrieve (r) an address, or quit (q)? ");
			if(input.equalsIgnoreCase("a")){
				String name = view.getInput("Enter name --> ");
				String address = view.getInput("Enter address --> ");
				book.add(name, address);
				view.display("Current book size: " + book.getSize());
			}
			else if(input.equalsIgnoreCase("r")){
				input = view.getInput("Enter name --> ");
				view.display("Address: " + view.getResult() + "\n-----");
			}
			else {
				handler.saveData("addresses.txt");
				break; 
			}
		}while(true); */			
	}
}

class ActionFactory{
	static IAction getActor(char desc){
		switch(desc){
			case 'a':
				return new Addition();
			case 'r':
				return new Retrieval();
			case 'q':
				return new DataService();
			default: return null;
		}
	}
}

class Addition implements IAction{
	View view = new View();
	AddressBook book = new AddressBook();
	@Override
	public void takeAction() {
		String name = view.getInput("Enter name --> ");
		String address = view.getInput("Enter address --> ");
		book.add(name, address);
		view.display("Current book size: " + book.getSize());	
	}	
}

class Retrieval  implements IAction{
	View view = new View();
	@Override
	public void takeAction() {
		String input = view.getInput("Enter name --> ");
		view.display("Address: " + view.getResult() + "\n-----");		
	}	
}

class DataService implements IAction{
	DataHandler handler = new DataHandler();
	@Override
	public void takeAction() {
		handler.saveData("addresses.txt");		
	}	
}

interface IAction{
	void takeAction();
}

class View{	
	String getInput(String prompt){ return ""; }
	String getResult(){return "";}
	void display(String what){}
}
class DataHandler{
	void saveData(String file){}
}
class AddressBook{
	void add(String name, String address){}
	int getSize(){return 0;}
}
