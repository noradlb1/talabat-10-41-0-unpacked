package com.instabug.terminations.cache;

import com.instabug.commons.caching.FileCacheDirectory;
import com.instabug.commons.caching.SessionCacheDirectory;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements FileCacheDirectory {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f52598b = new a((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SessionCacheDirectory f52599a;

    public b(@NotNull SessionCacheDirectory sessionCacheDirectory) {
        Intrinsics.checkNotNullParameter(sessionCacheDirectory, "parentDir");
        this.f52599a = sessionCacheDirectory;
    }

    @Nullable
    public File getFileDirectory() {
        File currentSessionDirectory = this.f52599a.getCurrentSessionDirectory();
        if (currentSessionDirectory == null) {
            return null;
        }
        return f52598b.g(currentSessionDirectory);
    }
}
