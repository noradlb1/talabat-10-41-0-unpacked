package com.instabug.library.sessionV3.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.model.v3Session.a0;
import com.instabug.library.model.v3Session.b0;
import com.instabug.library.sessionV3.di.c;
import com.instabug.library.user.UserEvent;
import com.instabug.library.user.f;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.a;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Instrumented
public final class e implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f51822a = new e();

    private e() {
    }

    private final Context p() {
        return Instabug.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
        r1 = r1.toString();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(@org.jetbrains.annotations.Nullable com.instabug.library.model.UserAttributes r1) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            goto L_0x0009
        L_0x0003:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x000c
        L_0x0009:
            java.lang.String r1 = "{}"
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.sessionV3.providers.e.a(com.instabug.library.model.UserAttributes):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
        r1 = r1.keysAsStringJsonArray();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(@org.jetbrains.annotations.Nullable com.instabug.library.model.UserAttributes r1) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            goto L_0x0009
        L_0x0003:
            java.lang.String r1 = r1.keysAsStringJsonArray()
            if (r1 != 0) goto L_0x000b
        L_0x0009:
            java.lang.String r1 = "[]"
        L_0x000b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.sessionV3.providers.e.b(com.instabug.library.model.UserAttributes):java.lang.String");
    }

    public boolean c() {
        return a(Feature.SURVEYS);
    }

    public boolean d() {
        return a(Feature.FEATURE_REQUESTS);
    }

    public boolean e() {
        return InstabugCore.isCrashReportingEnabled();
    }

    @Nullable
    public String f() {
        if (m()) {
            return f.h();
        }
        return null;
    }

    @Nullable
    public String g() {
        return InstabugCore.getSDKVersion();
    }

    @Nullable
    public String getAppVersion() {
        Context p11 = p();
        if (p11 == null) {
            return null;
        }
        return DeviceStateProvider.getAppVersion(p11);
    }

    @NotNull
    public String getOs() {
        String os2 = DeviceStateProvider.getOS();
        Intrinsics.checkNotNullExpressionValue(os2, "getOS()");
        return os2;
    }

    @NotNull
    public String getUuid() {
        String k11 = f.k();
        Intrinsics.checkNotNullExpressionValue(k11, "getUUID()");
        return k11;
    }

    @Nullable
    public String h() {
        return Instabug.getAppToken();
    }

    @NotNull
    public String i() {
        String a11;
        Context p11 = p();
        if (p11 == null || (a11 = a.a(p11)) == null) {
            return "other";
        }
        return a11;
    }

    @NotNull
    public List j() {
        List<UserEvent> userEvents = InstabugUserEventLogger.getInstance().getUserEvents();
        Intrinsics.checkNotNullExpressionValue(userEvents, "getInstance()\n            .userEvents");
        return CollectionsKt___CollectionsKt.toList(userEvents);
    }

    @NotNull
    public String k() {
        if (InstabugDeviceProperties.isProbablyAnEmulator()) {
            return Intrinsics.stringPlus("Emulator - ", InstabugDeviceProperties.getDeviceType());
        }
        String deviceType = InstabugDeviceProperties.getDeviceType();
        Intrinsics.checkNotNullExpressionValue(deviceType, "getDeviceType()");
        return deviceType;
    }

    @Nullable
    public String l() {
        if (m()) {
            return f.i();
        }
        return null;
    }

    public boolean m() {
        return InstabugCore.isUsersPageEnabled();
    }

    @Nullable
    public UserAttributes n() {
        HashMap hashMap = (HashMap) Filters.applyOn(UserAttributesDbHelper.getAll()).apply(h.g()).thenGet();
        if (hashMap == null) {
            return null;
        }
        if (hashMap.isEmpty()) {
            hashMap = null;
        }
        if (hashMap == null) {
            return null;
        }
        UserAttributes userAttributes = new UserAttributes();
        userAttributes.putMap(hashMap);
        return userAttributes;
    }

    public boolean o() {
        Context applicationContext;
        String packageName;
        boolean z11;
        Context p11 = p();
        if (p11 == null || (applicationContext = p11.getApplicationContext()) == null || (packageName = applicationContext.getPackageName()) == null) {
            return false;
        }
        if (packageName.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            packageName = null;
        }
        if (packageName == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) packageName, (Object) f51822a.a("debug.instabug.apm.app"));
    }

    @NotNull
    public String a(@NotNull List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            JSONArray json = UserEvent.toJson(list);
            obj = Result.m6329constructorimpl(!(json instanceof JSONArray) ? json.toString() : JSONArrayInstrumentation.toString(json));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("parsing user events got error: ", message));
        }
        Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
        if (r03 != null) {
            String message2 = r03.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("parsing user events got error: ", str), r03);
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return (String) obj;
    }

    @NotNull
    public String b(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray keysAsJsonArray = UserEvent.keysAsJsonArray(list);
        String jSONArray = !(keysAsJsonArray instanceof JSONArray) ? keysAsJsonArray.toString() : JSONArrayInstrumentation.toString(keysAsJsonArray);
        Intrinsics.checkNotNullExpressionValue(jSONArray, "run(UserEvent::keysAsJsonArray).toString()");
        return jSONArray;
    }

    public boolean b() {
        return a(Feature.BUG_REPORTING);
    }

    private final boolean a(Feature feature) {
        return InstabugCore.isFeatureEnabled(feature);
    }

    public boolean a() {
        return InstabugCore.isAPMEnabled();
    }

    @NotNull
    public b0 a(@NotNull a0 a0Var) {
        Intrinsics.checkNotNullParameter(a0Var, "startTime");
        if (a0Var.e()) {
            return b0.BACKGROUND_SESSION;
        }
        if (c.f51790a.s().a(a0Var.b())) {
            return b0.SESSION_LEAD;
        }
        return b0.STITCHED;
    }

    @Nullable
    @SuppressLint({"PrivateApi"})
    public final String a(@Nullable String str) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Class.forName("android.os.SystemProperties"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            String message = r12.getMessage();
            if (message == null) {
                message = "";
            }
            InstabugCore.reportError(r12, Intrinsics.stringPlus("", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("", message2), r13);
        }
        String str2 = null;
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        Class cls = (Class) obj;
        if (cls == null) {
            return null;
        }
        try {
            obj2 = Result.m6329constructorimpl(cls.getDeclaredMethod("get", new Class[]{String.class}));
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable r62 = Result.m6332exceptionOrNullimpl(obj2);
        if (r62 != null) {
            String message3 = r62.getMessage();
            if (message3 == null) {
                message3 = "";
            }
            InstabugCore.reportError(r62, Intrinsics.stringPlus("", message3));
        }
        Throwable r63 = Result.m6332exceptionOrNullimpl(obj2);
        if (r63 != null) {
            String message4 = r63.getMessage();
            if (message4 == null) {
                message4 = "";
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("", message4), r63);
        }
        if (Result.m6335isFailureimpl(obj2)) {
            obj2 = null;
        }
        Method method = (Method) obj2;
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke((Object) null, new Object[]{str});
            if (invoke != null) {
                obj3 = Result.m6329constructorimpl((String) invoke);
                Throwable r02 = Result.m6332exceptionOrNullimpl(obj3);
                if (r02 != null) {
                    String message5 = r02.getMessage();
                    if (message5 == null) {
                        message5 = "";
                    }
                    InstabugCore.reportError(r02, Intrinsics.stringPlus("", message5));
                }
                Throwable r03 = Result.m6332exceptionOrNullimpl(obj3);
                if (r03 != null) {
                    String message6 = r03.getMessage();
                    if (message6 == null) {
                        message6 = "";
                    }
                    InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("", message6), r03);
                }
                if (!Result.m6335isFailureimpl(obj3)) {
                    str2 = obj3;
                }
                return str2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th4) {
            Result.Companion companion4 = Result.Companion;
            obj3 = Result.m6329constructorimpl(ResultKt.createFailure(th4));
        }
    }
}
