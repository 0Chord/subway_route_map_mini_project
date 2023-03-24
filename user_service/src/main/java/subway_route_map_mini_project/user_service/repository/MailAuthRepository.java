package subway_route_map_mini_project.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import subway_route_map_mini_project.user_service.domain.MailAuth;

@Repository
public interface MailAuthRepository extends JpaRepository<MailAuth, String> {
	@Transactional
	void deleteByEmail(String email);

	Optional<MailAuth> findByEmail(String email);
}
