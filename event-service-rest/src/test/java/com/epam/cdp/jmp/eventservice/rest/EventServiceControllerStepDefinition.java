package com.epam.cdp.jmp.eventservice.rest;

import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.EventType;
import com.epam.cdp.jmp.eventservice.rest.beans.CreateEventRequest;
import com.epam.cdp.jmp.eventservice.rest.utils.LocalDateTimeToStringConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class EventServiceControllerStepDefinition {

    protected RestTemplate restTemplate;

    @LocalServerPort
    protected int port;

//    private List<Event> events = new ArrayList<Event>();

    protected String getEventServiceHost() {
        return "http://localhost:" + port;
    }

    protected ResponseEntity<Event> responseEntity;

    public EventServiceControllerStepDefinition() {
        restTemplate = new RestTemplate();
    }

//    @Given("^there are no events in a database$")
//    public void there_are_no_events_in_a_database() throws Throwable {
//        Iterable<Event> events = eventRepository.findAll();
//        System.out.println("is there any events in repo: " + events.iterator().hasNext());
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @When("^the client calls POST \"([^\"]*)\" and Body contains Event with title: \"([^\"]*)\", place: \"([^\"]*)\", speaker: \"([^\"]*)\", eventType: \"([^\"]*)\", dateTime: \"([^\"]*)\"\\.$")
    public void createEvent(String url,
                            String title,
                            String place,
                            String speaker,
                            EventType eventType,
                            @Transform(LocalDateTimeToStringConverter.class) LocalDateTime dateTime) {
        System.out.println(url);
        Event event = new Event(title, place, speaker, eventType, dateTime);
//        events.add(event);
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setEvent(event);
        HttpEntity<CreateEventRequest> request = new HttpEntity<CreateEventRequest>(createEventRequest);
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.POST, request, Event.class);
    }

    @Then("^the client receives status code of (\\d+) and response body containes eventId: (\\d+)\\.$")
    public void validateStatusAndIdAfterCreate(int statusCode, int id) throws Throwable {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
        Assert.assertEquals(id, responseEntity.getBody().getEventId());
    }

    @When("^the client calls GET \"([^\"]*)\" url with id (\\d+)$")
    public void getById(String url) throws Throwable {
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.GET, null, Event.class);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void validateStatusCodeAfterGet(int statusCode) throws Throwable {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
    }

//    @When("^the client calls DELETE \"([^\"]*)\"$")
//    public void delete(String url) throws Throwable {
//        System.out.println("!!!!!!!!!!!!");
//        System.out.println(url);
//        if (true)throw new Error("AHTUNG: "+url);
//        HttpEntity<Integer> request = new HttpEntity<Integer>(1);
//        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.DELETE, request, Event.class);
//    }

//    @Then("^the client receives status code of (\\d+)$")
//    public void validateStatusAfterCodeDelete(int statusCode) throws Throwable {
//        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
//    }

//    @When("^the client calls POST \"([^\"]*)\" and Body contains Event with title: \"([^\"]*)\", place: \"([^\"]*)\", speaker: \"([^\"]*)\", eventType: \"([^\"]*)\", dateTime: \"([^\"]*)\"\\.$")
//    public void getEventById(String url, int id) {
//        CreateEventRequest createEventRequest = new CreateEventRequest();
//        HttpEntity<CreateEventRequest> request = new HttpEntity<CreateEventRequest>(createEventRequest);
//        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.GET, request, Event.class);
//    }
}
