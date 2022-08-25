package httpclients;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class HttpClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpClientsApplication.class, args);
    }
}
