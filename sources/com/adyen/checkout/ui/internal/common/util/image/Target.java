package com.adyen.checkout.ui.internal.common.util.image;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Target {

    public static final class ImageView implements Target {
        private final android.widget.ImageView mImageView;

        public ImageView(@NonNull android.widget.ImageView imageView) {
            this.mImageView = imageView;
        }

        public void setImageDrawable(@Nullable Drawable drawable) {
            this.mImageView.setImageDrawable(drawable);
        }
    }

    void setImageDrawable(@Nullable Drawable drawable);
}
