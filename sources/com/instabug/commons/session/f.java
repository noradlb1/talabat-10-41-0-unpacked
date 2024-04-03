package com.instabug.commons.session;

import com.instabug.commons.models.Incident;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface f {
    void a(@NotNull e eVar);

    void a(@NotNull String str, @NotNull Incident.Type type, int i11);

    void a(@NotNull String str, @Nullable String str2, @NotNull Incident.Type type, int i11);

    void a(@NotNull List list);

    @NotNull
    List b(@NotNull List list);
}
