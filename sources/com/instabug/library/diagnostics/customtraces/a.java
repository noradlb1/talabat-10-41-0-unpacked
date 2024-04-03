package com.instabug.library.diagnostics.customtraces;

import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface a {
    @Nullable
    IBGCustomTrace a(@Nullable String str, long j11);

    void a(@NotNull String str);

    void a(@Nullable String str, long j11, long j12);

    void clearCache();

    void clearSyncedTraces(@Nullable List list);

    @Nullable
    Boolean endTrace(long j11, long j12, boolean z11);

    @Nullable
    List getAllTraces();

    void removeUnEndedTraces();

    @Nullable
    Boolean setAttribute(long j11, @NotNull String str, @Nullable String str2);

    @Nullable
    Boolean updateAttribute(long j11, @NotNull String str, @Nullable String str2);
}
