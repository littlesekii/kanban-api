package com.littlesekii.kanban_api.process;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.littlesekii.kanban_api.client.IApiClient;

@SuppressWarnings("all")
@Component
public class PingProcess implements CommandLineRunner {

    private final IApiClient apiClient;

    public PingProcess(IApiClient apiClient) {
        this.apiClient = apiClient;
    }

    private Runnable ping = new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("API ping response: " + apiClient.ping().message());
                } catch (RuntimeException e) {
                    System.out.println("Failed while pinging.");
                }

                try {
                    Thread.sleep(1000 * 60 * 14);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    @Override
    public void run(String... args) throws Exception {
        new Thread(ping).run();
    }
}