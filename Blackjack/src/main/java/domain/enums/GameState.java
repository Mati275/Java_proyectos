package main.java.domain.enums;

public enum GameState {
	PLAYING {
		
		@Override
		public boolean isPlaying() {
			return true;
		}
	}, 
	
	ENDED {
		
		@Override
		public boolean isPlaying() {
			return false;
		}
	};
	
	public abstract boolean isPlaying();
}
