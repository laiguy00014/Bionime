package app.android.com.bionime.presenter;

import android.content.Intent;

import java.util.List;

import app.android.com.bionime.bean.DataBean;

/**
 * Created by laiguanyu on 2019/4/22.
 */

public interface IMainPresenter {
    void setAllAQIRestore();
    void setAQIDelete(int id);
    void getLocalSentence();
    void getLocalAQIDatas();
    void handleIntent(Intent intent);
}
