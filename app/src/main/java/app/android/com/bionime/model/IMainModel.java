package app.android.com.bionime.model;

import java.util.List;

import app.android.com.bionime.bean.DataBean;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public interface IMainModel {

    void setAQIDatas(List<DataBean> AQIData);

    void setSentence(String sentence);

    void setAQIDelete(int id, int is_delete);

    void setAllAQIRestore();

    List<DataBean> getAllAQIData();

    DataBean getAQIDataByPosition(int position);

    String getSentence();

    int getAQIDataSize();

}
