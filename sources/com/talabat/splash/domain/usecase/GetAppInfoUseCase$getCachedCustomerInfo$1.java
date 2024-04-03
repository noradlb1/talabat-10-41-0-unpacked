package com.talabat.splash.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAppInfoUseCase", f = "GetAppInfoUseCase.kt", i = {}, l = {106}, m = "getCachedCustomerInfo", n = {}, s = {})
public final class GetAppInfoUseCase$getCachedCustomerInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61475h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetAppInfoUseCase f61476i;

    /* renamed from: j  reason: collision with root package name */
    public int f61477j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAppInfoUseCase$getCachedCustomerInfo$1(GetAppInfoUseCase getAppInfoUseCase, Continuation<? super GetAppInfoUseCase$getCachedCustomerInfo$1> continuation) {
        super(continuation);
        this.f61476i = getAppInfoUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61475h = obj;
        this.f61477j |= Integer.MIN_VALUE;
        return this.f61476i.getCachedCustomerInfo(this);
    }
}
