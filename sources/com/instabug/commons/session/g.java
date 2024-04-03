package com.instabug.commons.session;

import androidx.annotation.WorkerThread;
import com.instabug.commons.models.Incident;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface g {
    @NotNull
    @WorkerThread
    Map a(@NotNull List list);

    @WorkerThread
    void a(@NotNull Incident incident, int i11);

    @WorkerThread
    void a(@NotNull String str, @NotNull Incident.Type type);

    @WorkerThread
    void a(@Nullable String str, @Nullable String str2, @NotNull Incident.Type type);
}
