package subway_route_map_mini_project.user_service.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import subway_route_map_mini_project.user_service.domain.User;
import subway_route_map_mini_project.user_service.dto.JoinDto;
import subway_route_map_mini_project.user_service.dto.LoginDto;
import subway_route_map_mini_project.user_service.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;

	public void join(JoinDto joinDto) {
		User user = User.builder().username(joinDto.getEmail()).password(encoder.encode(joinDto.getPassword()))
			.role("ROLE_USER").isAuth(false).build();
		userRepository.save(user);
	}

	public Boolean findUser(String email) {
		User user = findByEmail(email);
		return user == null;
	}

	public String login(LoginDto loginDto) {
		String email = loginDto.getEmail();
		String password = loginDto.getPassword();
		User user = findByEmail(email);
		if (user == null) {
			return "NoExistsUser";
		} else if (!encoder.matches(password, user.getPassword())) {
			return "WrongPassword";
		} else if (!user.getIsAuth()) {
			return "NoEmailAuth";
		}
		return "SUCCESS";
	}

	@Transactional
	public void updatePassword(String email, String password) {
		User user = userRepository.findByEmail(email).orElse(null);
		assert user != null;
		user.updatePassword(password);
	}

	@Transactional
	public void updateIsAuth(String email, Boolean isAuth) {
		User user = userRepository.findByEmail(email).orElse(null);
		assert user != null;
		user.updateIsAuth(isAuth);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
}
