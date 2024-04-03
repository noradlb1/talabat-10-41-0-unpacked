package com.adyen.checkout.ui.internal.common.util.image;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.ui.internal.common.util.image.Target;
import java.util.concurrent.Callable;

public final class RequestArgs {
    /* access modifiers changed from: private */
    public int mErrorResId;
    private final Callable<Drawable> mImageCallable;
    /* access modifiers changed from: private */
    public int mPlaceholderResId;
    private final Rembrandt mRembrandt;

    public final class Builder {
        public Builder() {
        }

        @NonNull
        public RequestArgs build() {
            return RequestArgs.this;
        }

        @NonNull
        public Builder error(@DrawableRes int i11) {
            int unused = RequestArgs.this.mErrorResId = i11;
            return this;
        }

        @NonNull
        public Builder placeholder(@DrawableRes int i11) {
            int unused = RequestArgs.this.mPlaceholderResId = i11;
            return this;
        }
    }

    private RequestArgs(@NonNull Rembrandt rembrandt, @NonNull Callable<Drawable> callable) {
        this.mRembrandt = rembrandt;
        this.mImageCallable = callable;
    }

    @NonNull
    public static Builder newBuilder(@NonNull Rembrandt rembrandt, @NonNull Callable<Drawable> callable) {
        return new Builder();
    }

    @DrawableRes
    public int getErrorResId() {
        return this.mErrorResId;
    }

    @NonNull
    public Callable<Drawable> getImageCallable() {
        return this.mImageCallable;
    }

    @DrawableRes
    public int getPlaceholderResId() {
        return this.mPlaceholderResId;
    }

    @SuppressLint({"LambdaLast"})
    public void into(@NonNull LifecycleOwner lifecycleOwner, @NonNull ImageView imageView) {
        into(lifecycleOwner, (Target) new Target.ImageView(imageView));
    }

    public void into(@NonNull LifecycleOwner lifecycleOwner, @NonNull Target target) {
        this.mRembrandt.b(new LifecycleAwareTargetRequest(this.mRembrandt, this, lifecycleOwner.getLifecycle(), target));
    }

    @SuppressLint({"LambdaLast"})
    public void into(@NonNull LifecycleOwner lifecycleOwner, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull ImageView imageView) {
        into(lifecycleOwner, viewHolder, (Target) new Target.ImageView(imageView));
    }

    public void into(@NonNull LifecycleOwner lifecycleOwner, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull Target target) {
        this.mRembrandt.b(new ViewHolderRequest(this.mRembrandt, this, lifecycleOwner.getLifecycle(), viewHolder, target));
    }
}
