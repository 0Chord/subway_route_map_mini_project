package subway_route_map_mini_project.user_service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class LoginDto {
	@NotNull(message = "Email can not be null")
	@Size(min = 2, message = "Email not be less than two characters")
	@Email
	private String email;

	@NotNull(message = "Password can not be null")
	@Size(min = 8, message = "Password must be equals or grater than 8 characters")
	private String password;
}
