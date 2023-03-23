package subway_route_map_mini_project.user_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;

	private Boolean isAuth;
	@Builder
	public User(String email, String password, Boolean isAuth) {
		this.email = email;
		this.password = password;
		this.isAuth = isAuth;
	}

	public void updatePassword(String password) {
		this.password = password;
	}

	public void updateIsAuth(Boolean isAuth) {
		this.isAuth = isAuth;
	}

}
