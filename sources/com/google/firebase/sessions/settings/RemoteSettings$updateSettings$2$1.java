package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lorg/json/JSONObject;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {122, 125, 128, 130, 131, 133}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
public final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull JSONObject jSONObject, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e2, code lost:
        r12 = (java.lang.Integer) r7.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e6, code lost:
        if (r12 == null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e8, code lost:
        r2 = r11.this$0;
        r12.intValue();
        r11.L$0 = r1;
        r11.L$1 = r0;
        r11.L$2 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0102, code lost:
        if (r2.settingsCache.updateSessionRestartTimeout((java.lang.Integer) r7.element, r11) != r4) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0104, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0105, code lost:
        r12 = (java.lang.Double) r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0109, code lost:
        if (r12 == null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010b, code lost:
        r2 = r11.this$0;
        r12.doubleValue();
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0125, code lost:
        if (r2.settingsCache.updateSamplingRate((java.lang.Double) r1.element, r11) != r4) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0127, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
        r12 = (java.lang.Integer) r0.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012c, code lost:
        if (r12 == null) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012e, code lost:
        r1 = r11.this$0;
        r12.intValue();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
        if (r1.settingsCache.updateSessionCacheDuration((java.lang.Integer) r0.element, r11) != r4) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x014a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014b, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014e, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014f, code lost:
        if (r12 != null) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(com.huawei.hms.push.constant.RemoteMessageConst.DEFAULT_TTL);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016b, code lost:
        if (r12.updateSessionCacheDuration(r0, r11) != r4) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016e, code lost:
        r12 = r11.this$0.settingsCache;
        r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(java.lang.System.currentTimeMillis());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0189, code lost:
        if (r12.updateSessionCacheUpdatedTime(r0, r11) != r4) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018b, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r11.label
            r6 = 0
            switch(r5) {
                case 0: goto L_0x0050;
                case 1: goto L_0x003f;
                case 2: goto L_0x0032;
                case 3: goto L_0x0029;
                case 4: goto L_0x0024;
                case 5: goto L_0x001f;
                case 6: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x018c
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x016e
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x014b
        L_0x0029:
            java.lang.Object r0 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0128
        L_0x0032:
            java.lang.Object r0 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0105
        L_0x003f:
            java.lang.Object r0 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00dd
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.String r9 = "app_quality"
            boolean r10 = r12.has(r9)
            if (r10 == 0) goto L_0x00be
            java.lang.Object r12 = r12.get(r9)
            java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r9)
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            boolean r9 = r12.has(r3)     // Catch:{ JSONException -> 0x00b4 }
            if (r9 == 0) goto L_0x0086
            java.lang.Object r3 = r12.get(r3)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x00b4 }
            goto L_0x0087
        L_0x0086:
            r3 = r6
        L_0x0087:
            boolean r9 = r12.has(r2)     // Catch:{ JSONException -> 0x00b2 }
            if (r9 == 0) goto L_0x0095
            java.lang.Object r2 = r12.get(r2)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00b2 }
            r5.element = r2     // Catch:{ JSONException -> 0x00b2 }
        L_0x0095:
            boolean r2 = r12.has(r1)     // Catch:{ JSONException -> 0x00b2 }
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r1 = r12.get(r1)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00b2 }
            r7.element = r1     // Catch:{ JSONException -> 0x00b2 }
        L_0x00a3:
            boolean r1 = r12.has(r0)     // Catch:{ JSONException -> 0x00b2 }
            if (r1 == 0) goto L_0x00bf
            java.lang.Object r12 = r12.get(r0)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ JSONException -> 0x00b2 }
            r8.element = r12     // Catch:{ JSONException -> 0x00b2 }
            goto L_0x00bf
        L_0x00b2:
            r12 = move-exception
            goto L_0x00b6
        L_0x00b4:
            r12 = move-exception
            r3 = r6
        L_0x00b6:
            java.lang.String r0 = "SessionConfigFetcher"
            java.lang.String r1 = "Error parsing the configs remotely fetched: "
            android.util.Log.e(r0, r1, r12)
            goto L_0x00bf
        L_0x00be:
            r3 = r6
        L_0x00bf:
            if (r3 == 0) goto L_0x00e0
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            r3.booleanValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r11.L$0 = r5
            r11.L$1 = r7
            r11.L$2 = r8
            r0 = 1
            r11.label = r0
            java.lang.Object r12 = r12.updateSettingsEnabled(r3, r11)
            if (r12 != r4) goto L_0x00da
            return r4
        L_0x00da:
            r2 = r5
            r1 = r7
            r0 = r8
        L_0x00dd:
            r7 = r1
            r1 = r2
            goto L_0x00e2
        L_0x00e0:
            r1 = r5
            r0 = r8
        L_0x00e2:
            T r12 = r7.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0105
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r2 = r7.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            r11.L$0 = r1
            r11.L$1 = r0
            r11.L$2 = r6
            r3 = 2
            r11.label = r3
            java.lang.Object r12 = r12.updateSessionRestartTimeout(r2, r11)
            if (r12 != r4) goto L_0x0105
            return r4
        L_0x0105:
            T r12 = r1.element
            java.lang.Double r12 = (java.lang.Double) r12
            if (r12 == 0) goto L_0x0128
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.doubleValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.settingsCache
            T r1 = r1.element
            java.lang.Double r1 = (java.lang.Double) r1
            r11.L$0 = r0
            r11.L$1 = r6
            r11.L$2 = r6
            r2 = 3
            r11.label = r2
            java.lang.Object r12 = r12.updateSamplingRate(r1, r11)
            if (r12 != r4) goto L_0x0128
            return r4
        L_0x0128:
            T r12 = r0.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x014e
            com.google.firebase.sessions.settings.RemoteSettings r1 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r1.settingsCache
            T r0 = r0.element
            java.lang.Integer r0 = (java.lang.Integer) r0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 4
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x014b
            return r4
        L_0x014b:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            goto L_0x014f
        L_0x014e:
            r12 = r6
        L_0x014f:
            if (r12 != 0) goto L_0x016e
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            r0 = 86400(0x15180, float:1.21072E-40)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x016e
            return r4
        L_0x016e:
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.settingsCache
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 6
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheUpdatedTime(r0, r11)
            if (r12 != r4) goto L_0x018c
            return r4
        L_0x018c:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
