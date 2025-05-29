package plansource.utilities;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EnrollmentAPI {
	
	public static Response enrollEmployee(String sessionId, String referer, Map<String, Object> jsonBody)
	{
		String url = "https://partner-dev-benefits.plansource.com/v1/self_service/coverages";
		
		Map<String, String> cookies = new HashMap<>();
		cookies.put("_session_id", sessionId);
		
		Map<String, String> headers = new HashMap<>();
        headers.put("Referer", referer);
        
        return RestAssured
           .given()
           .cookies(cookies)
           .headers(headers)
           .contentType("application/json")
           .body(jsonBody)
           .put(url);

	}

}
