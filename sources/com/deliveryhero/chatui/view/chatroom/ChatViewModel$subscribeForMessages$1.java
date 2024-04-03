package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.fwf.UserFeatureFlags;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/contract/model/BaseMessage;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$subscribeForMessages$1 extends Lambda implements Function1<BaseMessage, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29587g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$subscribeForMessages$1$1", f = "ChatViewModel.kt", i = {}, l = {654}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$subscribeForMessages$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29588h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(chatViewModel, baseMessage, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29588h;
            boolean z11 = true;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                ChatViewModel.a(chatViewModel, baseMessage, (ChatMessageViewModel) null, (Throwable) null, 6, (Object) null);
                chatViewModel.markAllMessagesAsRead();
                chatViewModel.updateUserCount(baseMessage);
                chatViewModel.fetchConfigIfUpdated(baseMessage);
                FeatureFlagProvider access$getFeatureFlagProvider$p = chatViewModel.featureFlagProvider;
                this.f29588h = 1;
                obj = access$getFeatureFlagProvider$p.getUserFeatureFlags(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            UserFeatureFlags userFeatureFlags = (UserFeatureFlags) obj;
            if (userFeatureFlags == null || !userFeatureFlags.isDisableChatOnChannelFrozenEnabled()) {
                z11 = false;
            }
            if (z11) {
                chatViewModel.checkIfChannelFrozen(baseMessage);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$subscribeForMessages$1(ChatViewModel chatViewModel) {
        super(1);
        this.f29587g = chatViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseMessage) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final BaseMessage baseMessage) {
        Intrinsics.checkNotNullParameter(baseMessage, "it");
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.f29587g);
        final ChatViewModel chatViewModel = this.f29587g;
        Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
