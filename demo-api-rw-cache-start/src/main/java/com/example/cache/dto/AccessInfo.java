package com.example.cache.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString()
@JsonInclude(Include.NON_EMPTY)
public class AccessInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private Epub epub;
    private Pdf pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
    
}
