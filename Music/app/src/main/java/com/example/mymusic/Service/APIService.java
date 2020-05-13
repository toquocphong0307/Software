package com.example.mymusic.Service;


//kết hợp rerofit va dataservice
public class APIService {
    private static String base_url = "https://mymusic1111.000webhostapp.com/Server/";

    public static  Dataservice getService(){
        return APIRerofitClient.getClient(base_url).create(Dataservice.class);
    }

}
