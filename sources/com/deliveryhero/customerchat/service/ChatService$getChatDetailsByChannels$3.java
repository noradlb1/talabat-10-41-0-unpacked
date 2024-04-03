package com.deliveryhero.customerchat.service;

import com.deliveryhero.contract.model.ChatDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$3", f = "ChatService.kt", i = {0}, l = {146}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$1"})
public final class ChatService$getChatDetailsByChannels$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f30023h;

    /* renamed from: i  reason: collision with root package name */
    public Object f30024i;

    /* renamed from: j  reason: collision with root package name */
    public Object f30025j;

    /* renamed from: k  reason: collision with root package name */
    public Object f30026k;

    /* renamed from: l  reason: collision with root package name */
    public int f30027l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List<String> f30028m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function1<List<ChatDetails>, Unit> f30029n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f30030o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ChatService f30031p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatService$getChatDetailsByChannels$3(List<String> list, Function1<? super List<ChatDetails>, Unit> function1, Function1<? super Throwable, Unit> function12, ChatService chatService, Continuation<? super ChatService$getChatDetailsByChannels$3> continuation) {
        super(2, continuation);
        this.f30028m = list;
        this.f30029n = function1;
        this.f30030o = function12;
        this.f30031p = chatService;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatService$getChatDetailsByChannels$3(this.f30028m, this.f30029n, this.f30030o, this.f30031p, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatService$getChatDetailsByChannels$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[Catch:{ all -> 0x0095 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f30027l
            r2 = 1
            if (r1 == 0) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r1 = r8.f30026k
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r3 = r8.f30025j
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r8.f30024i
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r8.f30023h
            com.deliveryhero.customerchat.service.ChatService r5 = (com.deliveryhero.customerchat.service.ChatService) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x009a }
            r6 = r5
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r8
            goto L_0x0076
        L_0x0024:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.List<java.lang.String> r9 = r8.f30028m     // Catch:{ all -> 0x009a }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x009a }
            com.deliveryhero.customerchat.service.ChatService r1 = r8.f30031p     // Catch:{ all -> 0x009a }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x009a }
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r9, r4)     // Catch:{ all -> 0x009a }
            r3.<init>(r4)     // Catch:{ all -> 0x009a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x009a }
            r5 = r1
            r1 = r3
            r3 = r9
            r9 = r8
        L_0x0048:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0095 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0095 }
            boolean r6 = r5.isRepoInitialized     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x0083
            com.deliveryhero.contract.ChatRepository r6 = r5.repository     // Catch:{ all -> 0x0095 }
            r9.f30023h = r5     // Catch:{ all -> 0x0095 }
            r9.f30024i = r1     // Catch:{ all -> 0x0095 }
            r9.f30025j = r3     // Catch:{ all -> 0x0095 }
            r9.f30026k = r1     // Catch:{ all -> 0x0095 }
            r9.f30027l = r2     // Catch:{ all -> 0x0095 }
            java.lang.Object r4 = r5.getChatDetailsByChannel((com.deliveryhero.contract.ChatRepository) r6, (java.lang.String) r4, (kotlin.coroutines.Continuation<? super com.deliveryhero.contract.model.ChatDetails>) r9)     // Catch:{ all -> 0x0095 }
            if (r4 != r0) goto L_0x006f
            return r0
        L_0x006f:
            r6 = r5
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r4
            r4 = r3
        L_0x0076:
            com.deliveryhero.contract.model.ChatDetails r9 = (com.deliveryhero.contract.model.ChatDetails) r9     // Catch:{ all -> 0x0081 }
            r3.add(r9)     // Catch:{ all -> 0x0081 }
            r9 = r0
            r0 = r1
            r1 = r4
            r3 = r5
            r5 = r6
            goto L_0x0048
        L_0x0081:
            r9 = move-exception
            goto L_0x009c
        L_0x0083:
            com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException r0 = new com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r5.registeringGccNotInitialized     // Catch:{ all -> 0x0095 }
            r0.<init>(r1)     // Catch:{ all -> 0x0095 }
            throw r0     // Catch:{ all -> 0x0095 }
        L_0x008d:
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0095 }
            kotlin.jvm.functions.Function1<java.util.List<com.deliveryhero.contract.model.ChatDetails>, kotlin.Unit> r0 = r9.f30029n     // Catch:{ all -> 0x0095 }
            r0.invoke(r1)     // Catch:{ all -> 0x0095 }
            goto L_0x00a1
        L_0x0095:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x009c
        L_0x009a:
            r9 = move-exception
            r0 = r8
        L_0x009c:
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r0 = r0.f30030o
            r0.invoke(r9)
        L_0x00a1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
