package com.talabat.helpcenter.data.repository;

import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1", f = "UnreadChatMessagesRepositoryImpl.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super UnreadChatMessages>, Boolean, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60739h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f60740i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UnreadChatMessagesRepositoryImpl f60741j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f60742k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1(Continuation continuation, UnreadChatMessagesRepositoryImpl unreadChatMessagesRepositoryImpl, String str) {
        super(3, continuation);
        this.f60741j = unreadChatMessagesRepositoryImpl;
        this.f60742k = str;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super UnreadChatMessages> flowCollector, Boolean bool, @Nullable Continuation<? super Unit> continuation) {
        UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1 unreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1 = new UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1(continuation, this.f60741j, this.f60742k);
        unreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1.L$0 = flowCollector;
        unreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1.f60740i = bool;
        return unreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60739h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            boolean booleanValue = ((Boolean) this.f60740i).booleanValue();
            if (booleanValue) {
                flow = this.f60741j.createUnreadMessagesFlow(this.f60742k);
            } else {
                flow = FlowKt.flowOf(new UnreadChatMessages(0, booleanValue));
            }
            this.f60739h = 1;
            if (FlowKt.emitAll(flowCollector, flow, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
