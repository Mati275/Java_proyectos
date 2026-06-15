package domain.model;

public abstract class Croupier extends User {


	// ATTRIBUTES
	
	

	
	// CONSTRUCTOR(S)
	public Croupier(String name) {
		super(name);
	}
	
	// GETTERS 
	
	// SETTERS
	
	
	
	// **********
	// OTHER METHODS
	// **********
	
	// This method is from the user
	@Override
	public abstract boolean isInBankruptcy();

}
