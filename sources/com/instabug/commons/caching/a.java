package com.instabug.commons.caching;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public static final boolean c(File file) {
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        return StringsKt__StringsJVMKt.endsWith$default(name2, "-sst", false, 2, (Object) null);
    }

    @NotNull
    public final File a(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "baseDirectory");
        return new File(file.getAbsolutePath() + File.separator + "crashes");
    }

    @Nullable
    public final File b(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        File[] listFiles = file.listFiles(new dc.a());
        if (listFiles == null) {
            return null;
        }
        return (File) ArraysKt___ArraysKt.firstOrNull((T[]) listFiles);
    }

    @NotNull
    public final File a(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "baseDirectory");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        File a11 = a(file);
        return new File(a11.getAbsolutePath() + File.separator + str);
    }

    @NotNull
    public final File a(@NotNull File file, long j11) {
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        return new File(file.getAbsolutePath() + File.separator + j11 + "-sst");
    }
}
