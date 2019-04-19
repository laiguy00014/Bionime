package app.android.com.bionime.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;

import app.android.com.bionime.R;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.presenter.MainPresenter;
import app.android.com.bionime.viewholder.MainViewHolder;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainAdapter extends RecyclerView.Adapter{

    private MainPresenter mainPresenter;

    public MainAdapter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_aqi,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mainPresenter.onBindViewHolder(position, (MainViewHolder)holder);
    }

    @Override
    public int getItemCount() {
        return mainPresenter.getAQICount();
    }


}
