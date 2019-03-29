package com.epam.cdp.jmp.eventservice.rest;

import com.epam.cdp.jmp.eventservice.dto.Event;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class EventServiceControllerStepDefinition {

    protected RestTemplate restTemplate;

    @LocalServerPort
    protected int port;

    protected String getEventServiceHost() {
        return "http://localhost:" + port;
    }

    protected ResponseEntity responseEntity;

    public EventServiceControllerStepDefinition() {
        restTemplate = new RestTemplate();
    }

    @When("^the client calls POST \"([^\"]*)\" and Body contains Event with title: \"([^\"]*)\", place: \"([^\"]*)\", speaker: \"([^\"]*)\", eventType: \"([^\"]*)\", dateTime: \"([^\"]*)\"\\.$")
    public void createEvent(String url,
                            String title,
                            String place,
                            String speaker,
                            String eventType,
                            String dateTime) {
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("title", title);
        map.add("place", place);
        map.add("speaker", speaker);
        map.add("eventType", eventType);
        map.add("dateTime", dateTime);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        responseEntity = restTemplate.postForEntity(getEventServiceHost() + url, request, String.class);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void validateStatusAndIdAfterCreate(int arg1) throws Throwable {
        Assert.assertEquals(arg1, responseEntity.getStatusCodeValue());
    }

    @When("^the client calls GET \"([^\"]*)\"$")
    public void getById(String url) throws Throwable {
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.GET, null, Event.class);
    }

    @Then("^the client receives status code of (\\d+)\\.$")
    public void validateStatusCodeAfterGet(int statusCode) throws Throwable {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
    }

    @When("^the client calls DELETE \"([^\"]*)\"$")
    public void delete(String url) throws Throwable {
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.DELETE, null, Long.class);
    }

    @Then("^the client receives status code of (\\d+) and id of deleted event: (\\d+)$")
    public void validateStatusAfterCodeDelete(int statusCode, int id) throws Throwable {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
        Assert.assertEquals((long) id, responseEntity.getBody());
    }
}
