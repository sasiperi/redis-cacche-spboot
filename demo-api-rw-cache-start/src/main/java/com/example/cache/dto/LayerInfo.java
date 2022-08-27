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
public class LayerInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<Layer> layers = new ArrayList<Layer>();

}