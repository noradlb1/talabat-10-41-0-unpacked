package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "blockingDispatcher", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/inject/Provider;)V", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLogger;", "sessionCoordinator", "Lcom/google/firebase/sessions/SessionCoordinator;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "initiateSessionStart", "", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "subscriber", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "shouldCollectEvents", "", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseSessions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FirebaseSessions";
    @NotNull
    private final ApplicationInfo applicationInfo;
    @NotNull
    private final EventGDTLogger eventGDTLogger;
    @NotNull
    private final FirebaseApp firebaseApp;
    @NotNull
    private final SessionCoordinator sessionCoordinator;
    @NotNull
    private final SessionGenerator sessionGenerator;
    @NotNull
    private final SessionsSettings sessionSettings;
    @NotNull
    private final TimeProvider timeProvider;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance$annotations", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final FirebaseSessions getInstance() {
            return getInstance(FirebaseKt.getApp(Firebase.INSTANCE));
        }

        @JvmStatic
        @NotNull
        public final FirebaseSessions getInstance(@NotNull FirebaseApp firebaseApp) {
            Intrinsics.checkNotNullParameter(firebaseApp, "app");
            Object obj = firebaseApp.get(FirebaseSessions.class);
            Intrinsics.checkNotNullExpressionValue(obj, "app.get(FirebaseSessions::class.java)");
            return (FirebaseSessions) obj;
        }
    }

    public FirebaseSessions(@NotNull FirebaseApp firebaseApp2, @NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull Provider<TransportFactory> provider) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        FirebaseInstallationsApi firebaseInstallationsApi2 = firebaseInstallationsApi;
        Provider<TransportFactory> provider2 = provider;
        Intrinsics.checkNotNullParameter(firebaseApp3, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi2, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "backgroundDispatcher");
        CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher2;
        Intrinsics.checkNotNullParameter(coroutineDispatcher3, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(provider2, "transportFactoryProvider");
        this.firebaseApp = firebaseApp3;
        ApplicationInfo applicationInfo2 = SessionEvents.INSTANCE.getApplicationInfo(firebaseApp3);
        this.applicationInfo = applicationInfo2;
        Context applicationContext = firebaseApp2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher;
        SessionsSettings sessionsSettings = new SessionsSettings(applicationContext, coroutineDispatcher3, coroutineDispatcher4, firebaseInstallationsApi, applicationInfo2);
        this.sessionSettings = sessionsSettings;
        Time time = new Time();
        this.timeProvider = time;
        EventGDTLogger eventGDTLogger2 = new EventGDTLogger(provider2);
        this.eventGDTLogger = eventGDTLogger2;
        this.sessionCoordinator = new SessionCoordinator(firebaseInstallationsApi2, eventGDTLogger2);
        SessionGenerator sessionGenerator2 = new SessionGenerator(shouldCollectEvents(), time, (Function0) null, 4, (DefaultConstructorMarker) null);
        this.sessionGenerator = sessionGenerator2;
        SessionInitiator sessionInitiator = new SessionInitiator(time, coroutineDispatcher4, new FirebaseSessions$sessionInitiateListener$1(this), sessionsSettings, sessionGenerator2);
        Context applicationContext2 = firebaseApp2.getApplicationContext().getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
            return;
        }
        Log.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext2.getClass() + '.');
    }

    @NotNull
    public static final FirebaseSessions getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    @NotNull
    public static final FirebaseSessions getInstance(@NotNull FirebaseApp firebaseApp2) {
        return Companion.getInstance(firebaseApp2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initiateSessionStart(com.google.firebase.sessions.SessionDetails r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = (com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = new com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0101
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0038:
            java.lang.Object r11 = r0.L$1
            com.google.firebase.sessions.SessionDetails r11 = (com.google.firebase.sessions.SessionDetails) r11
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r2 = (com.google.firebase.sessions.FirebaseSessions) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00d1
        L_0x0045:
            java.lang.Object r11 = r0.L$1
            com.google.firebase.sessions.SessionDetails r11 = (com.google.firebase.sessions.SessionDetails) r11
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r2 = (com.google.firebase.sessions.FirebaseSessions) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0064
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r12)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r12 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r5
            java.lang.Object r12 = r12.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r0)
            if (r12 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r2 = r10
        L_0x0064:
            java.util.Map r12 = (java.util.Map) r12
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L_0x006f
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x006f:
            java.util.Collection r6 = r12.values()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0079:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0092
            java.lang.Object r7 = r6.next()
            com.google.firebase.sessions.api.SessionSubscriber r7 = (com.google.firebase.sessions.api.SessionSubscriber) r7
            com.google.firebase.sessions.api.SessionSubscriber$SessionDetails r8 = new com.google.firebase.sessions.api.SessionSubscriber$SessionDetails
            java.lang.String r9 = r11.getSessionId()
            r8.<init>(r9)
            r7.onSessionChanged(r8)
            goto L_0x0079
        L_0x0092:
            java.util.Collection r12 = r12.values()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r6 = r12 instanceof java.util.Collection
            if (r6 == 0) goto L_0x00a6
            r6 = r12
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00a6
            goto L_0x00bd
        L_0x00a6:
            java.util.Iterator r12 = r12.iterator()
        L_0x00aa:
            boolean r6 = r12.hasNext()
            if (r6 == 0) goto L_0x00bd
            java.lang.Object r6 = r12.next()
            com.google.firebase.sessions.api.SessionSubscriber r6 = (com.google.firebase.sessions.api.SessionSubscriber) r6
            boolean r6 = r6.isDataCollectionEnabled()
            if (r6 == 0) goto L_0x00aa
            r5 = 0
        L_0x00bd:
            if (r5 == 0) goto L_0x00c2
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00c2:
            com.google.firebase.sessions.settings.SessionsSettings r12 = r2.sessionSettings
            r0.L$0 = r2
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r12.updateSettings(r0)
            if (r12 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            com.google.firebase.sessions.settings.SessionsSettings r12 = r2.sessionSettings
            boolean r12 = r12.getSessionsEnabled()
            if (r12 != 0) goto L_0x00dc
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00dc:
            com.google.firebase.sessions.SessionGenerator r12 = r2.sessionGenerator
            boolean r12 = r12.getCollectEvents()
            if (r12 != 0) goto L_0x00e7
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00e7:
            com.google.firebase.sessions.SessionCoordinator r12 = r2.sessionCoordinator
            com.google.firebase.sessions.SessionEvents r4 = com.google.firebase.sessions.SessionEvents.INSTANCE
            com.google.firebase.FirebaseApp r5 = r2.firebaseApp
            com.google.firebase.sessions.settings.SessionsSettings r2 = r2.sessionSettings
            com.google.firebase.sessions.SessionEvent r11 = r4.startSession(r5, r11, r2)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r11 = r12.attemptLoggingSessionEvent(r11, r0)
            if (r11 != r1) goto L_0x0101
            return r1
        L_0x0101:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.initiateSessionStart(com.google.firebase.sessions.SessionDetails, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean shouldCollectEvents() {
        if (Math.random() <= this.sessionSettings.getSamplingRate()) {
            return true;
        }
        return false;
    }

    public final void register(@NotNull SessionSubscriber sessionSubscriber) {
        Intrinsics.checkNotNullParameter(sessionSubscriber, "subscriber");
        FirebaseSessionsDependencies.INSTANCE.register$com_google_firebase_firebase_sessions(sessionSubscriber);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Registering Sessions SDK subscriber with name: ");
        sb2.append(sessionSubscriber.getSessionSubscriberName());
        sb2.append(", data collection enabled: ");
        sb2.append(sessionSubscriber.isDataCollectionEnabled());
        if (this.sessionGenerator.getHasGenerateSession()) {
            sessionSubscriber.onSessionChanged(new SessionSubscriber.SessionDetails(this.sessionGenerator.getCurrentSession().getSessionId()));
        }
    }
}
