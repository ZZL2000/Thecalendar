package com.example.thecalendar;

import java.io.*;

import com.google.gson.*;
import com.squareup.okhttp.*;

public class Translate {
    String subscriptionKey = "1e39af1bc8a34b929c363c062d18923c";
    String url = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=ja,it";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String input) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        String gg = "[{\n\t\"Text\": \"Welcome to Microsoft Translator. Guess how many languages I speak!\"\n}]";
        String pp = gg.replaceFirst("Welcome to Microsoft Translator. Guess how many languages I speak!", input);
        RequestBody body = RequestBody.create(mediaType,
                pp);
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // This function prettifies the json response.
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        String k = json.getAsJsonArray().get(0).getAsJsonObject().get("translations").getAsJsonArray().get(0).getAsJsonObject().get("text").getAsString();
        System.out.println(k);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }
    public static void main(String[] args) {
        try {
            Translate translateRequest = new Translate();
            String response = translateRequest.Post("I love eat");
            System.out.println(prettify(response));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
