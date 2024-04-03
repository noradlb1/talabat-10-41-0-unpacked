package com.talabat.wallet.knetStatusManager.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.knetStatusManager.data.impl.KNetStatusManagerRepositoryImpl", f = "KNetStatusManagerRepositoryImpl.kt", i = {}, l = {12}, m = "getKNetStatus", n = {}, s = {})
public final class KNetStatusManagerRepositoryImpl$getKNetStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12616h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12617i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ KNetStatusManagerRepositoryImpl f12618j;

    /* renamed from: k  reason: collision with root package name */
    public int f12619k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KNetStatusManagerRepositoryImpl$getKNetStatus$1(KNetStatusManagerRepositoryImpl kNetStatusManagerRepositoryImpl, Continuation<? super KNetStatusManagerRepositoryImpl$getKNetStatus$1> continuation) {
        super(continuation);
        this.f12618j = kNetStatusManagerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12617i = obj;
        this.f12619k |= Integer.MIN_VALUE;
        return this.f12618j.getKNetStatus(this);
    }
}
