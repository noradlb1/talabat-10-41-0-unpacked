package com.instabug.library.diagnostics.nonfatals.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.nonfatals.model.a;
import com.instabug.library.diagnostics.nonfatals.model.b;
import java.util.List;

public interface NonFatalCacheManager {
    public static final String NON_FATAL_STATE = "non_fatal_state";

    @WorkerThread
    void clearCache();

    void deleteNonFatal(long j11);

    void deleteOccurrence(@Nullable String str);

    @NonNull
    List<a> getAllNonFatals();

    @WorkerThread
    List<b> getAllOccurrences();

    @NonNull
    List<b> getNonFatalOccurrences(long j11);

    List<String> getStateFilesForAllOccurrences();

    @WorkerThread
    void saveNonFatal(@NonNull a aVar);

    @WorkerThread
    List<Long> saveNonFatals(@NonNull List<a> list);

    @WorkerThread
    void saveOccurrence(b bVar);
}
