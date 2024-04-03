package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener<R> {
    boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z11);

    boolean onResourceReady(R r11, Object obj, Target<R> target, DataSource dataSource, boolean z11);
}
