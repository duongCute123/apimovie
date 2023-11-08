package iuh.spring.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class MovieConTroller {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/phim-sap-chieu/{currentPage}")
	public ResponseEntity<String> searchMovie(@PathVariable String currentPage) {
		String url = "https://ophim9.cc/_next/data/s4OlXy8jONoHVWAT5vg7b/danh-sach/phim-sap-chieu.json?page="
				+ currentPage + "&slug=phim-sap-chieu";
		ResponseEntity<String> responsive = restTemplate.getForEntity(url, String.class);
		return responsive;
	}

	@GetMapping("/tvshow/{currentPage}")
	public ResponseEntity<String> getTvShow(@PathVariable String currentPage) {
		String url = "https://ophim9.cc/_next/data/s4OlXy8jONoHVWAT5vg7b/danh-sach/tv-shows.json?page=" + currentPage
				+ "&slug=tv-shows";
		ResponseEntity<String> responsive = restTemplate.getForEntity(url, String.class);

		return responsive;
	}

	@GetMapping("/getmovie-countries/{countries}/{currentPage}")
	public ResponseEntity<String> getMovieCountries(@PathVariable String countries, @PathVariable String currentPage) {
		String url = "https://ophim9.cc/_next/data/s4OlXy8jONoHVWAT5vg7b/quoc-gia/" + countries + ".json?page="
				+ currentPage + "&slug=" + countries;
		ResponseEntity<String> responsive = restTemplate.getForEntity(url, String.class);
		return responsive;
	}

	@GetMapping("/movie-genres/{genres}/{currentPage}")
	public ResponseEntity<String> getMoviegenres(@PathVariable String genres, @PathVariable String currentPage) {
		String url = "https://ophim9.cc/_next/data/s4OlXy8jONoHVWAT5vg7b/danh-sach/" + genres + ".json?page="
				+ currentPage + "&slug=" + genres;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response;
	}

	@GetMapping("/tim-kiem/{keywork}")
	public ResponseEntity<String> timKiem(@PathVariable String keywork) {
		String url = "https://ophim9.cc/_next/data/s4OlXy8jONoHVWAT5vg7b/tim-kiem.json?keyword=" + keywork;
		ResponseEntity<String> resposive = restTemplate.getForEntity(url, String.class);
		return resposive;
	}

	@GetMapping("/loai-phim/")
	public ResponseEntity<String> getLoaiMovie() {
		return null;
	}
}