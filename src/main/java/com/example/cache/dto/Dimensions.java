package com.example.cache.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;


@Data
@ToString()
@JsonInclude(Include.NON_EMPTY)
public class Dimensions implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String height;

}
