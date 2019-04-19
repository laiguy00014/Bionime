package app.android.com.bionime.presenter;

import android.content.Context;
import android.view.View;

import java.util.List;

import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.model.IMainModel;
import app.android.com.bionime.model.MainModel;
import app.android.com.bionime.view.IAQICellView;
import app.android.com.bionime.view.IMainView;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainPresenter {
    private IMainModel iMainModel;
    private IMainView iMainView;


    public MainPresenter(IMainView iMainView, Context context) {
        this.iMainView = iMainView;
        iMainModel = new MainModel(this, context);

    }

    public void onBindViewHolder(final int position, IAQICellView iaqiCellView){
        iaqiCellView.setAllData(iMainModel.getAQIDataByPosition(position));
        iaqiCellView.setOnDeleteClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iMainModel.setAQIDelete(position,1);
            }
        });
    }

    public int getAQICount(){
        return iMainModel.getAQIDataSize();
    }

    public void setSentenceOnView(){
        iMainView.setSentence(iMainModel.getSentence());
    }

    public void setAQIDataOnView(){
        iMainView.setAQIDatas();
    }

    public void setAllAQIRestore(){
        iMainModel.setAllAQIRestore();
    }
}
