package cn.xiaojii.dapu.Bean;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInformationBean implements Parcelable {

    private int[] UserAnswerArray;
    private int UserScore;


    private String StrName;
    private int IntAge;
    private GlogalBean.Sex Sex;
    private String StrIdNumber;
    private GlogalBean.InformationType informationType;
    private GlogalBean.EducationalLevel educationalLevel;
    private GlogalBean.IllTime illTime;
    private GlogalBean.InsulinTherapy insulinTherapy;
    private GlogalBean.WorkStatus workStatus;

    private int CurIndex;

    public int getCurIndex() {
        return CurIndex;
    }

    public void setCurIndex(int curIndex) {
        CurIndex = curIndex;
    }

    public int getSumCount() {
        return SumCount;
    }

    public void setSumCount(int sumCount) {
        SumCount = sumCount;
    }

    private int SumCount;


    public GlogalBean.InformationType getInformationType() {
        return informationType;
    }

    private GlogalBean.TypeOfMedication typeOfMedication;
    private int NumberOfTablets;
    private int FastingBloodSugar;
    private int TotalAmountOfInsulinAday;


    public int getUserScore() {
        return UserScore;
    }

    public void setUserAnswerArray(int[] userAnswerArray) {

        UserAnswerArray = userAnswerArray;
    }

    public int[] getUserAnswerArray() {
        return UserAnswerArray;
    }

    public void setUserScore(int userScore) {
        UserScore = userScore;
    }

    public void setEducationalLevel(GlogalBean.EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getStrName() {
        return StrName;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.UserAnswerArray);
        dest.writeInt(this.UserScore);
        dest.writeString(this.StrName);
        dest.writeInt(this.IntAge);
        dest.writeInt(this.Sex == null ? -1 : this.Sex.ordinal());
        dest.writeString(this.StrIdNumber);
        dest.writeInt(this.informationType == null ? -1 : this.informationType.ordinal());
        dest.writeInt(this.educationalLevel == null ? -1 : this.educationalLevel.ordinal());
        dest.writeInt(this.illTime == null ? -1 : this.illTime.ordinal());
        dest.writeInt(this.insulinTherapy == null ? -1 : this.insulinTherapy.ordinal());
        dest.writeInt(this.workStatus == null ? -1 : this.workStatus.ordinal());
        dest.writeInt(this.typeOfMedication == null ? -1 : this.typeOfMedication.ordinal());
        dest.writeInt(this.NumberOfTablets);
        dest.writeInt(this.FastingBloodSugar);
        dest.writeInt(this.TotalAmountOfInsulinAday);
    }

    protected UserInformationBean(Parcel in) {
        this.UserAnswerArray = in.createIntArray();
        this.UserScore = in.readInt();
        this.StrName = in.readString();
        this.IntAge = in.readInt();
        int tmpSex = in.readInt();
        this.Sex = tmpSex == -1 ? null : GlogalBean.Sex.values()[tmpSex];
        this.StrIdNumber = in.readString();
        int tmpInformationType = in.readInt();
        this.informationType = tmpInformationType == -1 ? null : GlogalBean.InformationType.values()[tmpInformationType];
        int tmpEducationalLevel = in.readInt();
        this.educationalLevel = tmpEducationalLevel == -1 ? null : GlogalBean.EducationalLevel.values()[tmpEducationalLevel];
        int tmpIllTime = in.readInt();
        this.illTime = tmpIllTime == -1 ? null : GlogalBean.IllTime.values()[tmpIllTime];
        int tmpInsulinTherapy = in.readInt();
        this.insulinTherapy = tmpInsulinTherapy == -1 ? null : GlogalBean.InsulinTherapy.values()[tmpInsulinTherapy];
        int tmpWorkStatus = in.readInt();
        this.workStatus = tmpWorkStatus == -1 ? null : GlogalBean.WorkStatus.values()[tmpWorkStatus];
        int tmpTypeOfMedication = in.readInt();
        this.typeOfMedication = tmpTypeOfMedication == -1 ? null : GlogalBean.TypeOfMedication.values()[tmpTypeOfMedication];
        this.NumberOfTablets = in.readInt();
        this.FastingBloodSugar = in.readInt();
        this.TotalAmountOfInsulinAday = in.readInt();
    }

    public static final Creator<UserInformationBean> CREATOR = new Creator<UserInformationBean>() {
        @Override
        public UserInformationBean createFromParcel(Parcel source) {
            return new UserInformationBean(source);
        }

        @Override
        public UserInformationBean[] newArray(int size) {
            return new UserInformationBean[size];
        }
    };
}
