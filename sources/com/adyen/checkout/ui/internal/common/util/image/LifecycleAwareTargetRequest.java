package com.adyen.checkout.ui.internal.common.util.image;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

class LifecycleAwareTargetRequest extends LifecycleAwareRequest {
    private Target mTarget;

    public LifecycleAwareTargetRequest(@NonNull Rembrandt rembrandt, @NonNull RequestArgs requestArgs, @NonNull Lifecycle lifecycle, @NonNull Target target) {
        super(rembrandt, requestArgs, lifecycle);
        this.mTarget = target;
    }

    public void b(@Nullable Drawable drawable) {
        Target target = this.mTarget;
        if (target != null) {
            target.setImageDrawable(drawable);
        }
    }

    public void c() {
        super.c();
        this.mTarget = null;
    }
}
