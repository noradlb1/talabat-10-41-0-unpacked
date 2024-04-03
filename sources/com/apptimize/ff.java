package com.apptimize;

import android.content.Context;
import android.os.StrictMode;
import java.io.File;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class ff {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42419a = "ff";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Date f42424a;

        /* renamed from: b  reason: collision with root package name */
        private final String f42425b;

        public Date a() {
            return this.f42424a;
        }

        public String b() {
            return this.f42425b;
        }

        private a(Date date, String str) {
            this.f42424a = date;
            this.f42425b = str;
        }
    }

    public static File a(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return context.getFilesDir();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static a b(Context context, au auVar, String str) {
        return a(context, auVar, str, true);
    }

    public static File a(Context context, String str) {
        return new File(a(context), str);
    }

    public static a a(Context context, au auVar, String str) {
        return a(context, auVar, str, false);
    }

    /* JADX INFO: finally extract failed */
    private static a a(final Context context, au auVar, final String str, final boolean z11) {
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            auVar.d().a((fi) new fi() {
                public void run() {
                    StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        File a11 = ff.a(context, str);
                        if (a11.exists()) {
                            atomicReference.set(new a(c.a(Long.valueOf(a11.lastModified())), fx.b(a11)));
                            a11.delete();
                            String str = ff.f42419a;
                            bo.k(str, "File-flag existed and was purged: " + a11.getAbsolutePath());
                        }
                        if (z11) {
                            try {
                                a11.createNewFile();
                                String str2 = ff.f42419a;
                                bo.k(str2, "File-flag created: " + a11.getAbsolutePath());
                            } catch (Exception unused) {
                            }
                        }
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    }
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return (a) atomicReference.get();
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th2;
        }
    }
}
