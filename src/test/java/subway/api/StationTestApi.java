package subway.api;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class StationTestApi {

	public ExtractableResponse<Response> createStation(String stationName) {
		Map<String, String> params = new HashMap<>();
		params.put("name", stationName);

		ExtractableResponse<Response> response = RestAssured
			.given().log().all()
			.body(params)
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.when().post("/stations")
			.then().log().all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
		return response;
	}

	public ExtractableResponse<Response> showStation() {
		ExtractableResponse<Response> response = RestAssured
			.given().log().all()
			.when().get("/stations")
			.then().log().all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		return response;
	}

	public ExtractableResponse<Response> deleteStationById(Long id) {
		ExtractableResponse<Response> response = RestAssured
			.given().log().all()
			.when().delete("/stations/{id}", id)
			.then().log().all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
		return response;
	}
}
