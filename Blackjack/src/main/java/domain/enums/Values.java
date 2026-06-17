package main.java.domain.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum Values {
	
	AS {
		@Override
		public int getValue() {
			return 0;
		}
	}, 
	
	DOS {
		@Override
		public int getValue() {
			return 2;
		}
	}, 
	
	TRES {
		@Override
		public int getValue() {
			return 3;
		}
	}, 
	
	CUATRO {
		@Override
		public int getValue() {
			return 4;
		}
	}, 
	
	CINCO {
		@Override
		public int getValue() {
			return 5;
		}
	}, 
	
	SEIS {
		@Override
		public int getValue() {
			return 6;
		}
	}, 
	
	SIETE {
		@Override
		public int getValue() {
			return 7;
		}
	}, 
	
	OCHO {
		@Override
		public int getValue() {
			return 8;
		}
	}, 
	
	NUEVE {
		@Override
		public int getValue() {
			return 9;
		}
	}, 
	
	DIEZ {
		@Override
		public int getValue() {
			return 10;
		}
	}, 
	
	J {
		@Override
		public int getValue() {
			return 10;
		}
	}, 
	
	Q {
		@Override
		public int getValue() {
			return 10;
		}
	}, 
	
	K {
		@Override
		public int getValue() {
			return 10;
		}
	};
	
	
	// Method that returns the "int" associated with the enum
	public abstract int getValue();
	
	
    private static final Values[] VALUES = values(); // Array that contains every type of this enum 

    // Method that return a random element of the enum 
    public static Values random() {
        return VALUES[ThreadLocalRandom.current().nextInt(VALUES.length)]; 
    }
	
}
