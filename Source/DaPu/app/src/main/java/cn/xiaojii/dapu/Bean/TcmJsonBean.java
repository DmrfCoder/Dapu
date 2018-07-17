package cn.xiaojii.dapu.Bean;

public class TcmJsonBean {

    private String DaiChaYin;
    private String TiZhiLeiXing;
    private String XueWeiAnMo;
    private String YunDong;
    private String ShiLiao;



    public void setDaiChaYin(String daiChaYin) {
        this.DaiChaYin = daiChaYin;
    }

    public void setTiZhiLeiXing(String tiZhiLeiXing) {
        this.TiZhiLeiXing = tiZhiLeiXing;
    }

    public void setXueWeiAnMo(String xueWeiAnMo) {
        this.XueWeiAnMo = xueWeiAnMo;
    }

    public void setYunDong(String yunDong) {
        this.YunDong = yunDong;
    }

    public void setShiLiao(String shiLiao) {
        this.ShiLiao = shiLiao;
    }


    public String getDaiChaYin() {
        return DaiChaYin;
    }

    public String getTiZhiLeiXing() {
        return TiZhiLeiXing;
    }

    public String getXueWeiAnMo() {
        return XueWeiAnMo;
    }

    public String getYunDong() {
        return YunDong;
    }

    public String getShiLiao() {
        return ShiLiao;
    }

    @Override
    public String toString() {
        return "\n是 " + TiZhiLeiXing + "\n[中医药调养]\n代茶饮:\n" + DaiChaYin +
                "\n食疗:\n" + ShiLiao + "\n运动:\n" + YunDong + "\n穴位按摩:\n" + XueWeiAnMo;
    }
}
