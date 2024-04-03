package com.huawei.secure.android.common.activity.protect;

import android.app.ActivityManager;
import android.app.servertransaction.ClientTransaction;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import com.huawei.secure.android.common.activity.a;
import java.lang.reflect.Method;

public class e implements IActivityProtect {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33695a = "e";

    private void a(Message message) throws Throwable {
        a(((ClientTransaction) message.obj).getActivityToken());
    }

    private void b(Message message) throws Throwable {
        Object obj = message.obj;
        a((IBinder) obj.getClass().getDeclaredMethod("getActivityToken", new Class[0]).invoke(obj, new Object[0]));
    }

    private void c(Message message) throws Throwable {
        Object obj = message.obj;
        a((IBinder) obj.getClass().getDeclaredField("mActivityToken").get(obj));
    }

    public void finishLaunchActivity(Message message) {
        a.b(f33695a, "finishLaunchActivity: ");
        try {
            a(message);
        } catch (Throwable unused) {
            a.a(f33695a, "finishLaunchActivity2 exception ");
            try {
                c(message);
            } catch (Throwable unused2) {
                a.a(f33695a, "finishLaunchActivity3 exception ");
            }
        }
    }

    public void finishPauseActivity(Message message) {
    }

    public void finishResumeActivity(Message message) {
    }

    public void finishStopActivity(Message message) {
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
