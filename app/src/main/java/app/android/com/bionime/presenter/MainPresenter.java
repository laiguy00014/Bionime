package app.android.com.bionime.presenter;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.model.IMainModel;
import app.android.com.bionime.model.MainModel;
import app.android.com.bionime.view.IMainView;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainPresenter implements IMainPresenter{
    private IMainModel iMainModel;
    private IMainView iMainView;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        iMainModel = new MainModel(iMainView);
        startTimer();
    }

    @Override
    public void setAllAQIRestore() {
        iMainModel.setAllAQIRestore();
        iMainView.notifyRecyclerView(iMainModel.getLocalAQIDatas());
    }

    @Override
    public void setAQIDelete(int id) {
        iMainModel.setAQIDelete(id,1);
        iMainView.notifyRecyclerView(iMainModel.getLocalAQIDatas());
    }

    @Override
    public void getLocalSentence() {
        iMainView.setSentence(iMainModel.getLocalSentence());
    }

    @Override
    public void getLocalAQIDatas() {
        List<DataBean> datas = iMainModel.getLocalAQIDatas();
        if (datas == null){
            iMainView.setAQIDatas(new ArrayList<DataBean>());
        }else {
            iMainView.setAQIDatas(datas);
        }

    }

    @Override
    public void handleIntent(Intent intent) {
        if (intent.getStringExtra("type").equals("aqi")){
            iMainModel.setAQIDatas((ArrayList<DataBean>)intent.getSerializableExtra("datas"));
            iMainView.setAQIDatas(iMainModel.getLocalAQIDatas());
        }else if (intent.getStringExtra("type").equals("sentence")){
            iMainModel.setSentence(intent.getStringExtra("sentence"));
            iMainView.setSentence(iMainModel.getLocalSentence());
        }
    }

    private void startTimer(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                iMainModel.getNetworkAQIData("http://opendata.epa.gov.tw/webapi/Data/REWIQA/?$orderby=SiteName&$skip=0&$top=1000&format=json");
            }
        },0,30 * 60 * 1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                iMainModel.getNetworkSentence("https://tw.appledaily.com/index/dailyquote/");
            }
        },0, 12 * 60 * 60 * 1000);
    }

}
