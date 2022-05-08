package com.axbg.video.service;

import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class VideoService {
    public String getVideoFile() {
        URL resource = this.getClass().getClassLoader().getResource("video.mp4");

        return resource != null ? resource.getFile() : null;
    }
}
