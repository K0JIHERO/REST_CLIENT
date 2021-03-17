package com.zaur.spring.rest;

import java.util.Arrays;
import com.zaur.spring.rest.entity.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class SpringRestClient {

    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://91.241.64.178:7081/api/users/3";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);

        ResponseEntity < String > result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);
        String cookie = result.getHeaders().getFirst(HttpHeaders.SET_COOKIE);


        User user = new User(3L, "James", "Brown", (byte) 22);
        User user2 = new User(3L, "Thomas", "Shelby", (byte) 22);
        HttpHeaders headers2 = new HttpHeaders();
        headers2.set("Cookie", cookie);
        System.out.println(cookie);
        HttpEntity<User> entity2 = new HttpEntity<User>(user, headers2);
        ResponseEntity result2 = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.POST, entity2, String.class);
        System.out.println(result2.getBody());

        HttpEntity<User> entity3 = new HttpEntity<User>(user2, headers2);
        ResponseEntity result3 = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.PUT, entity3, String.class);
        System.out.println(result3.getBody());

        ResponseEntity result4 = restTemplate.exchange(DELETE_EMPLOYEE_ENDPOINT_URL, HttpMethod.DELETE, entity3, String.class);
        System.out.println(result4.getBody());
        String total = (String) result2.getBody() + result3.getBody() + result4.getBody();
        System.out.println(total);
    }
}