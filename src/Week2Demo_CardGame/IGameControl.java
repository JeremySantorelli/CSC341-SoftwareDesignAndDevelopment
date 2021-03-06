package Week2Demo_CardGame;

public interface IGameControl {
	void playRound();
	void runGame();
	void init();
}

interface IGameView{
	void getResult(String prompt);
	void display(String message);
	<T> T getInput();
}
