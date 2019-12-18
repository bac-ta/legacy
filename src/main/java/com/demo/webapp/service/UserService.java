package com.demo.webapp.service;

import com.demo.webapp.constant.APIMessage;
import com.demo.webapp.constant.FormatString;
import com.demo.webapp.entity.Role;
import com.demo.webapp.entity.User;
import com.demo.webapp.enumeration.GenderType;
import com.demo.webapp.enumeration.UserType;
import com.demo.webapp.repository.UserRepository;
import com.demo.webapp.rest.request.UserRegistrationReq;
import com.demo.webapp.rest.response.UserRegistrationResp;
import com.demo.webapp.security.entrypoint.JwtAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

/**
 * @author bac-ta
 */
@Service
public class UserService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegistrationResp regist(UserRegistrationReq registration) throws ParseException {
        User user = User.builder().firstName(registration.getFirstName()).lastName(registration.getLastName())
                .email(registration.getEmail())
                .password(passwordEncoder.encode(registration.getPassword()))
                .userName(registration.getUsername())
                .phoneNumber(registration.getPhoneNumber())
                .genderType(GenderType.findByValue(registration.getGenderType()))
                .dateOfBirth(new SimpleDateFormat(FormatString.DATE_OF_BIRTH_FORMAT).parse(registration.getDateOfBirth()))
                .roles(registration.getUserTypes().stream().map(type -> new Role(UserType.findByValue(type))).collect(Collectors.toSet())).build();
        try {
            User userSave = userRepository.save(user);
            Long id = userSave.getId();
            return new UserRegistrationResp(id, APIMessage.REGIST_USER_SUCCESSFUL);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new UserRegistrationResp(null, APIMessage.REGIST_USER_FAIL);
        }
    }
}
