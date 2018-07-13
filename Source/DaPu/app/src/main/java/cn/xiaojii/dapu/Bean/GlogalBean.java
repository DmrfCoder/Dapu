package cn.xiaojii.dapu.Bean;

public class GlogalBean {

    public enum Type {
        Questionnaire, SelfTest
    }

    public enum InformationType {
        TcmConstitutionIdentification,HypertensionQuestionnaire,HypertensionSelfTest,DiabetesQuestionnaire,DiabetesSelfTest,WaitYouChallage
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
