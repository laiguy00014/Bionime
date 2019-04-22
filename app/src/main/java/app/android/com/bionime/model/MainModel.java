package app.android.com.bionime.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import app.android.com.bionime.LocalClient;
import app.android.com.bionime.MySqlite;
import app.android.com.bionime.NetworkClient;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.presenter.IMainPresenter;
import app.android.com.bionime.presenter.MainPresenter;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainModel implements IMainModel {

    private static final String TAG = "MainModel";
    private NetworkClient networkClient;
    private LocalClient localClient;
    private Context context;
    private boolean isLocalAQIDataNull = false;

    public MainModel(Context context){
        this.context = context;
        networkClient = new NetworkClient(context);
        localClient = new LocalClient(context);
        isLocalAQIDataNull = (localClient.getAQIDatas() == null);
    }

    @Override
    public void setAQIDatas(List<DataBean> datas) {
        MySqlite mySqlite = MySqlite.getInstance(context);
        if (isLocalAQIDataNull){
            mySqlite.insertAllAQIDatas(datas);
            isLocalAQIDataNull = false;
        }else {
            mySqlite.updateAllAQIDatas(datas);
        }
    }

    @Override
    public void setSentence(String sentence) {
        context.getSharedPreferences("sentence",Context.MODE_PRIVATE).edit().putString("sentence",sentence).commit();
    }


    @Override
    public String getLocalSentence() {
        return localClient.getSentence();
    }

    @Override
    public List<DataBean> getLocalAQIDatas() {
        return localClient.getAQIDatas();
    }

    @Override
    public void getNetworkAQIData(String url){
        networkClient.getAQIData(url);
    }

    @Override
    public void getNetworkSentence(String url) {
        networkClient.getSentence(url);
    }

    @Override
    public void setAQIDelete(int id, int is_delete) {
        MySqlite.getInstance(context).updateIsDelete(id,1);
    }

    @Override
    public void setAllAQIRestore() {
        MySqlite.getInstance(context).restoreIsDelete();
    }


}
