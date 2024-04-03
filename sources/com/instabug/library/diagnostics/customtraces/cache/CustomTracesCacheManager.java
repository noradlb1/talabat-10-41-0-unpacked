package com.instabug.library.diagnostics.customtraces.cache;

import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CustomTracesCacheManager {
    void clearSyncedTraces(@NotNull List<IBGCustomTrace> list);

    void clearTracesByName(@NotNull String[] strArr);

    void deleteAll();

    boolean endTrace(long j11, long j12, boolean z11);

    @NotNull
    List<IBGCustomTrace> getAllTraces();

    long getTraceId(@NotNull IBGCustomTrace iBGCustomTrace);

    void logTrace(@NotNull String str, long j11, long j12, boolean z11);

    void removeUnEndedTraces();

    boolean setAttribute(long j11, @NotNull String str, @Nullable String str2);

    long startTrace(@NotNull IBGCustomTrace iBGCustomTrace);

    boolean updateAttribute(long j11, @NotNull String str, @Nullable String str2);
}
