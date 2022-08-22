package com.example.cache.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString()
@JsonInclude(Include.NON_EMPTY)
public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private LayerInfo layerInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;

}
