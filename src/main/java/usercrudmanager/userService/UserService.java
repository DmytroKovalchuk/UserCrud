package usercrudmanager.userService;

import usercrudmanager.model.UserStore;

import java.util.List;

/**
 * Created by Kovalchuk Dmytro on 22.02.2017.
 */
public interface UserService {
    void add(UserStore userStore);
    void updateUser(UserStore userStore);
    void deleteUser(int id);
    UserStore getUser(int id);
    List<UserStore> usersList();
}
