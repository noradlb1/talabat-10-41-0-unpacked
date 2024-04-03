package com.deliveryhero.customerchat.voip;

import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTracker;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallUserRegistered$1", f = "VOIPEventsImpl.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class VOIPEventsImpl$inAppCallUserRegistered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30175h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VOIPEventsImpl f30176i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CallRegistrationStatus f30177j;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallUserRegistered$1$1", f = "VOIPEventsImpl.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallUserRegistered$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f30178h;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(vOIPEventsImpl, callRegistrationStatus, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f30178h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CallEventsTracker access$getCallEventsTracker$p = vOIPEventsImpl.callEventsTracker;
                EventMetadata access$eventMetadata = vOIPEventsImpl.eventMetadata();
                CallMetadata callMetadata = r5;
                CallMetadata callMetadata2 = new CallMetadata((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, callRegistrationStatus, (Boolean) null, (String) null, 1791, (DefaultConstructorMarker) null);
                this.f30178h = 1;
                if (access$getCallEventsTracker$p.trackInAppCallUserRegistered(access$eventMetadata, callMetadata, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VOIPEventsImpl$inAppCallUserRegistered$1(VOIPEventsImpl vOIPEventsImpl, CallRegistrationStatus callRegistrationStatus, Continuation<? super VOIPEventsImpl$inAppCallUserRegistered$1> continuation) {
        super(2, continuation);
        this.f30176i = vOIPEventsImpl;
        this.f30177j = callRegistrationStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VOIPEventsImpl$inAppCallUserRegistered$1(this.f30176i, this.f30177j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VOIPEventsImpl$inAppCallUserRegistered$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30175h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final VOIPEventsImpl vOIPEventsImpl = this.f30176i;
            final CallRegistrationStatus callRegistrationStatus = this.f30177j;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f30175h = 1;
            if (vOIPEventsImpl.ifTrackingEnabled(r12, this) == coroutine_suspended) {
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
