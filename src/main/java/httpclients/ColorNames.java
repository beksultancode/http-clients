package httpclients;

import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class ColorNames {

    private static final RestTemplate restTemplate = new RestTemplate();

    record ColorResponse(String hexCode, String name) {}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("write color hex: ");
        String colorHex = scanner.nextLine();

        ColorResponse colorResponse = restTemplate.getForObject(
                "https://colornames.org/search/json/?hex=" + colorHex,
                ColorResponse.class
        );

        System.out.println("\u001B[36m colorResponse.name = " + colorResponse.name + "\u001B[0m");
    }
}
