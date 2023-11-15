package iuh.spring.cms.readcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import iuh.spring.cms.entity.PhimBo;

@Service
public class ReadDataImlp implements ReadData {

    @Override
    public List<PhimBo> getPoducts() throws IOException {
        List<PhimBo> products = new ArrayList<>();
        File file = new File("data.txt");
        System.out.println(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            String[] product = st.split(",");
            PhimBo item = PhimBo.builder()
                    .avg_rate(product[0])
                    .episode(product[1])
                    .images(product[2])
                    .id(product[3])
                    .build();
            products.add(item);
        }

        return products;
    }

}
