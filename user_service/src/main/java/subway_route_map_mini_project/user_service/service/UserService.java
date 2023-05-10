package subway_route_map_mini_project.user_service.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import subway_route_map_mini_project.user_service.domain.UserEntity;
import subway_route_map_mini_project.user_service.dto.JoinDto;

public interface UserService extends UserDetailsService {
	void join(JoinDto joinDto);

	Boolean findUser(String email);

	void updatePassword(String email, String password);

	void updateIsAuth(String email, Boolean isAuth);

	UserEntity findByUsername(String email);
}
