package test.com.hellogenio.tools.asyncTask;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import test.com.hellogenio.models.Data;
import test.com.hellogenio.models.DataObj;
import test.com.hellogenio.models.Footer;
import test.com.hellogenio.models.Header;
import test.com.hellogenio.tools.Constant;
import test.com.hellogenio.tools.interfaces.ListItem;

/**
 * Created by kevin on 24/10/17.
 */

public class AsyncTaskGetDataSP extends AsyncTask<List<DataObj>, Void, List<ListItem>> {


    public ResultGetData delegate = null;

    public interface ResultGetData {
        void onResult(List<ListItem> listItems);
    }

    public AsyncTaskGetDataSP(ResultGetData delegate) {
        this.delegate = delegate;
    }

    @Override
    protected List<ListItem> doInBackground(List<DataObj>... params) {

        List<ListItem> listItems = new ArrayList<>();

        if (params[0] == null)
            return listItems;

        int count = 0;
        DataObj temp_dataObj = null;
        for (DataObj item : params[0]) {

            if (item.getType() == null)
                continue;

            switch (item.getType()) {

                case Constant.TYPE_HEADER:

                    if (count > 0)
                        listItems.set(0, new Header(item.getType(), item.getName(), item.getText(), item.getImage()));

                    listItems.add(new Header(item.getType(), item.getName(), item.getText(), item.getImage()));

                    break;


                case Constant.TYPE_DATA_0:
                case Constant.TYPE_DATA_1:

                    listItems.add(new Data(item.getType(), item.getText(), item.getImage()));

                    break;


                case Constant.TYPE_FOOTER:

                    temp_dataObj = item;

                    break;
            }
            count++;

        }

        if (temp_dataObj != null)
            listItems.add(new Footer(temp_dataObj.getType(), temp_dataObj.getName(), temp_dataObj.getText()));


        return listItems;
    }

    @Override
    protected void onPostExecute(List<ListItem> listItems) {
        super.onPostExecute(listItems);

        if (!isCancelled())
            delegate.onResult(listItems);
    }
}
