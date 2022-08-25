package httpclients.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {

    private Long id;

    private String brand;

    private String name;

    private String price;
}
