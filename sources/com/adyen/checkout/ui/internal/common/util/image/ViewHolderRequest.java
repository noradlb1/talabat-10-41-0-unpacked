package com.adyen.checkout.ui.internal.common.util.image;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderRequest extends LifecycleAwareRequest {
    private Target mTarget;
    private int mTargetAdapterPosition;
    private RecyclerView.ViewHolder mViewHolder;

    public ViewHolderRequest(@NonNull Rembrandt rembrandt, @NonNull RequestArgs requestArgs, @NonNull Lifecycle lifecycle, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull Target target) {
        super(rembrandt, requestArgs, lifecycle);
        this.mViewHolder = viewHolder;
        this.mTarget = target;
        this.mTargetAdapterPosition = viewHolder.getAdapterPosition();
    }

    private boolean isValidAdapterPosition() {
        int adapterPosition = this.mViewHolder.getAdapterPosition();
        int i11 = this.mTargetAdapterPosition;
        if (i11 == -1) {
            if (adapterPosition != -1) {
                this.mTargetAdapterPosition = adapterPosition;
            }
            return true;
        } else if (i11 == adapterPosition) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a() {
        return super.a() || !isValidAdapterPosition();
    }

    public void b(@Nullable Drawable drawable) {
        Target target = this.mTarget;
        if (target != null) {
            target.setImageDrawable(drawable);
        }
    }
}
