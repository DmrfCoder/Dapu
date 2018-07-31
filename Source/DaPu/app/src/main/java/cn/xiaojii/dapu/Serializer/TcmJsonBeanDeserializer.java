package cn.xiaojii.dapu.Serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import cn.xiaojii.dapu.Bean.TcmJsonBean;

public class TcmJsonBeanDeserializer implements JsonDeserializer<TcmJsonBean> {
    @Override
    public TcmJsonBean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {


        JsonObject jsonObject = jsonElement.getAsJsonObject();
        TcmJsonBean tcmJsonBean = new TcmJsonBean();

        if (jsonObject.has("代茶饮")) {
            tcmJsonBean.setDaiChaYin(jsonObject.get("代茶饮").getAsString());
        }

        if (jsonObject.has("体质类型")) {
            tcmJsonBean.setTiZhiLeiXing(jsonObject.get("体质类型").getAsString());
        }

        if (jsonObject.has("穴位按摩")) {
            tcmJsonBean.setXueWeiAnMo(jsonObject.get("穴位按摩").getAsString());
        }

        if (jsonObject.has("运动")) {
            tcmJsonBean.setYunDong(jsonObject.get("运动").getAsString());
        }

        if (jsonObject.has("食疗")) {
            tcmJsonBean.setShiLiao(jsonObject.get("食疗").getAsString());
        }


        return tcmJsonBean;
    }
}
