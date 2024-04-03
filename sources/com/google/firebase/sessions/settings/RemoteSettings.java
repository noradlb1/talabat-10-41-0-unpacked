package com.google.firebase.sessions.settings;

import androidx.annotation.VisibleForTesting;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0011\u0010%\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "clearCachedSettings", "", "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", "", "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RemoteSettings implements SettingsProvider {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";
    @NotNull
    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    @NotNull
    private final ApplicationInfo appInfo;
    @NotNull
    private final CoroutineContext backgroundDispatcher;
    @NotNull
    private final CrashlyticsSettingsFetcher configsFetcher;
    @NotNull
    private final Mutex fetchInProgress = MutexKt.Mutex$default(false, 1, (Object) null);
    @NotNull
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    /* access modifiers changed from: private */
    @NotNull
    public final SettingsCache settingsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettings(@NotNull CoroutineContext coroutineContext, @NotNull FirebaseInstallationsApi firebaseInstallationsApi2, @NotNull ApplicationInfo applicationInfo, @NotNull CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, @NotNull DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi2, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(applicationInfo, "appInfo");
        Intrinsics.checkNotNullParameter(crashlyticsSettingsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.backgroundDispatcher = coroutineContext;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.appInfo = applicationInfo;
        this.configsFetcher = crashlyticsSettingsFetcher;
        this.settingsCache = new SettingsCache(dataStore);
    }

    private final String removeForwardSlashesIn(String str) {
        return new Regex("/").replace((CharSequence) str, "");
    }

    @VisibleForTesting
    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), (CoroutineContext) null, (CoroutineStart) null, new RemoteSettings$clearCachedSettings$1(this, (Continuation<? super RemoteSettings$clearCachedSettings$1>) null), 3, (Object) null);
    }

    @Nullable
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    @Nullable
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Nullable
    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public Duration m9380getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.Companion;
        return Duration.m7615boximpl(DurationKt.toDuration(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[SYNTHETIC, Splitter:B:39:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b0 A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSettings(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x005d
            if (r2 == r5) goto L_0x0050
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0035 }
            goto L_0x0143
        L_0x0035:
            r15 = move-exception
            goto L_0x014f
        L_0x0038:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0040:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x004c }
            goto L_0x00ac
        L_0x004c:
            r15 = move-exception
            r0 = r2
            goto L_0x014f
        L_0x0050:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r2
            goto L_0x0083
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            boolean r15 = r15.isLocked()
            if (r15 != 0) goto L_0x0073
            com.google.firebase.sessions.settings.SettingsCache r15 = r14.settingsCache
            boolean r15 = r15.hasCacheExpired$com_google_firebase_firebase_sessions()
            if (r15 != 0) goto L_0x0073
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0073:
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            r0.L$0 = r14
            r0.L$1 = r15
            r0.label = r5
            java.lang.Object r2 = r15.lock(r6, r0)
            if (r2 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r7 = r14
        L_0x0083:
            com.google.firebase.sessions.settings.SettingsCache r2 = r7.settingsCache     // Catch:{ all -> 0x014b }
            boolean r2 = r2.hasCacheExpired$com_google_firebase_firebase_sessions()     // Catch:{ all -> 0x014b }
            if (r2 != 0) goto L_0x0091
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014b }
            r15.unlock(r6)
            return r0
        L_0x0091:
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r7.firebaseInstallationsApi     // Catch:{ all -> 0x014b }
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch:{ all -> 0x014b }
            java.lang.String r8 = "firebaseInstallationsApi.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)     // Catch:{ all -> 0x014b }
            r0.L$0 = r7     // Catch:{ all -> 0x014b }
            r0.L$1 = r15     // Catch:{ all -> 0x014b }
            r0.label = r4     // Catch:{ all -> 0x014b }
            java.lang.Object r2 = kotlinx.coroutines.tasks.TasksKt.await(r2, r0)     // Catch:{ all -> 0x014b }
            if (r2 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r13 = r2
            r2 = r15
            r15 = r13
        L_0x00ac:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x004c }
            if (r15 != 0) goto L_0x00bd
            java.lang.String r15 = "SessionConfigFetcher"
            java.lang.String r0 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r15, r0)     // Catch:{ all -> 0x004c }
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004c }
            r2.unlock(r6)
            return r15
        L_0x00bd:
            r8 = 5
            kotlin.Pair[] r8 = new kotlin.Pair[r8]     // Catch:{ all -> 0x004c }
            java.lang.String r9 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r9, r15)     // Catch:{ all -> 0x004c }
            r9 = 0
            r8[r9] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-Device-Model"
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ all -> 0x004c }
            java.lang.String r10 = "%s/%s"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x004c }
            java.lang.String r12 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x004c }
            r11[r9] = r12     // Catch:{ all -> 0x004c }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x004c }
            r11[r5] = r9     // Catch:{ all -> 0x004c }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r11, r4)     // Catch:{ all -> 0x004c }
            java.lang.String r9 = java.lang.String.format(r10, r9)     // Catch:{ all -> 0x004c }
            java.lang.String r10 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ all -> 0x004c }
            java.lang.String r9 = r7.removeForwardSlashesIn(r9)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r9)     // Catch:{ all -> 0x004c }
            r8[r5] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r5 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x004c }
            java.lang.String r9 = "INCREMENTAL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)     // Catch:{ all -> 0x004c }
            java.lang.String r5 = r7.removeForwardSlashesIn(r5)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r5)     // Catch:{ all -> 0x004c }
            r8[r4] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x004c }
            java.lang.String r5 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r7.removeForwardSlashesIn(r4)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r4)     // Catch:{ all -> 0x004c }
            r8[r3] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r4 = r7.appInfo     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r4.getSessionSdkVersion()     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r4)     // Catch:{ all -> 0x004c }
            r4 = 4
            r8[r4] = r15     // Catch:{ all -> 0x004c }
            java.util.Map r15 = kotlin.collections.MapsKt__MapsKt.mapOf(r8)     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r4 = r7.configsFetcher     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r5 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x004c }
            r5.<init>(r7, r6)     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r7 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x004c }
            r7.<init>(r6)     // Catch:{ all -> 0x004c }
            r0.L$0 = r2     // Catch:{ all -> 0x004c }
            r0.L$1 = r6     // Catch:{ all -> 0x004c }
            r0.label = r3     // Catch:{ all -> 0x004c }
            java.lang.Object r15 = r4.doConfigFetch(r15, r5, r7, r0)     // Catch:{ all -> 0x004c }
            if (r15 != r1) goto L_0x0142
            return r1
        L_0x0142:
            r0 = r2
        L_0x0143:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0035 }
            r0.unlock(r6)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x014b:
            r0 = move-exception
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x014f:
            r0.unlock(r6)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
