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
	private String username;
	private String password;

	private Boolean isAuth;
	private String role;

	@Builder
	public User(String username, String password, Boolean isAuth, String role) {
		this.username = username;
		this.password = password;
		this.isAuth = isAuth;
		this.role = role;
	}



	public void updatePassword(String password) {
		this.password = password;
	}

	public void updateIsAuth(Boolean isAuth) {
		this.isAuth = isAuth;
	}

}
