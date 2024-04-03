package com.instabug.library.apichecker;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import sc.a;
import sc.b;
import sc.c;
import sc.d;
import sc.e;

public class APIChecker {
    public static final String MAIN_THREAD_ERROR_MESSAGE = "Threading violation: {%s} should only be called from a background thread, but was called from main thread.";
    public static final String NOT_BUILT_ERROR_MESSAGE = "Instabug API {%s} was called before the SDK is built. To build it, please call Instabug.Builder().build().";
    public static final String NOT_ENABLED_ERROR_MESSAGE = "Instabug API {%s} was called while the SDK is disabled. To enable it, please call Instabug.enable().";
    public static final String NOT_EXECUTED_ERROR_MESSAGE = "Instabug failed to execute {%s}";

    @Nullable
    public static <T> T checkAndGet(@NonNull String str, @NonNull ReturnableRunnable<T> returnableRunnable, @Nullable T t11) {
        checkMainThreadCalls(str);
        return PoolProvider.getApiExecutor().executeAndGet(new b(returnableRunnable, str, t11));
    }

    public static void checkAndRun(@NonNull String str, @NonNull VoidRunnable voidRunnable) {
        try {
            checkBuilt();
            checkEnabled();
            voidRunnable.run();
        } catch (a unused) {
            logSdkNotBuilt(str);
        } catch (b unused2) {
            logSdkNotEnabled(str);
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    public static void checkAndRunInExecutor(@NonNull String str, @NonNull VoidRunnable voidRunnable) {
        PoolProvider.getApiExecutor().execute(new e(voidRunnable, str));
    }

    public static void checkAndRunInExecutorThenPostOnMain(@NonNull String str, @NonNull VoidRunnable voidRunnable) {
        PoolProvider.getApiExecutor().execute(new c(voidRunnable, str));
    }

    public static void checkAndRunOrThrow(@NonNull String str, @NonNull VoidRunnable voidRunnable) throws Exception {
        try {
            checkBuilt();
            checkEnabled();
            PoolProvider.getApiExecutor().execute(new d(voidRunnable, str));
        } catch (a e11) {
            logSdkNotBuilt(str);
            throw e11;
        } catch (b e12) {
            logSdkNotEnabled(str);
            throw e12;
        } catch (Exception e13) {
            logExecutionException(str, e13);
            throw e13;
        }
    }

    public static void checkBuilt(@NonNull String str, @NonNull VoidRunnable voidRunnable) {
        try {
            checkBuilt();
            voidRunnable.run();
        } catch (a unused) {
            logSdkNotBuilt(str);
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    public static void checkEnable(@NonNull String str, @NonNull VoidRunnable voidRunnable) {
        try {
            checkEnabled();
            voidRunnable.run();
        } catch (b unused) {
            logSdkNotEnabled(str);
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    private static void checkEnabled() throws b {
        if (!Instabug.isEnabled()) {
            throw new b("Instabug API called while Instabug SDK was disabled");
        }
    }

    private static void checkMainThreadCalls(String str) {
        if (Thread.currentThread().getName().equals("main")) {
            logMainThreadWarning(str);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$checkAndGet$0(ReturnableRunnable returnableRunnable, String str, Object obj) {
        try {
            checkBuilt();
            checkEnabled();
            return returnableRunnable.run();
        } catch (a unused) {
            logSdkNotBuilt(str);
            return obj;
        } catch (b unused2) {
            logSdkNotEnabled(str);
            return obj;
        } catch (Exception e11) {
            logExecutionException(str, e11);
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAndRunInExecutor$1(VoidRunnable voidRunnable, String str) {
        try {
            checkBuilt();
            checkEnabled();
            voidRunnable.run();
        } catch (a unused) {
            logSdkNotBuilt(str);
        } catch (b unused2) {
            logSdkNotEnabled(str);
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAndRunInExecutorThenPostOnMain$2(VoidRunnable voidRunnable) {
        try {
            voidRunnable.run();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAndRunInExecutorThenPostOnMain$3(VoidRunnable voidRunnable, String str) {
        try {
            checkBuilt();
            checkEnabled();
            PoolProvider.postMainThreadTask(new a(voidRunnable));
        } catch (a unused) {
            logSdkNotBuilt(str);
        } catch (b unused2) {
            logSdkNotEnabled(str);
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAndRunOrThrow$4(VoidRunnable voidRunnable, String str) {
        try {
            voidRunnable.run();
        } catch (Exception e11) {
            logExecutionException(str, e11);
        }
    }

    private static void logExecutionException(String str, Exception exc) {
        InstabugSDKLogger.e("IBG-Core", String.format(NOT_EXECUTED_ERROR_MESSAGE, new Object[]{str}) + " due to" + exc.getMessage());
    }

    private static void logMainThreadWarning(String str) {
        Log.w("IBG-Core", String.format(MAIN_THREAD_ERROR_MESSAGE, new Object[]{str}));
    }

    private static void logSdkNotBuilt(String str) {
        Log.e("IBG-Core", String.format(NOT_BUILT_ERROR_MESSAGE, new Object[]{str}));
    }

    private static void logSdkNotEnabled(String str) {
        Log.e("IBG-Core", String.format(NOT_ENABLED_ERROR_MESSAGE, new Object[]{str}));
    }

    private static void checkBuilt() throws a {
        if (!Instabug.isBuilt()) {
            throw new a("Instabug API called before Instabug.Builder().build() was called");
        }
    }
}
