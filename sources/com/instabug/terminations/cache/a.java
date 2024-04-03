package com.instabug.terminations.cache;

import com.instabug.commons.snapshot.FileKtxKt;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import ee.b;
import ee.c;
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
    public static final boolean b(File file) {
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        return StringsKt__StringsJVMKt.endsWith$default(name2, "-bl", false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean d(File file) {
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        return StringsKt__StringsJVMKt.endsWith$default(name2, "-osd", false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean i(File file) {
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        return StringsKt__StringsJVMKt.endsWith$default(name2, "-vld", false, 2, (Object) null);
    }

    @NotNull
    public final File a(@NotNull File file, long j11) {
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        File g11 = g(file);
        return new File(g11.getAbsolutePath() + File.separator + j11 + "-bl");
    }

    @Nullable
    public final File c(@NotNull File file) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        File g11 = g(file);
        if (!g11.exists()) {
            g11 = null;
        }
        if (g11 == null || (listFiles = g11.listFiles(new b())) == null) {
            return null;
        }
        return (File) ArraysKt___ArraysKt.firstOrNull((T[]) listFiles);
    }

    @NotNull
    public final File e(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "terminationDir");
        File f11 = f(file);
        if (f11 == null) {
            return null;
        }
        return new File(Intrinsics.stringPlus(f11.getAbsolutePath(), StateSnapshotCaptor.OLD_STATE_SNAPSHOT_FILE_SUFFIX));
    }

    @NotNull
    public final File f(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "terminationDir");
        return new File(file.getAbsolutePath() + File.separator + "trm-snapshot");
    }

    @NotNull
    public final File g(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        return new File(file.getAbsolutePath() + File.separator + "trm");
    }

    @Nullable
    public final File h(@NotNull File file) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        File g11 = g(file);
        if (!g11.exists()) {
            g11 = null;
        }
        if (g11 == null || (listFiles = g11.listFiles(new ee.a())) == null) {
            return null;
        }
        return (File) ArraysKt___ArraysKt.firstOrNull((T[]) listFiles);
    }

    public final void j(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "snapshotFile");
        FileKtxKt.rename(file, Intrinsics.stringPlus(file.getName(), StateSnapshotCaptor.OLD_STATE_SNAPSHOT_FILE_SUFFIX));
    }

    @Nullable
    public final File a(@NotNull File file) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        File g11 = g(file);
        if (!g11.exists()) {
            g11 = null;
        }
        if (g11 == null || (listFiles = g11.listFiles(new c())) == null) {
            return null;
        }
        return (File) ArraysKt___ArraysKt.firstOrNull((T[]) listFiles);
    }

    public final void b(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "detectionFile");
        Intrinsics.checkNotNullParameter(str, "suffix");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        FileKtxKt.rename(file, Intrinsics.stringPlus(StringsKt__StringsKt.removeSuffix(name2, (CharSequence) str), "-mig"));
    }

    public final void c(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "sessionDir");
        Intrinsics.checkNotNullParameter(str, "suffix");
        File g11 = g(file);
        a aVar = b.f52598b;
        File f11 = aVar.f(g11);
        File file2 = null;
        if (!f11.exists()) {
            f11 = null;
        }
        if (f11 == null) {
            File e11 = aVar.e(g11);
            if (e11.exists()) {
                file2 = e11;
            }
        } else {
            file2 = f11;
        }
        if (file2 != null) {
            FileKtxKt.rename(file2, Intrinsics.stringPlus(file2.getName(), str));
        }
    }

    public final void a(@NotNull File file, @NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(file, "baselineFile");
        Intrinsics.checkNotNullParameter(str, "groundState");
        FileKtxKt.rename(file, j11 + str + "-osd");
    }

    public final void a(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "detectedFile");
        Intrinsics.checkNotNullParameter(str, "stateSuffix");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        FileKtxKt.rename(file, Intrinsics.stringPlus(StringsKt__StringsKt.removeSuffix(name2, (CharSequence) Intrinsics.stringPlus(str, "-osd")), "-vld"));
    }
}
