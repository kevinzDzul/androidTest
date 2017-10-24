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

public class DataAdapter$MyHeaderViewHolder_ViewBinding implements Unbinder {
  private DataAdapter.MyHeaderViewHolder target;

  @UiThread
  public DataAdapter$MyHeaderViewHolder_ViewBinding(DataAdapter.MyHeaderViewHolder target,
      View source) {
    this.target = target;

    target.titleHeader = Utils.findRequiredViewAsType(source, R.id.titleHeader, "field 'titleHeader'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DataAdapter.MyHeaderViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titleHeader = null;
  }
}
