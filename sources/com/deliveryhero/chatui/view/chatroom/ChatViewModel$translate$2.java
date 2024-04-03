package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
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
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$translate$2", f = "ChatViewModel.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$translate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29595h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29596i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventMetadata f29597j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TranslationMetadata f29598k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$translate$2(ChatViewModel chatViewModel, EventMetadata eventMetadata, TranslationMetadata translationMetadata, Continuation<? super ChatViewModel$translate$2> continuation) {
        super(2, continuation);
        this.f29596i = chatViewModel;
        this.f29597j = eventMetadata;
        this.f29598k = translationMetadata;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$translate$2(this.f29596i, this.f29597j, this.f29598k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$translate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29595h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MessageEventsTracker messageEvents$customerchat_basicRelease = this.f29596i.getMessageEvents$customerchat_basicRelease();
            EventMetadata eventMetadata = this.f29597j;
            TranslationMetadata translationMetadata = this.f29598k;
            this.f29595h = 1;
            if (messageEvents$customerchat_basicRelease.trackTranslationActivatedEvent(eventMetadata, translationMetadata, this) == coroutine_suspended) {
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
