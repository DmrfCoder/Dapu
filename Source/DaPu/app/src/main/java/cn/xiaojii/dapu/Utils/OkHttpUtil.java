package cn.xiaojii.dapu.Utils;

import android.net.Uri;

import java.io.IOException;

import cn.xiaojii.dapu.Bean.GlogalBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {


    public static void SendDataToServer(String name, String content) {

        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBuilder = new FormBody.Builder();
        formBuilder.add(name, content);

        Request request = new Request.Builder().url(GlogalBean.Url).post(formBuilder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }
}
