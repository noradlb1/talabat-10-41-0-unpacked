package com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl", f = "BenefitManagerRepositoryImpl.kt", i = {}, l = {12}, m = "getBinsDetails", n = {}, s = {})
public final class BenefitManagerRepositoryImpl$getBinsDetails$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f11886h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f11887i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BenefitManagerRepositoryImpl f11888j;

    /* renamed from: k  reason: collision with root package name */
    public int f11889k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BenefitManagerRepositoryImpl$getBinsDetails$1(BenefitManagerRepositoryImpl benefitManagerRepositoryImpl, Continuation<? super BenefitManagerRepositoryImpl$getBinsDetails$1> continuation) {
        super(continuation);
        this.f11888j = benefitManagerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f11887i = obj;
        this.f11889k |= Integer.MIN_VALUE;
        return this.f11888j.getBinsDetails((String) null, this);
    }
}
