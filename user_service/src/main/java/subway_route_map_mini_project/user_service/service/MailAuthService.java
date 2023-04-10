package subway_route_map_mini_project.user_service.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import subway_route_map_mini_project.user_service.domain.MailAuth;
import subway_route_map_mini_project.user_service.dto.EmailDto;
import subway_route_map_mini_project.user_service.dto.MailAuthDto;
import subway_route_map_mini_project.user_service.repository.MailAuthRepository;

@Service
@RequiredArgsConstructor
public class MailAuthService {
	private final MailAuthRepository mailAuthRepository;
	private final UserService userService;

	public void deleteByEmail(String email) {
		mailAuthRepository.deleteByEmail(email);
	}

	public void save(EmailDto emailDto, String code) {
		MailAuth mailAuth = MailAuth.builder()
			.email(emailDto.getEmail())
			.authCode(code)
			.build();
		mailAuthRepository.save(mailAuth);
	}

	public Boolean confirmMailAuth(MailAuthDto mailAuthDto) {
		MailAuth mailAuth = findByEmail(mailAuthDto.getEmail());
		if (mailAuth == null) {
			return false;
		} else if (Objects.equals(mailAuth.getAuthCode(), mailAuthDto.getAuthCode())) {
			userService.updateIsAuth(mailAuth.getEmail(), true);
			deleteByEmail(mailAuthDto.getEmail());
			return true;
		}
		return false;
	}

	public MailAuth findByEmail(String email) {
		return mailAuthRepository.findByEmail(email).orElse(null);
	}
}
