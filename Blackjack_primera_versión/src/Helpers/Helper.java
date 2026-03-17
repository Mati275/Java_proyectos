package Helpers;


public class Helper {
	
	
	public static int indexOf (String[] array, String value) {
	
		int indexOf = 0;
		for(int i = 0; i < array.length; i++) {
			
			if( array[i] == value ) {
				indexOf = i;
				return indexOf;
			}
		}
		return -1;
		
	}
	
	
	
	
}
