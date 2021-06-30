package com.entropy.backend.models.exceptions;

import com.entropy.backend.common.constants.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostFindNotFoundException extends RuntimeException {
    public PostFindNotFoundException(int id) {
        super(String.format(APIMessage.POST_NOT_FOUND, id));
    }
}