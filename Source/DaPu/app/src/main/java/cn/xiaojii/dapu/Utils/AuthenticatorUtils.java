package cn.xiaojii.dapu.Utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AuthenticatorUtils extends Authenticator {
    String userName = null;
    String password = null;

    public AuthenticatorUtils() {
    }

    public AuthenticatorUtils(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}

