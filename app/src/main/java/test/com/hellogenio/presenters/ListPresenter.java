package test.com.hellogenio.presenters;

import java.util.List;


import test.com.hellogenio.api.DataService;
import test.com.hellogenio.models.Data;
import test.com.hellogenio.utils.SharedPreference;
import test.com.hellogenio.views.ListActivity;

/**
 * Created by kevin on 22/10/17.
 */

public class ListPresenter {

    ListActivity mView;
    DataService mData;
    SharedPreference sp;

    public ListPresenter(ListActivity mView, DataService mData) {
        this.mView = mView;
        this.mData = mData;
        sp = new SharedPreference();
    }

    public void loadData() {

        /*mData.getAllData().enqueue(new Callback<ArrayData>() {
            @Override
            public void onResponse(Call<ArrayData> call, Response<ArrayData> response) {

                List<Data> mListData = fetchResults(response);

                saveListDataSP(mListData);
                getListDataSP();


            }

            @Override
            public void onFailure(Call<ArrayData> call, Throwable t) {
                t.printStackTrace();
                getListDataSP();
            }
        });*/

    }

   /* private List<Data> fetchResults(Response<ArrayData> response) {
        ArrayData data = response.body();
        return data.getResults();
    }*/

    private void saveListDataSP(List<Data> dataList) {
        sp = new SharedPreference();
        sp.saveData(mView, dataList);

    }

    private void getListDataSP() {
        List<Data> dataList = sp.getData(mView);
        mView.displayData(dataList);
    }
}
