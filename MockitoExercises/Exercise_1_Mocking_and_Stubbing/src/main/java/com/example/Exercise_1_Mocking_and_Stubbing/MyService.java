package com.example.Exercise_1_Mocking_and_Stubbing;
public class MyService {

    private ExternalAPI api;

    public MyService(ExternalAPI api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}