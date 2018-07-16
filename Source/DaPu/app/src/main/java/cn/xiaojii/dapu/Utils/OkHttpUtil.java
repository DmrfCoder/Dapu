package cn.xiaojii.dapu.Utils;


import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.ResponseBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {


    public static void SendDataToServer(String name, String content) {

        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, content);


        final Request request = new Request.Builder()
                .url(GlogalBean.Url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        //异步
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                Gson gson = new Gson();
                ResponseBean responseBean = gson.fromJson(res, ResponseBean.class);
                String result = responseBean.getResult();
                Log.i("response info",result);
                if (result.equals("True")) {//成功

                } else if (result.equals("False")) {//失败

                }
            }
        });


    }
}
