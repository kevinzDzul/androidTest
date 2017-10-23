package test.com.hellogenio.api;

import retrofit2.Call;
import retrofit2.http.GET;
import test.com.hellogenio.models.ArrayData;

/**
 * Created by kevin on 23/10/17.
 */

public interface DataService {

    @GET("data")
    Call<ArrayData>getAllData();


}
