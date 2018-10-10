package android.shinetech.com.tradereport.Model;

import android.shinetech.com.tradereport.Bean.Report;
import android.shinetech.com.tradereport.Tools.OkHttpClientInstance;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ReportModel {

    List<Report> reports = null;

    public List<Report> getData() {
        reports = new ArrayList<Report>();
        for (int i = 0; i < 10; i++) {
            reports.add(new Report(i + 1, i + 1, "Class" + i, "Report Name" + i, "Report Descripation" + i));
        }
        getRemoteData();

        return reports;
    }


    public List<Report> getRemoteData() {
        OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();


        String URL =  "https://raw.github.com/square/okhttp/master/README.md";
        //RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8") );
        Request request = new Request.Builder()
                .url(URL)
               // .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("连接失败");
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("===========" + response.body().toString() + "==============");
                    }
                };
                r.run();
            }
        });
        return null;


    }




}
