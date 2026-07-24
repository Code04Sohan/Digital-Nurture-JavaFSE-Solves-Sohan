package com.example;

public class MyService {
    private final ExternalApi api;

    // Constructor injection
    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}