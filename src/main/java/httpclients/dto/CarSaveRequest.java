package httpclients.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarSaveRequest {

    private String brand;

    private String name;

    private int price;
}
