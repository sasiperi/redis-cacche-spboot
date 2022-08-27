package com.example.cache.dto;

import java.io.Serializable;

public class Layer implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String layerId;
    private String volumeAnnotationsVersion;

    public String getLayerId()
    {
        return layerId;
    }

    public void setLayerId(String layerId)
    {
        this.layerId = layerId;
    }

    public String getVolumeAnnotationsVersion()
    {
        return volumeAnnotationsVersion;
    }

    public void setVolumeAnnotationsVersion(String volumeAnnotationsVersion)
    {
        this.volumeAnnotationsVersion = volumeAnnotationsVersion;
    }
}