package th.database.dao;

import th.model.entities.User;

import java.util.List;

public interface UserDao extends IDao<User> {
    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
