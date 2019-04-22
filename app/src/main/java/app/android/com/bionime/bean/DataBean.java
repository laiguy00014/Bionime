package app.android.com.bionime.bean;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class DataBean implements Serializable {


    /**
     * SiteName : 二林
     * County : 彰化縣
     * AQI : 97
     * Pollutant : 細懸浮微粒
     * Status : 普通
     * SO2 :
     * CO :
     * CO_8hr : 0.4
     * O3 :
     * O3_8hr : 24
     * PM10 : 72
     * PM2.5 : 39
     * NO2 :
     * NOx :
     * NO :
     * WindSpeed : 2.1
     * WindDirec : 347
     * PublishTime : 2019-04-18 10:00
     * PM2.5_AVG : 34
     * PM10_AVG : 85
     * SO2_AVG : 5
     * Longitude : 120.409653
     * Latitude : 23.925175
     */

    private String SiteName;
    private String County;
    private String AQI;
    private String Pollutant;
    private String Status;
    private String SO2;
    private String CO;
    private String CO_8hr;
    private String O3;
    private String O3_8hr;
    private String PM10;
    @SerializedName("PM2.5")
    private String _$PM25313; // FIXME check this code
    private String NO2;
    private String NOx;
    private String NO;
    private String WindSpeed;
    private String WindDirec;
    private String PublishTime;
    @SerializedName("PM2.5_AVG")
    private String _$PM25_AVG294; // FIXME check this code
    private String PM10_AVG;
    private String SO2_AVG;
    private String Longitude;
    private String Latitude;
    private int id;
    private int is_delete;

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getPollutant() {
        return Pollutant;
    }

    public void setPollutant(String Pollutant) {
        this.Pollutant = Pollutant;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSO2() {
        return SO2;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getCO_8hr() {
        return CO_8hr;
    }

    public void setCO_8hr(String CO_8hr) {
        this.CO_8hr = CO_8hr;
    }

    public String getO3() {
        return O3;
    }

    public void setO3(String O3) {
        this.O3 = O3;
    }

    public String getO3_8hr() {
        return O3_8hr;
    }

    public void setO3_8hr(String O3_8hr) {
        this.O3_8hr = O3_8hr;
    }

    public String getPM10() {
        return PM10;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public String get_$PM25313() {
        return _$PM25313;
    }

    public void set_$PM25313(String _$PM25313) {
        this._$PM25313 = _$PM25313;
    }

    public String getNO2() {
        return NO2;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public String getNOx() {
        return NOx;
    }

    public void setNOx(String NOx) {
        this.NOx = NOx;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(String WindSpeed) {
        this.WindSpeed = WindSpeed;
    }

    public String getWindDirec() {
        return WindDirec;
    }

    public void setWindDirec(String WindDirec) {
        this.WindDirec = WindDirec;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String PublishTime) {
        this.PublishTime = PublishTime;
    }

    public String get_$PM25_AVG294() {
        return _$PM25_AVG294;
    }

    public void set_$PM25_AVG294(String _$PM25_AVG294) {
        this._$PM25_AVG294 = _$PM25_AVG294;
    }

    public String getPM10_AVG() {
        return PM10_AVG;
    }

    public void setPM10_AVG(String PM10_AVG) {
        this.PM10_AVG = PM10_AVG;
    }

    public String getSO2_AVG() {
        return SO2_AVG;
    }

    public void setSO2_AVG(String SO2_AVG) {
        this.SO2_AVG = SO2_AVG;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}
