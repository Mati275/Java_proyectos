package respositories;

import domain.model.PlayerUser;

public interface UserRepository {

    public void saveUser( PlayerUser playerUser );

    public boolean findUser( String username, int password );




}
