package app.android.com.bionime.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.android.com.bionime.R;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.presenter.IMainPresenter;
import app.android.com.bionime.presenter.MainPresenter;
import app.android.com.bionime.viewholder.MainViewHolder;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{

    private IMainPresenter mainPresenter;
    private List<DataBean> datas;


    public MainAdapter(List<DataBean> datas, IMainPresenter mainPresenter){
        this.datas = datas;
        this.mainPresenter = mainPresenter;
    }

    public void setData(List<DataBean> datas){
        this.datas = datas;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_aqi,null));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        final DataBean data = datas.get(position);
        holder.setAllData(data);
        holder.setOnDeleteClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.setAQIDelete(data.getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

}
