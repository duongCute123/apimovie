package iuh.spring.cms.craw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import iuh.spring.cms.entity.PhimBo;
import iuh.spring.cms.service.Connection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class ThreadCraw implements Runnable {
    private List<PhimBo> pokemonProducts;
    private Connection connection;
    private String urlPage;
    private int index;

    @Override
    public void run() {
        Document connectionPage = null;
		try {
			connectionPage = connection.getConnection(this.urlPage, this.index);
			Elements products = connectionPage.select("div.section__body");
            System.out.println(products);
			products.stream().forEach(product -> {
				PhimBo pokemonProduct = PhimBo.builder()
                .avg_rate(product.selectFirst("a").attr("href"))
				.images(product.selectFirst("img").attr("src"))
                .episode(product.selectFirst("h2").text())
				.id(product.selectFirst("span").text())
                .build();
				this.pokemonProducts.add(pokemonProduct);
            });

            writeFile(pokemonProducts);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void writeFile(List<PhimBo> pokemonProducts) {
        File path = new File("data.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("");

            Iterator<PhimBo> iterator = pokemonProducts.iterator();

            while (iterator.hasNext()) {
                try {
                    PhimBo item = iterator.next();
                    bufferedWriter.write(
                            item.getId() + "," + item.getTitle() + "," + item.getShort_description() + ","
                                    + item.getImages()
                                    + "," + item.getAvg_rate() + "," + item.getEpisode() + "," + item.getSlug()
                                    + "," + item.getLink_play() + "," + item.getRelated_season() + ","
                                    + item.getTags_genre_txt()
                                    + "," + item.getPeople_str());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
