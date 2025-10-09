package fi.tietotupsu.delena.kingmakerpf2;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ImageController {

	@GetMapping("/image")
	public ResponseEntity<byte[]> getImage() throws IOException {
        String imageUrl = "https://static.wikia.nocookie.net/pathfinderkingmaker_gamepedia_en/images/3/3f/Valerie.png/revision/latest?cb=20180927134317";

        java.net.URL url = new java.net.URL(imageUrl);
        try (java.io.InputStream in = url.openStream()) {
            byte[] bytes = in.readAllBytes();
            return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=valerie.png")
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
        }
	}

    @GetMapping("/image/url/{encodedUrl}")
    public ResponseEntity<byte[]> getImageByUrl(@PathVariable String encodedUrl) throws IOException {
            String imageUrl = java.net.URLDecoder.decode(encodedUrl, java.nio.charset.StandardCharsets.UTF_8);

            System.out.println("Fetching image from URL: " + imageUrl);

            java.net.URL url = new java.net.URL(imageUrl);
            try (java.io.InputStream in = url.openStream()) {
                    byte[] bytes = in.readAllBytes();
                    String filename = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
                    return ResponseEntity
                            .ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename)
                            .contentType(MediaType.IMAGE_PNG)
                            .body(bytes);
            }
    }

    @GetMapping("/image/byparam")
    public ResponseEntity<byte[]> getImageByParam(@RequestParam String url) throws IOException {
        String decodedUrl = java.net.URLDecoder.decode(url, java.nio.charset.StandardCharsets.UTF_8);

            java.net.URL imageUrl = new java.net.URL(decodedUrl);
            try (java.io.InputStream in = imageUrl.openStream()) {
                    byte[] bytes = in.readAllBytes();
                    String filename = url.substring(url.lastIndexOf('/') + 1);
                    return ResponseEntity
                            .ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename)
                            .contentType(MediaType.IMAGE_PNG)
                            .body(bytes);
            }
    }
}
