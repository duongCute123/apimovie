package iuh.spring.cms.craw;

import java.io.IOException;

public interface CrawData {
    Integer getTotalElementPages() throws IOException;

    void crawData() throws IOException, InterruptedException;

}