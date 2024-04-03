package com.deliveryhero.chatui.view.root;

import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTracker;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.root.CustomerChatViewModel$logCallButtonClickedEvent$1", f = "CustomerChatViewModel.kt", i = {}, l = {93, 96, 106}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerChatViewModel$logCallButtonClickedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29705h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerChatViewModel f29706i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CallStatus f29707j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatViewModel$logCallButtonClickedEvent$1(CustomerChatViewModel customerChatViewModel, CallStatus callStatus, Continuation<? super CustomerChatViewModel$logCallButtonClickedEvent$1> continuation) {
        super(2, continuation);
        this.f29706i = customerChatViewModel;
        this.f29707j = callStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerChatViewModel$logCallButtonClickedEvent$1(this.f29706i, this.f29707j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomerChatViewModel$logCallButtonClickedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29705h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagProvider access$getFeatureFlagProvider$p = this.f29706i.featureFlagProvider;
            this.f29705h = 1;
            obj2 = access$getFeatureFlagProvider$p.getPhoneCallingType(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i11 == 2 || i11 == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String simpleName = obj2.getClass().getSimpleName();
        CallStatus callStatus = this.f29707j;
        if (callStatus instanceof CallStatus.Active) {
            CallEventsTracker access$getCallEventsTracker$p = this.f29706i.callEventsTracker;
            EventMetadata eventMetadata = this.f29706i.getEventMetadata();
            CallMetadata callMetadata = r5;
            CallMetadata callMetadata2 = new CallMetadata((String) null, (String) null, (String) null, this.f29706i.getReceiverType(), (String) null, (String) null, (String) null, (String) null, (CallRegistrationStatus) null, (Boolean) null, simpleName, 1015, (DefaultConstructorMarker) null);
            this.f29705h = 2;
            if (access$getCallEventsTracker$p.trackTraditionalCallButtonClicked(eventMetadata, callMetadata, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (callStatus instanceof CallStatus.VoipActive) {
            CallEventsTracker access$getCallEventsTracker$p2 = this.f29706i.callEventsTracker;
            EventMetadata eventMetadata2 = this.f29706i.getEventMetadata();
            CallMetadata callMetadata3 = r5;
            CallMetadata callMetadata4 = new CallMetadata((String) null, (String) null, ((CallStatus.VoipActive) this.f29707j).getUsername(), this.f29706i.getReceiverType(), (String) null, (String) null, (String) null, (String) null, (CallRegistrationStatus) null, (Boolean) null, (String) null, 2035, (DefaultConstructorMarker) null);
            this.f29705h = 3;
            if (access$getCallEventsTracker$p2.trackInAppCallButtonClicked(eventMetadata2, callMetadata3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
