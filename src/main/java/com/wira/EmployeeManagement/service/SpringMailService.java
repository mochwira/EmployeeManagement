package com.wira.EmployeeManagement.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class SpringMailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    public void sendMail(Map<String, Object> model, String sbj, String to) {
        MimeMessage message = sender.createMimeMessage();
        System.out.println("sendMail running");

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template t = config.getTemplate("mail.html");

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setTo(to);
            helper.setSubject(sbj);
            helper.setFrom("noreply@acesanjay.yeah");
            helper.setText(html, true);

            sender.send(message);

        } catch (MessagingException | IOException | TemplateException e) {
            System.out.println("pengiriman gagal "+e);
        }
    }
}
