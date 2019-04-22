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
import app.android.com.bionime.presenter.MainPresenter;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainModel implements IMainModel {

    private static final String TAG = "MainModel";
    private List<DataBean> AQIDatas;
    private String sentence;
    private NetworkClient networkClient;
    private LocalClient localClient;
    private MainPresenter mainPresenter;
    private Context context;
    private boolean isLocalAQIDataNull = false;
    private static MainModel mainModel;

    public static MainModel getInstance(){
        return mainModel;
    }

    public MainModel(MainPresenter mainPresenter, Context context){

        this.mainPresenter = mainPresenter;
        this.context = context;
        networkClient = new NetworkClient(context);
        localClient = new LocalClient(context);
        getSentenceFromLocal();
        getAQIDataFromLocal();
        startTimer();
        mainModel = this;
    }

    @Override
    public void setAQIDatas(List<DataBean> AQIDatas) {
//        this.AQIDatas = AQIDatas;
        MySqlite mySqlite = MySqlite.getInstance(context);
        if (isLocalAQIDataNull){
            mySqlite.insertAllAQIDatas(AQIDatas);
            isLocalAQIDataNull = false;
        }else {
            mySqlite.updateAllAQIDatas(AQIDatas);
        }

        this.AQIDatas = mySqlite.getAllAQIDatasWithoutDelete();
        mainPresenter.setAQIDataOnView();

    }

    @Override
    public void setSentence(String sentence) {
        this.sentence = sentence;
        mainPresenter.setSentenceOnView();
        context.getSharedPreferences("sentence",Context.MODE_PRIVATE).edit().putString("sentence",sentence).commit();
    }

    @Override
    public List<DataBean> getAllAQIData() {
        return AQIDatas;
    }

    @Override
    public String getSentence() {
        return sentence;
    }

    @Override
    public DataBean getAQIDataByPosition(int position) {
        return AQIDatas.get(position);
    }

    @Override
    public int getAQIDataSize() {
        if (AQIDatas == null) return 0;
        return AQIDatas.size();
    }

    private void startTimer(){
        new Timer().schedule(task1,0,30 * 60 * 1000);
        new Timer().schedule(task2,0, 12 * 60 * 60 * 1000);
    }

    private void getSentenceFromLocal(){
        sentence = localClient.getSentence();
    }

    private void getAQIDataFromLocal(){
        AQIDatas = localClient.getAQIDatas();
        if (AQIDatas == null){
            isLocalAQIDataNull = true;
        }else{
            isLocalAQIDataNull = false;
        }
    }

    private void getAQIDataFromInternet(String url, MainModel mainModel){
        networkClient.getAQIData(url);
    }

    private void getSentenceFromInternet(String url, MainModel mainModel) {
        networkClient.getSentence(url);
    }

    private TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            getAQIDataFromInternet("http://opendata.epa.gov.tw/webapi/Data/REWIQA/?$orderby=SiteName&$skip=0&$top=1000&format=json", MainModel.this);
        }
    };

    private TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            getSentenceFromInternet("https://tw.appledaily.com/index/dailyquote/", MainModel.this);
        }
    };

    @Override
    public void setAQIDelete(int position, int is_delete) {
        AQIDatas.remove(position);
        MySqlite.getInstance(context).updateIsDelete(AQIDatas.get(position).getId(),1);
        Log.d(TAG, "setAQIDelete: AQIDatas.size = " + AQIDatas.size());
    }

    @Override
    public void setAllAQIRestore() {
        MySqlite.getInstance(context).restoreIsDelete();
        AQIDatas = MySqlite.getInstance(context).getAllAQIDatasWithoutDelete();
        Log.d(TAG, "setAllAQIRestore: AQIDatas.size = " + AQIDatas.size());
    }


}
