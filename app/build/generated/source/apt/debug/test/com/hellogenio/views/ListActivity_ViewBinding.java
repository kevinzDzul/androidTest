// Generated code from Butter Knife. Do not modify!
package test.com.hellogenio.views;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import test.com.hellogenio.R;

public class ListActivity_ViewBinding implements Unbinder {
  private ListActivity target;

  @UiThread
  public ListActivity_ViewBinding(ListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListActivity_ViewBinding(ListActivity target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.main_recycler, "field 'mRecyclerView'", RecyclerView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.main_progress, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mProgressBar = null;
  }
}
