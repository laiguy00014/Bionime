package app.android.com.bionime;

import android.content.Context;

import java.util.List;

import app.android.com.bionime.bean.DataBean;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class LocalClient {

    private Context context;

    public LocalClient(Context context) {
        this.context = context;
    }

    public String getSentence(){
        return context.getSharedPreferences("sentence", Context.MODE_PRIVATE).getString("sentence","");
    }

    public List<DataBean> getAQIDatas(){
        return MySqlite.getInstance(context).getAllAQIDatasWithoutDelete(true);
    }
}
