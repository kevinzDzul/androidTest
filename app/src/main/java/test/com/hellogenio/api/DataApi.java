package test.com.hellogenio.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kevin on 22/10/17.
 */

public class DataApi {

    private static Retrofit retrofit = null;

    public static Retrofit getTestData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.hellogenio.com/common/global/test/android/sample/")
                    .build();
        }

        return retrofit;
    }

}
