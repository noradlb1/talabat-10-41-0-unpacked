package com.huawei.secure.android.common.activity.protect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.lang.reflect.Field;

public class a implements IActivityProtect {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33691a = "a";

    @SuppressLint({"PrivateApi"})
    private void a(IBinder iBinder) throws Exception {
        Object invoke = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
        invoke.getClass().getDeclaredMethod("finishActivity", new Class[]{IBinder.class, Integer.TYPE, Intent.class}).invoke(invoke, new Object[]{iBinder, 0, null});
    }

    public void finishLaunchActivity(Message message) {
        com.huawei.secure.android.common.activity.a.b(f33691a, "finishLaunchActivity: ");
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField(LegacyTokenLocalDataSourceImpl.KEY);
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Exception unused) {
            com.huawei.secure.android.common.activity.a.a(f33691a, "finishLaunchActivity exception ");
        }
    }

    public void finishPauseActivity(Message message) {
        com.huawei.secure.android.common.activity.a.b(f33691a, "finishPauseActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            com.huawei.secure.android.common.activity.a.a(f33691a, "finishPauseActivity exception ");
        }
    }

    public void finishResumeActivity(Message message) {
        com.huawei.secure.android.common.activity.a.b(f33691a, "finishResumeActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            com.huawei.secure.android.common.activity.a.a(f33691a, "finishResumeActivity exception ");
        }
    }

    public void finishStopActivity(Message message) {
        com.huawei.secure.android.common.activity.a.b(f33691a, "finishStopActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            com.huawei.secure.android.common.activity.a.a(f33691a, "finishStopActivity exception ");
        }
    }
}
