package usercrudmanager.userService;

import usercrudmanager.dao.UserDao;
import usercrudmanager.model.UserStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kovalchuk Dmytro on 22.02.2017.
 */
@Service
public class UserServiceImpl implements UserService {

   private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(UserStore userStore) {
        this.userDao.add(userStore);
    }

    @Override
    @Transactional
    public void updateUser(UserStore userStore) {
        this.userDao.updateUser(userStore);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public UserStore getUser(int id) {
       return this.userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<UserStore> usersList() {
        return this.userDao.usersList();
    }
}
