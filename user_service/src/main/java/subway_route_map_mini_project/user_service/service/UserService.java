package subway_route_map_mini_project.user_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import subway_route_map_mini_project.user_service.domain.User;
import subway_route_map_mini_project.user_service.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void join(User user) {
		userRepository.save(user);
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

	public User findByEmail(String email){
		return userRepository.findByEmail(email).orElse(null);
	}
}
