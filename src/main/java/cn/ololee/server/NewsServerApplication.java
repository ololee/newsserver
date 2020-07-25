package cn.ololee.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ololee.server.mybaits")
public class NewsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsServerApplication.class, args);
	}

}
