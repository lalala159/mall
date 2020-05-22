package com.mall.oauth2.authbean;

import com.mall.oauth2.domain.TUser;
import lombok.Data;
import org.springframework.security.core.userdetails.User;
import java.util.Collections;

@Data
public class AuthUserDetail extends User {
    private TUser tUser;
    public AuthUserDetail(TUser user) {
        super(user.getUsername(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.tUser= user;
    }
}
