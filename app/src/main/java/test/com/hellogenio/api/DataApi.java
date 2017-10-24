package test.com.hellogenio.api;


import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by kevin on 22/10/17.
 */

public interface DataApi {

    void notifySuccess(String requestType,JSONObject response);
    void notifyError(String requestType,VolleyError error);

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
