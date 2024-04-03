package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(@NonNull T t11, int i11, int i12, @NonNull Options options) throws IOException;

    boolean handles(@NonNull T t11, @NonNull Options options) throws IOException;
}
