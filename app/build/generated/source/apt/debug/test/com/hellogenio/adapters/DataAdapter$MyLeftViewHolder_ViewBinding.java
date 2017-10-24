// Generated code from Butter Knife. Do not modify!
package test.com.hellogenio.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import test.com.hellogenio.R;

public class DataAdapter$MyLeftViewHolder_ViewBinding implements Unbinder {
  private DataAdapter.MyLeftViewHolder target;

  @UiThread
  public DataAdapter$MyLeftViewHolder_ViewBinding(DataAdapter.MyLeftViewHolder target,
      View source) {
    this.target = target;

    target.nameTitleLeft = Utils.findRequiredViewAsType(source, R.id.txtTitle, "field 'nameTitleLeft'", TextView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.img_data, "field 'imageView'", ImageView.class);
    target.progressBarImg = Utils.findRequiredViewAsType(source, R.id.img_progress, "field 'progressBarImg'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DataAdapter.MyLeftViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameTitleLeft = null;
    target.imageView = null;
    target.progressBarImg = null;
  }
}
