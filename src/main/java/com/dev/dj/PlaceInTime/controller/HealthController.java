package com.dev.dj.PlaceInTime.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/health")
public class HealthController {

  @Value("${server.environment}")
  private String environment;

  @Value("${server.version}")
  private String version;

  @GetMapping("/")
  public ResponseEntity<Map<String, Object>> info(HttpServletRequest request) {
    Map<String, Object> response = new HashMap<>();
    response.put("server", request.getServerName());
    response.put("environment", environment);
    response.put("port", request.getServerPort());
    response.put("service", "PlaceInTime");
    response.put("version", version);
    response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    response.put("message", "Application is running successfully!");

    return ResponseEntity.ok(response);
  }

  @GetMapping("/ping")
  public ResponseEntity<Map<String, String>> ping() {
    Map<String, String> response = new HashMap<>();
    response.put("message", "pong");
    response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    return ResponseEntity.ok(response);
  }

}
