package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties;
import com.deliveryhero.customerchat.eventTracking.tracker.ChatEventsTracker;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$init$3", f = "ChatViewModel.kt", i = {}, l = {195, 197}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$init$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29515h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29516i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatConfiguration f29517j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$init$3(ChatViewModel chatViewModel, ChatConfiguration chatConfiguration, Continuation<? super ChatViewModel$init$3> continuation) {
        super(2, continuation);
        this.f29516i = chatViewModel;
        this.f29517j = chatConfiguration;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$init$3(this.f29516i, this.f29517j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$init$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29515h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChatViewModel chatViewModel = this.f29516i;
            FeatureFlagProvider access$getFeatureFlagProvider$p = chatViewModel.featureFlagProvider;
            ChatConfiguration chatConfiguration = this.f29517j;
            this.f29515h = 1;
            obj = chatViewModel.getFeatureFlagProperties(access$getFeatureFlagProvider$p, chatConfiguration, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FeatureFlagProperties featureFlagProperties = (FeatureFlagProperties) obj;
        ChatEventsTracker chatEvents$customerchat_basicRelease = this.f29516i.getChatEvents$customerchat_basicRelease();
        EventMetadata eventMetadata$customerchat_basicRelease = this.f29516i.getEventMetadata$customerchat_basicRelease();
        if (eventMetadata$customerchat_basicRelease == null) {
            return Unit.INSTANCE;
        }
        this.f29515h = 2;
        if (chatEvents$customerchat_basicRelease.trackFeatureFlagSetEvent(eventMetadata$customerchat_basicRelease, featureFlagProperties, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
