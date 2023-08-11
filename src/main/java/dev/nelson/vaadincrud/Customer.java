package dev.nelson.vaadincrud;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }




}
