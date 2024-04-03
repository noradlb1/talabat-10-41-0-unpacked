package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$updateMessageSuccess$1", f = "ChatViewModel.kt", i = {0, 1, 1}, l = {774, 785}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "message"}, s = {"L$0", "L$0", "L$1"})
public final class ChatViewModel$updateMessageSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f29611h;

    /* renamed from: i  reason: collision with root package name */
    public Object f29612i;

    /* renamed from: j  reason: collision with root package name */
    public int f29613j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BaseMessage f29614k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29615l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChatMessageViewModel f29616m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Throwable f29617n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$updateMessageSuccess$1(BaseMessage baseMessage, ChatViewModel chatViewModel, ChatMessageViewModel chatMessageViewModel, Throwable th2, Continuation<? super ChatViewModel$updateMessageSuccess$1> continuation) {
        super(2, continuation);
        this.f29614k = baseMessage;
        this.f29615l = chatViewModel;
        this.f29616m = chatMessageViewModel;
        this.f29617n = th2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChatViewModel$updateMessageSuccess$1 chatViewModel$updateMessageSuccess$1 = new ChatViewModel$updateMessageSuccess$1(this.f29614k, this.f29615l, this.f29616m, this.f29617n, continuation);
        chatViewModel$updateMessageSuccess$1.L$0 = obj;
        return chatViewModel$updateMessageSuccess$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$updateMessageSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r6 = r20
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.f29613j
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 == r2) goto L_0x002c
            if (r0 != r1) goto L_0x0024
            java.lang.Object r0 = r6.f29612i
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r6.f29611h
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r6.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r21)
            r8 = r0
            r0 = r21
            goto L_0x00ba
        L_0x0024:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002c:
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r21)
            r3 = r21
            goto L_0x005f
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.deliveryhero.contract.model.BaseMessage r3 = r6.f29614k
            boolean r3 = r3 instanceof com.deliveryhero.contract.model.AdminMessage
            if (r3 == 0) goto L_0x0048
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = r6.f29615l
            r3.fetchConfigIfPhoneCalling()
        L_0x0048:
            com.deliveryhero.contract.model.BaseMessage r3 = r6.f29614k
            boolean r3 = r3 instanceof com.deliveryhero.contract.model.AdminMessage
            if (r3 == 0) goto L_0x006a
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = r6.f29615l
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r3 = r3.featureFlagProvider
            r6.L$0 = r0
            r6.f29613j = r2
            java.lang.Object r3 = com.deliveryhero.chatui.view.chatroom.ChatViewModelKt.getHideAdminMessagesEnabled(r3, r6)
            if (r3 != r7) goto L_0x005f
            return r7
        L_0x005f:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x006a
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x006a:
            com.deliveryhero.contract.model.BaseMessage r3 = r6.f29614k
            boolean r4 = r3 instanceof com.deliveryhero.contract.model.ConfigUpdateMessage
            if (r4 != 0) goto L_0x014d
            boolean r3 = r3 instanceof com.deliveryhero.contract.model.ChannelFrozenMessage
            if (r3 == 0) goto L_0x0076
            goto L_0x014d
        L_0x0076:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = r6.f29615l
            r3.scrollToBottom = r2
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r2 = r6.f29615l
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper r2 = r2.mapper
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r3 = r6.f29616m
            if (r3 == 0) goto L_0x008f
            int r3 = r3.getIndex()
            goto L_0x0099
        L_0x008f:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r3 = r6.f29615l
            java.util.Map r3 = r3.messages
            int r3 = r3.size()
        L_0x0099:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r4 = r6.f29615l
            java.lang.String r4 = r4.preferredLanguage$customerchat_basicRelease()
            com.deliveryhero.contract.model.BaseMessage r5 = r6.f29614k
            java.lang.Throwable r9 = r6.f29617n
            r6.L$0 = r0
            r6.f29611h = r8
            r6.f29612i = r8
            r6.f29613j = r1
            r0 = r2
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r9
            r5 = r20
            java.lang.Object r0 = r0.map(r1, r2, r3, r4, r5)
            if (r0 != r7) goto L_0x00b9
            return r7
        L_0x00b9:
            r1 = r8
        L_0x00ba:
            r8.element = r0
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r0 = r6.f29616m
            if (r0 == 0) goto L_0x0102
            java.lang.Throwable r0 = r6.f29617n
            if (r0 == 0) goto L_0x00e3
            T r0 = r1.element
            r7 = r0
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r7 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            com.deliveryhero.contract.model.Receipt r15 = com.deliveryhero.contract.model.Receipt.FAILED
            r16 = 0
            r17 = 0
            r18 = 895(0x37f, float:1.254E-42)
            r19 = 0
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r0 = com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1.element = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00e4
        L_0x00e3:
            r0 = 0
        L_0x00e4:
            if (r0 != 0) goto L_0x0102
            T r0 = r1.element
            r7 = r0
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r7 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            com.deliveryhero.contract.model.Receipt r15 = com.deliveryhero.contract.model.Receipt.SENT
            r16 = 0
            r17 = 0
            r18 = 895(0x37f, float:1.254E-42)
            r19 = 0
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r0 = com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1.element = r0
        L_0x0102:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r6.f29615l
            java.util.Map r0 = r0.messages
            T r2 = r1.element
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r2 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r2
            int r2 = r2.getIndex()
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            T r3 = r1.element
            r0.put(r2, r3)
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r6.f29615l
            androidx.lifecycle.MutableLiveData r0 = r0._messagesLiveData
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r2 = r6.f29615l
            java.util.Map r2 = r2.messages
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r2)
            r0.postValue(r2)
            T r0 = r1.element
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r0 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r0
            boolean r0 = r0.getSendByMe()
            if (r0 == 0) goto L_0x0145
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r6.f29615l
            T r1 = r1.element
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r1 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r1
            com.deliveryhero.chatui.view.chatroom.ChatViewModelEventsHelperKt.trackMessageDeliveredEvent(r0, r1)
        L_0x0145:
            com.deliveryhero.chatui.view.chatroom.ChatViewModel r0 = r6.f29615l
            r0.getAndSyncLastMessageInChat()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.ChatViewModel$updateMessageSuccess$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
