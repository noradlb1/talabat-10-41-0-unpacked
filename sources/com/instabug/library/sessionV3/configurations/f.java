package com.instabug.library.sessionV3.configurations;

import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.percentagefeatures.a;
import com.instabug.library.sessionV3.manager.m;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class f implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f51770a = new f();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51771b = LazyKt__LazyJVMKt.lazy(d.f51768a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f51772c = LazyKt__LazyJVMKt.lazy(e.f51769a);

    private f() {
    }

    private final c a() {
        return (c) f51771b.getValue();
    }

    private final m b() {
        return (m) f51772c.getValue();
    }

    private final JSONObject c(JSONObject jSONObject) {
        f fVar = f51770a;
        c a11 = fVar.a();
        fVar.a(jSONObject.optDouble("e", 0.0d));
        a11.b(jSONObject.optBoolean("dme", false));
        a11.a(jSONObject.optLong("i", 360));
        a11.b(jSONObject.optInt("rl", 10));
        a11.a(jSONObject.optInt("sl", 100));
        a11.setNonFatalStoreLimit(fVar.a(jSONObject, "nf", 100));
        a11.setAnrStoreLimit(fVar.a(jSONObject, "anrc", 100));
        a11.setFatalHangStoreLimit(fVar.a(jSONObject, "fh", 100));
        return jSONObject;
    }

    private final JSONObject d(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ex");
        if (optJSONObject != null) {
            c a11 = f51770a.a();
            a11.c(optJSONObject.optBoolean("en", false));
            a11.d(optJSONObject.optInt("l", 100));
        }
        return jSONObject;
    }

    private final JSONObject e(JSONObject jSONObject) {
        m b11 = f51770a.b();
        b11.a(jSONObject.optBoolean("se", true));
        b11.a(jSONObject.optInt(UserDataStore.STATE, 1800));
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@org.jetbrains.annotations.Nullable org.json.JSONObject r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x0005
            goto L_0x0012
        L_0x0005:
            org.json.JSONObject r5 = r4.c(r5)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            org.json.JSONObject r5 = r4.e(r5)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x0014
        L_0x0012:
            r5 = 0
            goto L_0x0018
        L_0x0014:
            org.json.JSONObject r5 = r4.d(r5)     // Catch:{ all -> 0x001d }
        L_0x0018:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x001d }
            goto L_0x0028
        L_0x001d:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0028:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            java.lang.String r1 = ""
            java.lang.String r2 = "Can't parse V3 Session configurations"
            if (r0 != 0) goto L_0x0033
            goto L_0x0041
        L_0x0033:
            java.lang.String r3 = r0.getMessage()
            if (r3 != 0) goto L_0x003a
            r3 = r1
        L_0x003a:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            com.instabug.library.core.InstabugCore.reportError(r0, r3)
        L_0x0041:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 != 0) goto L_0x0048
            goto L_0x0059
        L_0x0048:
            java.lang.String r0 = r5.getMessage()
            if (r0 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r1 = r0
        L_0x0050:
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.String r1 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.sessionV3.configurations.f.a(org.json.JSONObject):void");
    }

    public void b(@Nullable JSONObject jSONObject) {
        Object obj;
        if (jSONObject != null) {
            try {
                Result.Companion companion = Result.Companion;
                boolean z11 = true;
                boolean optBoolean = jSONObject.optBoolean("an_capture_session_duration_periodically", true);
                long optLong = jSONObject.optLong("an_capture_session_duration_interval", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                f fVar = f51770a;
                c a11 = fVar.a();
                if (!optBoolean || optLong <= 0) {
                    z11 = false;
                }
                a11.a(z11);
                fVar.a().b(optLong);
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
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
                InstabugCore.reportError(r02, Intrinsics.stringPlus("Can't parse V3 Session experiments configurations", message));
            }
            Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
            if (r03 != null) {
                String message2 = r03.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Can't parse V3 Session experiments configurations", str), r03);
            }
            Result.m6328boximpl(obj);
        }
    }

    private final int a(JSONObject jSONObject, String str, int i11) {
        Integer valueOf = Integer.valueOf(jSONObject.optInt(str, i11));
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        return valueOf == null ? i11 : valueOf.intValue();
    }

    private final void a(double d11) {
        a.a(Feature.V3_SESSION.name(), d11);
    }
}
