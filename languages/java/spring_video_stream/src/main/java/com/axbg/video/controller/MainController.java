package com.axbg.video.controller;

import com.axbg.video.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final VideoService videoService;

    public MainController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/source")
    public ResponseEntity<FileSystemResource> getVideo() {
        LOGGER.info("endpoint called");

        // Inspired from https://www.section.io/engineering-education/building-a-video-streaming-app-with-spring/
        // but modified so that only the current selection from the video being served is loaded into memory
        // For this behavior to be more obvious, use a larger video file, start a profiler and observe the memory usage
        return ResponseEntity.ok(new FileSystemResource(this.videoService.getVideoFile()));
    }
}
