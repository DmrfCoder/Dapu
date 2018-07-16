package cn.xiaojii.dapu.Serializer;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Calendar;

import cn.xiaojii.dapu.Bean.GlogalBean;
import cn.xiaojii.dapu.Bean.ServerJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;

public class UserInformationBeanSerializer implements JsonSerializer<UserInformationBean> {
    @Override
    public JsonElement serialize(UserInformationBean userInformationBean, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject Server = new JsonObject();
        JsonObject data = new JsonObject();


        data.addProperty("report", getReport(userInformationBean));
        data.addProperty("time", getTimeStr());

        JsonObject pollData = new JsonObject();


        for (int pollDataIndex = 0; pollDataIndex < userInformationBean.getUserAnswerList().size(); pollDataIndex++) {
            pollData.addProperty("" + pollDataIndex, userInformationBean.getUserAnswerList().get(pollDataIndex) + "");
        }

        data.add("pollData", pollData);


        JsonObject basicData = new JsonObject();

        if (userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionQuestionnaire) {

            basicData.addProperty("gender", userInformationBean.getSex().ordinal() + "");
            basicData.addProperty("payWay", "0");
            basicData.addProperty("idNumber", userInformationBean.getStrIdNumber());
            basicData.addProperty("age", userInformationBean.getIntAge() + "");
            basicData.addProperty("workStatus", userInformationBean.getWorkStatus().ordinal() + "");
            basicData.addProperty("medicalHistory", userInformationBean.getIllTime().ordinal() + "");
            basicData.addProperty("education", userInformationBean.getEducationalLevel().ordinal() + "");
            basicData.addProperty("JiangyaType", userInformationBean.getTypeOfMedication().ordinal() + "");
            basicData.addProperty("Score", userInformationBean.getIntUserScore() + "");
            basicData.addProperty("name", userInformationBean.getStrName());
            basicData.addProperty("JiangyeTimes", "0");


            data.add("basicData", basicData);


            data.addProperty("reportCSV", getReport(userInformationBean));
            data.addProperty("version", userInformationBean.getVsersion());
            data.addProperty("type", "GaoXueYaWenjuan");
            data.addProperty("typeChinese", "高血压问卷");
            data.addProperty("SignatureID", userInformationBean.getSignatureID());


        } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionSelfTest) {


            basicData.addProperty("age", userInformationBean.getIntAge() + "");
            basicData.addProperty("gender", userInformationBean.getSex().ordinal() + "");
            basicData.addProperty("name", userInformationBean.getStrName());
            basicData.addProperty("Score", userInformationBean.getIntUserScore() + "");
            basicData.addProperty("idNumber", userInformationBean.getStrIdNumber());


            data.add("basicData", basicData);


            data.addProperty("reportCSV", getReport(userInformationBean));
            data.addProperty("version", userInformationBean.getVsersion());
            data.addProperty("type", "GaoxueyaCeshi");
            data.addProperty("typeChinese", "高血压测试");
            data.addProperty("SignatureID", userInformationBean.getSignatureID());

        } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesQuestionnaire) {

            basicData.addProperty("YiDaoSuTreat", userInformationBean.getInsulinTherapy().ordinal() + "");
            basicData.addProperty("YiDaosuCount", userInformationBean.getIntTotalAmountOfInsulinAday() + "");
            basicData.addProperty("idNumber", userInformationBean.getStrIdNumber());
            basicData.addProperty("Score", userInformationBean.getIntUserScore() + "");
            basicData.addProperty("age", userInformationBean.getIntAge() + "");
            basicData.addProperty("XueTang", userInformationBean.getIntFastingBloodSugar() + "");
            basicData.addProperty("medicalHistory", userInformationBean.getIllTime().ordinal() + "");
            basicData.addProperty("workStatus", userInformationBean.getWorkStatus().ordinal() + "");
            basicData.addProperty("JiangyaType", userInformationBean.getTypeOfMedication().ordinal() + "");
            basicData.addProperty("education", userInformationBean.getEducationalLevel().ordinal() + "");
            basicData.addProperty("JiangTangYao", userInformationBean.getIntNumberOfTablets() + "");
            basicData.addProperty("gender", userInformationBean.getSex().ordinal() + "");
            basicData.addProperty("name", userInformationBean.getStrName());


            data.add("basicData", basicData);

            data.addProperty("reportCSV", getReport(userInformationBean));
            data.addProperty("version", userInformationBean.getVsersion());
            data.addProperty("type", "TangniaobingWenjuan");
            data.addProperty("typeChinese", "糖尿病问卷");
            data.addProperty("SignatureID", userInformationBean.getSignatureID());


        } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesSelfTest) {

            basicData.addProperty("YiDaoSuTreat", userInformationBean.getInsulinTherapy().ordinal() + "");
            basicData.addProperty("YiDaosuCount", userInformationBean.getIntTotalAmountOfInsulinAday() + "");
            basicData.addProperty("idNumber", userInformationBean.getStrIdNumber());
            basicData.addProperty("Score", userInformationBean.getIntUserScore() + "");
            basicData.addProperty("age", userInformationBean.getIntAge() + "");
            basicData.addProperty("XueTang", userInformationBean.getIntFastingBloodSugar() + "");
            basicData.addProperty("medicalHistory", userInformationBean.getIllTime().ordinal() + "");
            basicData.addProperty("workStatus", userInformationBean.getWorkStatus().ordinal() + "");
            basicData.addProperty("JiangyaType", userInformationBean.getTypeOfMedication().ordinal() + "");
            basicData.addProperty("education", userInformationBean.getEducationalLevel().ordinal() + "");
            basicData.addProperty("JiangTangYao", userInformationBean.getIntNumberOfTablets() + "");
            basicData.addProperty("gender", userInformationBean.getSex().ordinal() + "");
            basicData.addProperty("name", userInformationBean.getStrName());


            data.add("basicData", basicData);

            data.addProperty("reportCSV", getReport(userInformationBean));
            data.addProperty("version", userInformationBean.getVsersion());
            data.addProperty("type", "TangniaobingCeShi");
            data.addProperty("typeChinese", "糖尿病测试");
            data.addProperty("SignatureID", userInformationBean.getSignatureID());

        } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.TcmResult) {
            basicData.addProperty("age", userInformationBean.getIntAge() + "");
            basicData.addProperty("gender", userInformationBean.getSex().ordinal() + "");
            basicData.addProperty("name", userInformationBean.getStrName());
            basicData.addProperty("idNumber", userInformationBean.getStrIdNumber());


            data.add("basicData", basicData);

            data.addProperty("reportCSV", getReport(userInformationBean));
            data.addProperty("version", userInformationBean.getVsersion());
            data.addProperty("type", "TiZhiCeshi");
            data.addProperty("typeChinese", "体质测试");
            data.addProperty("SignatureID", userInformationBean.getSignatureID());
        }


        Server.add("data", data);

        return Server;

    }


    private static String getReport(UserInformationBean userInformationBean) {


        String report = "[基本信息]:" + "\n姓名:" + userInformationBean.getStrName() + ",\n性别:";
        if (userInformationBean.getSex() == GlogalBean.Sex.Male) {
            report = report + "男,\n年龄:";
        } else {
            report = report + "女,\n年龄:";
        }

        report = report + userInformationBean.getIntAge() + ",\n身份证号码:" + userInformationBean.getStrIdNumber();

        if (userInformationBean.getInformationType() == GlogalBean.InformationType.TcmResult) {
            report = report + ", \n~~~\n        \n\n [体质测试]:\n";

        } else {
            switch (userInformationBean.getEducationalLevel()) {
                case CollegeOrAbove:
                    report = ",\n学历:" + report + "大专及以上,\n病史:";
                    break;
                case SecondarySchool:
                    report = ",\n学历:" + report + "中学/中专,\n病史:";
                    break;
                case ElementarySchoolAndBelow:
                    report = ",\n学历:" + report + "小学及以下,\n病史:";
                    break;
            }

            switch (userInformationBean.getIllTime()) {
                case LessFive:
                    report = report + "<5年,\n工作状态:";
                    break;
                case FiveToTen:
                    report = report + "5年-10年,\n工作状态:";
                    break;
                case MoreThanTen:
                    report = report + ">10年,\n工作状态:";
                    break;
            }


            switch (userInformationBean.getWorkStatus()) {
                case Work:
                    report = report + "在职,\n服药种类:";
                    break;
                case NoWork:
                    report = report + "未就业,\n服药种类:";
                    break;
                case Retirement:
                    report = report + "离退休,\n服药种类:";
                    break;
            }

            switch (userInformationBean.getTypeOfMedication()) {
                case One:
                    report = report + "1种,\n目前血糖:";
                    break;
                case Two:
                    report = report + "2种,\n目前血糖:";
                    break;
                case MoreThanThree:
                    report = report + "3种及以上,\n目前血糖:";
                    break;
            }

            report = report + userInformationBean.getIntFastingBloodSugar() + ",\n胰岛素一天总量:" + userInformationBean.getIntTotalAmountOfInsulinAday();

            if (userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionQuestionnaire || userInformationBean.getInformationType() == GlogalBean.InformationType.HypertensionSelfTest) {
                report = report + ",\n降压药总量" + userInformationBean.getIntNumberOfTablets();
            } else if (userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesSelfTest || userInformationBean.getInformationType() == GlogalBean.InformationType.DiabetesQuestionnaire) {
                report = report + ",\n降糖药总量" + userInformationBean.getIntNumberOfTablets();
            }

            switch (userInformationBean.getInsulinTherapy()) {
                case TRUE:
                    report = report + ",\n胰岛素治疗:是,\n得分:" + userInformationBean.getIntUserScore();
                    break;
                case FALSE:
                    report = report + ",\n胰岛素治疗:否,\n得分:" + userInformationBean.getIntUserScore();
                    break;
            }

            report = report + ", \n~~~\n        \n\n [";

            switch (userInformationBean.getInformationType()) {
                case HypertensionSelfTest:
                    report = report + "高血压自测]:\n";
                    break;
                case HypertensionQuestionnaire:
                    report = report + "高血压问卷]:\n";
                    break;
                case DiabetesSelfTest:
                    report = report + "糖尿病自测]:\n";
                    break;
                case DiabetesQuestionnaire:
                    report = report + "高血压问卷]:\n";
                    break;

            }

        }


        int answers[] = new int[userInformationBean.getUserAnswerList().size()];

        for (int answerIndex = 0; answerIndex < userInformationBean.getUserAnswerList().size(); answerIndex++) {
            answers[answerIndex] = userInformationBean.getUserAnswerList().get(answerIndex);
        }

        String[] IndexString = {"A", "B", "C", "D", "E", "F"};

        for (int answer = 0; answer < userInformationBean.getUserAnswerList().size() - 1; answer++) {
            report = report + "第" + (answer + 1) + "题:选" + IndexString[answers[answer]] + ",\n";
        }
        if (userInformationBean.getUserAnswerList().size() - 1 >= 0) {
            report = report + "第" + (userInformationBean.getUserAnswerList().size() - 1) + "题:选" + IndexString[answers[userInformationBean.getUserAnswerList().size() - 1]];
        }

        report = report + ", \n\n~~~\n[报告]:" + userInformationBean.getStrTcmResult();


        return report;
    }


    private static String getTimeStr() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "_" + (c.get(Calendar.MONTH) + 1) + "_" + c.get(Calendar.DAY_OF_MONTH)
                + "_" + c.get(Calendar.HOUR_OF_DAY) + "_" + c.get(Calendar.MINUTE) + "_" + c.get(Calendar.SECOND);
    }

}
