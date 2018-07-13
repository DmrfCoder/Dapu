package cn.xiaojii.dapu.Utils;

import android.util.Log;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import cn.xiaojii.dapu.Bean.MailSenderInfoBean;

/**
 * 发送器
 */
public class MailSender {
    /**
     * 以文本格式发送邮件
     *
     * @param mailSenderInfoBean 待发送的邮件的信息
     */
    public boolean sendTextMail(final MailSenderInfoBean mailSenderInfoBean) {

        // 判断是否需要身份认证
        AuthenticatorUtil authenticator = null;
        Properties pro = mailSenderInfoBean.getProperties();
        if (mailSenderInfoBean.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new AuthenticatorUtil(mailSenderInfoBean.getUserName(), mailSenderInfoBean.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);


        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailSenderInfoBean.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailSenderInfoBean.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailMessage.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());

            // 设置邮件消息的主要内容
            String mailContent = mailSenderInfoBean.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            Log.e("MessagingException","MessagingException");
        }
        return false;
    }

    /**
     * 以HTML格式发送邮件
     *
     * @param mailSenderInfoBean 待发送的邮件信息
     */
    public static boolean sendHtmlMail(MailSenderInfoBean mailSenderInfoBean) {
        // 判断是否需要身份认证
        AuthenticatorUtil authenticator = null;
        Properties pro = mailSenderInfoBean.getProperties();
        // 如果需要身份认证，则创建一个密码验证器
        if (mailSenderInfoBean.isValidate()) {
            authenticator = new AuthenticatorUtil(mailSenderInfoBean.getUserName(), mailSenderInfoBean.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailSenderInfoBean.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailSenderInfoBean.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailSenderInfoBean.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailSenderInfoBean.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    /**
     * 发送带附件的邮件
     *
     * @param info
     * @return
     */
    public boolean sendFileMail(MailSenderInfoBean info, File file) {
        Message attachmentMail = createAttachmentMail(info, file);
        try {
            Transport.send(attachmentMail);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 创建带有附件的邮件
     *
     * @return
     */
    private Message createAttachmentMail(final MailSenderInfoBean info, File file) {
        //创建邮件
        MimeMessage message = null;
        Properties pro = info.getProperties();
        try {

            Session sendMailSession = Session.getInstance(pro, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(info.getUserName(), info.getPassword());
                }
            });

            message = new MimeMessage(sendMailSession);
            // 设置邮件的基本信息
            //创建邮件发送者地址
            Address from = new InternetAddress(info.getFromAddress());
            //设置邮件消息的发送者
            message.setFrom(from);
            //创建邮件的接受者地址，并设置到邮件消息中
            Address to = new InternetAddress(info.getToAddress());
            //设置邮件消息的接受者, Message.RecipientType.TO属性表示接收者的类型为TO
            message.setRecipient(Message.RecipientType.TO, to);
            //邮件标题
            message.setSubject(info.getSubject());

            // 创建邮件正文，为了避免邮件正文中文乱码问题，需要使用CharSet=UTF-8指明字符编码
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(info.getContent(), "text/html;charset=UTF-8");

            // 创建容器描述数据关系
            MimeMultipart mp = new MimeMultipart();
            mp.addBodyPart(text);
            // 创建邮件附件
            MimeBodyPart attach = new MimeBodyPart();

            FileDataSource ds = new FileDataSource(file);
            DataHandler dh = new DataHandler(ds);
            attach.setDataHandler(dh);
            attach.setFileName(MimeUtility.encodeText(dh.getName()));
            mp.addBodyPart(attach);
            mp.setSubType("mixed");
            message.setContent(mp);
            message.saveChanges();

        } catch (Exception e) {
            Log.e("TAG", "创建带附件的邮件失败");
            e.printStackTrace();
        }
        // 返回生成的邮件
        return message;
    }
}
