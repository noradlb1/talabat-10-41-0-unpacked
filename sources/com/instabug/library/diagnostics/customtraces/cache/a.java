package com.instabug.library.diagnostics.customtraces.cache;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public interface a {
    @NotNull
    HashMap a(long j11);

    boolean a(long j11, @NotNull String str);

    boolean a(long j11, @NotNull String str, @NotNull String str2);

    boolean updateAttribute(long j11, @NotNull String str, @NotNull String str2);
}
