package com.instabug.fatalhangs.cache;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.instabug.fatalhangs.model.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@WorkerThread
public interface a {
    @Nullable
    c a(@NotNull Context context);

    void a(@NotNull c cVar);

    void a(@NotNull c cVar, @Nullable Context context);

    void a(@NotNull String str);

    void b(@Nullable Context context);
}
