// Generated code from Butter Knife. Do not modify!
package test.com.hellogenio.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import test.com.hellogenio.R;

public class DataAdapter$MyFooterViewHolder_ViewBinding implements Unbinder {
  private DataAdapter.MyFooterViewHolder target;

  @UiThread
  public DataAdapter$MyFooterViewHolder_ViewBinding(DataAdapter.MyFooterViewHolder target,
      View source) {
    this.target = target;

    target.titleFooter = Utils.findRequiredViewAsType(source, R.id.titleFooter, "field 'titleFooter'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DataAdapter.MyFooterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleFooter = null;
  }
}
