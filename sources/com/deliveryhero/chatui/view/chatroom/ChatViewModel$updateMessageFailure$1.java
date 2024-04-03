package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.customerchat.eventTracking.data.ErrorMessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$updateMessageFailure$1", f = "ChatViewModel.kt", i = {}, l = {829}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$updateMessageFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29603h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29604i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BaseMessage f29605j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModel f29606k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Throwable f29607l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$updateMessageFailure$1$1", f = "ChatViewModel.kt", i = {}, l = {846}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$updateMessageFailure$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f29608h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(chatViewModel2, errorMessageMetadata, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f29608h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                MessageEventsTracker messageEvents$customerchat_basicRelease = chatViewModel2.getMessageEvents$customerchat_basicRelease();
                EventMetadata eventMetadata$customerchat_basicRelease = chatViewModel2.getEventMetadata$customerchat_basicRelease();
                if (eventMetadata$customerchat_basicRelease == null) {
                    return Unit.INSTANCE;
                }
                ErrorMessageMetadata errorMessageMetadata = errorMessageMetadata;
                this.f29608h = 1;
                if (messageEvents$customerchat_basicRelease.trackErrorSendingMessageEvent(eventMetadata$customerchat_basicRelease, errorMessageMetadata, this) == coroutine_suspended) {
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
    public ChatViewModel$updateMessageFailure$1(ChatViewModel chatViewModel, BaseMessage baseMessage, ChatMessageViewModel chatMessageViewModel, Throwable th2, Continuation<? super ChatViewModel$updateMessageFailure$1> continuation) {
        super(2, continuation);
        this.f29604i = chatViewModel;
        this.f29605j = baseMessage;
        this.f29606k = chatMessageViewModel;
        this.f29607l = th2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$updateMessageFailure$1(this.f29604i, this.f29605j, this.f29606k, this.f29607l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$updateMessageFailure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChatMessageViewModel chatMessageViewModel;
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29603h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f29604i.scrollToBottom = true;
            if (this.f29605j == null) {
                chatMessageViewModel = this.f29606k;
            } else {
                ChatMessageViewModelMapper access$getMapper$p = this.f29604i.mapper;
                int index = this.f29606k.getIndex();
                String preferredLanguage$customerchat_basicRelease = this.f29604i.preferredLanguage$customerchat_basicRelease();
                BaseMessage baseMessage = this.f29605j;
                Throwable th2 = this.f29607l;
                this.f29603h = 1;
                obj = access$getMapper$p.map(index, preferredLanguage$customerchat_basicRelease, baseMessage, th2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                chatMessageViewModel = (ChatMessageViewModel) obj;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
            chatMessageViewModel = (ChatMessageViewModel) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChatMessageViewModel chatMessageViewModel2 = chatMessageViewModel;
        this.f29604i.messages.put(Boxing.boxInt(chatMessageViewModel2.getIndex()), ChatMessageViewModel.copy$default(chatMessageViewModel2, 0, (TextMessage) null, (TextMessage) null, (ImageMessage) null, (LocationMessage) null, (String) null, false, Receipt.FAILED, (BaseMessage) null, (String) null, 895, (Object) null));
        this.f29604i._messagesLiveData.postValue(CollectionsKt___CollectionsKt.toList(this.f29604i.messages.values()));
        ChatViewModel chatViewModel = this.f29604i;
        chatViewModel.lastMessageInList = (ChatMessageViewModel) CollectionsKt___CollectionsKt.lastOrNull(chatViewModel.messages.values());
        Throwable th3 = this.f29607l;
        if (th3 != null) {
            str = th3.getMessage();
        } else {
            str = null;
        }
        BaseMessage baseMessage2 = this.f29605j;
        if (baseMessage2 != null) {
            str2 = baseMessage2.getCorrelationId();
        } else {
            str2 = null;
        }
        final ErrorMessageMetadata errorMessageMetadata = new ErrorMessageMetadata(str, (String) null, str2, 2, (DefaultConstructorMarker) null);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.f29604i);
        final ChatViewModel chatViewModel2 = this.f29604i;
        Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
