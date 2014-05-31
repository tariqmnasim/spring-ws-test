package com.test.ws.dao;

import com.test.ws.domain.User;
import com.test.ws.enumeration.Role;

/**
 * Created by Nasim on 5/31/14.
 */
public class UserDao {

    private static final String DEFAULT_ADMIN_PASS = "admin@12";
    private static final String DEFAULT_MEMBER_PASS = "member#34";
    private static final String DUMMY_ADMIN_EMAIL = "admin@domain.com";
    private static final String DUMMY_MEMBER_EMAIL = "member@domain.com";

    public User getUser(String email) {
        /** We are only allowing now two dummy users here
         * Actually here we will have to retrieve the users by the email address from Database **/

        User user = new User();
        if(email.equals(DUMMY_ADMIN_EMAIL)) {
            user.setId(1);
            user.setName("Administrator");
            user.setPassword(DEFAULT_ADMIN_PASS);
            user.setRole(Role.ROLE_ADMIN);
        } else if(email.equals(DUMMY_MEMBER_EMAIL)) {
            user.setId(2);
            user.setName("Member");
            user.setPassword(DEFAULT_MEMBER_PASS);
            user.setRole(Role.ROLE_ADMIN);
        }
        user.setEmail(email);
        return user;
    }
}
