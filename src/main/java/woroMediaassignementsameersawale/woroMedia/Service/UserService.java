package woroMediaassignementsameersawale.woroMedia.Service;

import woroMediaassignementsameersawale.woroMedia.Entity.User;

public interface UserService {

    public User registerUser(User user) throws Exception;

    public User getAuthenticateUser();

    public User findUserByUserName(String userName);

    public User findUserById(int id);
}
