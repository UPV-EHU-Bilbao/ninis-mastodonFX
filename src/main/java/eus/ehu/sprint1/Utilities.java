package eus.ehu.sprint1;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class Utilities {



    public static String request(String endpoint) {

        String result = "";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://mastodon.social/api/v1/" + endpoint)
                .get()
                .addHeader("Authorization", "Bearer " + System.getenv("TOKEN"))
                .build();

        try {

            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                result = response.body().string();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
