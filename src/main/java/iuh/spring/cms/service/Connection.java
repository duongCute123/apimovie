package iuh.spring.cms.service;

import java.io.IOException;
import org.jsoup.nodes.Document;
public interface Connection {
    Document getConnection(String url) throws IOException;

    Document getConnection(String url, int page) throws IOException;
}
