package com.xieke.test.demo;
import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件发送控制器
 * 
 * @author 邪客
 * 
 */
@RestController
public class MailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.sender}")
	private String sender;// 发送者

    @Value("${mail.fromMail.receiver}")
	private String receiver;// 接受者

    @Autowired
    private JavaMailSender javaMailSender;

	/**
	 * @Description http://localhost:8888/sendMail
	 * @method 发送文本邮件
	 * @return
	 */
    @RequestMapping("/sendMail")
    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
		message.setSubject("邪客发送文本邮件测试");// 标题
		message.setText("世界，你好！--->文本邮件");// 内容
        try {
            javaMailSender.send(message);
			logger.info("文本邮件发送成功！");
			return "success";
        } catch (Exception e) {
			logger.error("文本邮件发送异常！", e);
			return "failure";
        }
    }

	/**
	 * @Description http://localhost:8888/sendHtmlMail
	 * @method 发送html邮件
	 * @return
	 */
    @RequestMapping("/sendHtmlMail")
    public String testHtmlMail() {
		String content = "<html><body><h3>hello world ! --->Html邮件</h3></body></html>";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
			helper.setSubject("邪客发送Html邮件测试");
            helper.setText(content, true);

            javaMailSender.send(message);
			logger.info("Html邮件发送成功！");
			return "success";
        } catch (MessagingException e) {
			logger.error("Html邮件发送异常！", e);
			return "failure";
        }
    }

	/**
	 * @Description http://localhost:8888/sendFilesMail
	 * @method 发送附件邮件
	 * @return
	 */
    @RequestMapping("/sendFilesMail")
    public String sendFilesMail() {
		String filePath = "F:\\select_from_user.sql";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
			helper.setSubject("邪客发送附件邮件测试");
			helper.setText("一封带附件的邮件", true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            javaMailSender.send(message);
			logger.info("附件邮件发送成功！");
			return "success";
        } catch (MessagingException e) {
			logger.error("附件邮件发送异常！", e);
			return "failure";
        }
    }

	/**
	 * @Description http://localhost:8888/sendInlineResourceMail
	 * @method 发送图片邮件
	 * @return
	 */
    @RequestMapping("/sendInlineResourceMail")
    public String sendInlineResourceMail() {
		String id = "xieke90";
		// cid:内嵌资源
		String content = "<html><body>带有图片的邮件：<img src=\'cid:" + id + "\'></body></html>";
		String imgPath = "F:\\spring-cloud.png";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
			helper.setSubject("邪客发送图片邮件测试");
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(imgPath));
			helper.addInline(id, res);

            javaMailSender.send(message);
			logger.info("图片邮件发送成功！");
			return "success";
        } catch (MessagingException e) {
			logger.error("图片邮件发送异常！", e);
			return "failure";
        }

    }

}