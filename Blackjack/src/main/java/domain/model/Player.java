package domain.model;


import domain.enums.UserState;
import domain.exceptions.invalidChipsException;

public class Player extends User{

	// ATTRIBUTES
	
	private PlayerUser playerUser; // The user registred in DB that is playing the game

	private int chips; // Chips that the player has
	//protected int currentBet; // The number of chips in the currentBet
	private int id; // An id for each player
	
	// Static attributes
	private static int nextId;
	private static final int INITIAL_CHIPS = 100;
	
	// CONSTRUCTOR(S)
	public Player(int chips, PlayerUser playerUser){
		super( playerUser.getNickname() );

		this.playerUser = playerUser;
		
		if(chips <= 0) {
			throw new invalidChipsException("Se han agregado : " + chips + " fichas");
		}
		
		
		this.chips = chips;
		//currentBet = 0;

		// Create the id for the player
		id = nextId;
		nextId += 1;
		
	}
	
	public Player(PlayerUser playerUser){
		this(INITIAL_CHIPS, playerUser);
	}

	
	// GETTERS 
	public int getChips() { return chips; }

	//public int getCurrentBet() { return currentBet; }

	public int getId() { return id; }
	


	// SETTERS
	public void setChips( int chips ) { this.chips = chips ; }
	
	//public void setCurrentBet( int currentBet ) { this.currentBet = currentBet ; }

	public void setId( int id ) { this.id = id; }

	
	// ************
	// OTHER METHODS
	// ************
	
	
	
//	public void incrementCurrentBet( int increment ) {
//		currentBet += increment;
//	}
	
	
	/**
	 * Add the amount of chips passed in the parameter
	 * @param chips
	 */
	
	public void addChips(int chips) {
		this.chips += chips;
	}
	
	
	@Override
	public boolean isInBankruptcy() {
		if ( chips > 0 ) return false;
		
		// Have 0 or less chips
		playingState = UserState.BANKRUPTCY;
		return true;
	}
	
	/**
	 * Returns in a string the value of the chips that this user has to bet
	 * @return
	 */
	public String chipsToString() {
		return toString() + ": " + chips + " fichas para apostar" ;
	}



}
