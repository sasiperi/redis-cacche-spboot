package com.example.cache.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString()
@JsonInclude(Include.NON_EMPTY)
public class VolumeInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String title;
    private List<String> authors = new ArrayList<String>();
    private String publisher;
    private String publishedDate;
    private String description;
    private ReadingModes readingModes;
    private Integer pageCount;
    private Integer printedPageCount;
    private Dimensions dimensions;
    private String printType;
    private Integer averageRating;
    private Integer ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private PanelizationSummary panelizationSummary;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
    
}