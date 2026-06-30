package domain.model;

import java.time.OffsetDateTime;

public class PlayerUser {

    // ATTRIBUTES
    private int user_id;
    private String username;
    private String password;
    private String nickname;
    private OffsetDateTime register_date;

    // CONSTRUCTOR
    public PlayerUser(int user_id, String username, String password, String nickname, OffsetDateTime register_date) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.register_date = register_date;
    }

    // GETTERS

    public int getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }
}

