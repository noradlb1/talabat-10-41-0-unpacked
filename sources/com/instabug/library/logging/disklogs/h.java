package com.instabug.library.logging.disklogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.dataretention.files.c;
import com.instabug.library.internal.dataretention.files.logs.b;
import com.instabug.library.internal.dataretention.files.logs.f;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.memory.MemoryUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class h {
    @VisibleForTesting
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public File f51478a;
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public File f51479b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference f51480c;

    public h(Context context) {
        this.f51480c = new WeakReference(context);
    }

    @NonNull
    public static c a(Context context) {
        File insatbugLogDirectory = DiskUtils.getInsatbugLogDirectory("logs/", context);
        return new b().a(insatbugLogDirectory.getAbsolutePath(), com.instabug.library.internal.dataretention.core.b.LOGS, new f());
    }

    @Nullable
    public synchronized File b() throws IOException {
        if (this.f51478a != null) {
            File a11 = a();
            if (g.g(this.f51478a)) {
                if (!g.d(this.f51478a)) {
                    return this.f51478a;
                }
                this.f51478a = g.a(a11);
            } else if (a11 != null) {
                this.f51478a = a(a11);
            }
        } else {
            c();
        }
        return this.f51478a;
    }

    @VisibleForTesting
    @SuppressLint({"THREAD_SAFETY_VIOLATION"})
    public void c() {
        Context context;
        try {
            WeakReference weakReference = this.f51480c;
            if (weakReference != null && (context = (Context) weakReference.get()) != null) {
                com.instabug.library.model.h b11 = com.instabug.library.internal.resolver.c.a().b();
                if (!MemoryUtils.isLowMemory(context) && b11 != null && b11.d() != 0) {
                    File insatbugLogDirectory = DiskUtils.getInsatbugLogDirectory("logs/", context);
                    this.f51479b = insatbugLogDirectory;
                    this.f51478a = a(insatbugLogDirectory);
                }
            }
        } catch (IOException e11) {
            Log.e("IBG-Core", "Error while preparing disk logs", e11);
        }
    }

    public synchronized void d() {
        if (g.c(a())) {
            g.b(this.f51479b);
        }
    }

    @VisibleForTesting
    @Nullable
    private File a(@NonNull File file) throws IOException {
        if (g.c(file)) {
            g.b(file);
        }
        return g.f(file);
    }

    @Nullable
    private synchronized File a() {
        if (this.f51479b == null) {
            c();
        }
        return this.f51479b;
    }
}
