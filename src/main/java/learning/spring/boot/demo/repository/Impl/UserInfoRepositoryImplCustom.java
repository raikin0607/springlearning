package learning.spring.boot.demo.repository.Impl;

import learning.spring.boot.demo.common.JpaResultConverter;
import learning.spring.boot.demo.entity.UserInfo;
import learning.spring.boot.demo.repository.UserInfoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class UserInfoRepositoryImplCustom implements UserInfoRepositoryCustom {

    private final EntityManager entityManager;
    public UserInfoRepositoryImplCustom (EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public UserInfo getUserByUserName(String userName) {
        UserInfo user ;
        String sql = "SELECT * FROM user_info WHERE user_name = :user_name ";
        Query query = entityManager.createNativeQuery(sql)
                .setParameter("user_name",userName);
        user = new JpaResultConverter().uniqueResult(query,UserInfo.class);
        return user;
    }
}
