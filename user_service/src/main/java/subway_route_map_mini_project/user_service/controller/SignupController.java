package subway_route_map_mini_project.user_service.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import subway_route_map_mini_project.user_service.domain.MailAuth;
import subway_route_map_mini_project.user_service.domain.User;
import subway_route_map_mini_project.user_service.dto.EmailDto;
import subway_route_map_mini_project.user_service.dto.JoinDto;
import subway_route_map_mini_project.user_service.service.MailAuthService;
import subway_route_map_mini_project.user_service.service.MailService;
import subway_route_map_mini_project.user_service.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/signup")
public class SignupController {
	private final UserService userService;
	private final MailAuthService mailAuthService;
	private final MailService mailService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/join")
	public String signup(@Validated JoinDto joinDto) {
		System.out.println("joinDto = " + joinDto);
		User user = userService.findByEmail(joinDto.getEmail());
		if (user != null) {
			return "AlreadyExistsUser";
		}
		String encodingPassword = bCryptPasswordEncoder.encode(joinDto.getPassword());
		User joinUser = User.builder().email(joinDto.getEmail()).password(encodingPassword).isAuth(false).build();
		System.out.println("joinUser = " + joinUser);
		userService.join(joinUser);
		return "SuccessJoinUser";
	}

	@PostMapping("/post-auth-mail")
	public String postAuthMail(EmailDto emailDto) throws MessagingException, UnsupportedEncodingException {
		System.out.println("emailDto = " + emailDto);
		String code = mailService.sendEmail(emailDto.getEmail());
		MailAuth mailAuth = MailAuth.builder().email(emailDto.getEmail()).authCode(code).build();
		mailAuthService.save(mailAuth);
		return "SUCCESS";
	}

}
