package com.huawei.hms.maps.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.b;
import com.huawei.hms.maps.MapClientIdentify;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.utils.DynamicUtil;
import com.huawei.hms.maps.utils.LogM;

public class mab {

    /* renamed from: a  reason: collision with root package name */
    private static Context f49398a = null;

    /* renamed from: b  reason: collision with root package name */
    private static ICreator f49399b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49400c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f49401d = false;

    /* renamed from: e  reason: collision with root package name */
    private static int f49402e;

    /* renamed from: f  reason: collision with root package name */
    private static SharedPreferences f49403f;

    public static ICreator a(Context context) {
        if (!DynamicUtil.isAndroidN()) {
            return f49399b;
        }
        LogM.i("MapCreator", "get creator async.");
        return c(context);
    }

    public static void a() {
        f49398a = null;
        f49399b = null;
    }

    public static void a(boolean z11) {
        f49400c = z11;
    }

    public static ICreator b(Context context) {
        f49401d = true;
        ICreator c11 = c(context);
        f49401d = false;
        return c11;
    }

    public static void b(boolean z11) {
        SharedPreferences sharedPreferences = f49403f;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("providerUpdateFlag", z11).apply();
        }
    }

    public static synchronized ICreator c(Context context) {
        synchronized (mab.class) {
            Preconditions.checkNotNull(context);
            ICreator iCreator = f49399b;
            if (iCreator != null) {
                return iCreator;
            }
            LogM.i("MapCreator", "Making Creator dynamically");
            ICreator iCreator2 = null;
            try {
                Context d11 = d(context);
                if (d11 == null) {
                    LogM.e("MapCreator", "getRemoteMapContext failed");
                    return null;
                }
                Object newInstance = d11.getClassLoader().loadClass("com.huawei.hms.maps.CreatorImpl").newInstance();
                if (newInstance instanceof IBinder) {
                    ICreator asInterface = ICreator.Stub.asInterface((IBinder) newInstance);
                    asInterface.init(ObjectWrapper.wrap(d11.getResources()), 1000);
                    iCreator2 = asInterface;
                }
                f49399b = iCreator2;
                return iCreator2;
            } catch (Throwable unused) {
                LogM.e("MapCreator", "loadClass failed");
                f49398a = null;
                DynamicUtil.setDynamicModule((DynamicModule) null);
                return null;
            }
        }
    }

    public static Context d(Context context) {
        MapClientIdentify.setAppContext(context);
        Context context2 = f49398a;
        if (context2 != null) {
            return context2;
        }
        Context f11 = f(context);
        f49398a = f11;
        return f11;
    }

    public static SharedPreferences e(Context context) {
        if (f49403f == null) {
            f49403f = context.getSharedPreferences("com.huawei.hmsmap.updateFlag", 0);
        }
        return f49403f;
    }

    private static Context f(Context context) {
        String str;
        String str2;
        try {
            DynamicUtil.handlerDynamicLoadAfterLogic("huawei_module_huaweimaps", context);
            if (DynamicUtil.getDynamicModule() == null) {
                DynamicUtil.setDynamicModule(DynamicModule.loadV3(context, DynamicModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "huawei_module_huaweimaps"));
            }
            if (DynamicUtil.getDynamicModule() != null) {
                return DynamicUtil.getDynamicModule().getModuleContext();
            }
            return null;
        } catch (DynamicModule.LoadingException e11) {
            LogM.e("MapCreator", "Loading mapRoute dynamically failed, exception is " + e11.getMessage());
            Bundle bundle = e11.getBundle();
            if (bundle == null || bundle.getInt(b.f48765h) != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getRemoteContext: LoadingException: ");
                if (bundle == null) {
                    str = "bundle = null";
                } else {
                    str = "errcode = " + bundle.getInt(b.f48765h);
                }
                sb2.append(str);
                sb2.append(", and retryCount is ");
                sb2.append(f49402e);
                LogM.e("MapCreator", sb2.toString());
                if (DynamicUtil.isAndroidN() || f49401d || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    return null;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException unused) {
                    LogM.e("MapCreator", "InterruptedException: getRemoteContext failed.");
                }
                int i11 = f49402e;
                if (i11 < 200) {
                    f49402e = i11 + 1;
                    return f(context);
                }
                str2 = "Failed to obtain remote context. The maximum number of times has been reached.";
            } else {
                LogM.e("MapCreator", "getRemoteContext: LoadingException: errcode = " + bundle.getInt(b.f48765h));
                Intent intent = (Intent) bundle.getParcelable("resolution");
                if (intent == null) {
                    str2 = "null intent, please check it.";
                } else {
                    LogM.e("MapCreator", "get intent successfully.");
                    intent.setFlags(268435456);
                    if (!f49400c) {
                        return null;
                    }
                    try {
                        context.startActivity(intent);
                        f49400c = false;
                        LogM.e("MapCreator", "startUpdateActivity Success.");
                        return null;
                    } catch (ActivityNotFoundException unused2) {
                        LogM.e("MapCreator", "startActivity error ActivityNotFound.");
                        return null;
                    }
                }
            }
            LogM.e("MapCreator", str2);
            return null;
        }
    }
}
