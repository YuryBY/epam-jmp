Feature: event_service_controller_queries
  Event's create get delete functionality testing

  Scenario: a client calls create event method
  client call POST /l0/v1.0/event-service
#    Given there are no events in a database
#"2019-03-25T14:27:35.007Z".
    When the client calls POST "/l0/v1.0/event-service" and Body contains Event with title: "the_title_1", place: "the_place_1", speaker: "the_speaker_1", eventType: "TECHTALK", dateTime: "2019-03-25T14:27:35".
    Then the client receives status code of 200 and response body containes eventId: 1.

  Scenario: a client calls get by id event method
  client call GET /l2/v2.0/event-service/events/{id}
    When the client calls GET "/l2/v2.0/event-service/events/1"
    Then the client receives status code of 200

  Scenario: a client calls delete event method
    client call DELETE /l2/v2.0/event-service/events/{id}
      When the client calls DELETE "/l2/v2.0/event-service/events/1"
      Then the client receives status code of 201

#  Scenario: a client calls get by id event method and get an error response code
#    client call GET /l0/v1.0/event-service/events/{id}
#      When the client calls GET "/l2/v2.0/event-service/events/1" url with id 1
#      Then the client receives status code of 200