package com.instabug.library.experiments.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.List;

@WorkerThread
public interface a {
    @Nullable
    List a(float f11);

    void a();

    void a(@NonNull List list);

    void b(@NonNull List list);

    int trimToLimit(int i11);
}
