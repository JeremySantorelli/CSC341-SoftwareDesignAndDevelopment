package Week3Demo_Factory;
import java.util.*;

public class ReplacingIfsWithObjStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void mainLogic(){
		Scanner sc = new Scanner(System.in);
		String intput; 
		while(true){
			System.out.println("Selct from a, b, c, d...");
			intput = sc.nextLine();
			if(intput.equals("a")){
				//do something
			}
			else if(intput.equals("b")){
				//do something
			}
			else if(intput.equals("c")){
				//do something
			}
			else{
				System.exit(0);
			}
		}
		
	}
	
	static void mainObjLogic(String prompt){
		Scanner sc = new Scanner(System.in);
		String input; 
		IDoSomething doer;
		while(true){
			System.out.println(prompt);
			input = sc.nextLine();
			doer = getDoer(input);
			if(doer == null){
				System.exit(0);
			}
			doer.doSomething();
		}		
	}
	
	static IDoSomething getDoer(String whichDoer){
		if(whichDoer.equals("a")) return new DoThis();
		else if(whichDoer.equals("b")) return new DoThat();
		else return null;
	}
}

interface IDoSomething{
	void doSomething();
}

class DoThis implements IDoSomething{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}	
}

class DoThat implements IDoSomething{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}	
}

