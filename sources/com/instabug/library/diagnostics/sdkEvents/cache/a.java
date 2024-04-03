package com.instabug.library.diagnostics.sdkEvents.cache;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface a {
    void a();

    void a(@NotNull com.instabug.library.diagnostics.sdkEvents.models.a aVar);

    void a(@Nullable Collection collection);

    void a(@NotNull List list);

    @Nullable
    List b();

    void clearCache();
}
