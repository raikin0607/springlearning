package learning.spring.boot.demo.common.Security;

import learning.spring.boot.demo.entity.UserInfo;
import learning.spring.boot.demo.model.UserInfoModel;
import learning.spring.boot.demo.repository.UserInfoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OAuthDao {
    @Autowired
    UserInfoRepositoryCustom userInfoRepositoryCustom;

    public UserInfoModel getUserDetails(String userName) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoRepositoryCustom.getUserByUserName(userName);
        if (userInfo != null) {
            UserInfoModel userInfoModel = new UserInfoModel();

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthorityList.add(grantedAuthority);

            userInfoModel.setUserName(userInfo.getUserName());
            userInfoModel.setPassWord(userInfo.getPassWord());
            userInfoModel.setGrantedAuthoritiesList(grantedAuthorityList);
            return userInfoModel;
        }
        ;
        return null;
    }
}
