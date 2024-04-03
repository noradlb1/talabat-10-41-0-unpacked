package com.deliveryhero.chatui.view.chatroom;

import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.contract.model.BaseMessage;
import java.util.List;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "chatList", "", "Lcom/deliveryhero/contract/model/BaseMessage;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatViewModel$loadChat$1 extends Lambda implements Function1<List<? extends BaseMessage>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29528g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$loadChat$1$1", f = "ChatViewModel.kt", i = {2}, l = {718, 723, 727}, m = "invokeSuspend", n = {"filteredMessages"}, s = {"L$0"})
    /* renamed from: com.deliveryhero.chatui.view.chatroom.ChatViewModel$loadChat$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public Object f29529h;

        /* renamed from: i  reason: collision with root package name */
        public Object f29530i;

        /* renamed from: j  reason: collision with root package name */
        public Object f29531j;

        /* renamed from: k  reason: collision with root package name */
        public int f29532k;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(list, chatViewModel, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0148  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.f29532k
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x0039
                if (r1 == r6) goto L_0x0035
                if (r1 == r3) goto L_0x0024
                if (r1 != r2) goto L_0x001c
                java.lang.Object r0 = r9.f29529h
                java.util.List r0 = (java.util.List) r0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x00d1
            L_0x001c:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0024:
                java.lang.Object r1 = r9.f29531j
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r3 = r9.f29530i
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = (com.deliveryhero.chatui.view.chatroom.ChatViewModel) r3
                java.lang.Object r7 = r9.f29529h
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r7 = (com.deliveryhero.chatui.view.chatroom.ChatViewModel) r7
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x009d
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x005a
            L_0x0039:
                kotlin.ResultKt.throwOnFailure(r10)
                java.util.List<com.deliveryhero.contract.model.BaseMessage> r10 = r8
                java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r10)
                com.deliveryhero.contract.model.BaseMessage r10 = (com.deliveryhero.contract.model.BaseMessage) r10
                if (r10 == 0) goto L_0x004b
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                r1.updateUserCount(r10)
            L_0x004b:
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                com.deliveryhero.customerchat.fwf.FeatureFlagProvider r10 = r10.featureFlagProvider
                r9.f29532k = r6
                java.lang.Object r10 = r10.getUserFeatureFlags(r9)
                if (r10 != r0) goto L_0x005a
                return r0
            L_0x005a:
                com.deliveryhero.customerchat.fwf.UserFeatureFlags r10 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r10
                if (r10 == 0) goto L_0x0066
                boolean r10 = r10.isDisableChatOnChannelFrozenEnabled()
                if (r10 != r6) goto L_0x0066
                r10 = r6
                goto L_0x0067
            L_0x0066:
                r10 = r5
            L_0x0067:
                if (r10 == 0) goto L_0x0083
                java.util.List<com.deliveryhero.contract.model.BaseMessage> r10 = r8
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                java.util.Iterator r10 = r10.iterator()
            L_0x0073:
                boolean r7 = r10.hasNext()
                if (r7 == 0) goto L_0x0083
                java.lang.Object r7 = r10.next()
                com.deliveryhero.contract.model.BaseMessage r7 = (com.deliveryhero.contract.model.BaseMessage) r7
                r1.checkIfChannelFrozen(r7)
                goto L_0x0073
            L_0x0083:
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                java.util.List<com.deliveryhero.contract.model.BaseMessage> r1 = r8
                com.deliveryhero.customerchat.fwf.FeatureFlagProvider r7 = r10.featureFlagProvider
                r9.f29529h = r10
                r9.f29530i = r10
                r9.f29531j = r1
                r9.f29532k = r3
                java.lang.Object r3 = com.deliveryhero.chatui.view.chatroom.ChatViewModelKt.getHideAdminMessagesEnabled(r7, r9)
                if (r3 != r0) goto L_0x009a
                return r0
            L_0x009a:
                r7 = r10
                r10 = r3
                r3 = r7
            L_0x009d:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                java.util.List r10 = r3.filterAdmin(r1, r10)
                java.util.List r10 = r7.removeConfigAndChatFrozenMessages(r10)
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                java.util.Map r1 = r1.messages
                r1.clear()
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper r1 = r1.mapper
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = r0
                java.lang.String r3 = r3.preferredLanguage$customerchat_basicRelease()
                r9.f29529h = r10
                r9.f29530i = r4
                r9.f29531j = r4
                r9.f29532k = r2
                java.lang.Object r1 = r1.map(r3, r10, r9)
                if (r1 != r0) goto L_0x00cf
                return r0
            L_0x00cf:
                r0 = r10
                r10 = r1
            L_0x00d1:
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                java.util.Iterator r10 = r10.iterator()
                r2 = r5
            L_0x00da:
                boolean r3 = r10.hasNext()
                if (r3 == 0) goto L_0x00fa
                java.lang.Object r3 = r10.next()
                int r7 = r2 + 1
                if (r2 >= 0) goto L_0x00eb
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x00eb:
                com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r3 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r3
                java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                java.util.Map r8 = r1.messages
                r8.put(r2, r3)
                r2 = r7
                goto L_0x00da
            L_0x00fa:
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                androidx.lifecycle.MutableLiveData r10 = r10._messagesLiveData
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r1 = r0
                java.util.Map r1 = r1.messages
                java.util.Collection r1 = r1.values()
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)
                r10.setValue(r1)
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                r10.getAndSyncLastMessageInChat()
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r10 = r0.isEmpty()
                r10 = r10 ^ r6
                if (r10 == 0) goto L_0x012e
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                boolean r10 = r10.scrollToBottom
                if (r10 == 0) goto L_0x012e
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                r10.scrollToBottom = r5
            L_0x012e:
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                androidx.lifecycle.MutableLiveData r10 = r10._refreshing
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                r10.setValue(r0)
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                r10.markAllMessagesAsRead()
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r10 = r0
                com.deliveryhero.contract.model.LocationData r10 = r10.pendingLocationData
                if (r10 == 0) goto L_0x0150
                com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r0
                r0.pendingLocationData = r4
                r0.onLocationReceived(r10)
            L_0x0150:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatViewModel$loadChat$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$loadChat$1(ChatViewModel chatViewModel) {
        super(1);
        this.f29528g = chatViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends BaseMessage>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final List<? extends BaseMessage> list) {
        Intrinsics.checkNotNullParameter(list, "chatList");
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.f29528g);
        final ChatViewModel chatViewModel = this.f29528g;
        Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
