package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.model.rest.request.user.UserRegistrationReq;
import com.entropy.backend.model.rest.response.user.UserRegistrationResp;
import com.entropy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author bac-ta
 */
@RestController
@RequestMapping(APIEndpointBase.USER_ENDPOINT_BASE)
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
    public ResponseEntity<UserRegistrationResp> registUser(@Valid @RequestBody UserRegistrationReq req) {
        try {
            UserRegistrationResp resp = userService.regist(req);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UserRegistrationResp(null, APIMessage.REGIST_USER_FAIL), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ids-watting")
    public ResponseEntity<List<Long>> findUserRegistListWatting() {
        List<Long> idList = userService.findUserRegistListWatting();
        return new ResponseEntity<>(idList, HttpStatus.OK);
    }
}
