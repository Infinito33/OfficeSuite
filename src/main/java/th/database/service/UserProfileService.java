package th.database.service;

import th.model.entities.UserProfile;

import java.util.List;

public interface UserProfileService extends IService<UserProfile>{

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}
