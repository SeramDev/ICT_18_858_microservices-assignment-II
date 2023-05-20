package ds.ict18858.seram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SeramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeramApplication.class, args);
	}

}
