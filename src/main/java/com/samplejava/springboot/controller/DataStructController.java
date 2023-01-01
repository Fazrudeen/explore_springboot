package com.samplejava.springboot.controller;

import com.samplejava.springboot.model.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sample_data_sturct/v1")
public class DataStructController {

	@GetMapping(path = "/all_sorting")
	public void allSorting() {
		String sentence  = "The array of tall buildings in New York City seemed to reach the sky and go on for miles";
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(sentence.split(" ")));
		//Collection sort
		Collections.sort(arrayList);
		Collections.reverse(arrayList);
		// List Sort
		arrayList.sort(Comparator.naturalOrder());
		arrayList.sort(Comparator.reverseOrder());
		// Stream Sort
		arrayList.stream().sorted().collect(Collectors.toList());

		ArrayList<UserRequest> userRequests = new ArrayList<>();
		userRequests.add(new UserRequest("111", "fazru"));
		userRequests.add(new UserRequest("222", "ashalina"));
		userRequests.sort(Comparator.comparing(UserRequest::getUserName));
		userRequests.sort(Comparator.comparing(UserRequest::getUserName).thenComparing(UserRequest::getUserId));
		userRequests.stream().sorted(Comparator.comparing(UserRequest::getUserName)).collect(Collectors.toList());
		userRequests.stream().sorted(Comparator.comparing(x -> x.getUserName())).collect(Collectors.toList());
		userRequests.stream().sorted(Comparator.comparing(UserRequest::getUserName).reversed()).collect(Collectors.toList());
	}
}
