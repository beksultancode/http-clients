package httpclients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import httpclients.dto.CarDto;
import httpclients.dto.CarSaveRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarService {

    @RequestLine("GET /api/cars")
    List<CarDto> findAll();

    @RequestLine("GET /api/cars/{carId}")
    CarDto findById(@Param("carId") Long carId);

    @RequestLine("POST /api/cars/save")
    @Headers("Content-Type: application/json")
    List<CarDto> save(CarSaveRequest carSaveRequest);

    @RequestLine("PUT /api/cars/update/{carId}")
    @Headers("Content-Type: application/json")
    List<CarDto> update(@Param("carId") Long carId,
                        CarSaveRequest carSaveRequest);

    @RequestLine("DELETE /api/cars/delete/{carId}")
    void delete(@Param("carId") Long carId);
}
