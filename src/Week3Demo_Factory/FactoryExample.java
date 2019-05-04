package factoryPack;
import java.util.*;

public class FactoryExample {

	public static void main(String[] args) {

	}
	
	static void actionMethod1(int whichOne){
		List<Integer> lst = Factory.getConcreteList(whichOne); //new ArrayList<Integer>();
		lst.add(12);
		lst.add(45);
		//......		
	}
	
	static void actionMethod2(int workerKind){
		Context context = new Context();
		context.doWork(12, workerKind);
		//......
	}		
}

class Factory{
	static List<Integer> getConcreteList(int selector){
		if(selector == 1) return new ArrayList<Integer>();
		else if(selector == 2) return new LinkedList<Integer>();
		else return null;
	}
}

class Context{
	WorkerType worker;
	
	void setWorker(WorkerType worker){ this.worker = worker; }
	void doWork(int time, int workerKind){
		//.....
		worker = WorkerFactory.getWorker(workerKind);
		if(time > 8 && time < 17) worker.doSomething();
		//.....
	}
}

interface WorkerType{ void doSomething(); }
class PhysicalWorker implements WorkerType{
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub		
	}	
}
class MentalWorker implements WorkerType{
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub		
	}	
}
class WorkerFactory{
	static WorkerType getWorker(int workerKind){
		if(workerKind == 1) return new PhysicalWorker();
		else return new MentalWorker();
	}
}