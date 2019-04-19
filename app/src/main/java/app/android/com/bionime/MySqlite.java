package app.android.com.bionime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import app.android.com.bionime.bean.DataBean;

/**
 * Created by laiguanyu on 2019/4/19.
 */

public class MySqlite extends SQLiteOpenHelper {
    private static String DB_NAME = "MainDB.db";
    private static int DB_VERSION = 1;
    private String DB_TABLE_MAIN = "MainTable";
    private static MySqlite instance;
    private final String ID = "_id";
    private final String SITE_NAME = "site_name";
    private final String COUNTRY = "country";
    private final String AQI = "aqi";
    private final String POLLUTANT = "pollutant";
    private final String STATUS = "status";
    private final String SO2 = "so2";
    private final String CO = "co";
    private final String CO_8HR = "co_8hr";
    private final String O3 = "o3";
    private final String O3_8HR = "o3_8hr";
    private final String PM10 = "pm10";
    private final String PM25 = "pm25";
    private final String NO2 = "no2";
    private final String NOX = "nox";
    private final String NO = "no";
    private final String WIND_SPEED = "wind_speed";
    private final String WIND_DIREC = "wind_direc";
    private final String PUBLISH_TIME = "publish_time";
    private final String PM25_AVG = "pm25_avg";
    private final String PM10_AVG = "pm10_avg";
    private final String SO2_AVG = "so2_avg";
    private final String LONGITUDE = "longitude";
    private final String LATITUDE = "latitude";
    private final String IS_DELETE = "is_delete";


    private Cursor cursor;
    public static MySqlite getInstance(Context ctx){
        if (instance==null){
            instance = new MySqlite(ctx, DB_NAME, null, DB_VERSION);
        }
        return instance;
    }

    private MySqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlStr = "CREATE TABLE IF NOT EXISTS " + DB_TABLE_MAIN
                + " (  "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SITE_NAME + " TEXT NOT NULL, "
                + COUNTRY + " TEXT NOT NULL, "
                + AQI + " TEXT NOT NULL, "
                + POLLUTANT + " TEXT NOT NULL, "
                + STATUS + " TEXT NOT NULL, "
                + SO2 + " TEXT NOT NULL, "
                + CO + " TEXT NOT NULL, "
                + CO_8HR + " TEXT NOT NULL, "
                + O3 + " TEXT NOT NULL, "
                + O3_8HR + " TEXT NOT NULL, "
                + PM10 + " TEXT NOT NULL, "
                + PM25 + " TEXT NOT NULL, "
                + NO2 + " TEXT NOT NULL, "
                + NOX + " TEXT NOT NULL, "
                + NO + " TEXT NOT NULL, "
                + WIND_SPEED + " TEXT NOT NULL, "
                + WIND_DIREC + " TEXT NOT NULL, "
                + PUBLISH_TIME + " TEXT NOT NULL, "
                + PM25_AVG + " TEXT NOT NULL, "
                + PM10_AVG + " TEXT NOT NULL, "
                + SO2_AVG + " TEXT NOT NULL, "
                + LONGITUDE + " TEXT NOT NULL, "
                + LATITUDE + " TEXT NOT NULL, "
                + IS_DELETE + " INTEGER NOT NULL "
                + ");";

        db.execSQL(sqlStr);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<DataBean> getAllAQIDatas()
    {
        List<DataBean> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.query(DB_TABLE_MAIN, null, null, null, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount() == 0){
            return null;
        }
        do{
            list.add(formateDataBean(cursor));
        }while (cursor.moveToNext());

        return list;
    }

    public List<DataBean> getAllAQIDatasWithoutDelete()
    {
        List<DataBean> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.query(DB_TABLE_MAIN, null, null, null, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount() == 0){
            return null;
        }
        do{
            DataBean dataBean = formateDataBean(cursor);
            if (dataBean.getIs_delete() == 0){
                list.add(formateDataBean(cursor));
            }
        }while (cursor.moveToNext());

        return list;
    }

    public DataBean formateDataBean(Cursor cursor){
        DataBean dataBean = new DataBean();
        dataBean.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        dataBean.setSiteName(cursor.getString(cursor.getColumnIndex(SITE_NAME)));
        dataBean.setCounty(cursor.getString(cursor.getColumnIndex(COUNTRY)));
        dataBean.setAQI(cursor.getString(cursor.getColumnIndex(AQI)));
        dataBean.setPollutant(cursor.getString(cursor.getColumnIndex(POLLUTANT)));
        dataBean.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
        dataBean.setSO2(cursor.getString(cursor.getColumnIndex(SO2)));
        dataBean.setCO(cursor.getString(cursor.getColumnIndex(CO)));
        dataBean.setCO_8hr(cursor.getString(cursor.getColumnIndex(CO_8HR)));
        dataBean.setO3(cursor.getString(cursor.getColumnIndex(O3)));
        dataBean.setO3_8hr(cursor.getString(cursor.getColumnIndex(O3_8HR)));
        dataBean.setPM10(cursor.getString(cursor.getColumnIndex(PM10)));
        dataBean.set_$PM25313(cursor.getString(cursor.getColumnIndex(PM25)));
        dataBean.setNO2(cursor.getString(cursor.getColumnIndex(NO2)));
        dataBean.setNOx(cursor.getString(cursor.getColumnIndex(NOX)));
        dataBean.setNO(cursor.getString(cursor.getColumnIndex(NO)));
        dataBean.setWindSpeed(cursor.getString(cursor.getColumnIndex(WIND_SPEED)));
        dataBean.setWindDirec(cursor.getString(cursor.getColumnIndex(WIND_DIREC)));
        dataBean.setPublishTime(cursor.getString(cursor.getColumnIndex(PUBLISH_TIME)));
        dataBean.set_$PM25_AVG294(cursor.getString(cursor.getColumnIndex(PM25_AVG)));
        dataBean.setPM10_AVG(cursor.getString(cursor.getColumnIndex(PM10_AVG)));
        dataBean.setSO2_AVG(cursor.getString(cursor.getColumnIndex(SO2_AVG)));
        dataBean.setLongitude(cursor.getString(cursor.getColumnIndex(LONGITUDE)));
        dataBean.setLatitude(cursor.getString(cursor.getColumnIndex(LATITUDE)));
        dataBean.setIs_delete(cursor.getInt(cursor.getColumnIndex(IS_DELETE)));
        return dataBean;
    }

    public void insertAllAQIDatas(List<DataBean> datas){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DB_TABLE_MAIN, null, null);

        for(int i = 0 ; i < datas.size() ; i++){
            ContentValues cv = new ContentValues();
            cv.put(ID, i);
            cv.put(SITE_NAME, datas.get(i).getSiteName());
            cv.put(COUNTRY, datas.get(i).getCounty());
            cv.put(AQI, datas.get(i).getAQI());
            cv.put(POLLUTANT, datas.get(i).getPollutant());
            cv.put(STATUS, datas.get(i).getStatus());
            cv.put(SO2, datas.get(i).getSO2());
            cv.put(CO, datas.get(i).getCO());
            cv.put(CO_8HR, datas.get(i).getCO_8hr());
            cv.put(O3, datas.get(i).getO3());
            cv.put(O3_8HR, datas.get(i).getO3_8hr());
            cv.put(PM10, datas.get(i).getPM10());
            cv.put(PM25, datas.get(i).get_$PM25313());
            cv.put(NO2, datas.get(i).getNO2());
            cv.put(NOX, datas.get(i).getNOx());
            cv.put(NO, datas.get(i).getNO());
            cv.put(WIND_SPEED, datas.get(i).getWindSpeed());
            cv.put(WIND_DIREC, datas.get(i).getWindDirec());
            cv.put(PUBLISH_TIME, datas.get(i).getPublishTime());
            cv.put(PM25_AVG, datas.get(i).get_$PM25_AVG294());
            cv.put(PM10_AVG, datas.get(i).getPM10_AVG());
            cv.put(SO2_AVG, datas.get(i).getSO2_AVG());
            cv.put(LONGITUDE, datas.get(i).getLongitude());
            cv.put(LATITUDE, datas.get(i).getLatitude());
            cv.put(IS_DELETE, 0);//預設false
            db.insert(DB_TABLE_MAIN, null, cv);

        }
    }

    public void updateAllAQIDatas(List<DataBean> datas){
        SQLiteDatabase db = this.getWritableDatabase();

        for (DataBean dataBean : datas){
            ContentValues values = new ContentValues();
            values.put(AQI, dataBean.getAQI());
            values.put(POLLUTANT, dataBean.getPollutant());
            values.put(STATUS, dataBean.getStatus());
            values.put(SO2, dataBean.getSO2());
            values.put(CO, dataBean.getCO());
            values.put(CO_8HR, dataBean.getCO_8hr());
            values.put(O3, dataBean.getO3());
            values.put(O3_8HR, dataBean.getO3_8hr());
            values.put(PM10, dataBean.getPM10());
            values.put(PM25, dataBean.get_$PM25313());
            values.put(NO2, dataBean.getNO2());
            values.put(NOX, dataBean.getNOx());
            values.put(NO, dataBean.getNO());
            values.put(WIND_SPEED, dataBean.getWindSpeed());
            values.put(WIND_DIREC, dataBean.getWindDirec());
            values.put(PUBLISH_TIME, dataBean.getPublishTime());
            values.put(PM25_AVG, dataBean.get_$PM25_AVG294());
            values.put(PM10_AVG, dataBean.getPM10_AVG());
            values.put(SO2_AVG, dataBean.getSO2_AVG());
            values.put(LONGITUDE, dataBean.getLongitude());
            values.put(LATITUDE, dataBean.getLatitude());
            db.update(DB_TABLE_MAIN,values,SITE_NAME + " = '"+ dataBean.getSiteName() + "' and " + COUNTRY + " = '" + dataBean.getCounty() + "'",null);
        }

    }

    public void updateIsDelete(int id, int is_delete){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IS_DELETE, is_delete);
        db.update(DB_TABLE_MAIN,values,ID + " = "+ id,null);
    }

    public void restoreIsDelete(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IS_DELETE, 0);
        db.update(DB_TABLE_MAIN,values,IS_DELETE + " = 1",null);
    }


    @Override
    public synchronized void close() {
        super.close();
        instance = null;
    }
}
