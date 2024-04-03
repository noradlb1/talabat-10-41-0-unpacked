package com.talabat.user.address.domain.usecases.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl", f = "RetrieveAndCacheCustomerAddressesUseCaseImpl.kt", i = {0}, l = {14}, m = "retrieveAndCacheCustomerAddresses", n = {"this"}, s = {"L$0"})
public final class RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12160h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12161i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RetrieveAndCacheCustomerAddressesUseCaseImpl f12162j;

    /* renamed from: k  reason: collision with root package name */
    public int f12163k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1(RetrieveAndCacheCustomerAddressesUseCaseImpl retrieveAndCacheCustomerAddressesUseCaseImpl, Continuation<? super RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1> continuation) {
        super(continuation);
        this.f12162j = retrieveAndCacheCustomerAddressesUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12161i = obj;
        this.f12163k |= Integer.MIN_VALUE;
        return this.f12162j.retrieveAndCacheCustomerAddresses(0, this);
    }
}
