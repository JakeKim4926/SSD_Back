package com.seongseobdang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class SeongSeobDangSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeongSeobDangSpringBootApplication.class, args);
	}
}
