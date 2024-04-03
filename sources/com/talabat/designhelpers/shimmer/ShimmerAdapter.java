package com.talabat.designhelpers.shimmer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class ShimmerAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {
    private int mItemCount = 10;
    private int mLayoutReference = R.layout.layout_sample_view;
    private int mShimmerAngle;
    private int mShimmerColor;
    private Drawable mShimmerItemBackground;

    public int getItemCount() {
        return this.mItemCount;
    }

    public void setLayoutReference(int i11) {
        this.mLayoutReference = i11;
    }

    public void setMinItemCount(int i11) {
        this.mItemCount = i11;
    }

    public void setShimmerAngle(int i11) {
        this.mShimmerAngle = i11;
    }

    public void setShimmerColor(int i11) {
        this.mShimmerColor = i11;
    }

    public void setShimmerItemBackground(Drawable drawable) {
        this.mShimmerItemBackground = drawable;
    }

    public void onBindViewHolder(ShimmerViewHolder shimmerViewHolder, int i11) {
        shimmerViewHolder.bind();
    }

    public ShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        ShimmerViewHolder shimmerViewHolder = new ShimmerViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, this.mLayoutReference);
        shimmerViewHolder.setShimmerColor(this.mShimmerColor);
        shimmerViewHolder.setShimmerAngle(this.mShimmerAngle);
        shimmerViewHolder.setShimmerViewHolderBackground(this.mShimmerItemBackground);
        return shimmerViewHolder;
    }
}
