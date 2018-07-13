package cn.xiaojii.dapu.Utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AuthenticatorUtil extends Authenticator {
    String userName = null;
    String password = null;

    public AuthenticatorUtil() {
    }

    public AuthenticatorUtil(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}

