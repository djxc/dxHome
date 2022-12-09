package com.djxc.study.web.service;

import com.djxc.study.demo.entity.EmailEntity;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


@Service
public class EmailService {

    public static void main(String[] args) {
        EmailService email = new EmailService();
        email.mail_163("1278349695@qq.com", "成功", "尊敬的姜晓翠女士你好,感谢你来到徐州游玩,您的到来是对我们最大的肯定!");
//		email.mail_QQ("2276771363@qq.com", "情书", "亲爱的晓翠翠你好,感谢你来到徐州游玩,你的到来是我的幸福!虽然这几天让你很伤心,"
//				+ "可是你知道我是喜欢你的,也许以后我们会面临很多的难处,但这都是对我们爱情的考验.我愿意和你一起面对爱情考验,牵着你的手走进婚姻!");
    }


    /**
     * 利用QQ邮箱配置邮件发送所需信息:地址\标题\正文
     * @param strMail
     * @param strTitle
     * @param strText
     * @throws MessagingException
     */
    private void mail_QQ(String strMail, String strTitle, String strText) throws MessagingException{
        // 配置发送邮件的环境属性
        Properties props = new Properties();

        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");	// 需要请求认证
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");	//遇到最多的坑就是下面这行，不加要报“A secure connection is requiered”错。
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", "1278349695@qq.com");	 // 发件人的账号
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "ukjzpxnwwzoggedd");		//ukjzpxnwwzoggedd

        sendMail(props, strMail, strTitle, strText);

    }

    public boolean send(EmailEntity emailEntity) {
        return mail_163(emailEntity.getReceiveEmail(), emailEntity.getTitle(), emailEntity.getContent());
    }

    /**
     * 利用163邮箱配置邮件发送所需信息:地址\标题\正文
     * @param strMail	要接受邮件的邮件地址
     * @param strTitle	邮件的标题
     * @param strText	邮件的正文
     * @throws MessagingException
     */
    private boolean mail_163(String strMail, String strTitle, String strText) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");   // 需要请求认证
        props.put("mail.smtp.host", "smtp.163.com");  //设置发件人的邮箱的 SMTP 服务器地址
        props.put("mail.debug", "true");	//显示调试信息
        props.put("mail.user", "dj_jxc@163.com");  // 发件人的账号
        props.put("mail.password", "123xc321"); 	 //发件人的密码,这里使用授权码
        boolean result = false;
        try {
            sendMail(props, strMail, strTitle, strText);
            result = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 根据生成的配置信息进行邮件的构建及发送
     * 1.创建邮件配置信息
     * 2.构建授权信息
     * 3.生成邮件回话
     * 4.创建邮件
     * 5.发送邮件
     * @param propss
     * @param strMail	要接受邮件的邮件地址
     * @param strTitle	邮件的标题
     * @param strText	邮件的正文
     * @throws MessagingException
     */
    private void sendMail(Properties propss, String strMail, String strTitle, String strText) throws MessagingException{
        final Properties props = propss;
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        Session mailSession = Session.getInstance(props, authenticator);  	// 使用环境属性和授权信息，创建邮件会话

        MimeMessage message = createMessage(mailSession, props, strMail, strTitle, strText);

        Transport.send(message);  	// 发送邮件
    }

    /**
     * 创建一封只包含文本的简单邮件
     * 1.通过session对话创建一个新的邮件
     * 2.设置发送人邮箱昵称
     * 3.设置收件人的邮箱昵称
     * 4.设置邮件的主题
     * 5.设置邮箱的正文
     * 6.设置日期
     * 7.保存编辑
     * @param mailSession	对话
     * @param props		包含邮件设置的配置信息
     * @param toUser	发送给的用户邮箱
     * @param title		邮件的标题
     * @param mail_content		邮件的正文
     * @return
     * @throws MessagingException
     */
    private MimeMessage createMessage(Session mailSession, Properties props,
                                      String toUser, String title, String mail_content)
            throws MessagingException{
        // 创建邮件消息,通过session对话创建一个新的邮件
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人及其昵称
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress(toUser);
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject(title);

        // 设置邮件的内容体
        message.setContent(mail_content, "text/html;charset=UTF-8");

        message.setSentDate(new Date()); 	//设置邮件发送时间
        message.saveChanges();		// 7. 保存设置
        return message;
    }
}
