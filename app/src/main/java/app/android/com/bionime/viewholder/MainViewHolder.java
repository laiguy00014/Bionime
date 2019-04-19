package app.android.com.bionime.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.android.com.bionime.R;
import app.android.com.bionime.bean.DataBean;
import app.android.com.bionime.view.IAQICellView;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MainViewHolder extends RecyclerView.ViewHolder implements IAQICellView{

    TextView tv_site_name, tv_country, tv_aqi, tv_pollutant, tv_status, tv_so2, tv_co
            , tv_co_8hr, tv_o3, tv_o3_8hr, tv_pm10, tv_pm25, tv_no2, tv_nox, tv_no
            ,tv_wind_speed, tv_wind_direc, tv_publish_time, tv_pm25_avg, tv_pm10_avg
            ,tv_so2_avg, tv_longitude, tv_latitude;

    Button btn_delete;

    public MainViewHolder(View itemView) {
        super(itemView);
        tv_site_name = itemView.findViewById(R.id.tv_site_name);
        tv_country = itemView.findViewById(R.id.tv_country);
        tv_aqi = itemView.findViewById(R.id.tv_aqi);
        tv_pollutant = itemView.findViewById(R.id.tv_pollutant);
        tv_status = itemView.findViewById(R.id.tv_status);
        tv_so2 = itemView.findViewById(R.id.tv_so2);
        tv_co = itemView.findViewById(R.id.tv_co);
        tv_co_8hr = itemView.findViewById(R.id.tv_co_8hr);
        tv_o3 = itemView.findViewById(R.id.tv_o3);
        tv_o3_8hr = itemView.findViewById(R.id.tv_o3_8hr);
        tv_pm10 = itemView.findViewById(R.id.tv_pm10);
        tv_pm25 = itemView.findViewById(R.id.tv_pm25);
        tv_no2 = itemView.findViewById(R.id.tv_no2);
        tv_nox = itemView.findViewById(R.id.tv_nox);
        tv_no = itemView.findViewById(R.id.tv_no);
        tv_wind_speed = itemView.findViewById(R.id.tv_wind_speed);
        tv_wind_direc = itemView.findViewById(R.id.tv_wind_direc);
        tv_publish_time = itemView.findViewById(R.id.tv_publish_time);
        tv_pm25_avg = itemView.findViewById(R.id.tv_pm25_avg);
        tv_pm10_avg = itemView.findViewById(R.id.tv_pm10_avg);
        tv_so2_avg = itemView.findViewById(R.id.tv_so2_avg);
        tv_longitude = itemView.findViewById(R.id.tv_longitude);
        tv_latitude = itemView.findViewById(R.id.tv_latitude);
        btn_delete = itemView.findViewById(R.id.btn_delete);
    }

    @Override
    public void setAllData(DataBean dataBean) {
        setSiteName(dataBean.getSiteName());
        setCounty(dataBean.getCounty());
        setAQI(dataBean.getAQI());
        setPollutant(dataBean.getPollutant());
        setStatus(dataBean.getStatus());
        setSO2(dataBean.getSO2());
        setCO(dataBean.getCO());
        setCO_8hr(dataBean.getCO_8hr());
        setO3(dataBean.getO3());
        setO3_8hr(dataBean.getO3_8hr());
        setPM10(dataBean.getPM10());
        setPM25(dataBean.get_$PM25313());
        setNO2(dataBean.getNO2());
        setNOx(dataBean.getNOx());
        setNO(dataBean.getNO());
        setWindSpeed(dataBean.getWindSpeed());
        setWindDirec(dataBean.getWindDirec());
        setPublishTime(dataBean.getPublishTime());
        setPM25_AVG(dataBean.get_$PM25_AVG294());
        setPM10_AVG(dataBean.getPM10_AVG());
        setSO2_AVG(dataBean.getSO2_AVG());
        setLongitude(dataBean.getLongitude());
        setLatitude(dataBean.getLatitude());
    }

    @Override
    public void setSiteName(String SiteName) {
        tv_site_name.setText(SiteName);
    }

    @Override
    public void setCounty(String County) {
        tv_country.setText(County);
    }

    @Override
    public void setAQI(String AQI) {
        tv_aqi.setText(AQI);
    }

    @Override
    public void setPollutant(String Pollutant) {
        tv_pollutant.setText(Pollutant);
    }

    @Override
    public void setStatus(String Status) {
        tv_status.setText(Status);
    }

    @Override
    public void setSO2(String SO2) {
        tv_so2.setText(SO2);
    }

    @Override
    public void setCO(String CO) {
        tv_co.setText(CO);
    }

    @Override
    public void setCO_8hr(String CO_8hr) {
        tv_co_8hr.setText(CO_8hr);
    }

    @Override
    public void setO3(String O3) {
        tv_o3.setText(O3);
    }

    @Override
    public void setO3_8hr(String O3_8hr) {
        tv_o3_8hr.setText(O3_8hr);
    }

    @Override
    public void setPM10(String PM10) {
        tv_pm10.setText(PM10);
    }

    @Override
    public void setPM25(String PM25) {
        tv_pm25.setText(PM25);
    }

    @Override
    public void setNO2(String NO2) {
        tv_no2.setText(NO2);
    }

    @Override
    public void setNOx(String NOx) {
        tv_nox.setText(NOx);
    }

    @Override
    public void setNO(String NO) {
        tv_no.setText(NO);
    }

    @Override
    public void setWindSpeed(String WindSpeed) {
        tv_wind_speed.setText(WindSpeed);
    }

    @Override
    public void setWindDirec(String WindDirec) {
        tv_wind_direc.setText(WindDirec);
    }

    @Override
    public void setPublishTime(String PublishTime) {
        tv_publish_time.setText(PublishTime);
    }

    @Override
    public void setPM25_AVG(String PM25_AVG) {
        tv_pm25_avg.setText(PM25_AVG);
    }

    @Override
    public void setPM10_AVG(String PM10_AVG) {
        tv_pm10_avg.setText(PM10_AVG);
    }

    @Override
    public void setSO2_AVG(String SO2_AVG) {
        tv_so2_avg.setText(SO2_AVG);
    }

    @Override
    public void setLongitude(String Longitude) {
        tv_longitude.setText(Longitude);
    }

    @Override
    public void setLatitude(String Latitude) {
        tv_latitude.setText(Latitude);
    }

    @Override
    public void setOnDeleteClick(View.OnClickListener onDeleteClick) {
        btn_delete.setOnClickListener(onDeleteClick);
    }
}
