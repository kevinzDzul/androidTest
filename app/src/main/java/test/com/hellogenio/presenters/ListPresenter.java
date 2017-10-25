package test.com.hellogenio.presenters;

import android.util.Log;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;


import test.com.hellogenio.api.DataApi;
import test.com.hellogenio.api.DataService;
import test.com.hellogenio.models.ArrayData;
import test.com.hellogenio.models.Data;
import test.com.hellogenio.models.DataObj;
import test.com.hellogenio.models.Footer;
import test.com.hellogenio.models.Header;
import test.com.hellogenio.tools.Constant;
import test.com.hellogenio.tools.asyncTask.AsyncTaskGetDataSP;
import test.com.hellogenio.tools.interfaces.ListItem;
import test.com.hellogenio.utils.SharedPreference;
import test.com.hellogenio.views.ListActivity;

/**
 * Created by kevin on 22/10/17.
 */

public class ListPresenter implements AsyncTaskGetDataSP.ResultGetData {
    private String TAG = "ListPresenter";
    ListActivity mView;
    DataService mData;
    DataApi mResultCallback;
    SharedPreference sp;

    public ListPresenter(ListActivity mView, DataService mData) {
        this.mView = mView;
        this.mData = mData;
        sp = new SharedPreference();
        initVolleyCallback();
    }

    public void loadData() {

        mData = new DataService(mResultCallback, mView);
        mData.getDataVolley(Constant.DATA);
    }


    void initVolleyCallback() {
        mResultCallback = new DataApi() {
            @Override
            public void notifySuccess(ArrayData response) {

                saveListDataSP(response.getResults());
                getListDataSP();

            }

            @Override
            public void notifyError(VolleyError error) {
                getListDataSP();
                Log.d(TAG, "Volley JSON post" + "That didn't work!");
            }
        };
    }


    private void saveListDataSP(List<DataObj> dataObjList) {
        sp = new SharedPreference();
        sp.saveData(mView, dataObjList);

    }


    public void getListDataSP() {
        List<DataObj> dataObjList = sp.getData(mView);
        new AsyncTaskGetDataSP(this).execute(dataObjList);
    }

    @Override
    public void onResult(List<ListItem> listItems) {
        mView.displayData(listItems);
    }
}
