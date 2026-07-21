package com.example.Exercise_2_Verifying_Interactions;

public class MyService {

    private ExternalAPI api;

    public MyService(ExternalAPI api) {
        this.api = api;
    }

    public void fetchData() {
        System.out.println("Calling getData()...");
        api.getData();
    }
}