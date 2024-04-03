package com.instabug.library.diagnostics;

import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.diagnostics.customtraces.a;
import com.instabug.library.diagnostics.customtraces.settings.b;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.diagnostics.sdkEvents.f;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.settings.SettingsManager;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List f34219a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final a f34220b = com.instabug.library.diagnostics.customtraces.di.a.d();

    static {
        new b((DefaultConstructorMarker) null);
    }

    public c() {
        com.instabug.library.diagnostics.configuration.a e11 = com.instabug.library.diagnostics.nonfatals.di.a.e();
        Intrinsics.checkNotNullExpressionValue(e11, "getNonFatalsConfigurationHandler()");
        this.f34219a = CollectionsKt__CollectionsKt.listOf(e11, com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.f(), com.instabug.library.diagnostics.customtraces.di.a.f34228a.g());
    }

    private final e a() {
        return com.instabug.library.diagnostics.nonfatals.di.a.g();
    }

    private final com.instabug.library.diagnostics.sdkEvents.configurations.a b() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.c();
    }

    private final f c() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.j();
    }

    private final SettingsManager d() {
        SettingsManager instance = SettingsManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    private final void e(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "os_version_changed")) {
            e a11 = a();
            if (a11 != null) {
                a11.clearCache();
            }
            this.f34220b.clearCache();
            c().clearCache();
        }
    }

    private final void f(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "sdk_version_changed")) {
            e a11 = a();
            if (a11 != null) {
                a11.clearCache();
            }
            this.f34220b.clearCache();
            c().clearCache();
        }
    }

    private final void b(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) SDKCoreEvent.Feature.VALUE_UPDATED)) {
            f c11 = c();
            if (b().isEnabled()) {
                c11 = null;
            }
            if (c11 != null) {
                c11.clearCache();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlin.Unit} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ all -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object c(java.lang.String r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x003e }
            if (r5 != 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            org.json.JSONObject r5 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x003e }
            if (r5 != 0) goto L_0x000d
        L_0x000b:
            r5 = 0
            goto L_0x0032
        L_0x000d:
            com.instabug.library.settings.SettingsManager r0 = r4.d()     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "sync_interval"
            r2 = 1440(0x5a0, float:2.018E-42)
            int r1 = r5.optInt(r1, r2)     // Catch:{ all -> 0x003e }
            r0.setDiagnosticsSyncInterval(r1)     // Catch:{ all -> 0x003e }
            java.util.List r0 = r4.f34219a     // Catch:{ all -> 0x003e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003e }
        L_0x0022:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003e }
            com.instabug.library.diagnostics.configuration.a r1 = (com.instabug.library.diagnostics.configuration.a) r1     // Catch:{ all -> 0x003e }
            r1.a(r5)     // Catch:{ all -> 0x003e }
            goto L_0x0022
        L_0x0032:
            if (r5 != 0) goto L_0x0039
            r4.e()     // Catch:{ all -> 0x003e }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003e }
        L_0x0039:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x003e }
            goto L_0x0049
        L_0x003e:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0049:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0052
            goto L_0x0060
        L_0x0052:
            java.lang.String r2 = r0.getMessage()
            if (r2 != 0) goto L_0x0059
            r2 = r1
        L_0x0059:
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            com.instabug.library.core.InstabugCore.reportError(r0, r2)
        L_0x0060:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            java.lang.String r2 = "IBG-Core"
            if (r0 != 0) goto L_0x0069
            goto L_0x0077
        L_0x0069:
            java.lang.String r3 = r0.getMessage()
            if (r3 != 0) goto L_0x0070
            r3 = r1
        L_0x0070:
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            com.instabug.library.util.InstabugSDKLogger.e(r2, r1, r0)
        L_0x0077:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r0 != 0) goto L_0x007e
            goto L_0x0083
        L_0x007e:
            java.lang.String r1 = "Error in parsing Diagnostics"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r0, r1, r2)
        L_0x0083:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.c.c(java.lang.String):java.lang.Object");
    }

    private final void d(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "app_token_changed")) {
            this.f34220b.clearCache();
            e a11 = a();
            if (a11 != null) {
                a11.clearCache();
            }
            c().clearCache();
        }
    }

    public final void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "event");
        String type = sDKCoreEvent.getType();
        if (type != null) {
            switch (type.hashCode()) {
                case -376724013:
                    if (type.equals("sdk_version")) {
                        String value = sDKCoreEvent.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "event.value");
                        f(value);
                        return;
                    }
                    return;
                case -296668708:
                    if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                        c(sDKCoreEvent.getValue());
                        return;
                    }
                    return;
                case -290659267:
                    if (type.equals("features")) {
                        String value2 = sDKCoreEvent.getValue();
                        Intrinsics.checkNotNullExpressionValue(value2, "event.value");
                        b(value2);
                        return;
                    }
                    return;
                case 672836989:
                    if (type.equals(UserPropertyKeys.OS_VERSION)) {
                        String value3 = sDKCoreEvent.getValue();
                        Intrinsics.checkNotNullExpressionValue(value3, "event.value");
                        e(value3);
                        return;
                    }
                    return;
                case 1843313243:
                    if (type.equals(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN)) {
                        String value4 = sDKCoreEvent.getValue();
                        Intrinsics.checkNotNullExpressionValue(value4, "event.value");
                        d(value4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void e() {
        e a11 = a();
        if (a11 != null) {
            a11.clearCache();
        }
        this.f34220b.clearCache();
        b.f34237a.c();
    }

    private final JSONObject a(String str) {
        return new JSONObject(str).optJSONObject("diagnostics");
    }
}
