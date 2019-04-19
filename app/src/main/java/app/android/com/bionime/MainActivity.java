package app.android.com.bionime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import app.android.com.bionime.adapter.MainAdapter;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.presenter.MainPresenter;
import app.android.com.bionime.view.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView{

    private static final String TAG = "MainActivity";
    private TextView tv_sentence;
    private RecyclerView recyclerView;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    private Button btn_restore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mainPresenter = new MainPresenter(this, this);
        bindData();
    }

    private void init(){
        tv_sentence = findViewById(R.id.tv_sentence);
        recyclerView = findViewById(R.id.recyclerView);
        btn_restore = findViewById(R.id.btn_restore);
    }

    private void bindData(){
        mainPresenter.setSentenceOnView();
        mainAdapter = new MainAdapter(mainPresenter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mainAdapter);
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
    public void setAQIDatas() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                synchronized (mainAdapter){
                    mainAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void setOnRestoreClick() {
        btn_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.setAllAQIRestore();
            }
        });
    }
}
