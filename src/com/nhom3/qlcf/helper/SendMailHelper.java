/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Le Minh Hung - PS08234
 */
public class SendMailHelper {

    public static String StrHtml(String input) {
        return "<html><h1 style=\"color: red; size: 20px; display: inline; text-align: center\">" + input + "</h1></html>";
    }

    public static void sendMail(String mail, String code) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", true);
            p.put("mail.smtp.starttls.enable", true);
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accName = "tridbps08177@fpt.edu.vn";
            String pass = "peverbmxktrbtemc";
            Session s = Session.getInstance(p, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accName, pass);
                }
            });

            String from = accName;
            String to = mail;
            String subject = "Quên Mật Khẩu Đăng Nhập!";
            String body =StrHtml(code) + " là mã xác nhận của bạn, mã xác nhận chỉ hiệu lực trong 30 phút!";
            MimeMessage msg = new MimeMessage(s);
            Multipart multi = new MimeMultipart();
            MimeBodyPart msgBody = new MimeBodyPart();
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msgBody.setContent(body, "text/html; charset=utf-8");
            multi.addBodyPart(msgBody);
            msg.setContent(multi);
            Transport.send(msg);
            //JOptionPane.showMessageDialog(null, "Mail was sent successfully.");
        } catch (Exception e) {
            Logger.getLogger(SendMailHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
