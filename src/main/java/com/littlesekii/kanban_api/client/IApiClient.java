package com.littlesekii.kanban_api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.littlesekii.kanban_api.dto.ping.PingResponseDTO;

@FeignClient(
    name = "kanban-api", 
    url = "${server.url}"
)
public interface IApiClient {

    @GetMapping("/api/ping")
    PingResponseDTO ping();
}
