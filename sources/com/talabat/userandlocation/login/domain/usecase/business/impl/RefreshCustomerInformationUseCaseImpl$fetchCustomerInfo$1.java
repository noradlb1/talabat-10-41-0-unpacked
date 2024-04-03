package com.talabat.userandlocation.login.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl", f = "RefreshCustomerInformationUseCaseImpl.kt", i = {0}, l = {48}, m = "fetchCustomerInfo", n = {"this"}, s = {"L$0"})
public final class RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12352h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12353i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RefreshCustomerInformationUseCaseImpl f12354j;

    /* renamed from: k  reason: collision with root package name */
    public int f12355k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1(RefreshCustomerInformationUseCaseImpl refreshCustomerInformationUseCaseImpl, Continuation<? super RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1> continuation) {
        super(continuation);
        this.f12354j = refreshCustomerInformationUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12353i = obj;
        this.f12355k |= Integer.MIN_VALUE;
        return this.f12354j.fetchCustomerInfo(this);
    }
}
