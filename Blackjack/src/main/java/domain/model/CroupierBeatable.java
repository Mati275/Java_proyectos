package domain.model;


import domain.enums.UserState;

public class CroupierBeatable extends Croupier{
	
	// ATTRIBUTES	
	private int chips;			// Amount of chips that have to make a bet
	//protected int currentBet;	// Amount of chips that is on bet right now
	
	// Static attributes
	private static final int INITIAL_CHIPS = 100;
	
	// CONSTRUCTOR(S)
	public CroupierBeatable(int chips, String name) {
		super( name );
		this.chips = chips;
		
	}
	
	// Put the initial chips by default
	public CroupierBeatable(String name) {
		this(INITIAL_CHIPS, name);
		
	}
	
	
	// GETTERS 
	public int getChips() { return chips; }
	
	//public int getCurrentBet() { return currentBet; }

	// SETTERS
	public void setChips( int chips ) { this.chips = chips ; }
	
	//public void setCurrentBet( int currentBet ) { this.currentBet = currentBet ; }

	
	
	
	// **********
	// OTHER METHODS
	// **********
	
	
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
