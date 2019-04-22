package app.android.com.bionime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.model.MainModel;

/**
 * Created by laiguanyu on 2019/4/22.
 */

public class MainReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("type").equals("aqi")){
            MainModel.getInstance().setAQIDatas((ArrayList<DataBean>)intent.getSerializableExtra("datas"));
        }else if (intent.getStringExtra("type").equals("sentence")){
            MainModel.getInstance().setSentence(intent.getStringExtra("sentence"));
        }
    }
}
