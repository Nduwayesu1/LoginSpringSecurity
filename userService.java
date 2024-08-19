package LoginSecurities.LoginSecurity.Service;

import LoginSecurities.LoginSecurity.Domain.User;

public interface userService {
    User signUp(User users);
    User login(String username,String pasword, String role);
    User findByEmail(String email);

}
