package subway_route_map_mini_project.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import subway_route_map_mini_project.user_service.domain.MailAuth;

@Repository
public interface MailAuthRepository extends JpaRepository<MailAuth, String> {

	void deleteByEmail(String email);
}
