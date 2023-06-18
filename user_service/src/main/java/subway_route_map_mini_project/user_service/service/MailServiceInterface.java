package subway_route_map_mini_project.user_service.service;

import javax.mail.internet.MimeMessage;

public interface MailServiceInterface {

	void createCode();

	MimeMessage createEmailForm(String email);

	String sendEmail(String email);

	String setContext(String code, String email);

}
