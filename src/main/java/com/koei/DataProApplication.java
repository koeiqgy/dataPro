package com.koei;

import com.koei.test.http.HttpClientUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication
@ServletComponentScan("com.utils")
public class DataProApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(DataProApplication.class, args);
		//HttpClientUtils.class.newInstance().post2();
	}
}
