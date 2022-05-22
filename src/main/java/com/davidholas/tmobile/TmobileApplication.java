package com.davidholas.tmobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmobileApplication.class, args);
		MarkTheOrder mTK = new MarkTheOrder();
		String result = mTK.markTheOrder("C:\\Users\\David\\Desktop\\tmobile\\tmobile\\src\\main\\resources\\input.txt");
		System.out.println(result);
	}
}
