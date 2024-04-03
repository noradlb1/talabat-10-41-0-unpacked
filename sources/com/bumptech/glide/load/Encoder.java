package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

public interface Encoder<T> {
    boolean encode(@NonNull T t11, @NonNull File file, @NonNull Options options);
}
