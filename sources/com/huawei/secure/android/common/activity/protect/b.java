package com.huawei.secure.android.common.activity.protect;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.huawei.secure.android.common.activity.a;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.lang.reflect.Field;

public class b implements IActivityProtect {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33692a = "b";

    private void a(IBinder iBinder) throws Exception {
        Object invoke = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
        invoke.getClass().getDeclaredMethod("finishActivity", new Class[]{IBinder.class, Integer.TYPE, Intent.class, Boolean.TYPE}).invoke(invoke, new Object[]{iBinder, 0, null, Boolean.FALSE});
    }

    public void finishLaunchActivity(Message message) {
        a.b(f33692a, "finishLaunchActivity: ");
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField(LegacyTokenLocalDataSourceImpl.KEY);
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Exception unused) {
            a.a(f33692a, "finishLaunchActivity exception ");
        }
    }

    public void finishPauseActivity(Message message) {
        a.b(f33692a, "finishPauseActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            a.a(f33692a, "finishPauseActivity exception ");
        }
    }

    public void finishResumeActivity(Message message) {
        a.b(f33692a, "finishResumeActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            a.a(f33692a, "finishResumeActivity exception ");
        }
    }

    public void finishStopActivity(Message message) {
        a.b(f33692a, "finishStopActivity: ");
        try {
            a((IBinder) message.obj);
        } catch (Exception unused) {
            a.a(f33692a, "finishStopActivity  exception ");
        }
    }
}
