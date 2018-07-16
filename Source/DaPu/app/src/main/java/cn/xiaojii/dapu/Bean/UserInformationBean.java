package cn.xiaojii.dapu.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class UserInformationBean implements Parcelable {

    private List<Integer> UserAnswerList;//用户答题答案数据

    private String StrName;//用户姓名
    private int IntAge;//用户年龄
    private int IntUserScore;//用户答题得分
    private int IntCurIndex;//用户当前答题Index
    private int IntSumCount;//当前题库题量
    private int IntNumberOfTablets;//服药总粒数
    private int IntFastingBloodSugar;//空腹血糖
    private int IntTotalAmountOfInsulinAday;//胰岛素用量

    private GlogalBean.TypeOfMedication typeOfMedication= GlogalBean.TypeOfMedication.One;
    private GlogalBean.InformationType informationType;
    private GlogalBean.EducationalLevel educationalLevel= GlogalBean.EducationalLevel.ElementarySchoolAndBelow;
    private GlogalBean.IllTime illTime= GlogalBean.IllTime.LessFive;
    private GlogalBean.InsulinTherapy insulinTherapy= GlogalBean.InsulinTherapy.TRUE;
    private GlogalBean.WorkStatus workStatus= GlogalBean.WorkStatus.Retirement;
    private GlogalBean.Sex Sex= GlogalBean.Sex.Male;

    private String StrTcmResult="\n2\n";

    private String Vsersion="1.0";

    private String SignatureID="4ddc59b2-4525-4611-a89e-bc68e25feaca";

    public String getSignatureID() {
        return SignatureID;
    }

    public void setSignatureID(String signatureID) {
        SignatureID = signatureID;
    }

    public String getVsersion() {
        return Vsersion;
    }

    public void setVsersion(String vsersion) {
        Vsersion = vsersion;
    }

    public String getStrTcmResult() {
        return StrTcmResult;
    }

    public void setStrTcmResult(String strTcmResult) {
        StrTcmResult = strTcmResult;
    }

    public String getStrIdNumber() {
        return StrIdNumber;
    }

    public int getIntAge() {
        return IntAge;
    }

    public int getIntNumberOfTablets() {
        return IntNumberOfTablets;
    }

    public int getIntFastingBloodSugar() {
        return IntFastingBloodSugar;
    }

    public int getIntTotalAmountOfInsulinAday() {
        return IntTotalAmountOfInsulinAday;
    }

    public GlogalBean.TypeOfMedication getTypeOfMedication() {
        return typeOfMedication;
    }

    public GlogalBean.EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public GlogalBean.IllTime getIllTime() {
        return illTime;
    }

    public GlogalBean.InsulinTherapy getInsulinTherapy() {
        return insulinTherapy;
    }

    public GlogalBean.WorkStatus getWorkStatus() {
        return workStatus;
    }

    public GlogalBean.Sex getSex() {
        return Sex;
    }

    private String StrIdNumber;//用户身份证号

    public int getIntCurIndex() {
        return IntCurIndex;
    }

    public void setIntCurIndex(int intCurIndex) {
        IntCurIndex = intCurIndex;
    }

    public int getIntSumCount() {
        return IntSumCount;
    }

    public void setIntSumCount(int intSumCount) {
        IntSumCount = intSumCount;
    }


    public GlogalBean.InformationType getInformationType() {
        return informationType;
    }


    public int getIntUserScore() {
        return IntUserScore;
    }



    public void setIntUserScore(int intUserScore) {
        IntUserScore = intUserScore;
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

    public void setIntNumberOfTablets(int intNumberOfTablets) {
        IntNumberOfTablets = intNumberOfTablets;
    }

    public void setIntFastingBloodSugar(int intFastingBloodSugar) {
        IntFastingBloodSugar = intFastingBloodSugar;
    }

    public void setIntTotalAmountOfInsulinAday(int intTotalAmountOfInsulinAday) {
        IntTotalAmountOfInsulinAday = intTotalAmountOfInsulinAday;
    }

    public void setInformationType(GlogalBean.InformationType informationType) {
        this.informationType = informationType;
    }

    public UserInformationBean() {
        UserAnswerList=new ArrayList<Integer>();
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



    public void setIntAge(String str) throws Exception {
        try {
            this.IntAge = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void setIntUserScore(String str) throws Exception {
        try {
            this.IntUserScore = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw e;
        }
    }


    public void setIntNumberOfTablets(String str) throws Exception {
        try {
            this.IntNumberOfTablets = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void setIntFastingBloodSugar(String str) throws Exception {
        try {
            this.IntFastingBloodSugar = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void setIntTotalAmountOfInsulinAday(String str) throws Exception {
        try {
            this.IntTotalAmountOfInsulinAday = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw e;
        }
    }


    public List<Integer> getUserAnswerList() {
        return UserAnswerList;
    }

    public void setUserAnswerList(List<Integer> userAnswerList) {
        UserAnswerList = userAnswerList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.UserAnswerList);
        dest.writeString(this.StrName);
        dest.writeInt(this.IntAge);
        dest.writeInt(this.IntUserScore);
        dest.writeInt(this.IntCurIndex);
        dest.writeInt(this.IntSumCount);
        dest.writeInt(this.IntNumberOfTablets);
        dest.writeInt(this.IntFastingBloodSugar);
        dest.writeInt(this.IntTotalAmountOfInsulinAday);
        dest.writeInt(this.typeOfMedication == null ? -1 : this.typeOfMedication.ordinal());
        dest.writeInt(this.informationType == null ? -1 : this.informationType.ordinal());
        dest.writeInt(this.educationalLevel == null ? -1 : this.educationalLevel.ordinal());
        dest.writeInt(this.illTime == null ? -1 : this.illTime.ordinal());
        dest.writeInt(this.insulinTherapy == null ? -1 : this.insulinTherapy.ordinal());
        dest.writeInt(this.workStatus == null ? -1 : this.workStatus.ordinal());
        dest.writeInt(this.Sex == null ? -1 : this.Sex.ordinal());
        dest.writeString(this.StrTcmResult);
        dest.writeString(this.StrIdNumber);
    }

    protected UserInformationBean(Parcel in) {
        this.UserAnswerList = new ArrayList<Integer>();
        in.readList(this.UserAnswerList, Integer.class.getClassLoader());
        this.StrName = in.readString();
        this.IntAge = in.readInt();
        this.IntUserScore = in.readInt();
        this.IntCurIndex = in.readInt();
        this.IntSumCount = in.readInt();
        this.IntNumberOfTablets = in.readInt();
        this.IntFastingBloodSugar = in.readInt();
        this.IntTotalAmountOfInsulinAday = in.readInt();
        int tmpTypeOfMedication = in.readInt();
        this.typeOfMedication = tmpTypeOfMedication == -1 ? null : GlogalBean.TypeOfMedication.values()[tmpTypeOfMedication];
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
        int tmpSex = in.readInt();
        this.Sex = tmpSex == -1 ? null : GlogalBean.Sex.values()[tmpSex];
        this.StrTcmResult = in.readString();
        this.StrIdNumber = in.readString();
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
