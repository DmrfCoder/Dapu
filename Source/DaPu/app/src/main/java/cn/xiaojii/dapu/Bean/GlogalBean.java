package cn.xiaojii.dapu.Bean;

public class GlogalBean {

    public static boolean DEBUG=false;

    public static String PassWord="2222";
    //发送数据到管理员邮箱所需信息
    public static final String HOST = "smtp.qq.com";
    public static final String PORT = "587";
    public static final String FROM_ADD = "2296452542@qq.com"; //发送方邮箱
    public static final String FROM_PSW = "uzblydlkkdnzebbi";//发送方邮箱授权码

    //发送数据到服务器所需信息
    public static String Url = "http://apidapuzhongyitest.xiaojii.cn/api/v1.0/sendDataJson";


    public static String WrongNumber="×";
    public static String CorrentNumber="√";


    public enum Type {
        Questionnaire, SelfTest
    }

    public enum PayWay{
        YiLiaoBaoXian,QuanZiFei,QuanGongFei
    }

    public enum JiangYaYaoCiShu{
        One,Two,Three
    }

    public enum InformationType {
        TcmConstitutionIdentification,HypertensionQuestionnaire,HypertensionSelfTest,DiabetesQuestionnaire,DiabetesSelfTest,WaitYouChallage,TcmResult
    }

    public enum Sex {
        Male, Female
    }

    public enum EducationalLevel {
        ElementarySchoolAndBelow, SecondarySchool, CollegeOrAbove
    }


    public enum IllTime {
        LessFive, FiveToTen, MoreThanTen
    }


    public enum InsulinTherapy {//是否使用胰岛素
        TRUE, FALSE
    }

    public enum WorkStatus {
        Retirement, Work,NoWork
    }

    public enum TypeOfMedication {
        One, Two, MoreThanThree
    }


}
