package learning.spring.boot.demo.repository;

import learning.spring.boot.demo.entity.UserInfo;

public interface UserInfoRepositoryCustom {
    UserInfo getUserByUserName(String userName);
}
