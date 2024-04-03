package com.apptimize;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.apptimize.an;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42968a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static i f42969b;

    /* renamed from: c  reason: collision with root package name */
    private au f42970c;

    /* renamed from: d  reason: collision with root package name */
    private an f42971d = new an.b();

    public interface a {
        void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor);
    }

    private i(au auVar) {
        this.f42970c = auVar;
    }

    /* access modifiers changed from: private */
    public SharedPreferences c(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return context.getSharedPreferences("apptimize" + context.getPackageName(), 4);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public synchronized void b(Context context, final String str, final boolean z11) {
        a(context.getApplicationContext(), (a) new a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.putBoolean(str, z11);
            }
        });
    }

    public static void a(au auVar) {
        if (f42969b == null) {
            f42969b = new i(auVar);
        }
    }

    public static i a() {
        return f42969b;
    }

    public synchronized void b(Context context, final String str, final long j11) {
        a(context.getApplicationContext(), (a) new a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.putLong(str, j11);
            }
        });
    }

    public synchronized boolean a(Context context, String str, boolean z11) {
        AtomicReference atomicReference;
        final Context applicationContext = context.getApplicationContext();
        atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = atomicReference;
        final String str2 = str;
        final boolean z12 = z11;
        a((fi) new fi() {
            public void run() {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    atomicReference2.set(Boolean.valueOf(i.this.c(applicationContext).getBoolean(str2, z12)));
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
        });
        return ((Boolean) atomicReference.get()).booleanValue();
    }

    public synchronized void b(Context context, final String str, final String str2) {
        a(context.getApplicationContext(), (a) new a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.putString(str, str2);
            }
        });
    }

    public synchronized long a(Context context, String str, long j11) {
        AtomicReference atomicReference;
        final Context applicationContext = context.getApplicationContext();
        atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = atomicReference;
        final String str2 = str;
        final long j12 = j11;
        a((fi) new fi() {
            public void run() {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    atomicReference2.set(Long.valueOf(i.this.c(applicationContext).getLong(str2, j12)));
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
        });
        return ((Long) atomicReference.get()).longValue();
    }

    public synchronized void b(Context context, final String str, final Date date) {
        a(context.getApplicationContext(), (a) new a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.putLong(str, date.getTime());
            }
        });
    }

    public synchronized String a(Context context, String str, String str2) {
        AtomicReference atomicReference;
        final Context applicationContext = context.getApplicationContext();
        atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = atomicReference;
        final String str3 = str;
        final String str4 = str2;
        a((fi) new fi() {
            public void run() {
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    atomicReference2.set(i.this.c(applicationContext).getString(str3, str4));
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                }
            }
        });
        return (String) atomicReference.get();
    }

    public void b(Context context) {
        this.f42971d = new an.a(context, "apptimize_shared_preferences.pid");
    }

    public synchronized Date a(Context context, String str, Date date) {
        AtomicReference atomicReference;
        final Context applicationContext = context.getApplicationContext();
        atomicReference = new AtomicReference();
        final String str2 = str;
        final AtomicReference atomicReference2 = atomicReference;
        final Date date2 = date;
        a((fi) new fi() {
            public void run() {
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    long j11 = i.this.c(applicationContext).getLong(str2, 0);
                    if (j11 != 0) {
                        atomicReference2.set(new Date(j11));
                    } else {
                        atomicReference2.set(date2);
                    }
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                }
            }
        });
        return (Date) atomicReference.get();
    }

    public synchronized void a(Context context, final a aVar) {
        final Context applicationContext = context.getApplicationContext();
        a((fi) new fi() {
            public void run() {
                SharedPreferences a11 = i.this.c(applicationContext);
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    SharedPreferences.Editor edit = a11.edit();
                    aVar.a(a11, edit);
                    edit.commit();
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                }
            }
        });
    }

    public synchronized void a(Context context) {
        a(context.getApplicationContext(), (a) new a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.clear();
            }
        });
    }

    private void a(fi fiVar) {
        try {
            this.f42971d.a();
            fiVar.run();
            this.f42971d.b();
        } catch (IOException e11) {
            bo.b(f42968a, "IOException when holding process lock: ", e11);
        } catch (Throwable th2) {
            this.f42971d.b();
            throw th2;
        }
    }
}
