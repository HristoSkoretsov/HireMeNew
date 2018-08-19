package org.ico.hireme.common.factories;

import org.ico.hireme.domain.entities.UserRole;

public final class UserRoleFactory {
    public UserRoleFactory() {}

    public final UserRole createUserRole(String authority) {
        UserRole userRole = new UserRole();

        userRole.setAuthority(authority);

        return userRole;
    }
}
