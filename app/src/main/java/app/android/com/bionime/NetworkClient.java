package app.android.com.bionime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.model.MainModel;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class NetworkClient {

    private static final String TAG = "NetworkClient";
    private static final String BROADCAST_ACTION =
            "app.android.com.bionime.broadcast";
    public Context context;

    public NetworkClient(Context context){
        this.context = context;
    }

    public void getAQIData(String url){
        String decodedString = "";
        String urlData = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((decodedString = reader.readLine()) != null){
                urlData += decodedString;
            }
            reader.close();
            Log.d(TAG, "getUrlData: urlData = " + urlData);
            formateData(urlData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formateData(String dataStr){
        try {
            JSONArray jsonArray = new JSONArray(dataStr);
            ArrayList<DataBean> list = new ArrayList<>();
            for (int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonItem = jsonArray.getJSONObject(i);
                DataBean bean = new Gson().fromJson(jsonItem.toString(),DataBean.class);
                list.add(bean);
            }
            Intent intent = new Intent(BROADCAST_ACTION);
            intent.putExtra("type","aqi");
            intent.putExtra("datas", list);
            context.sendBroadcast(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getSentence(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("meta[name=description]");
            String content = elements.get(0).attr("content");
            Log.d(TAG, "getWebData: content = " + content);
            Intent intent = new Intent(BROADCAST_ACTION);
            intent.putExtra("type","sentence");
            intent.putExtra("sentence", content);
            context.sendBroadcast(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
