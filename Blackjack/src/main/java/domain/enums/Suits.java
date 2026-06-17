package main.java.domain.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum Suits {
	
	CORAZONES {
		@Override
		public String getSuitName() {
			return "corazones";
		}
	}, 
	
	DIAMANTES {
		@Override
		public String getSuitName() {
			return "diamantes";
		}
	}, 
	
	PICAS {
		@Override
		public String getSuitName() {
			return "picas";
		}
	}, 
	
	TREBOLES {
		@Override
		public String getSuitName() {
			return "treboles";
		}
	};
	
	
	// Method that returns the string associated with the enum
	public abstract String getSuitName();
	
	
    private static final Suits[] VALUES = values(); // Array that contains every type of this enum 

    // Method that return a random element of the enum 
    public static Suits random() {
        return VALUES[ThreadLocalRandom.current().nextInt(VALUES.length)]; 
    }
	
	
}

