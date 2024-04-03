package com.instabug.library.networkv2.service.synclogs;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.internal.contentprovider.a;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.logging.disklogs.g;
import com.instabug.library.model.h;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.MD5Generator;
import com.instabug.library.util.TaskDebouncer;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class c implements Request.Callbacks {

    /* renamed from: h  reason: collision with root package name */
    private static c f51684h;

    /* renamed from: a  reason: collision with root package name */
    private com.instabug.library.internal.resolver.c f51685a = com.instabug.library.internal.resolver.c.a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51686b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51687c;

    /* renamed from: d  reason: collision with root package name */
    private a f51688d = new SyncLogKeyProvider();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public f f51689e;

    /* renamed from: f  reason: collision with root package name */
    private String f51690f = "logs_last_uploaded_at";

    /* renamed from: g  reason: collision with root package name */
    private TaskDebouncer f51691g = new TaskDebouncer(TimeUnit.SECONDS.toMillis(1));

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f51684h == null) {
                f51684h = new c();
            }
            cVar = f51684h;
        }
        return cVar;
    }

    @Nullable
    private String c(@NonNull String str) {
        return MD5Generator.generateMD5(this.f51688d.f() + str.toLowerCase() + this.f51688d.e());
    }

    @Nullable
    private String d(@NonNull String str) {
        return MD5Generator.generateMD5(this.f51688d.d() + str.toLowerCase() + this.f51688d.h());
    }

    /* renamed from: e */
    public void onSucceeded(@Nullable String str) {
        Application application;
        if (a.b() != null) {
            application = a.b().a();
        } else {
            application = null;
        }
        if (application != null) {
            g(System.currentTimeMillis(), application);
        }
        if (str != null) {
            File file = new File(str);
            if (!g.g(file)) {
                try {
                    if (!file.delete()) {
                        InstabugSDKLogger.e("IBG-Core", "couldn't delete disposable file (" + file.getName() + ")");
                    }
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-Core", "couldn't delete disposable file", e11);
                }
            }
        }
    }

    @VisibleForTesting
    @Nullable
    public String f(@NonNull String str) {
        return MD5Generator.generateMD5(this.f51688d.g() + str.toLowerCase() + this.f51688d.c());
    }

    @VisibleForTesting
    public void g(long j11, Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        if (instabugSharedPreferences != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putLong(this.f51690f, j11);
            edit.apply();
        }
    }

    @VisibleForTesting
    @Nullable
    public String h(@NonNull String str) {
        return MD5Generator.generateMD5(this.f51688d.b() + str.toLowerCase() + this.f51688d.a());
    }

    @VisibleForTesting
    public boolean i() {
        h b11;
        Set a11;
        String str;
        String str2 = this.f51687c;
        if ((str2 != null && f(str2) == null) || (b11 = this.f51685a.b()) == null || (a11 = b11.a()) == null || (str = this.f51687c) == null || f(str) == null || !a11.contains(f(this.f51687c))) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public boolean j() {
        h b11;
        Set k11;
        String str;
        String str2 = this.f51686b;
        if ((str2 != null && c(str2) == null) || (b11 = this.f51685a.b()) == null || (k11 = b11.k()) == null || (str = this.f51686b) == null || c(str) == null || !k11.contains(c(this.f51686b))) {
            return false;
        }
        return true;
    }

    public void b(String str, String str2) {
        this.f51686b = str;
        this.f51687c = str2;
    }

    private boolean b(Context context) {
        h b11 = this.f51685a.b();
        if (b11 == null) {
            return false;
        }
        if (System.currentTimeMillis() - a(context) > TimeUnit.SECONDS.toMillis(b11.j())) {
            return true;
        }
        return false;
    }

    private boolean c() {
        return i() || j();
    }

    public void a(Context context, String str) {
        File[] listFiles;
        try {
            if (c() && b(context)) {
                this.f51689e = f.a(new NetworkManager(), new d(), (Request.Callbacks) this, new com.instabug.library.networkv2.service.base.a());
                Pair a11 = a(this.f51687c, this.f51686b);
                String str2 = (String) a11.first;
                String str3 = (String) a11.second;
                File insatbugLogDirectory = DiskUtils.getInsatbugLogDirectory("logs/", context);
                if (insatbugLogDirectory != null && insatbugLogDirectory.exists() && (listFiles = insatbugLogDirectory.listFiles()) != null) {
                    a(listFiles, str3, str2, str);
                }
            }
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while syncing logs", e11);
            Instabug.disable();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private Pair a(@Nullable String str, @Nullable String str2) {
        Pair pair = new Pair("", "");
        if (str == null || !i()) {
            return (str2 == null || !j()) ? pair : new Pair(h(str2), d(str2));
        }
        return new Pair(h(str), d(str));
    }

    private void a(File[] fileArr, @Nullable String str, @Nullable String str2, String str3) {
        if (this.f51689e != null) {
            this.f51691g.debounce((Runnable) new b(this, fileArr, str, str2, str3));
        }
    }

    @VisibleForTesting
    public long a(Context context) {
        SharedPreferences instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(context, SettingsManager.INSTABUG_SHARED_PREF_NAME);
        if (instabugSharedPreferences == null) {
            return 0;
        }
        return instabugSharedPreferences.getLong(this.f51690f, 0);
    }

    /* renamed from: a */
    public void onFailed(Exception exc) {
        InstabugSDKLogger.e("IBG-Core", "exception", exc);
    }
}
