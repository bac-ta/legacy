package com.entropy.backend.model.rest.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostCreateReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    @JsonProperty("category_type")
    private Integer categoryType;
    @NotNull
    @JsonProperty("publish_type")
    private Integer publishType;
}