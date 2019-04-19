package app.android.com.bionime.view;

import android.view.View;

import app.android.com.bionime.bean.DataBean;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public interface IAQICellView {

    public void setAllData(DataBean dataBean);

    public void setSiteName(String SiteName);

    public void setCounty(String County);

    public void setAQI(String AQI);

    public void setPollutant(String Pollutant);

    public void setStatus(String Status);

    public void setSO2(String SO2);

    public void setCO(String CO);

    public void setCO_8hr(String CO_8hr);

    public void setO3(String O3);

    public void setO3_8hr(String O3_8hr);

    public void setPM10(String PM10);

    public void setPM25(String PM25);

    public void setNO2(String NO2);

    public void setNOx(String NOx);

    public void setNO(String NO);

    public void setWindSpeed(String WindSpeed);

    public void setWindDirec(String WindDirec);

    public void setPublishTime(String PublishTime);

    public void setPM25_AVG(String PM25_AVG);

    public void setPM10_AVG(String PM10_AVG);

    public void setSO2_AVG(String SO2_AVG);

    public void setLongitude(String Longitude);

    public void setLatitude(String Latitude);

    public void setOnDeleteClick(View.OnClickListener onDeleteClick);
}
