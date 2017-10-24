package test.com.hellogenio.presenters;

import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.List;


import test.com.hellogenio.api.DataApi;
import test.com.hellogenio.api.DataService;
import test.com.hellogenio.models.Data;
import test.com.hellogenio.utils.Constant;
import test.com.hellogenio.utils.SharedPreference;
import test.com.hellogenio.views.ListActivity;

/**
 * Created by kevin on 22/10/17.
 */

public class ListPresenter {
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

        mData = new DataService(mResultCallback,mView);
        mData.getDataVolley(Constant.DATA,Constant.DATA);
    }

   /* private List<Data> fetchResults(Response<ArrayData> response) {
        ArrayData data = response.body();
        return data.getResults();
    }*/
   void initVolleyCallback(){
       mResultCallback = new DataApi() {
           @Override
           public void notifySuccess(String requestType,JSONObject response) {
               Log.d(TAG, "Volley requester " + requestType);
               Log.d(TAG, "Volley JSON post" + response);
           }

           @Override
           public void notifyError(String requestType,VolleyError error) {
               Log.d(TAG, "Volley requester " + requestType);
               Log.d(TAG, "Volley JSON post" + "That didn't work!");
           }
       };
   }


    private void saveListDataSP(List<Data> dataList) {
        sp = new SharedPreference();
        sp.saveData(mView, dataList);

    }

    private void getListDataSP() {
        List<Data> dataList = sp.getData(mView);
        mView.displayData(dataList);
    }
}
