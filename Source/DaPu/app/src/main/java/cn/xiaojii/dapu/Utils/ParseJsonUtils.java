package cn.xiaojii.dapu.Utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.xiaojii.dapu.Bean.QuestionInJsonBean;

public class ParseJsonUtils {
    private ReadFileToStringUtils readFileToStringUtils;
    private List<QuestionInJsonBean> questionInJsonBeanList;


    public ParseJsonUtils(Context context) {
        readFileToStringUtils = new ReadFileToStringUtils(context);

    }

    public List<QuestionInJsonBean> GetJsonData(String filename) {
        String json = readFileToStringUtils.ReadJsonToString(filename);
        Gson gson = new Gson();
        List<JsonElement> list = new ArrayList();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);  //将json字符串转换成JsonElement
        JsonArray jsonArray = jsonElement.getAsJsonArray();  //将JsonElement转换成JsonArray
        Iterator it = jsonArray.iterator();  //Iterator处理
        questionInJsonBeanList = new ArrayList<QuestionInJsonBean>();

        while (it.hasNext()) {  //循环
            jsonElement = (JsonElement) it.next(); //提取JsonElement
            json = jsonElement.toString();  //JsonElement转换成String
            QuestionInJsonBean questionInJsonBean = gson.fromJson(json, QuestionInJsonBean.class); //String转化成JavaBean
            questionInJsonBeanList.add(questionInJsonBean);
        }
        return questionInJsonBeanList;
    }
}
