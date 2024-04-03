package com.instabug.library.diagnostics.customtraces.cache;

import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface d {
    long a(@NotNull IBGCustomTrace iBGCustomTrace);

    void a();

    void a(@NotNull List list);

    void b(@NotNull List list);

    boolean endTrace(long j11, long j12, boolean z11);

    @NotNull
    List getAllTraces();

    long getTraceId(@NotNull IBGCustomTrace iBGCustomTrace);

    void removeUnEndedTraces();

    void trimToLimit(int i11);
}
