package com.instabug.library.diagnostics.nonfatals.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.nonfatals.model.b;
import java.util.List;

public interface d {
    @WorkerThread
    int a(long j11);

    @WorkerThread
    void a();

    @WorkerThread
    boolean a(@NonNull b bVar);

    @WorkerThread
    List b();

    @WorkerThread
    @Nullable
    String[] b(long j11);

    @WorkerThread
    void deleteOccurrence(String str);

    @WorkerThread
    @NonNull
    List getAllOccurrences();

    @WorkerThread
    @NonNull
    List getNonFatalOccurrences(long j11);
}
