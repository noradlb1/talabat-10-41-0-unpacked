package com.deliveryhero.customerchat.telephony.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.deliveryhero.customerchat.telephony.repository.PushConfigRepository", f = "PushConfigRepository.kt", i = {0}, l = {31}, m = "awaitTokenFlow", n = {"this"}, s = {"L$0"})
public final class PushConfigRepository$awaitTokenFlow$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f30052h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f30053i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PushConfigRepository f30054j;

    /* renamed from: k  reason: collision with root package name */
    public int f30055k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PushConfigRepository$awaitTokenFlow$1(PushConfigRepository pushConfigRepository, Continuation<? super PushConfigRepository$awaitTokenFlow$1> continuation) {
        super(continuation);
        this.f30054j = pushConfigRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f30053i = obj;
        this.f30055k |= Integer.MIN_VALUE;
        return this.f30054j.awaitTokenFlow(this);
    }
}
