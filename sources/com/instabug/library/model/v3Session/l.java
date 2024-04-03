package com.instabug.library.model.v3Session;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.model.common.Session;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.sessionV3.configurations.c;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.extenstions.a;
import com.instabug.library.util.extenstions.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f51616a = new l();

    private l() {
    }

    private final y c(IBGCursor iBGCursor) {
        return new y(b.e(iBGCursor, "uuid"), b.d(iBGCursor, InstabugDbContract.SessionEntry.COLUMN_USER_NAME), b.d(iBGCursor, InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL), b.d(iBGCursor, "user_attributes"), b.a(iBGCursor, InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED), b.d(iBGCursor, "user_events"));
    }

    private final a0 d(IBGCursor iBGCursor) {
        return new a0(b.c(iBGCursor, "nano_start_time"), b.c(iBGCursor, "background_start_time"), b.c(iBGCursor, "foreground_start_time"));
    }

    @NotNull
    public final IBGContentValues a(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put("session_id", gVar.c(), true);
        iBGContentValues.put("duration", Long.valueOf(gVar.b()), false);
        iBGContentValues.put("v2_session_sent", Integer.valueOf(a.a(Boolean.valueOf(gVar.j()))), false);
        iBGContentValues.put("stitching_state", gVar.g().name(), false);
        iBGContentValues.put("sync_status", gVar.h().name(), true);
        w d11 = gVar.d();
        iBGContentValues.put(InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE, d11 == null ? null : f51616a.a(d11), false);
        l lVar = f51616a;
        lVar.a(iBGContentValues, gVar.f());
        lVar.a(iBGContentValues, gVar.i());
        lVar.a(iBGContentValues, gVar.a());
        return iBGContentValues;
    }

    @NotNull
    public final Session b(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        return new k(gVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.instabug.library.model.v3Session.g e(@org.jetbrains.annotations.NotNull com.instabug.library.internal.storage.cache.dbv2.IBGCursor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4.moveToNext()     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r4
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x0013
            r0 = r1
            goto L_0x0019
        L_0x0013:
            com.instabug.library.model.v3Session.l r2 = f51616a     // Catch:{ all -> 0x001d }
            com.instabug.library.model.v3Session.g r0 = r2.b((com.instabug.library.internal.storage.cache.dbv2.IBGCursor) r0)     // Catch:{ all -> 0x001d }
        L_0x0019:
            kotlin.io.CloseableKt.closeFinally(r4, r1)
            return r0
        L_0x001d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.v3Session.l.e(com.instabug.library.internal.storage.cache.dbv2.IBGCursor):com.instabug.library.model.v3Session.g");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List f(@org.jetbrains.annotations.NotNull com.instabug.library.internal.storage.cache.dbv2.IBGCursor r3) {
        /*
            r2 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x001f }
            r0.<init>()     // Catch:{ all -> 0x001f }
        L_0x000a:
            boolean r1 = r3.moveToNext()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001a
            com.instabug.library.model.v3Session.l r1 = f51616a     // Catch:{ all -> 0x001f }
            com.instabug.library.model.v3Session.g r1 = r1.b((com.instabug.library.internal.storage.cache.dbv2.IBGCursor) r3)     // Catch:{ all -> 0x001f }
            r0.add(r1)     // Catch:{ all -> 0x001f }
            goto L_0x000a
        L_0x001a:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            return r0
        L_0x001f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.v3Session.l.f(com.instabug.library.internal.storage.cache.dbv2.IBGCursor):java.util.List");
    }

    private final g b(IBGCursor iBGCursor) {
        long c11 = b.c(iBGCursor, "session_serial");
        String e11 = b.e(iBGCursor, "session_id");
        y c12 = c(iBGCursor);
        q a11 = a(iBGCursor);
        b0 valueOf = b0.valueOf(b.e(iBGCursor, "stitching_state"));
        long c13 = b.c(iBGCursor, "duration");
        String d11 = b.d(iBGCursor, InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE);
        w a12 = d11 == null ? null : a(d11);
        return new g(c11, e11, c12, a11, valueOf, b.a(iBGCursor, "v2_session_sent"), d(iBGCursor), a12, c13, c0.valueOf(b.e(iBGCursor, "sync_status")));
    }

    private final Object c(Object obj) {
        Object jSONObject;
        if (a(obj)) {
            jSONObject = new JSONArray(obj.toString());
        } else if (!b(obj)) {
            return obj;
        } else {
            jSONObject = new JSONObject(obj.toString());
        }
        return jSONObject;
    }

    private final void a(IBGContentValues iBGContentValues, q qVar) {
        iBGContentValues.put(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, qVar.a(), false);
        iBGContentValues.put("os", qVar.d(), false);
        iBGContentValues.put("device", qVar.c(), false);
        iBGContentValues.put("sdk_version", qVar.e(), false);
        iBGContentValues.put("app_version", qVar.b(), false);
    }

    private final boolean b(Object obj) {
        return StringsKt__StringsJVMKt.startsWith$default(obj.toString(), "{", false, 2, (Object) null) && StringsKt__StringsJVMKt.endsWith$default(obj.toString(), "}", false, 2, (Object) null);
    }

    private final Request.Builder b(Request.Builder builder, c cVar) {
        int a11 = cVar.a();
        if (a11 > 0) {
            InstabugSDKLogger.w("IBG-Core", a11 + " sessions have been dropped due to reaching sessions storage limit. Please contact support for more information.");
            builder.addParameter(new RequestParameter("dsc", Integer.valueOf(a11)));
        }
        return builder;
    }

    private final void a(IBGContentValues iBGContentValues, y yVar) {
        iBGContentValues.put("uuid", yVar.f(), true);
        iBGContentValues.put("user_events", yVar.c(), false);
        iBGContentValues.put("user_attributes", yVar.a(), false);
        iBGContentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL, yVar.b(), false);
        String d11 = yVar.d();
        if (d11 == null) {
            d11 = "";
        }
        iBGContentValues.put(InstabugDbContract.SessionEntry.COLUMN_USER_NAME, d11, false);
        iBGContentValues.put(InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED, Integer.valueOf(a.a(Boolean.valueOf(yVar.e()))), false);
    }

    private final void a(IBGContentValues iBGContentValues, a0 a0Var) {
        iBGContentValues.put("background_start_time", Long.valueOf(a0Var.a()), false);
        iBGContentValues.put("nano_start_time", Long.valueOf(a0Var.c()), false);
        iBGContentValues.put("foreground_start_time", Long.valueOf(a0Var.b()), false);
    }

    private final q a(IBGCursor iBGCursor) {
        String e11 = b.e(iBGCursor, "device");
        String d11 = b.d(iBGCursor, "sdk_version");
        return new q(b.d(iBGCursor, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN), b.e(iBGCursor, "os"), e11, b.d(iBGCursor, "app_version"), d11);
    }

    @NotNull
    public final String a(@NotNull w wVar) {
        Intrinsics.checkNotNullParameter(wVar, "<this>");
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) wVar.a(new HashMap())));
        Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "hashMapOf<String, Any>()…)\n            .toString()");
        return jSONObjectInstrumentation;
    }

    @NotNull
    public final w a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("su", "other");
        boolean optBoolean = jSONObject.optBoolean("pua", false);
        boolean optBoolean2 = jSONObject.optBoolean("pub", false);
        boolean optBoolean3 = jSONObject.optBoolean("puc", false);
        boolean optBoolean4 = jSONObject.optBoolean("pufr", false);
        boolean optBoolean5 = jSONObject.optBoolean("pus", false);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(STORE_URL_KEY, DEFAULT_STORE_URL)");
        return new w(optString, optBoolean2, optBoolean5, optBoolean4, optBoolean, optBoolean3);
    }

    public static /* synthetic */ Request a(l lVar, h hVar, c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = com.instabug.library.sessionV3.di.c.l();
        }
        return lVar.a(hVar, cVar);
    }

    @Nullable
    public final Request a(@NotNull h hVar, @NotNull c cVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(cVar, "configurations");
        Request.Builder method = new Request.Builder().url(Endpoints.V3_SESSION).method("POST");
        Intrinsics.checkNotNullExpressionValue(method, "Builder().url(Endpoints.…ethod(RequestMethod.POST)");
        Request.Builder shorten = a(b(method, cVar), hVar.a()).shorten(true);
        Intrinsics.checkNotNullExpressionValue(shorten, "Builder().url(Endpoints.…           .shorten(true)");
        return a(a(shorten, hVar.b()), cVar).hasUuid(false).build();
    }

    private final Request.Builder a(Request.Builder builder, List list) {
        l lVar = f51616a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.a((Map) it.next()));
        }
        builder.addParameter(new RequestParameter("ses", new JSONArray((Collection<?>) arrayList)));
        return builder;
    }

    private final boolean a(Object obj) {
        return StringsKt__StringsJVMKt.startsWith$default(obj.toString(), "[", false, 2, (Object) null) && StringsKt__StringsJVMKt.endsWith$default(obj.toString(), "]", false, 2, (Object) null);
    }

    private final Request.Builder a(Request.Builder builder, c cVar) {
        if (cVar.c()) {
            builder.addHeader(new RequestParameter(Header.DEBUG_MODE_HEADER, "true"));
            builder.addParameter(new RequestParameter("dm", Boolean.TRUE));
        }
        return builder;
    }

    @NotNull
    public final Pair a(@NotNull IBGSessionData iBGSessionData) {
        Intrinsics.checkNotNullParameter(iBGSessionData, "<this>");
        return TuplesKt.to(iBGSessionData.getFeatureKey(), iBGSessionData.getFeatureData());
    }

    private final Request.Builder a(Request.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            builder.addParameter(new RequestParameter((String) entry.getKey(), f51616a.c(entry.getValue())));
        }
        return builder;
    }

    private final Map a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), f51616a.c(entry.getValue())));
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }
}
