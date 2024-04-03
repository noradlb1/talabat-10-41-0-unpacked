package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl", f = "FetchHomeCollectionsUseCaseImpl.kt", i = {0}, l = {21}, m = "fetchHomeCollections", n = {"this"}, s = {"L$0"})
public final class FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59720h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59721i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FetchHomeCollectionsUseCaseImpl f59722j;

    /* renamed from: k  reason: collision with root package name */
    public int f59723k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1(FetchHomeCollectionsUseCaseImpl fetchHomeCollectionsUseCaseImpl, Continuation<? super FetchHomeCollectionsUseCaseImpl$fetchHomeCollections$1> continuation) {
        super(continuation);
        this.f59722j = fetchHomeCollectionsUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59721i = obj;
        this.f59723k |= Integer.MIN_VALUE;
        return this.f59722j.fetchHomeCollections(this);
    }
}
