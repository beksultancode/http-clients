package httpclients;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import httpclients.dto.CarSaveRequest;

public class OpenFeignClient {
    public static void main(String[] args) {
        CarService carService = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(CarService.class, "http://localhost:9000");

//        carService.findAll().forEach(System.out::println);

//        carService.save(new CarSaveRequest("BMW", "X5", 120000)).forEach(System.out::println);

        carService.delete(3L);
        carService.delete(4L);

        carService.findAll().forEach(System.out::println);
    }
}
