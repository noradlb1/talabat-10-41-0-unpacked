package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {
    private final int height;
    @Nullable
    private Request request;
    private final int width;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Nullable
    public final Request getRequest() {
        return this.request;
    }

    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public void onDestroy() {
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void setRequest(@Nullable Request request2) {
        this.request = request2;
    }

    public CustomTarget(int i11, int i12) {
        if (Util.isValidDimensions(i11, i12)) {
            this.width = i11;
            this.height = i12;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i11 + " and height: " + i12);
    }
}
