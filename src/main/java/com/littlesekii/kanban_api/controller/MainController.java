package com.littlesekii.kanban_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.kanban_api.dto.apiInfo.ApiInfoResponseDTO;
import com.littlesekii.kanban_api.dto.ping.PingResponseDTO;


@RestController
@RequestMapping("/api")
public class MainController {
    
    @GetMapping
    public ResponseEntity<ApiInfoResponseDTO> apiInfo() {
        
        ApiInfoResponseDTO res = new ApiInfoResponseDTO("Kanban API v1.0");
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/ping")
    public ResponseEntity<PingResponseDTO> ping() {
        
        PingResponseDTO res = new PingResponseDTO(
            "Pong🏓", 
            System.currentTimeMillis()
        );
        return ResponseEntity.ok().body(res);
    }
    

}
