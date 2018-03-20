package th.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.UserProfileDao;
import th.database.service.AbstractService;
import th.database.service.UserProfileService;
import th.model.entities.UserProfile;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl extends AbstractService<UserProfile, UserProfileDao> implements UserProfileService {

    UserProfileDao dao;

    @Autowired
    public UserProfileServiceImpl(UserProfileDao dao) {
        this.dao = dao;
    }

    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    public UserProfile findByType(String type) {
        return dao.findByType(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}