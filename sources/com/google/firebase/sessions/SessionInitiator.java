package com.google.firebase.sessions;

import android.app.Application;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0002R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\u00020\u0012X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/SessionInitiator;", "", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "sessionInitiateListener", "Lcom/google/firebase/sessions/SessionInitiateListener;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/SessionInitiateListener;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/SessionGenerator;)V", "activityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "backgroundTime", "Lkotlin/time/Duration;", "J", "appBackgrounded", "", "appForegrounded", "initiateSession", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionInitiator {
    @NotNull
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new SessionInitiator$activityLifecycleCallbacks$1(this);
    @NotNull
    private final CoroutineContext backgroundDispatcher;
    private long backgroundTime;
    @NotNull
    private final SessionGenerator sessionGenerator;
    /* access modifiers changed from: private */
    @NotNull
    public final SessionInitiateListener sessionInitiateListener;
    @NotNull
    private final SessionsSettings sessionsSettings;
    @NotNull
    private final TimeProvider timeProvider;

    public SessionInitiator(@NotNull TimeProvider timeProvider2, @NotNull CoroutineContext coroutineContext, @NotNull SessionInitiateListener sessionInitiateListener2, @NotNull SessionsSettings sessionsSettings2, @NotNull SessionGenerator sessionGenerator2) {
        Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
        Intrinsics.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(sessionInitiateListener2, "sessionInitiateListener");
        Intrinsics.checkNotNullParameter(sessionsSettings2, "sessionsSettings");
        Intrinsics.checkNotNullParameter(sessionGenerator2, "sessionGenerator");
        this.timeProvider = timeProvider2;
        this.backgroundDispatcher = coroutineContext;
        this.sessionInitiateListener = sessionInitiateListener2;
        this.sessionsSettings = sessionsSettings2;
        this.sessionGenerator = sessionGenerator2;
        this.backgroundTime = timeProvider2.m9378elapsedRealtimeUwyO8pc();
        initiateSession();
    }

    private final void initiateSession() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), (CoroutineContext) null, (CoroutineStart) null, new SessionInitiator$initiateSession$1(this, this.sessionGenerator.generateNewSession(), (Continuation<? super SessionInitiator$initiateSession$1>) null), 3, (Object) null);
    }

    public final void appBackgrounded() {
        this.backgroundTime = this.timeProvider.m9378elapsedRealtimeUwyO8pc();
    }

    public final void appForegrounded() {
        if (Duration.m7616compareToLRDsOJo(Duration.m7652minusLRDsOJo(this.timeProvider.m9378elapsedRealtimeUwyO8pc(), this.backgroundTime), this.sessionsSettings.m9382getSessionRestartTimeoutUwyO8pc()) > 0) {
            initiateSession();
        }
    }

    @NotNull
    public final Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions() {
        return this.activityLifecycleCallbacks;
    }
}
