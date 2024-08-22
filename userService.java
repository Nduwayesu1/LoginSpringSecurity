package LoginSecurities.LoginSecurity.Service;

import LoginSecurities.LoginSecurity.Domain.User;

public interface userService {
    User signUp(User users);
    User findByUsername(String username);

}
