package com.talabat.helpcenter.data.repository;

import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1", f = "UnreadChatMessagesRepositoryImpl.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {39, 40, 49}, m = "invokeSuspend", n = {"$this$flow", "tries", "$this$flow", "chat", "tries", "$this$flow", "tries"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "I$0"})
public final class UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super UnreadChatMessages>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f60743h;

    /* renamed from: i  reason: collision with root package name */
    public int f60744i;

    /* renamed from: j  reason: collision with root package name */
    public int f60745j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ UnreadChatMessagesRepositoryImpl f60746k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f60747l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1(UnreadChatMessagesRepositoryImpl unreadChatMessagesRepositoryImpl, String str, Continuation<? super UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1> continuation) {
        super(2, continuation);
        this.f60746k = unreadChatMessagesRepositoryImpl;
        this.f60747l = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1 unreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1 = new UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1(this.f60746k, this.f60747l, continuation);
        unreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1.L$0 = obj;
        return unreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super UnreadChatMessages> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        throw new com.talabat.helpcenter.domain.exception.UnableToFetchUnreadChatMessages();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053 A[SYNTHETIC, Splitter:B:21:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[ExcHandler: HttpException (unused retrofit2.HttpException), SYNTHETIC, Splitter:B:31:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f60745j
            r2 = 2
            r3 = 0
            r4 = 3
            r5 = 1
            if (r1 == 0) goto L_0x0047
            if (r1 == r5) goto L_0x0036
            if (r1 == r2) goto L_0x0026
            if (r1 != r4) goto L_0x001e
            int r1 = r12.f60744i
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
        L_0x001c:
            r7 = r6
            goto L_0x0051
        L_0x001e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0026:
            int r1 = r12.f60744i
            java.lang.Object r6 = r12.f60743h
            com.talabat.helpcenter.data.datasources.remote.dto.Chat r6 = (com.talabat.helpcenter.data.datasources.remote.dto.Chat) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ IOException -> 0x0044, HttpException -> 0x00a6 }
            r13 = r12
            goto L_0x0094
        L_0x0036:
            int r1 = r12.f60744i
            java.lang.Object r6 = r12.L$0
            r7 = r6
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ IOException -> 0x0044, HttpException -> 0x00a6 }
            r6 = r1
            r1 = r0
            r0 = r12
            goto L_0x006d
        L_0x0044:
            r13 = r12
            goto L_0x00ac
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
            r1 = 0
            r7 = r13
            r13 = r12
        L_0x0051:
            if (r1 >= r4) goto L_0x00c3
            com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl r6 = r13.f60746k     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            com.talabat.helpcenter.data.datasources.remote.ChatMessagesDataSource r6 = r6.chatMessagesDataSource     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            java.lang.String r8 = r13.f60747l     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            r13.L$0 = r7     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            r13.f60744i = r1     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            r13.f60745j = r5     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            java.lang.Object r6 = r6.getUnreadMessagesCount(r8, r13)     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            if (r6 != r0) goto L_0x0068
            return r0
        L_0x0068:
            r11 = r0
            r0 = r13
            r13 = r6
            r6 = r1
            r1 = r11
        L_0x006d:
            com.talabat.helpcenter.data.datasources.remote.dto.UnreadChatMessagesCountResponse r13 = (com.talabat.helpcenter.data.datasources.remote.dto.UnreadChatMessagesCountResponse) r13     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            com.talabat.helpcenter.data.datasources.remote.dto.Chat r13 = r13.component1()     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            com.talabat.helpcenter.domain.entity.UnreadChatMessages r8 = new com.talabat.helpcenter.domain.entity.UnreadChatMessages     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            int r9 = r13.getUnreadMessageCount()     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            boolean r10 = r13.getActive()     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            r8.<init>(r9, r10)     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            r0.L$0 = r7     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            r0.f60743h = r13     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            r0.f60744i = r6     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            r0.f60745j = r2     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            java.lang.Object r8 = r7.emit(r8, r0)     // Catch:{ IOException -> 0x00a2, HttpException -> 0x00a6 }
            if (r8 != r1) goto L_0x008f
            return r1
        L_0x008f:
            r11 = r6
            r6 = r13
            r13 = r0
            r0 = r1
            r1 = r11
        L_0x0094:
            boolean r6 = r6.getActive()     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            if (r6 != 0) goto L_0x00ad
            kotlin.coroutines.CoroutineContext r6 = r13.getContext()     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            kotlinx.coroutines.JobKt__JobKt.cancel$default((kotlin.coroutines.CoroutineContext) r6, (java.util.concurrent.CancellationException) r3, (int) r5, (java.lang.Object) r3)     // Catch:{ IOException -> 0x00ac, HttpException -> 0x00a6 }
            goto L_0x00ad
        L_0x00a2:
            r13 = r0
            r0 = r1
            r1 = r6
            goto L_0x00ac
        L_0x00a6:
            com.talabat.helpcenter.domain.exception.UnableToFetchUnreadChatMessages r13 = new com.talabat.helpcenter.domain.exception.UnableToFetchUnreadChatMessages
            r13.<init>()
            throw r13
        L_0x00ac:
            int r1 = r1 + r5
        L_0x00ad:
            r6 = r7
            com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl r7 = r13.f60746k
            long r7 = r7.delay
            r13.L$0 = r6
            r13.f60743h = r3
            r13.f60744i = r1
            r13.f60745j = r4
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.m7781delayVtjQ1oo(r7, r13)
            if (r7 != r0) goto L_0x001c
            return r0
        L_0x00c3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.data.repository.UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
