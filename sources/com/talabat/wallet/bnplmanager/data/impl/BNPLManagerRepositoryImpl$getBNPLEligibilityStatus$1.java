package com.talabat.wallet.bnplmanager.data.impl;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl", f = "BNPLManagerRepositoryImpl.kt", i = {0}, l = {50, 53}, m = "getBNPLEligibilityStatus", n = {"this"}, s = {"L$0"})
public final class BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12456h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12457i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BNPLManagerRepositoryImpl f12458j;

    /* renamed from: k  reason: collision with root package name */
    public int f12459k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1(BNPLManagerRepositoryImpl bNPLManagerRepositoryImpl, Continuation<? super BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1> continuation) {
        super(continuation);
        this.f12458j = bNPLManagerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12457i = obj;
        this.f12459k |= Integer.MIN_VALUE;
        return this.f12458j.getBNPLEligibilityStatus((BNPLEligibilityRequestDto) null, this);
    }
}
