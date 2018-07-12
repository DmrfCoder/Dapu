package cn.xiaojii.dapu.Bean;

public class UserInformationBean {
    private String StrName;
    private int IntAge;
    private GlogalBean.Sex Sex;
    private String StrIdNumber;

    public UserInformationBean(String strName, int intAge, GlogalBean.Sex sex, String strIdNumber) {
        StrName = strName;
        IntAge = intAge;
        Sex = sex;
        StrIdNumber = strIdNumber;
    }

    public void setStrName(String strName) {
        StrName = strName;
    }

    public void setIntAge(int intAge) {
        IntAge = intAge;
    }

    public void setSex(GlogalBean.Sex sex) {
        Sex = sex;
    }

    public void setStrIdNumber(String strIdNumber) {
        StrIdNumber = strIdNumber;
    }
}
