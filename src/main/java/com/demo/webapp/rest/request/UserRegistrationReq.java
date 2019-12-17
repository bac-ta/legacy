package com.demo.webapp.rest.request;

import com.demo.webapp.anonation.FieldMatch;
import com.demo.webapp.constant.APIMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author bac-ta
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = APIMessage.PASSWORD_INCORRECT),
        @FieldMatch(first = "email", second = "confirmEmail", message = APIMessage.EMAIL_INCORRECT)
})
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserRegistrationReq {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

}