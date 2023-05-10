package subway_route_map_mini_project.user_service.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import subway_route_map_mini_project.user_service.domain.UserEntity;
import subway_route_map_mini_project.user_service.dto.JoinDto;
import subway_route_map_mini_project.user_service.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;

	public void join(JoinDto joinDto) {
		UserEntity userEntity = UserEntity.builder()
			.username(joinDto.getEmail())
			.password(encoder.encode(joinDto.getPassword()))
			.role("ROLE_USER")
			.isAuth(false)
			.build();
		userRepository.save(userEntity);
	}

	public Boolean findUser(String email) {
		UserEntity userEntity = findByUsername(email);
		return userEntity == null;
	}

	@Transactional
	public void updatePassword(String email, String password) {
		UserEntity userEntity = userRepository.findByUsername(email).orElse(null);
		assert userEntity != null;
		userEntity.updatePassword(password);
	}

	@Transactional
	public void updateIsAuth(String email, Boolean isAuth) {
		UserEntity userEntity = userRepository.findByUsername(email).orElse(null);
		assert userEntity != null;
		userEntity.updateIsAuth(isAuth);
	}

	public UserEntity findByUsername(String email) {
		return userRepository.findByUsername(email).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(userEntity.getUsername(), userEntity.getPassword(), true,
			true, true, true, new ArrayList<>());
	}
}
