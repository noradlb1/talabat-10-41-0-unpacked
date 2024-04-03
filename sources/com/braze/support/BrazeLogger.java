package com.braze.support;

import android.util.Log;
import bo.app.b6;
import bo.app.u5;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\bÇ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b8\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0002H\u0007J.\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0002H\u0007J.\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0002H\u0007J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0014\u0010\u0016\u001a\u00020\t2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u001a\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0014\u0010\u001d\u001a\u00020\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH\u0002J$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\n\u0010\u0016\u001a\u00020\t*\u00020\tJ8\u0010#\u001a\u00020\u0004*\u00020\u00012\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001cJ<\u0010#\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001cJ\n\u0010$\u001a\u00020\t*\u00020\u0001R\u001a\u0010%\u001a\u00020\u00068\u0006XT¢\u0006\f\n\u0004\b%\u0010&\u0012\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u00068\u0006XT¢\u0006\f\n\u0004\b)\u0010&\u0012\u0004\b*\u0010(R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b.\u0010&R\u0014\u0010/\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00068\u0002XD¢\u0006\u0006\n\u0004\b1\u0010&R0\u00102\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0018\n\u0004\b2\u0010&\u0012\u0004\b7\u0010(\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/braze/support/BrazeLogger;", "", "", "returnOnDebug", "", "checkForSystemLogLevelProperty", "", "initialLogLevel", "setInitialLogLevelFromConfiguration", "", "tag", "msg", "", "tr", "v", "includeInTestUserLog", "d", "i", "w", "e", "Ljava/lang/Class;", "classForTag", "getBrazeLogTag", "Lbo/app/b6;", "loggingManager", "setTestUserDeviceLoggingManager", "resetForTesting", "willAppendToTestUserLog", "Lkotlin/Function0;", "toStringSafe", "appendToDeviceLogData", "canAppendToTestUserLog", "Lcom/braze/support/BrazeLogger$Priority;", "priority", "message", "brazelog", "brazeLogTag", "SUPPRESS", "I", "getSUPPRESS$annotations", "()V", "VERBOSE", "getVERBOSE$annotations", "isSystemPropLogLevelSet", "Z", "hasLogLevelBeenSetForAppRun", "DESIRED_MAX_APPBOY_TAG_LENGTH", "LOG_LEVEL_PROPERTY_NAME", "Ljava/lang/String;", "MAX_REMAINING_LENGTH_FOR_CLASS_TAG", "logLevel", "getLogLevel", "()I", "setLogLevel", "(I)V", "getLogLevel$annotations", "<init>", "Priority", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class BrazeLogger {
    private static final int DESIRED_MAX_APPBOY_TAG_LENGTH = 80;
    public static final BrazeLogger INSTANCE = new BrazeLogger();
    private static final String LOG_LEVEL_PROPERTY_NAME = "log.tag.APPBOY";
    private static final int MAX_REMAINING_LENGTH_FOR_CLASS_TAG = 65;
    public static final int SUPPRESS = Integer.MAX_VALUE;
    public static final int VERBOSE = -1;
    private static boolean hasLogLevelBeenSetForAppRun;
    private static boolean isSystemPropLogLevelSet;
    private static int logLevel = 4;
    private static b6 testUserDeviceLoggingManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/braze/support/BrazeLogger$Priority;", "", "logLevel", "", "(Ljava/lang/String;II)V", "getLogLevel", "()I", "D", "I", "E", "V", "W", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Priority {
        D(3),
        I(4),
        E(6),
        V(2),
        W(5);
        
        private final int logLevel;

        private Priority(int i11) {
            this.logLevel = i11;
        }

        public final int getLogLevel() {
            return this.logLevel;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43936a;

        static {
            int[] iArr = new int[Priority.values().length];
            iArr[Priority.D.ordinal()] = 1;
            iArr[Priority.I.ordinal()] = 2;
            iArr[Priority.E.ordinal()] = 3;
            iArr[Priority.W.ordinal()] = 4;
            iArr[Priority.V.ordinal()] = 5;
            f43936a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Exception f43937g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Exception exc) {
            super(0);
            this.f43937g = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to append to test user device log. ", this.f43937g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43938g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f43938g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "BrazeLogger log level set to " + this.f43938g + " via device system property. Note that subsequent calls to BrazeLogger.setLogLevel() will have no effect.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43939g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i11) {
            super(0);
            this.f43939g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Log level already set via system property. BrazeLogger.setLogLevel() ignored for level: ", Integer.valueOf(this.f43939g));
        }
    }

    private BrazeLogger() {
    }

    private final void appendToDeviceLogData(String str, String str2, Throwable th2) {
        try {
            if (canAppendToTestUserLog()) {
                b6 b6Var = testUserDeviceLoggingManager;
                if (b6Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("testUserDeviceLoggingManager");
                    b6Var = null;
                }
                b6Var.a(str, str2, th2);
            }
        } catch (Exception e11) {
            Exception exc = e11;
            brazelog$default(this, (Object) this, Priority.E, (Throwable) exc, false, (Function0) new b(exc), 4, (Object) null);
        }
    }

    public static /* synthetic */ void brazelog$default(BrazeLogger brazeLogger, Object obj, Priority priority, Throwable th2, boolean z11, Function0 function0, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            priority = Priority.D;
        }
        Priority priority2 = priority;
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        Throwable th3 = th2;
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        brazeLogger.brazelog(obj, priority2, th3, z11, (Function0<String>) function0);
    }

    private final boolean canAppendToTestUserLog() {
        b6 b6Var = testUserDeviceLoggingManager;
        if (b6Var == null) {
            return false;
        }
        return b6Var.e();
    }

    @JvmStatic
    public static final synchronized void checkForSystemLogLevelProperty(boolean z11) {
        synchronized (BrazeLogger.class) {
            BrazeLogger brazeLogger = INSTANCE;
            String a11 = u5.a(LOG_LEVEL_PROPERTY_NAME);
            if (StringsKt__StringsJVMKt.equals("verbose", StringsKt__StringsKt.trim((CharSequence) a11).toString(), true)) {
                setLogLevel(2);
                isSystemPropLogLevelSet = true;
                brazelog$default(brazeLogger, (Object) brazeLogger, Priority.I, (Throwable) null, false, (Function0) new c(a11), 6, (Object) null);
            }
        }
    }

    public static /* synthetic */ void checkForSystemLogLevelProperty$default(boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        checkForSystemLogLevelProperty(z11);
    }

    @JvmStatic
    public static final void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        d$default(str, str2, (Throwable) null, false, 12, (Object) null);
    }

    @JvmStatic
    public static final void d(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        d$default(str, str2, th2, false, 8, (Object) null);
    }

    @JvmStatic
    public static final void d(String str, String str2, Throwable th2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z11) {
            INSTANCE.appendToDeviceLogData(str, str2, th2);
        }
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        d(str, str2, th2, z11);
    }

    @JvmStatic
    public static final void e(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th2, "tr");
        INSTANCE.appendToDeviceLogData(str, str2, th2);
        if (logLevel <= 6) {
            Log.e(str, str2, th2);
        }
    }

    @JvmStatic
    public static final String getBrazeLogTag(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "classForTag");
        String name2 = cls.getName();
        int length = name2.length();
        int i11 = MAX_REMAINING_LENGTH_FOR_CLASS_TAG;
        if (length <= i11) {
            Intrinsics.checkNotNullExpressionValue(name2, "{\n            // No need…  fullClassName\n        }");
        } else {
            Intrinsics.checkNotNullExpressionValue(name2, "fullClassName");
            name2 = name2.substring(length - i11);
            Intrinsics.checkNotNullExpressionValue(name2, "this as java.lang.String).substring(startIndex)");
        }
        return Intrinsics.stringPlus("Braze v23.3.0 .", name2);
    }

    public static final int getLogLevel() {
        return logLevel;
    }

    @JvmStatic
    public static /* synthetic */ void getLogLevel$annotations() {
    }

    public static /* synthetic */ void getSUPPRESS$annotations() {
    }

    public static /* synthetic */ void getVERBOSE$annotations() {
    }

    @JvmStatic
    public static final void i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        i$default(str, str2, (Throwable) null, false, 12, (Object) null);
    }

    @JvmStatic
    public static final void i(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        i$default(str, str2, th2, false, 8, (Object) null);
    }

    @JvmStatic
    public static final void i(String str, String str2, Throwable th2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z11) {
            INSTANCE.appendToDeviceLogData(str, str2, th2);
        }
        if (logLevel > 4) {
            return;
        }
        if (th2 != null) {
            Log.i(str, str2, th2);
        } else {
            Log.i(str, str2);
        }
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        i(str, str2, th2, z11);
    }

    @JvmStatic
    public static final void resetForTesting() {
        isSystemPropLogLevelSet = false;
        hasLogLevelBeenSetForAppRun = false;
    }

    @JvmStatic
    public static final synchronized void setInitialLogLevelFromConfiguration(int i11) {
        synchronized (BrazeLogger.class) {
            if (!hasLogLevelBeenSetForAppRun) {
                setLogLevel(i11);
            }
        }
    }

    public static final synchronized void setLogLevel(int i11) {
        synchronized (BrazeLogger.class) {
            if (!isSystemPropLogLevelSet) {
                hasLogLevelBeenSetForAppRun = true;
                logLevel = i11;
            } else {
                BrazeLogger brazeLogger = INSTANCE;
                brazelog$default(brazeLogger, (Object) brazeLogger, Priority.W, (Throwable) null, false, (Function0) new d(i11), 6, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setTestUserDeviceLoggingManager(b6 b6Var) {
        Intrinsics.checkNotNullParameter(b6Var, "loggingManager");
        testUserDeviceLoggingManager = b6Var;
    }

    private final String toStringSafe(Function0<? extends Object> function0) {
        try {
            return String.valueOf(function0.invoke());
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    public static final void v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        v$default(str, str2, (Throwable) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void v(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        v(str, str2, th2);
    }

    @JvmStatic
    public static final void w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        w$default(str, str2, (Throwable) null, false, 12, (Object) null);
    }

    @JvmStatic
    public static final void w(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        w$default(str, str2, th2, false, 8, (Object) null);
    }

    @JvmStatic
    public static final void w(String str, String str2, Throwable th2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z11) {
            INSTANCE.appendToDeviceLogData(str, str2, th2);
        }
        if (logLevel > 5) {
            return;
        }
        if (th2 != null) {
            Log.w(str, str2, th2);
        } else {
            Log.w(str, str2);
        }
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        w(str, str2, th2, z11);
    }

    private final boolean willAppendToTestUserLog(boolean z11) {
        return z11 && canAppendToTestUserLog();
    }

    public final String brazeLogTag(Object obj) {
        boolean z11;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String name2 = obj.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "fullClassName");
        String substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(StringsKt__StringsKt.substringBefore$default(name2, '$', (String) null, 2, (Object) null), '.', (String) null, 2, (Object) null);
        if (substringAfterLast$default.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return getBrazeLogTag(name2);
        }
        return getBrazeLogTag(substringAfterLast$default);
    }

    public final void brazelog(Object obj, Priority priority, Throwable th2, boolean z11, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(function0, "message");
        if (logLevel <= priority.getLogLevel() || willAppendToTestUserLog(z11)) {
            brazelog(brazeLogTag(obj), priority, th2, z11, function0);
        }
    }

    public static /* synthetic */ void brazelog$default(BrazeLogger brazeLogger, String str, Priority priority, Throwable th2, boolean z11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            priority = Priority.D;
        }
        Priority priority2 = priority;
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        Throwable th3 = th2;
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        brazeLogger.brazelog(str, priority2, th3, z11, (Function0<String>) function0);
    }

    public final void brazelog(String str, Priority priority, Throwable th2, boolean z11, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(function0, "message");
        if (logLevel <= priority.getLogLevel() || willAppendToTestUserLog(z11)) {
            int i11 = a.f43936a[priority.ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            if (i11 == 5) {
                                if (th2 == null) {
                                    toStringSafe(function0);
                                } else {
                                    toStringSafe(function0);
                                }
                            }
                        } else if (th2 == null) {
                            Log.w(str, toStringSafe(function0));
                        } else {
                            Log.w(str, toStringSafe(function0), th2);
                        }
                    } else if (th2 == null) {
                        Log.w(str, toStringSafe(function0));
                    } else {
                        Log.e(str, toStringSafe(function0), th2);
                    }
                } else if (th2 == null) {
                    Log.i(str, toStringSafe(function0));
                } else {
                    Log.i(str, toStringSafe(function0), th2);
                }
            } else if (th2 == null) {
                toStringSafe(function0);
            } else {
                toStringSafe(function0);
            }
        }
    }

    public final String getBrazeLogTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.stringPlus("Braze v23.3.0 .", str);
    }
}
