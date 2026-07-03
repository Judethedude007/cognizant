package com.cognizant.mockitobasic;

public interface ExternalApi {

    String getData();

    String getDataById(String id);

    void saveData(String data);

    void deleteData(String id);
}
