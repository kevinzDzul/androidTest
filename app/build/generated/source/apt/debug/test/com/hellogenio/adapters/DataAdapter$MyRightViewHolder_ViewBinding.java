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

public class DataAdapter$MyRightViewHolder_ViewBinding implements Unbinder {
  private DataAdapter.MyRightViewHolder target;

  @UiThread
  public DataAdapter$MyRightViewHolder_ViewBinding(DataAdapter.MyRightViewHolder target,
      View source) {
    this.target = target;

    target.nameTitleRight = Utils.findRequiredViewAsType(source, R.id.txtTitleRight, "field 'nameTitleRight'", TextView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.img_data_right, "field 'imageView'", ImageView.class);
    target.progressBarImg = Utils.findRequiredViewAsType(source, R.id.img_progress_right, "field 'progressBarImg'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DataAdapter.MyRightViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameTitleRight = null;
    target.imageView = null;
    target.progressBarImg = null;
  }
}
