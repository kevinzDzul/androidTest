package test.com.hellogenio.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 23/10/17.
 */

public class ArrayData {

    @SerializedName("array")
    @Expose
    private List<DataObj> results = new ArrayList<DataObj>();

    public List<DataObj> getResults() {
        return results;
    }

}
