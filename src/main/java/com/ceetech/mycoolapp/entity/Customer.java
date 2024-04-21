package com.ceetech.mycoolapp.entity;

import com.ceetech.mycoolapp.validation.CourseCode;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Customer {

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    @NotNull(message = "Lst name is required")
    @Size(min = 3, message = "A minimum of 3 character")
    private String lastName;

    @Setter
    @Getter
    @Min(value = 0, message = "Number must be greater than 0")
    @NotNull(message = "Free pass is required")
    @Max(value = 10, message = "Number must be less than 10")
    private Integer freePasses;

    @Setter
    @Getter
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters needed")
    private String postalCode;

    @Setter
    @Getter
    @CourseCode
    private String courseCode;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Customer() {
    }

    public Customer(String firstName,
            @NotNull(message = "Lst name is required") @Size(min = 3, message = "A minimum of 3 character") String lastName,
            @Min(value = 0, message = "Number must be greater than 0") @Max(value = 10, message = "Number must be less than 10") Integer freePasses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
    }

}
