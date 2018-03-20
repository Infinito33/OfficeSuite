package th.database.dao;

import th.model.entities.UserProfile;

import java.util.List;

public interface UserProfileDao extends IDao<UserProfile> {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}
