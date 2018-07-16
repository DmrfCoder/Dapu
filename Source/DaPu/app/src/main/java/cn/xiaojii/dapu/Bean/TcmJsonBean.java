package cn.xiaojii.dapu.Bean;

public class TcmJsonBean {
    private String 代茶饮;
    private String 体质类型;
    private String 穴位按摩;
    private String 运动;
    private String 食疗;

    public String get代茶饮() {
        return 代茶饮;
    }

    public String get体质类型() {
        return 体质类型;
    }

    public String get穴位按摩() {
        return 穴位按摩;
    }

    public String get运动() {
        return 运动;
    }

    public String get食疗() {
        return 食疗;
    }

    @Override
    public String toString() {
        return "\n是 " + 体质类型 + "\n[中医药调养]\n代茶饮:\n" + 代茶饮 +
                "\n食疗:\n" + 食疗 + "\n运动:\n" + 运动 + "\n穴位按摩:\n" + 穴位按摩;
    }
}
