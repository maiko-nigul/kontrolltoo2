package ee.kontrolltoo.backend.controller;

import ee.kontrolltoo.backend.entity.DTO.ExternalAPIDTO;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/bibles")
@CrossOrigin(origins = "*")
public class ExternalAPIController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ExternalAPIDTO[] getBooks() {
        String url = "https://marineregions.org/rest/getGazetteerTypes.json";
        return restTemplate.exchange(url, HttpMethod.GET, null, ExternalAPIDTO[].class).getBody();
    }
}