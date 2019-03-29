Feature: event_service_controller_queries
  Event's create get delete functionality testing

  Scenario: a client calls create event method
  client call POST /l2/v2.0/event-service/events/create
    When the client calls POST "/l2/v2.0/event-service/events/create" and Body contains Event with title: "the_title_1", place: "the_place_1", speaker: "the_speaker_1", eventType: "TECHTALK", dateTime: "2019-03-25T14:27:35".
    Then the client receives status code of 200.

  Scenario: a client calls get by id event method
  client makes call of GET /l2/v2.0/event-service/events/{id}
    When the client calls GET "/l2/v2.0/event-service/events/1"
    Then the client receives status code of 200

  Scenario: a client calls delete event method
  client makes call of DELETE /l2/v2.0/event-service/events/{id}
    When the client calls DELETE "/l2/v2.0/event-service/events/1"
    Then the client receives status code of 200 and id of deleted event: 1

  Scenario: a client calls get by id event method and get an error response code
  client call GET /l0/v1.0/event-service/events/{id}
    When the client calls GET "/l2/v2.0/event-service/events/1"
    Then the client receives status code of 204