package subway_route_map_mini_project.user_service.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import subway_route_map_mini_project.user_service.domain.MailAuth;
import subway_route_map_mini_project.user_service.repository.MailAuthRepository;

@Service
@RequiredArgsConstructor
public class MailAuthService {
	private final MailAuthRepository mailAuthRepository;

	public void deleteByEmail(String email) {
		mailAuthRepository.deleteByEmail(email);
	}

	public void save(MailAuth mailAuth) {
		mailAuthRepository.save(mailAuth);
	}
}
