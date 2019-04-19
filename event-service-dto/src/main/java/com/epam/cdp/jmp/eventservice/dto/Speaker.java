package com.epam.cdp.jmp.eventservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigInteger;
import java.util.Objects;

//import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class Speaker {
    //    BigInteger id;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long speakerId;
    private BigInteger id;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private Email email;

//    @JsonCreator
//    public Speaker() {
//    }

    @JsonCreator
    public Speaker(String firstName, String lastName, Email email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


//    }@JsonCreator
//    public Speaker(@JsonProperty("firstName") String firstName,
//                   @JsonProperty("lastName") String lastName,
//                   @JsonProperty("email") Email email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return Objects.equals(id, speaker.id) &&
                Objects.equals(firstName, speaker.firstName) &&
                Objects.equals(lastName, speaker.lastName) &&
                Objects.equals(email, speaker.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
