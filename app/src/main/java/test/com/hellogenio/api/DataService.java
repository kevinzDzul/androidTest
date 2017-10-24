package test.com.hellogenio.api;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import test.com.hellogenio.utils.Constant;

/**
 * Created by kevin on 23/10/17.
 */

public class DataService {

     DataApi mResultCallback = null;
     Context mContext;

     public DataService(DataApi mResultCallback, Context mContext) {
          this.mResultCallback = mResultCallback;
          this.mContext = mContext;
     }

     public void getDataVolley(final String requestType, String url){

          try {


               RequestQueue queue = Volley.newRequestQueue(mContext);
               JsonObjectRequest jsonObj = new JsonObjectRequest(Constant.URL+url,null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                         if(mResultCallback != null)
                              mResultCallback.notifySuccess(requestType, response);
                    }
               }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                         if(mResultCallback != null)
                              mResultCallback.notifyError(requestType, error);
                    }
               });

               queue.add(jsonObj);

          }catch (Exception e){

          }

     }

    /*@GET("data")
    Call<ArrayData>getAllData();*/


}
