package subway_route_map_mini_project.user_service.controller;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

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
import subway_route_map_mini_project.user_service.dto.MailAuthDto;
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

	@PostMapping("/join")
	public String signup(@Validated JoinDto joinDto) {
		if (!userService.findUser(joinDto.getEmail())) {
			return "AlreadyExistsUser";
		}
		userService.join(joinDto);
		return "SuccessJoinUser";
	}

	@PostMapping("/post-auth-mail")
	public String postAuthMail(EmailDto emailDto) throws MessagingException, UnsupportedEncodingException {
		mailAuthService.deleteByEmail(emailDto.getEmail());
		String code = mailService.sendEmail(emailDto.getEmail());
		mailAuthService.save(emailDto, code);
		return "SUCCESS";
	}

	@PostMapping("/confirm-mail")
	public Boolean confirm(@Validated MailAuthDto mailAuthDto) {
		return mailAuthService.confirmMailAuth(mailAuthDto);
	}

}
