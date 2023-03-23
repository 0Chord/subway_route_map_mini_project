package subway_route_map_mini_project.user_service.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import subway_route_map_mini_project.user_service.domain.User;
import subway_route_map_mini_project.user_service.dto.JoinDto;
import subway_route_map_mini_project.user_service.service.MailAuthService;
import subway_route_map_mini_project.user_service.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignupController {
	private final UserService userService;
	private final MailAuthService mailAuthService;
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

	@GetMapping("/test")
	public void test(){
		System.out.println("testtesttesttest");
	}

}
