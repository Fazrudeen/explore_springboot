package com.samplejava.springboot.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sample_test_prg/v1")
public class BasicController {

	private static final Logger logger = LogManager.getLogger(BasicController.class);

	@GetMapping(path = "/fizzbuzz/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLocationById(@PathVariable("num") Integer number) {
		if (number % 15 == 0) {
			return "fizzbuzz";
		} else if (number % 5 == 0) {
			return "buzz";
		}
		else if (number % 3 == 0) {
			return "fizz";
		}
		return String.valueOf(number);
	}

	@GetMapping(path = "/fibonici", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> fibonici() throws Exception {
		int a=0, b=1, c=0;
		List<Integer> outputList = new ArrayList<>();
		outputList.add(a);
		outputList.add(b);
		for (int i = 0; i<10; i++) {
			c= a+b;
			a=b;
			b=c;
			outputList.add(c);
		}
		return outputList;
	}

	@GetMapping(path = "/palindrome/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean palindrome(@PathVariable("name") String name) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = name.length() - 1; i >= 0; i--) {
			stringBuilder.append(name.charAt(i));
		}
		if(stringBuilder.toString().equals(name)) {
			return true;
		}
		return false;
	}

	@GetMapping(path = "/factorial", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer factorial() throws Exception {
		Integer input = 5;
		Integer fact = 1;
		for (int i = 2; i <= input; i++) {
			fact = fact * i;
		}
		return fact;
	}

	@GetMapping(path = "/prime_num/{num}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean primenumber(@PathVariable("num") Integer number) throws Exception {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	@GetMapping(path = "/2Darray")
	public void dArray() {
		int[][] a = {
				{1, 2, 3},
				{4, 5, 6, 9},
				{7},
		};
		for (int[] eachRow : a) {
			Long  countRow = Arrays.stream(eachRow).boxed()
					.collect(Collectors.counting());
			Integer  sumRow = Arrays.stream(eachRow).boxed()
					.collect(Collectors.summingInt(Integer::intValue));
			logger.info("system" + countRow);
			logger.info("system" + sumRow);
		}
	}
}
