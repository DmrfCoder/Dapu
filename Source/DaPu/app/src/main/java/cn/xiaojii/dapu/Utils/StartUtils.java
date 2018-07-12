package cn.xiaojii.dapu.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import cn.xiaojii.dapu.Activity.SkipActivity;
import cn.xiaojii.dapu.Application.DapuApplication;


/**
 * Created by zhaoshuo on 2016/3/17.
 */
public class StartUtils {
    public static void startActivityById(Context context, int resId) {
        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, SkipActivity.class);
        intent.putExtra("ResId", resId);
        intent.putExtra("code", 1);
        context.startActivity(intent);
    }


    public static void startActivityByIdAndTabIndex(Context context, int resId, int tabIndex) {
        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, SkipActivity.class);
        intent.putExtra("ResId", resId);
        intent.putExtra("tabIndex", tabIndex);
        intent.putExtra("code", 2);
        context.startActivity(intent);
    }

    public static void startActivityToPdf(Context context, String filenme) {
        Intent intent = new Intent(context, SkipActivity.class);
        intent.putExtra("pdf_file_name", filenme);
        intent.putExtra("code", 3);
        context.startActivity(intent);
    }


    public static void startActivityByFragment(Context context, String fragmentName) {

        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, SkipActivity.class);
        intent.putExtra("fragmentName", fragmentName);
        intent.putExtra("code", 4);
        context.startActivity(intent);
    }

    public static void startActivityByJsonFileName(Context context, String jsonFileName){
        Context context1 = DapuApplication.getContext();
        Intent intent = new Intent(context1, SkipActivity.class);
        intent.putExtra("jsonFileName", jsonFileName);
        intent.putExtra("code", 5);
        context.startActivity(intent);

    }






    public static void startActivityByIdForResult(Fragment activity, int resId, int requestCode) {
        Intent intent = new Intent(DapuApplication.getContext(), SkipActivity.class);
        intent.putExtra("ResId", resId);
        activity.startActivityForResult(intent, requestCode);
    }


}
