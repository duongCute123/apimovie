package iuh.spring.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import iuh.spring.cms.craw.CrawDataService;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
public class ProxyServerApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProxyServerApiApplication.class, args);
		CrawDataService crawDataService = context.getBean(CrawDataService.class);
		
	}

}
