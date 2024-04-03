package com.talabat.userandlocation.login.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl", f = "RefreshCustomerInformationUseCaseImpl.kt", i = {0}, l = {37}, m = "fetchCustomerAddresses", n = {"this"}, s = {"L$0"})
public final class RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12348h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12349i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RefreshCustomerInformationUseCaseImpl f12350j;

    /* renamed from: k  reason: collision with root package name */
    public int f12351k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1(RefreshCustomerInformationUseCaseImpl refreshCustomerInformationUseCaseImpl, Continuation<? super RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1> continuation) {
        super(continuation);
        this.f12350j = refreshCustomerInformationUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12349i = obj;
        this.f12351k |= Integer.MIN_VALUE;
        return this.f12350j.fetchCustomerAddresses(this);
    }
}
