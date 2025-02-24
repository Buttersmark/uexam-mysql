package com.alvis.exam.service.impl;

import com.alvis.exam.configuration.property.SystemConfig;
import com.alvis.exam.domain.User;
import com.alvis.exam.service.AuthenticationService;
import com.alvis.exam.service.UserService;
import com.alvis.exam.utility.RsaUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 高xh
 */
@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserService userService;

    private final SystemConfig systemConfig;


    /**
     * @param username username
     * @param password password
     * @return boolean
     */
    @Override
    public boolean authUser(String username, String password) {
        User user = userService.getUserByUserName(username);
        return authUser(user, username, password);
    }


    @Override
    public boolean authUser(User user, String username, String password) {
        if (user == null) {
            return false;
        }
        String encodePwd = user.getPassword();
        if (null == encodePwd || encodePwd.length() == 0) {
            return false;
        }
        String pwd = pwdDecode(encodePwd);
        return pwd.equals(password);
    }

    @Override
    public String pwdEncode(String password) {
        return RsaUtil.rsaEncode(systemConfig.getPwdKey().getPublicKey(), password);
    }

    @Override
    public String pwdDecode(String encodePwd) {
        return RsaUtil.rsaDecode(systemConfig.getPwdKey().getPrivateKey(), encodePwd);
    }


}
