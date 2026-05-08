import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock-api")
public class StreamingsController {
    @GetMapping("/netflix")
    public String getNetflixData() {
        return """
        {
            "externalID": "6f7d2e9a-4a1d-4e9b-8c7a-9b8c7d6e5f4a"",
            "description": "Netflix",
            "price": 55.90,
            "category": "MOVIE"
        }
        """;
    }
    @GetMapping("/disney")
    public String getDisneyData() {
        return """
        {
            "externalID": "7g8e3f0b-5b2e-5f0c-9d8b-0c9d8e7f6g5b"",
            "description": "Disney+",
            "price": 46.90,
            "category": "MOVIE"
        }
        """;
    }
    @GetMapping("/spotify")
    public String getSpotifyData() {
        return """
        {
            "externalID": "8h9f4g1c-6c3f-6g1d-0e9c-1d0e9f8g7h6c"",
            "description": "Spotify",
            "price": 9.99,
            "category": "MUSIC"
        }
        """;
    }
    @GetMapping("/amazonPrime")
    public String getAmazonPrimeData() {
        return """
        {
            "externalID": "9i0g5h2d-7d4g-7h2e-1f0d-2e1f0g9h8i7d"",
            "description": "Amazon Prime Video",
            "price": 19.99,
            "category": "MOVIE"
        }
        """;
    }
    @GetMapping("/xbox")
    public String getXboxData() {
        return """
        {
            "externalID": "9i0g5h2d-7d4g-7h2e-1f0d-2e1f0g9h8i7d"",
            "description": "Xbox Game Pass Ultimate",
            "price": 76.90,
            "category": "GAMING"
        }
        """;
    }
}
