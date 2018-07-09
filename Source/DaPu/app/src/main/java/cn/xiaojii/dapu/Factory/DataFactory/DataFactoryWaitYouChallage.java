package cn.xiaojii.dapu.Factory.DataFactory;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.dapu.Bean.QuestionAnwserWaitYouChallageBean;

public class DataFactoryWaitYouChallage {
    public List<QuestionAnwserWaitYouChallageBean> questionAnwserWaitYouChallageBeanList;

    public DataFactoryWaitYouChallage() {
        questionAnwserWaitYouChallageBeanList=new ArrayList<>();

    }

    public List<QuestionAnwserWaitYouChallageBean> getQuestionAnwserWaitYouChallageBeanList() {
        return questionAnwserWaitYouChallageBeanList;
    }
}
