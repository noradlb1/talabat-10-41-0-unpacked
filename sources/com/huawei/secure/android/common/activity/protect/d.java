package com.huawei.secure.android.common.activity.protect;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.huawei.secure.android.common.activity.a;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class d implements IActivityProtect {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33694a = "d";

    private void a(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("arg1");
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Throwable unused) {
            a.a(f33694a, "finishLaunchActivity exception ");
        }
    }

    public void finishLaunchActivity(Message message) {
        a.b(f33694a, "finishLaunchActivity: ");
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField(LegacyTokenLocalDataSourceImpl.KEY);
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Exception unused) {
            a.a(f33694a, "finishLaunchActivity exception ");
        }
    }

    public void finishPauseActivity(Message message) {
        a.b(f33694a, "finishPauseActivity: ");
        a(message);
    }

    public void finishResumeActivity(Message message) {
        a.b(f33694a, "finishResumeActivity: ");
        a(message);
    }

    public void finishStopActivity(Message message) {
        a.b(f33694a, "finishStopActivity: ");
        a(message);
    }

    private void a(IBinder iBinder) throws Exception {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", new Class[0]).invoke((Object) null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", new Class[]{IBinder.class, cls2, Intent.class, cls2});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, new Object[]{iBinder, 0, null, 0});
    }
}
