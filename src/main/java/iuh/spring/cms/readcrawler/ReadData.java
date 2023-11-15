package iuh.spring.cms.readcrawler;

import java.io.IOException;
import java.util.List;

import iuh.spring.cms.entity.PhimBo;

public interface ReadData {
    public List<PhimBo> getPoducts() throws IOException;
}
