package iuh.spring.cms.craw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import iuh.spring.cms.entity.PhimBo;
import iuh.spring.cms.service.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrawDataService implements CrawData {

    private Connection connection;

    // @Value("${page.url}")
    private String urlPage = "https://api.vieon.vn/backend/cm/v5/slug/ribbon?page/";
    // @Value("${page.url.root}")
    private String urlRoot = "https://vieon.vn/phim-hay/r/nghien-phim-trung-phim-bo";

    // @Value("${page.total.number}")
    private String elementCssPage = "10";

    @Override
    public Integer getTotalElementPages() throws IOException {
        System.out.println(this.connection);
        Elements elements = connection.getConnection(urlRoot).select(elementCssPage);

        return elements.stream().map(CrawDataService::convertToNumber).max(Comparator.comparing(Integer::valueOf))
                .get();
    }

    private static Integer convertToNumber(Element element) {
        try {
            return Integer.parseInt(Jsoup.parse(String.valueOf(element)).body().text());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void crawData() throws IOException, InterruptedException {
        Integer totalPages = getTotalElementPages();
        List<PhimBo> pokemonProducts = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int index = 1; index <= totalPages; index++) {
            executorService.execute(ThreadCraw.builder().pokemonProducts(pokemonProducts).connection(connection)
                    .urlPage(urlPage).index(index).build());
        }

        executorService.shutdown();
        executorService.awaitTermination(300, TimeUnit.SECONDS);
    }
}
