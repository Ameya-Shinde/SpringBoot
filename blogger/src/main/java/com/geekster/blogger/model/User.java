package com.geekster.blogger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotEmpty
    @Size(min = 3, message = "FirstName must be minimum of 3 characters")
    private String firstName;


    @NotEmpty
    @Size(min = 4, message = "Username must be minimum of 4 characters")
    private String username;


    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$", message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Pattern(regexp = "(0|91)?[6-9][0-9]{9}", message = "Phone number not valid")
    private String phoneNumber;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$", message = "Please enter valid password eg: Ameya@12390")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

}
