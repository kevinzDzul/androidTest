package test.com.hellogenio.api;


import com.android.volley.VolleyError;

import org.json.JSONObject;

import test.com.hellogenio.models.ArrayData;

/**
 * Created by kevin on 22/10/17.
 */

public interface DataApi {

    void notifySuccess(ArrayData response);
    void notifyError(VolleyError error);

    //private static Retrofit retrofit = null;

    /*public static Retrofit getTestData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.hellogenio.com/common/global/test/android/sample/")
                    .build();
        }

        return retrofit;
    }*/

}
