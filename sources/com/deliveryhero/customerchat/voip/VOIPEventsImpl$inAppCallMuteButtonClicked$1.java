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
@DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallMuteButtonClicked$1", f = "VOIPEventsImpl.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
public final class VOIPEventsImpl$inAppCallMuteButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30107h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VOIPEventsImpl f30108i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30109j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f30110k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30111l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f30112m;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallMuteButtonClicked$1$1", f = "VOIPEventsImpl.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.customerchat.voip.VOIPEventsImpl$inAppCallMuteButtonClicked$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f30113h;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(vOIPEventsImpl2, str, str2, str3, str4, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f30113h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CallEventsTracker access$getCallEventsTracker$p = vOIPEventsImpl2.callEventsTracker;
                EventMetadata access$eventMetadata = vOIPEventsImpl2.eventMetadata();
                CallMetadata callMetadata = new CallMetadata(str, str2, str3, vOIPEventsImpl2.receiverType(), (String) null, (String) null, (String) null, str4, (CallRegistrationStatus) null, (Boolean) null, (String) null, 1904, (DefaultConstructorMarker) null);
                this.f30113h = 1;
                if (access$getCallEventsTracker$p.trackInAppCallMuteButtonClicked(access$eventMetadata, callMetadata, this) == coroutine_suspended) {
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
    public VOIPEventsImpl$inAppCallMuteButtonClicked$1(VOIPEventsImpl vOIPEventsImpl, String str, String str2, String str3, String str4, Continuation<? super VOIPEventsImpl$inAppCallMuteButtonClicked$1> continuation) {
        super(2, continuation);
        this.f30108i = vOIPEventsImpl;
        this.f30109j = str;
        this.f30110k = str2;
        this.f30111l = str3;
        this.f30112m = str4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VOIPEventsImpl$inAppCallMuteButtonClicked$1(this.f30108i, this.f30109j, this.f30110k, this.f30111l, this.f30112m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VOIPEventsImpl$inAppCallMuteButtonClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30107h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            VOIPEventsImpl vOIPEventsImpl = this.f30108i;
            final String str = this.f30109j;
            final String str2 = this.f30110k;
            final String str3 = this.f30111l;
            final String str4 = this.f30112m;
            final VOIPEventsImpl vOIPEventsImpl2 = vOIPEventsImpl;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f30107h = 1;
            if (vOIPEventsImpl.ifTrackingEnabled(r32, this) == coroutine_suspended) {
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
