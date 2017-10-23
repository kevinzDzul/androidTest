package test.com.hellogenio.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.com.hellogenio.R;
import test.com.hellogenio.models.Data;

/**
 * Created by kevin on 22/10/17.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_FOOTER = 1;

    private static final int VIEW_TYPE_LEFT = 2;
    private static final int VIEW_TYPE_RIGHT = 3;


    private List<Data> mDataResult;
    private Context mContext;
    private Data mTempData = null;

    public DataAdapter(Context mContext) {
        this.mDataResult = new ArrayList<>();
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {

            case VIEW_TYPE_HEADER:

                View mViewHeader = layoutInflater.inflate(R.layout.layout_item_header, parent, false);
                viewHolder = new MyHeaderViewHolder(mViewHeader);

                break;

            case VIEW_TYPE_LEFT:

                View mViewLeft = layoutInflater.inflate(R.layout.layout_item_left, parent, false);
                viewHolder = new MyLeftViewHolder(mViewLeft);

                break;

            case VIEW_TYPE_RIGHT:

                View mViewRight = layoutInflater.inflate(R.layout.layout_item_right, parent, false);
                viewHolder = new MyRightViewHolder(mViewRight);
                break;

            case VIEW_TYPE_FOOTER:

                View mViewFooter = layoutInflater.inflate(R.layout.layout_item_footer, parent, false);
                viewHolder = new MyFooterViewHolder(mViewFooter);

                break;

        }
        return viewHolder;

    }

    public void add(Data dt) {
        mDataResult.add(dt);
        notifyItemInserted(mDataResult.size() - 1);
    }

    public void addAll(List<Data> dtList) {

        Data temp_data = null;

        for (Data dt : dtList) {

            if (dt.isFooter()) {
                temp_data = dt;
                continue;
            }
            add(dt);
        }

        add(temp_data);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyHeaderViewHolder)
            configureHeaderViewHolder((MyHeaderViewHolder) holder, position);


        else if (holder instanceof MyRightViewHolder)
            configureMyRightViewHolder((MyRightViewHolder) holder, position);


        else if (holder instanceof MyLeftViewHolder)
            configureMyLeftViewHolder((MyLeftViewHolder) holder, position);


        else if (holder instanceof MyFooterViewHolder)
            configureFooterViewHolder((MyFooterViewHolder) holder, position);


    }

    @Override
    public int getItemCount() {
        if (mDataResult != null)
            return getContentItemCount();

        return 0;
    }

    public int getContentItemCount() {
        return mDataResult.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (isPositionHeader(position) && mDataResult.get(position).isHeader())
            return VIEW_TYPE_HEADER;

        else if (isPositionFooter(position))
            return VIEW_TYPE_FOOTER;

        else if (mDataResult.get(position).getType().equals("data_0"))
            return VIEW_TYPE_RIGHT;

        else
            return VIEW_TYPE_LEFT;

        //}
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private boolean isPositionFooter(int position) {
        return position == mDataResult.size() - 1;
    }


    private void configureHeaderViewHolder(MyHeaderViewHolder myHeaderViewHolder, int position) {
        Data mData = mDataResult.get(position);
        myHeaderViewHolder.titleHeader.setText(mData.getName());
    }

    private void configureFooterViewHolder(MyFooterViewHolder myFooterViewHolder, int position) {
        Data mData = mDataResult.get(position);
        myFooterViewHolder.titleFooter.setText(mData.getText());

    }


    private void configureMyLeftViewHolder(final MyLeftViewHolder myLeftViewHolder, int position) {
        Data mData = mDataResult.get(position);

        myLeftViewHolder.nameTitleLeft.setText(mData.getText());
        Glide.with(mContext)
                .load(mData.getImage())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        myLeftViewHolder.progressBarImg.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        myLeftViewHolder.progressBarImg.setVisibility(View.GONE);

                        return false;
                    }
                })
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(myLeftViewHolder.imageView);

    }

    private void configureMyRightViewHolder(final MyRightViewHolder myRightViewHolder, int position) {
        Data mData = mDataResult.get(position);

        myRightViewHolder.nameTitleRight.setText(mData.getText());
        myRightViewHolder.nameTitleRight.setText(mData.getText());
        Glide.with(mContext)
                .load(mData.getImage())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        myRightViewHolder.progressBarImg.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        myRightViewHolder.progressBarImg.setVisibility(View.GONE);
                        return false;
                    }
                })
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(myRightViewHolder.imageView);

    }

    static class MyHeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleHeader)
        TextView titleHeader;

        public MyHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class MyFooterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleFooter)
        TextView titleFooter;

        public MyFooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class MyLeftViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitle)
        TextView nameTitleLeft;

        @BindView(R.id.img_data)
        ImageView imageView;

        @BindView(R.id.img_progress)
        ProgressBar progressBarImg;

        public MyLeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class MyRightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitleRight)
        TextView nameTitleRight;

        @BindView(R.id.img_data_right)
        ImageView imageView;

        @BindView(R.id.img_progress_right)
        ProgressBar progressBarImg;

        public MyRightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
