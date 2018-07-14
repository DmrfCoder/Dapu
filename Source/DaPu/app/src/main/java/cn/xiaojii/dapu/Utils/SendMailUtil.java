package cn.xiaojii.dapu.Utils;

import android.support.annotation.NonNull;

import java.io.File;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.MailSenderInfoBean;

/**
 * Created by Administrator on 2017/4/10.
 */

public class SendMailUtil {



    public static void SendDataFileToEmail(String toAdd, String name, final File file) {
        final MailSenderInfoBean mailInfo = creatMail(toAdd, name);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendFileMail(mailInfo, file);
            }
        }).start();
    }

    public static void SendDataToEmail(String toAdd, String name, String content) {
        final MailSenderInfoBean mailInfo = creatMail(toAdd, name, content);
        final MailSender sms = new MailSender();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendTextMail(mailInfo);
            }
        }).start();
    }


    @NonNull
    private static MailSenderInfoBean creatMail(String toAdd, String name) {
        final MailSenderInfoBean mailInfo = new MailSenderInfoBean();
        mailInfo.setMailServerHost(GlogalBean.HOST);
        mailInfo.setMailServerPort(GlogalBean.PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(GlogalBean.FROM_ADD); // 你的邮箱地址
        mailInfo.setPassword(GlogalBean.FROM_PSW);// 您的邮箱密码
        mailInfo.setFromAddress(GlogalBean.FROM_ADD); // 发送的邮箱
        mailInfo.setToAddress(toAdd); // 发到哪个邮件去
        mailInfo.setSubject(name); // 邮件主题
        return mailInfo;
    }

    @NonNull
    private static MailSenderInfoBean creatMail(String toAdd, String name, String content) {
        final MailSenderInfoBean mailInfo = new MailSenderInfoBean();
        mailInfo.setMailServerHost(GlogalBean.HOST);
        mailInfo.setMailServerPort(GlogalBean.PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(GlogalBean.FROM_ADD); // 你的邮箱地址
        mailInfo.setPassword(GlogalBean.FROM_PSW);// 您的邮箱密码
        mailInfo.setFromAddress(GlogalBean.FROM_ADD); // 发送的邮箱
        mailInfo.setToAddress(toAdd); // 发到哪个邮件去
        mailInfo.setSubject(name); // 邮件主题
        mailInfo.setContent(content); // 邮件文本
        return mailInfo;
    }
}
