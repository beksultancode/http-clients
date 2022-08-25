package httpclients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Map;

@Component
public class RestTemplateExample {

    private final RestTemplate restTemplate;

    public RestTemplateExample() {
        this.restTemplate = new RestTemplate();
    }

    record CarResponse(Long id, String brand, String name, String price) {}
    record AuthRequest(String email, String password) {}

    record AuthResponse(String authority, String token) {}
    record GetCourseResponse(Long id, String courseName, String imageLink, String creationAt, String description) {}

    @PostConstruct
    void init() {
//        CarResponse[] responses = restTemplate.getForObject("http://localhost:9000/api/cars", CarResponse[].class);
//
//        System.out.println("\u001B[34m");
//
//        for (CarResponse response : responses) {
//            System.out.println(response.toString());
//        }
//        System.out.println("\u001B[0m");

//        restTemplate.delete("http://localhost:9000/api/cars/delete/1");

        AuthResponse authResponse = restTemplate.postForObject(
                "http://peaksoftlms-backend.eu-central-1.elasticbeanstalk.com/api/auth/authenticate",
                new AuthRequest("admin@peaksoft.us", "adminov"),
                AuthResponse.class
        );

//        System.out.println("authResponse = " + authResponse);
//
//        GetCourseResponse[] courses = restTemplate.getForObject(
//                "http://peaksoftlms-backend.eu-central-1.elasticbeanstalk.com/api/courses",
//                GetCourseResponse[].class,
//                Map.of(
//                        "Authorization", "Bearer " + authResponse.token
//                )
//        );
//
//        for (GetCourseResponse course : courses) {
//            System.out.println("course = " + course);
//        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authResponse.token);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        GetCourseResponse[] courses = restTemplate.exchange(
                "http://peaksoftlms-backend.eu-central-1.elasticbeanstalk.com/api/courses",
                HttpMethod.GET,
                httpEntity,
                GetCourseResponse[].class
        ).getBody();

        for (GetCourseResponse course : courses) {
            System.out.println("course = " + course);
        }

    }
}
