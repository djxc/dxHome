package com.djxc.study.serverconsumer;

import com.djxc.study.serverapi.FeignApi.DemoFeignFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackageClasses = DemoFeignFacade.class)
public class ServerconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerconsumerApplication.class, args);
	}

}
