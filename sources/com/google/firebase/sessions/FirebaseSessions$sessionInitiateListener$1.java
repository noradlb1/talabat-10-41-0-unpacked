package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"com/google/firebase/sessions/FirebaseSessions$sessionInitiateListener$1", "Lcom/google/firebase/sessions/SessionInitiateListener;", "onInitiateSession", "", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseSessions$sessionInitiateListener$1 implements SessionInitiateListener {
    final /* synthetic */ FirebaseSessions this$0;

    public FirebaseSessions$sessionInitiateListener$1(FirebaseSessions firebaseSessions) {
        this.this$0 = firebaseSessions;
    }

    @Nullable
    public Object onInitiateSession(@NotNull SessionDetails sessionDetails, @NotNull Continuation<? super Unit> continuation) {
        Object access$initiateSessionStart = this.this$0.initiateSessionStart(sessionDetails, continuation);
        return access$initiateSessionStart == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$initiateSessionStart : Unit.INSTANCE;
    }
}
