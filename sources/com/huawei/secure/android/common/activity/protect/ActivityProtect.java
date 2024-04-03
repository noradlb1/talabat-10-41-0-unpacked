package com.huawei.secure.android.common.activity.protect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.Thread;
import java.lang.reflect.Field;

public final class ActivityProtect {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33683a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f33684b = "ActivityProtect";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static IActivityProtect f33685c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static ExceptionHandler f33686d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f33687e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f33688f;

    public static class a implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread thread, Throwable th2) {
            if (ActivityProtect.f33686d != null) {
                ActivityProtect.f33686d.uncaughtExceptionHappened(thread, th2);
            }
            if (thread == Looper.getMainLooper().getThread()) {
                ActivityProtect.d(th2);
                ActivityProtect.e(th2);
                ActivityProtect.i();
            }
        }
    }

    public static class b implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f33689b;

        public b(Handler handler) {
            this.f33689b = handler;
        }

        public boolean handleMessage(Message message) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (!ActivityProtect.f33683a) {
                    com.huawei.secure.android.common.activity.a.b(ActivityProtect.f33684b, "handleMessage: >= 28");
                    boolean unused = ActivityProtect.f33683a = true;
                }
                if (message.what != 159) {
                    return false;
                }
                try {
                    this.f33689b.handleMessage(message);
                } catch (Throwable th2) {
                    ActivityProtect.f33685c.finishLaunchActivity(message);
                    ActivityProtect.f(th2);
                }
                return true;
            }
            if (!ActivityProtect.f33683a) {
                com.huawei.secure.android.common.activity.a.b(ActivityProtect.f33684b, "handleMessage: < 28");
                boolean unused2 = ActivityProtect.f33683a = true;
            }
            int i11 = message.what;
            if (i11 == 104) {
                try {
                    this.f33689b.handleMessage(message);
                } catch (Throwable th3) {
                    ActivityProtect.f33685c.finishStopActivity(message);
                    ActivityProtect.f(th3);
                }
                return true;
            } else if (i11 == 107) {
                try {
                    this.f33689b.handleMessage(message);
                } catch (Throwable th4) {
                    ActivityProtect.f33685c.finishResumeActivity(message);
                    ActivityProtect.f(th4);
                }
                return true;
            } else if (i11 != 109) {
                switch (i11) {
                    case 100:
                        try {
                            this.f33689b.handleMessage(message);
                        } catch (Throwable th5) {
                            ActivityProtect.f33685c.finishLaunchActivity(message);
                            ActivityProtect.f(th5);
                        }
                        return true;
                    case 101:
                    case 102:
                        try {
                            this.f33689b.handleMessage(message);
                        } catch (Throwable th6) {
                            ActivityProtect.f33685c.finishPauseActivity(message);
                            ActivityProtect.f(th6);
                        }
                        return true;
                    default:
                        return false;
                }
            } else {
                try {
                    this.f33689b.handleMessage(message);
                } catch (Throwable th7) {
                    ActivityProtect.f(th7);
                }
                return true;
            }
        }
    }

    private ActivityProtect() {
    }

    /* access modifiers changed from: private */
    public static void e(Throwable th2) {
        if (th2 != null && f33686d != null) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                length--;
                if (length > -1 && stackTrace.length - length <= 20) {
                    if ("java.lang.ThreadGroup".equals(stackTrace[length].getClassName())) {
                        com.huawei.secure.android.common.activity.a.a(f33684b, "java.lang.ThreadGroup , suggest killing self ");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private static void f() throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(invoke);
        Field declaredField2 = Handler.class.getDeclaredField("mCallback");
        declaredField2.setAccessible(true);
        declaredField2.set(handler, new b(handler));
    }

    private static boolean h() {
        return f33688f;
    }

    /* access modifiers changed from: private */
    public static void i() {
        f33688f = true;
        if (f33686d != null) {
            com.huawei.secure.android.common.activity.a.b(f33684b, "safeMode: enter safe mode");
        }
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th2) {
                d(th2);
                e(th2);
                ExceptionHandler exceptionHandler = f33686d;
                if (exceptionHandler != null) {
                    exceptionHandler.a(th2);
                }
            }
        }
    }

    public static void init(Context context, ExceptionHandler exceptionHandler) {
        if (!f33687e) {
            try {
                f.a(context);
            } catch (Throwable th2) {
                String str = f33684b;
                com.huawei.secure.android.common.activity.a.a(str, "un reflect error :" + th2.getMessage(), th2);
            }
            f33687e = true;
            f33686d = exceptionHandler;
            g();
            Thread.setDefaultUncaughtExceptionHandler(new a());
        }
    }

    /* access modifiers changed from: private */
    public static void d(Throwable th2) {
        if (th2 != null && f33686d != null) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                length--;
                if (length > -1 && stackTrace.length - length <= 20) {
                    StackTraceElement stackTraceElement = stackTrace[length];
                    if ("android.view.Choreographer".equals(stackTraceElement.getClassName()) && "Choreographer.java".equals(stackTraceElement.getFileName()) && "doFrame".equals(stackTraceElement.getMethodName())) {
                        com.huawei.secure.android.common.activity.a.a(f33684b, "isChoreographerException BlackScreen , suggest killing self ");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private static void g() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            f33685c = new e();
        } else if (i11 >= 26) {
            f33685c = new d();
        } else if (i11 == 25 || i11 == 24) {
            f33685c = new c();
        } else if (i11 <= 23) {
            f33685c = new b();
        }
        try {
            f();
        } catch (Throwable th2) {
            String str = f33684b;
            com.huawei.secure.android.common.activity.a.a(str, "initActivityProtect: " + th2.getMessage(), th2);
        }
    }

    /* access modifiers changed from: private */
    public static void f(Throwable th2) {
        if (f33686d != null) {
            if (h()) {
                f33686d.a(th2);
                return;
            }
            f33686d.uncaughtExceptionHappened(Looper.getMainLooper().getThread(), th2);
            i();
        }
    }
}
