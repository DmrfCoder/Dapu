package cn.xiaojii.dapu.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import cn.xiaojii.dapu.Activity.ClickButtonActivity;
import cn.xiaojii.dapu.Application.DapuApplication;


/**
 * Created by zhaoshuo on 2016/3/17.
 */
public class StartUtils {
    public static void startActivityById(Context context, int resId) {
        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, ClickButtonActivity.class);
        intent.putExtra("resId", resId);
        intent.putExtra("code",1);
        context.startActivity(intent);
    }

    public static void startActivityByIdAndTabIndex(Context context, int resId, int tabIndex) {
        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, ClickButtonActivity.class);
        intent.putExtra("resId", resId);
        intent.putExtra("tabIndex", tabIndex);
        intent.putExtra("code",2);
        context.startActivity(intent);
    }

    public static void startActivityByIdForResult(Fragment activity, int resId, int requestCode) {
        Intent intent = new Intent(DapuApplication.getContext(), ClickButtonActivity.class);
        intent.putExtra("resId", resId);
        activity.startActivityForResult(intent, requestCode);
    }

}
