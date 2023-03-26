package subway_route_map_mini_project.user_service.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;
	private String authNumber;

	public void createCode() {
		Random random = new Random();
		StringBuffer key = new StringBuffer();

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(3);

			switch (index) {
				case 0:
					key.append((char)((int)random.nextInt(26) + 97));
					break;
				case 1:
					key.append((char)((int)random.nextInt(26) + 65));
					break;
				case 2:
					key.append(random.nextInt(9));
					break;
			}
		}
		authNumber = key.toString();
	}

	public MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException {
		createCode();
		String setFrom = "kim0208yh@naver.com";
		String title = "SUBWAY-ROUTING-MAP-SERVICE 회원 가입 인증 번호";

		MimeMessage message = mailSender.createMimeMessage();
		message.addRecipients(MimeMessage.RecipientType.TO, email);

		message.setSubject(title);
		message.setFrom(setFrom);
		message.setText(setContext(authNumber, email), "utf-8", "html");
		return message;
	}

	public String sendEmail(String email) throws MessagingException, UnsupportedEncodingException {
		MimeMessage emailForm = createEmailForm(email);
		mailSender.send(emailForm);

		return authNumber;
	}

	public String setContext(String code, String email) {
		Context context = new Context();
		context.setVariable("email", email);
		context.setVariable("code", code);
		return templateEngine.process("mail", context);
	}

}
