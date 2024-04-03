package com.talabat.designhelpers.shimmer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class ShimmerViewHolder extends RecyclerView.ViewHolder {
    private ShimmerLayout mShimmerLayout;

    public ShimmerViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i11) {
        super(layoutInflater.inflate(R.layout.viewholder_shimmer, viewGroup, false));
        ShimmerLayout shimmerLayout = (ShimmerLayout) this.itemView;
        this.mShimmerLayout = shimmerLayout;
        layoutInflater.inflate(i11, shimmerLayout, true);
    }

    private void setBackground(Drawable drawable) {
        this.mShimmerLayout.setBackground(drawable);
    }

    public void bind() {
        ((ShimmerLayout) this.itemView).startShimmerAnimation();
    }

    public void setShimmerAngle(int i11) {
        this.mShimmerLayout.setShimmerAngle(i11);
    }

    public void setShimmerColor(int i11) {
        this.mShimmerLayout.setShimmerColor(i11);
        this.mShimmerLayout.setShimmerAnimationDuration(1400);
    }

    public void setShimmerViewHolderBackground(Drawable drawable) {
        if (drawable != null) {
            setBackground(drawable);
        }
    }
}
