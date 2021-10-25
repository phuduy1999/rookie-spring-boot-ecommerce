package com.nashtech.rookies.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UriPathUtil {
    public static final String uri = "/api/v1/files/";

    public static String getUriPath(String imgUrl){
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(uri)
                .path(imgUrl)
                .toUriString();
    }
}
