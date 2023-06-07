package miniproject.subway_route_map.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import miniproject.subway_route_map.dto.Station;

@RestController
@RequiredArgsConstructor
public class SubwayController {

	private final RestTemplate restTemplate;
	private final HttpHeaders httpHeaders;

	@PostMapping("/subway-routing")
	public String routing(@Validated @RequestBody Station station) {
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("station = " + station);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("start_station", station.getStartStation());
		body.add("end_station", station.getEndStation());
		HttpEntity<MultiValueMap<String, String>> requestMessage = new HttpEntity<>(body, httpHeaders);
		ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8000/routing-service/route-map",
			requestMessage, String.class);
		String entityBody = entity.getBody();
		System.out.println("entityBody = " + entityBody);
		return entityBody;
	}

}
