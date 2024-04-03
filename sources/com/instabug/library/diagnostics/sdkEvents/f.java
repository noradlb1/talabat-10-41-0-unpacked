package com.instabug.library.diagnostics.sdkEvents;

import com.instabug.library.diagnostics.sdkEvents.models.a;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface f {
    void a();

    void a(@NotNull a aVar);

    void a(@Nullable Collection collection);

    void a(@NotNull List list);

    void b(@NotNull a aVar);

    void clearCache();
}
