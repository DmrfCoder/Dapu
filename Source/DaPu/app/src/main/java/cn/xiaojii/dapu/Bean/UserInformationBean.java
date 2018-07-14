package cn.xiaojii.dapu.Bean;

public class UserInformationBean {
    private String StrName;
    private int IntAge;
    private GlogalBean.Sex Sex;
    private String StrIdNumber;
    private GlogalBean.InformationType informationType;
    private GlogalBean.EducationalLevel educationalLevel;
    private GlogalBean.IllTime illTime;
    private GlogalBean.InsulinTherapy insulinTherapy;
    private GlogalBean.WorkStatus workStatus;
    private GlogalBean.TypeOfMedication typeOfMedication;
    private int NumberOfTablets;
    private int FastingBloodSugar;
    private int TotalAmountOfInsulinAday;

    public void setEducationalLevel(GlogalBean.EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public void setIllTime(GlogalBean.IllTime illTime) {
        this.illTime = illTime;
    }

    public void setInsulinTherapy(GlogalBean.InsulinTherapy insulinTherapy) {
        this.insulinTherapy = insulinTherapy;
    }

    public void setWorkStatus(GlogalBean.WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public void setTypeOfMedication(GlogalBean.TypeOfMedication typeOfMedication) {
        this.typeOfMedication = typeOfMedication;
    }

    public void setNumberOfTablets(int numberOfTablets) {
        NumberOfTablets = numberOfTablets;
    }

    public void setFastingBloodSugar(int fastingBloodSugar) {
        FastingBloodSugar = fastingBloodSugar;
    }

    public void setTotalAmountOfInsulinAday(int totalAmountOfInsulinAday) {
        TotalAmountOfInsulinAday = totalAmountOfInsulinAday;
    }

    public void setInformationType(GlogalBean.InformationType informationType) {
        this.informationType = informationType;
    }

    public UserInformationBean() {
    }

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
