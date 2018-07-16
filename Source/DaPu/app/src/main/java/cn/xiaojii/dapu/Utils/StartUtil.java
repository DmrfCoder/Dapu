package cn.xiaojii.dapu.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import cn.xiaojii.dapu.Activity.SkipActivity;
import cn.xiaojii.dapu.Application.DapuApplication;
import cn.xiaojii.dapu.Bean.UserInformationBean;


/**
 * Created by zhaoshuo on 2016/3/17.
 */
public class StartUtil {
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




    public static void startActivityByUserInfo(Context context, UserInformationBean userInformationBean){
        Context context1 = DapuApplication.getContext();

        Intent intent = new Intent(context1, SkipActivity.class);

        Bundle bundle=new Bundle();
        bundle.putParcelable("userinfobean",userInformationBean);

        intent.putExtra("code",5);

        intent.putExtras(bundle);

        context.startActivity(intent);


    }






    public static void startActivityByIdForResult(Fragment activity, int resId, int requestCode) {
        Intent intent = new Intent(DapuApplication.getContext(), SkipActivity.class);
        intent.putExtra("ResId", resId);
        activity.startActivityForResult(intent, requestCode);
    }


    public static void startActivityForQuestionnaireResult(Context context, UserInformationBean userInformationBean) {
        Context context1 = DapuApplication.getContext();

        Intent intent = new Intent(context1, SkipActivity.class);

        Bundle bundle=new Bundle();
        bundle.putParcelable("userinfobean",userInformationBean);

        intent.putExtra("code",6);

        intent.putExtras(bundle);

        context.startActivity(intent);
    }


}
