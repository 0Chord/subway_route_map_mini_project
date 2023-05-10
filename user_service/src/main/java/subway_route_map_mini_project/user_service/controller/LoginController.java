// package subway_route_map_mini_project.user_service.controller;
//
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import subway_route_map_mini_project.user_service.domain.User;
// import subway_route_map_mini_project.user_service.dto.LoginDto;
// import subway_route_map_mini_project.user_service.service.UserService;
//
// @Slf4j
// @RestController
// @RequiredArgsConstructor
// @RequestMapping("/api")
// public class LoginController {
//
// 	private final UserService userService;
//
// 	@PostMapping("/login")
// 	public String login(@Validated LoginDto loginDto) {
// 		return userService.login(loginDto);
// 	}
// }
