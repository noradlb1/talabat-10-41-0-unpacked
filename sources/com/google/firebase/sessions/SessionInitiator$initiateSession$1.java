package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.firebase.sessions.SessionInitiator$initiateSession$1", f = "SessionInitiator.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class SessionInitiator$initiateSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    int label;
    final /* synthetic */ SessionInitiator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionInitiator$initiateSession$1(SessionInitiator sessionInitiator, SessionDetails sessionDetails, Continuation<? super SessionInitiator$initiateSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionInitiator;
        this.$sessionDetails = sessionDetails;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SessionInitiator$initiateSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SessionInitiator$initiateSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SessionInitiateListener access$getSessionInitiateListener$p = this.this$0.sessionInitiateListener;
            SessionDetails sessionDetails = this.$sessionDetails;
            this.label = 1;
            if (access$getSessionInitiateListener$p.onInitiateSession(sessionDetails, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
