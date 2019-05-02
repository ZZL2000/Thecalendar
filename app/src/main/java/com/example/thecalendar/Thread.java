package com.example.thecalendar;

import android.os.AsyncTask;
import android.widget.EditText;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.google.gson.*;
import com.squareup.okhttp.*;

/**
 * Created by Xiaohan.
 * In this class, I called the Azure Translator API, and modified the response to one simple text.
 */
public class Thread extends AsyncTask<String, Void, String> {
    String subscriptionKey = "1e39af1bc8a34b929c363c062d18923c";
    String url = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=ja,it";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();
    private EditText text;
    public Thread(EditText setText) {
        this.text = setText;
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            String gg = "[{\n\t\"Text\": \"Welcome to Microsoft Translator. Guess how many languages I speak!\"\n}]";
            String pp = gg.replaceFirst("Welcome to Microsoft Translator. Guess how many languages I speak!", strings[0]);
            RequestBody body = RequestBody.create(mediaType,
                    pp);
            Request request = new Request.Builder()
                    .url(url).post(body)
                    .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                    .addHeader("Content-type", "application/json").build();
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            return prettify(responseString);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        String k = json.getAsJsonArray().get(0).getAsJsonObject().get("translations").getAsJsonArray().get(0).getAsJsonObject().get("text").getAsString();
        return k;
    }
    protected void onPostExecute(String output) {
        text.setText(output);
    }
}
