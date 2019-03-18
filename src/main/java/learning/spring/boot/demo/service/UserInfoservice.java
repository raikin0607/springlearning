package learning.spring.boot.demo.service;

import learning.spring.boot.demo.common.Security.OAuthDao;
import learning.spring.boot.demo.common.Security.UserAuthen;
import learning.spring.boot.demo.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoservice implements UserDetailsService {

    @Autowired
    OAuthDao oAuthDao;

    @Override
    public UserAuthen loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfoModel userInfoModel = new UserInfoModel();
        try {

            userInfoModel = oAuthDao.getUserDetails(userName);
            UserAuthen userAuthen = new UserAuthen(userInfoModel);
            return userAuthen;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("User " + userName + " Was not found in database ");
        }
    }
}
