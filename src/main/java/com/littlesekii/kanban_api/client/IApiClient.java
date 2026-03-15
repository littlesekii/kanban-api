package com.littlesekii.kanban_api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.littlesekii.kanban_api.dto.ping.PingResponse;

@FeignClient(
    name = "kanban-api", 
    url = "https://kb.linky.cat"
)
public interface IApiClient {

    @GetMapping("/api/ping")
    PingResponse ping();
}
