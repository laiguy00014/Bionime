package app.android.com.bionime.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import app.android.com.bionime.R;
import app.android.com.bionime.adapter.MainAdapter;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.presenter.IMainPresenter;
import app.android.com.bionime.presenter.MainPresenter;
import app.android.com.bionime.view.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView{

    private static final String TAG = "MainActivity";
    private TextView tv_sentence;
    private RecyclerView recyclerView;
    private IMainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    private Button btn_restore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mainReceiver, new IntentFilter("app.android.com.bionime.broadcast"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mainReceiver);
    }

    public BroadcastReceiver mainReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ");
            mainPresenter.handleIntent(intent);
        }
    };

    private void init(){
        tv_sentence = findViewById(R.id.tv_sentence);
        recyclerView = findViewById(R.id.recyclerView);
        btn_restore = findViewById(R.id.btn_restore);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }

    private void bindData(){
        mainPresenter = new MainPresenter(this, this);
        btn_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.setAllAQIRestore();
            }
        });

        mainPresenter.getLocalSentence();

        mainPresenter.getLocalAQIDatas();
    }

    @Override
    public void setSentence(final String sentence) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_sentence.setText(sentence);
            }
        });
    }

    @Override
    public void setAQIDatas(List<DataBean> datas) {
        mainAdapter = new MainAdapter(datas, mainPresenter);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void notifyRecyclerView(final List<DataBean> datas) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                synchronized (mainAdapter){
                    mainAdapter.setData(datas);
                    mainAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
