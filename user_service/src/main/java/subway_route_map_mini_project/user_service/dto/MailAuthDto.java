package subway_route_map_mini_project.user_service.dto;

import lombok.Data;

@Data
public class MailAuthDto {
	private String email;
	private String authCode;
}
