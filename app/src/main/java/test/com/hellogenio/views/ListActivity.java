package test.com.hellogenio.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.hellogenio.R;
import test.com.hellogenio.adapters.DataAdapter;
import test.com.hellogenio.api.DataApi;
import test.com.hellogenio.api.DataService;
import test.com.hellogenio.models.Data;
import test.com.hellogenio.presenters.ListPresenter;
import test.com.hellogenio.utils.Constant;
import test.com.hellogenio.utils.NetworkUtil;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.main_recycler)
    RecyclerView mRecyclerView;

    @BindView(R.id.main_progress)
    ProgressBar mProgressBar;

    private DataAdapter mDataAdapter;
    private ListPresenter mListPresenter;
    private DataService dataService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        //DataService dataService = DataApi.getTestData().create(DataService.class);

        mListPresenter = new ListPresenter(this,dataService);
        mListPresenter.loadData();

        LinearLayoutManager mLinearLayout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayout);
        mDataAdapter = new DataAdapter(this);
        mRecyclerView.setAdapter(mDataAdapter);


    }


    public void displayData(List<Data> mListData) {

        mDataAdapter.addAll(mListData);
        mProgressBar.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        IntentFilter inF = new IntentFilter("statusNetwork");
        LocalBroadcastManager.getInstance(this).registerReceiver(dataChangeReceiver, inF);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(dataChangeReceiver);
    }

    /***  receptor **/
    private BroadcastReceiver dataChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int  status = NetworkUtil.getConnectivityStatusString(context);

            switch (status){

                case Constant.TYPE_WIFI:
                    mListPresenter.loadData();
                    break;

                case Constant.TYPE_MOBILE:
                    mListPresenter.loadData();
                    break;

            }
        }
    };
}
