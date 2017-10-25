package test.com.hellogenio.api;


import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import test.com.hellogenio.models.ArrayData;
import test.com.hellogenio.tools.Constant;
import test.com.hellogenio.tools.GsonRequest;
import test.com.hellogenio.tools.MySingleton;

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

     public void getDataVolley(String url){

          MySingleton.getInstance(mContext).addToRequestQueue(new GsonRequest<ArrayData>(
                  Constant.URL+url,
                  ArrayData.class,
                  null,
                  new Response.Listener<ArrayData>(){
                       @Override
                       public void onResponse(ArrayData response) {
                            if(mResultCallback != null)
                                 mResultCallback.notifySuccess(response);
                       }
                  },
                  new Response.ErrorListener(){
                       @Override
                       public void onErrorResponse(VolleyError error) {
                            if(mResultCallback != null)
                                 mResultCallback.notifyError(error);
                       }
                  }

          ));


          /*try {


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

          }*/

     }

    /*@GET("data")
    Call<ArrayData>getAllData();*/


}
