package ui;

import jconsole.JConsole;

public class MultiplayerGame extends Game {

	public MultiplayerGame(int numPlayers) {
		super(numPlayers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turnLoop(JConsole console) {

	}

	@Override
	public boolean hasGameEnded() {
		return false;
	}

}
