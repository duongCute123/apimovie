package iuh.spring.cms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import iuh.spring.cms.craw.CrawData;
import iuh.spring.cms.dto.DataCrawl;
import iuh.spring.cms.entity.PhimBo;
import iuh.spring.cms.readcrawler.ReadData;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CrawDataController {
    private final CrawData crawData;
    private final ReadData readData;

    @Operation(description = "Access swagger : http://localhost:8080/swagger-ui/index.html")
    @PostMapping("crawls")
    public ResponseEntity<String> crawlingData() throws IOException, InterruptedException {
        crawData.crawData();
        return ResponseEntity.ok().body("Hello");
    }

    @GetMapping("crawls")
    public ResponseEntity<List<PhimBo>> readData() throws IOException {
        return ResponseEntity.ok(readData.getPoducts());
    }

}
