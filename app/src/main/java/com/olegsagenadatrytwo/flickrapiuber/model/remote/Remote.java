package com.olegsagenadatrytwo.flickrapiuber.model.remote;

import com.google.gson.Gson;
import com.olegsagenadatrytwo.flickrapiuber.entities.Flicker;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by omcna on 10/9/2017.
 */

public class Remote {

    private IRemote iremote;
    public Remote(IRemote iremote){
        this.iremote = iremote;
    }

    public void makeRestCallForImages(String query){

        final String URL = "https://api.flickr.com/services/rest/?&format=json&nojsoncallback=1&method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsonca%20llback=1&text=" + query;

        final OkHttpClient okHttpClient;
        final Request request;

        //get the data
        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(URL)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                Flicker data;
                data = gson.fromJson(response.body().string(), Flicker.class);
                iremote.sendData(data);
            }
        });

    }

}
