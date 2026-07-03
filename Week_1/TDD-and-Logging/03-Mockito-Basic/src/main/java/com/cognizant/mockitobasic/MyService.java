package com.cognizant.mockitobasic;

public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(String id) {
        return externalApi.getDataById(id);
    }

    public void saveData(String data) {
        externalApi.saveData(data);
    }

    public void deleteData(String id) {
        externalApi.deleteData(id);
    }

    public String fetchDataTwice() {
        String firstResult = externalApi.getData();
        String secondResult = externalApi.getData();

        return firstResult + " | " + secondResult;
    }
}
