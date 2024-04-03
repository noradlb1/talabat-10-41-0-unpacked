package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i11, int i12) {
        this.size = new int[]{i11, i12};
    }

    @Nullable
    public int[] getPreloadSize(@NonNull T t11, int i11, int i12) {
        return this.size;
    }
}
