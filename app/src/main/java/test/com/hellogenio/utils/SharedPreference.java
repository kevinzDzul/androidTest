package test.com.hellogenio.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.com.hellogenio.models.DataObj;

/**
 * Created by kevin on 23/10/17.
 */

public class SharedPreference {
    public static final String PREFS_NAME = "DATA_APP";
    public static final String DATA = "list_data";

    public SharedPreference() {
        super();
    }

    public void saveData(Context context, List<DataObj> dataObjList) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonData = gson.toJson(dataObjList);

        editor.putString(DATA, jsonData);

        editor.commit();
    }


    public List<DataObj> getData(Context context) {
        SharedPreferences settings;
        List<DataObj> dataObjList;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(DATA)) {
            String jsonData = settings.getString(DATA, null);
            Gson gson = new Gson();
            DataObj[] dataObjItems = gson.fromJson(jsonData,
                    DataObj[].class);

            dataObjList = Arrays.asList(dataObjItems);
            dataObjList = new ArrayList<DataObj>(dataObjList);
        } else
            return null;

        return (ArrayList<DataObj>) dataObjList;
    }
}
