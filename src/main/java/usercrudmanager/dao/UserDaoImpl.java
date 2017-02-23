package usercrudmanager.dao;

import usercrudmanager.model.UserStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kovalchuk Dmytro on 22.02.2017.
 */
@Repository
public class UserDaoImpl implements UserDao  {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UserStore userStore) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userStore);
        logger.info("UserStore is succesfuly added. Info: " + userStore.toString());
    }

    @Override
    public void updateUser(UserStore userStore) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userStore);
        logger.info("UserStore " + userStore.toString() + " succesfuly updated.");
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserStore userStore = (UserStore)session.load(UserStore.class, new Integer(id));
        if(userStore != null){session.delete(userStore);}
        logger.info("UserStore succesfuly deleted. UserStore info: " + userStore.toString());
    }

    @Override
    public UserStore getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserStore userStore = session.load(UserStore.class, new Integer(id));
        logger.info("UserStore is succesfuly load. Load userStore: " + userStore);
        return userStore;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<UserStore> usersList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserStore> usersList1 = session.createQuery("from UserStore").list();

        for(UserStore userStore : usersList1){
            logger.info("UserStore list:" + userStore.toString());
        }
        return usersList1;
    }
}
