package iuh.spring.cms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class DataCrawl {
	private boolean isSuccess;
	private int status;
	private String message;
}
