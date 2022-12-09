package com.djxc.study.web.dao;

import com.djxc.study.demo.entity.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class DJDataBase {

    private Map<String, AuthUser> data = null;
    public Map<String, AuthUser> getDatabase() {
        if(data == null) {
            data = new HashMap<>();
            AuthUser jack = new AuthUser(1, "dj", "123",
                    0, getGrants("ROLE_USER"));
            AuthUser jack1 = new AuthUser(1, "jack", "123",
                    0, getGrants("ROLE_EDITOR"));
            AuthUser jack2 = new AuthUser(1, "jack", "123",
                    0, getGrants("ROLE_ADMIN"));
            data.put("dj", jack);
            data.put("jack1", jack1);
            data.put("jack2", jack2);
        }
        return data;
    }

    private Collection<GrantedAuthority> getGrants(String role) {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }
}
