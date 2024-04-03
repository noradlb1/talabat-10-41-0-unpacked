package com.deliveryhero.contract.configuration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.contract.configuration.ChatDataRepositoryImpl", f = "ChatDataRepositoryImpl.kt", i = {}, l = {19}, m = "shouldClearVOIPCache", n = {}, s = {})
public final class ChatDataRepositoryImpl$shouldClearVOIPCache$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f29710h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatDataRepositoryImpl f29711i;

    /* renamed from: j  reason: collision with root package name */
    public int f29712j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatDataRepositoryImpl$shouldClearVOIPCache$1(ChatDataRepositoryImpl chatDataRepositoryImpl, Continuation<? super ChatDataRepositoryImpl$shouldClearVOIPCache$1> continuation) {
        super(continuation);
        this.f29711i = chatDataRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f29710h = obj;
        this.f29712j |= Integer.MIN_VALUE;
        return this.f29711i.shouldClearVOIPCache(this);
    }
}
