package domain.enums;

public enum CardValueState {
	//CARD_VALUE: Se toma el valor mas pequeño (porque no ha tocado as o el otro valor de as se ha pasado de 21)
	// EXTRA_CARD_VALUE: Se toma el valor mas grande (oorque ha tocado as y no se ha pasado de 21)
	
	// NONE_CARD_VALUE: Se toma el valor de -1 (ya que se ha pasado de 21 el valor mas pequeño)
	NORMAL_CARD_VALUE, EXTRA_CARD_VALUE, NONE_CARD_VALUE;
}
