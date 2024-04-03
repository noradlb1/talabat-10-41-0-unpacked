package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f47853a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    public static Context a(Context context) {
        return a() ? context.createDeviceProtectedStorageContext() : context;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                Log.w("StmUt", "close " + th2.getClass().getSimpleName());
            }
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (resolveContentProvider == null) {
            Log.e("StmUt", "verify provider invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
    }

    public static Integer b(Context context) {
        Bundle bundle;
        Object obj;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a(context), 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("ppskit_ver_code")) == null)) {
                return Integer.valueOf(obj.toString());
            }
        } catch (Throwable th2) {
            Log.i("StmUt", "getPpsKitVerCode ex: " + th2.getClass().getSimpleName());
        }
        return null;
    }
}
