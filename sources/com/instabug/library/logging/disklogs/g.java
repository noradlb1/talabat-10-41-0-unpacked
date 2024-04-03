package com.instabug.library.logging.disklogs;

import android.text.format.DateUtils;
import com.instabug.library.internal.resolver.c;
import com.instabug.library.model.h;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.TimeUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final g f51477a = new g();

    private g() {
    }

    @JvmStatic
    @Nullable
    public static final File a(@Nullable File file) throws IOException {
        if (file == null) {
            return null;
        }
        File file2 = new File(file.getAbsolutePath() + "/" + TimeUtils.currentTimeMillis() + ".txt");
        if (file2.exists()) {
            return file2;
        }
        if (file2.createNewFile()) {
            return file2;
        }
        return null;
    }

    @JvmStatic
    public static final void b(@Nullable File file) {
        File[] fileArr;
        boolean z11;
        if (file == null) {
            fileArr = null;
        } else {
            fileArr = file.listFiles();
        }
        if (fileArr != null) {
            if (fileArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(fileArr, fileArr.length));
                FileUtils.sortByLastModifiedAsc(mutableListOf);
                ((File) mutableListOf.get(0)).delete();
            }
        }
    }

    @JvmStatic
    public static final boolean c(@Nullable File file) {
        long j11;
        if (file == null) {
            return false;
        }
        h b11 = c.a().b();
        if (b11 == null) {
            j11 = 20000;
        } else {
            j11 = b11.h();
        }
        if (FileUtils.getSize(file) >= j11) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean d(@NotNull File file) {
        long j11;
        Intrinsics.checkNotNullParameter(file, "logFile");
        h b11 = c.a().b();
        if (b11 == null) {
            j11 = 5000;
        } else {
            j11 = b11.f();
        }
        if (FileUtils.getSize(file) >= j11) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final long e(@Nullable File file) {
        if (file != null) {
            try {
                String name2 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "fileName");
                if (StringsKt__StringsKt.contains$default((CharSequence) name2, (CharSequence) ".txt", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(name2, "fileName");
                    name2 = StringsKt__StringsJVMKt.replace$default(name2, ".txt", "", false, 4, (Object) null);
                }
                Intrinsics.checkNotNullExpressionValue(name2, "fileName");
                return Long.parseLong(name2);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    @JvmStatic
    @Nullable
    public static final File f(@Nullable File file) {
        boolean z11;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(listFiles, listFiles.length));
                FileUtils.sortByLastModifiedAsc(mutableListOf);
                if (g((File) mutableListOf.get(CollectionsKt__CollectionsKt.getLastIndex(mutableListOf)))) {
                    return (File) mutableListOf.get(CollectionsKt__CollectionsKt.getLastIndex(mutableListOf));
                }
            }
        }
        return a(file);
    }

    @JvmStatic
    public static final boolean g(@Nullable File file) {
        if (file != null) {
            return DateUtils.isToday(e(file));
        }
        return false;
    }
}
