package com.littlesekii.kanban_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.kanban_api.dto.apiInfo.ApiInfoResponse;
import com.littlesekii.kanban_api.dto.ping.PingResponse;


@RestController
@RequestMapping("/api")
public class MainController {
    
    @GetMapping
    public ResponseEntity<ApiInfoResponse> apiInfo() {
        
        ApiInfoResponse res = new ApiInfoResponse("Kanban API v1.0");
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/ping")
    public ResponseEntity<PingResponse> ping() {
        
        PingResponse res = new PingResponse(
            "Pong🏓", 
            System.currentTimeMillis()
        );
        return ResponseEntity.ok().body(res);
    }
    

}
