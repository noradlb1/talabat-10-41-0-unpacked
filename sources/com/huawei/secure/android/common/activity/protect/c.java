package com.huawei.secure.android.common.activity.protect;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.huawei.secure.android.common.activity.a;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.lang.reflect.Field;

public class c implements IActivityProtect {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33693a = "c";

    private void a(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("arg1");
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Throwable unused) {
            a.a(f33693a, "finishSomeArgs exception  ");
        }
    }

    public void finishLaunchActivity(Message message) {
        a.b(f33693a, "finishLaunchActivity: ");
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField(LegacyTokenLocalDataSourceImpl.KEY);
            declaredField.setAccessible(true);
            a((IBinder) declaredField.get(obj));
        } catch (Exception unused) {
            a.a(f33693a, "finishLaunchActivity exception ");
        }
    }

    public void finishPauseActivity(Message message) {
        a.b(f33693a, "finishPauseActivity: ");
        a(message);
    }

    public void finishResumeActivity(Message message) {
        a.b(f33693a, "finishResumeActivity: ");
        a(message);
    }

    public void finishStopActivity(Message message) {
        a.b(f33693a, "finishStopActivity: ");
        a(message);
    }

    private void a(IBinder iBinder) throws Exception {
        Object invoke = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class cls2 = Integer.TYPE;
        cls.getDeclaredMethod("finishActivity", new Class[]{IBinder.class, cls2, Intent.class, cls2}).invoke(invoke, new Object[]{iBinder, 0, null, 0});
    }
}
