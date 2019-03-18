package learning.spring.boot.demo.common.Security;

import learning.spring.boot.demo.model.UserInfoModel;
import org.springframework.security.core.userdetails.User;


public class UserAuthen extends User {
    private static  final long serialVersionUID = 1L;

    public UserAuthen (UserInfoModel userInfoModel) {
        super(userInfoModel.getUserName(), userInfoModel.getPassWord(), userInfoModel.getGrantedAuthoritiesList());

    }
}
