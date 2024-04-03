package com.google.firebase.sessions;

import com.google.firebase.installations.FirebaseInstallationsApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator;", "", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/EventGDTLoggerInterface;)V", "attemptLoggingSessionEvent", "", "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "(Lcom/google/firebase/sessions/SessionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionCoordinator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "SessionCoordinator";
    @NotNull
    private final EventGDTLoggerInterface eventGDTLogger;
    @NotNull
    private final FirebaseInstallationsApi firebaseInstallations;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator$Companion;", "", "()V", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionCoordinator(@NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull EventGDTLoggerInterface eventGDTLoggerInterface) {
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(eventGDTLoggerInterface, "eventGDTLogger");
        this.firebaseInstallations = firebaseInstallationsApi;
        this.eventGDTLogger = eventGDTLoggerInterface;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object attemptLoggingSessionEvent(@org.jetbrains.annotations.NotNull com.google.firebase.sessions.SessionEvent r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = (com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = new com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "SessionCoordinator"
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r7 = r0.L$3
            com.google.firebase.sessions.SessionInfo r7 = (com.google.firebase.sessions.SessionInfo) r7
            java.lang.Object r1 = r0.L$2
            com.google.firebase.sessions.SessionInfo r1 = (com.google.firebase.sessions.SessionInfo) r1
            java.lang.Object r2 = r0.L$1
            com.google.firebase.sessions.SessionEvent r2 = (com.google.firebase.sessions.SessionEvent) r2
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionCoordinator r0 = (com.google.firebase.sessions.SessionCoordinator) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x006d
        L_0x003b:
            r7 = move-exception
            goto L_0x007a
        L_0x003d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.firebase.sessions.SessionInfo r8 = r7.getSessionData()
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r6.firebaseInstallations     // Catch:{ Exception -> 0x0075 }
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r5 = "firebaseInstallations.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0075 }
            r0.L$0 = r6     // Catch:{ Exception -> 0x0075 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x0075 }
            r0.L$2 = r8     // Catch:{ Exception -> 0x0075 }
            r0.L$3 = r8     // Catch:{ Exception -> 0x0075 }
            r0.label = r3     // Catch:{ Exception -> 0x0075 }
            java.lang.Object r0 = kotlinx.coroutines.tasks.TasksKt.await(r2, r0)     // Catch:{ Exception -> 0x0075 }
            if (r0 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r2 = r7
            r7 = r8
            r1 = r7
            r8 = r0
            r0 = r6
        L_0x006d:
            java.lang.String r3 = "{\n        firebaseInstallations.id.await()\n      }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ Exception -> 0x003b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x003b }
            goto L_0x0096
        L_0x0075:
            r0 = move-exception
            r2 = r7
            r1 = r8
            r7 = r0
            r0 = r6
        L_0x007a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "Error getting Firebase Installation ID: "
            r8.append(r3)
            r8.append(r7)
            java.lang.String r7 = ". Using an empty ID"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.e(r4, r7)
            java.lang.String r8 = ""
            r7 = r1
        L_0x0096:
            r7.setFirebaseInstallationId(r8)
            com.google.firebase.sessions.EventGDTLoggerInterface r7 = r0.eventGDTLogger     // Catch:{ RuntimeException -> 0x00bb }
            r7.log(r2)     // Catch:{ RuntimeException -> 0x00bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00bb }
            r7.<init>()     // Catch:{ RuntimeException -> 0x00bb }
            java.lang.String r8 = "Successfully logged Session Start event: "
            r7.append(r8)     // Catch:{ RuntimeException -> 0x00bb }
            com.google.firebase.sessions.SessionInfo r8 = r2.getSessionData()     // Catch:{ RuntimeException -> 0x00bb }
            java.lang.String r8 = r8.getSessionId()     // Catch:{ RuntimeException -> 0x00bb }
            r7.append(r8)     // Catch:{ RuntimeException -> 0x00bb }
            java.lang.String r7 = r7.toString()     // Catch:{ RuntimeException -> 0x00bb }
            android.util.Log.i(r4, r7)     // Catch:{ RuntimeException -> 0x00bb }
            goto L_0x00c1
        L_0x00bb:
            r7 = move-exception
            java.lang.String r8 = "Error logging Session Start event to DataTransport: "
            android.util.Log.e(r4, r8, r7)
        L_0x00c1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionCoordinator.attemptLoggingSessionEvent(com.google.firebase.sessions.SessionEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
