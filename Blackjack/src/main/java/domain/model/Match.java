package domain.model;

import java.time.OffsetDateTime;

public class Match {

    // ATTRIBUTES
    private int match_id;
    private int rounds;
    private OffsetDateTime played_date;
    private boolean player_won;
    private int user_id;

    // CONSTRUCTOR
    public Match(int match_id, int rounds, OffsetDateTime played_date, boolean player_won, int user_id) {
        this.match_id = match_id;
        this.rounds = rounds;
        this.played_date = played_date;
        this.player_won = player_won;
        this.user_id = user_id;
    }

}
