package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

public interface MediaContent {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    @RecentlyNullable
    Drawable getMainImage();

    @RecentlyNonNull
    VideoController getVideoController();

    boolean hasVideoContent();

    void setMainImage(@Nullable Drawable drawable);
}
