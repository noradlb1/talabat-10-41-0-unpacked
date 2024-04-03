package com.talabat.user.address.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl", f = "CustomerAddressesRepositoryImpl.kt", i = {0}, l = {159}, m = "getCustomerAddressesFromFallback", n = {"this"}, s = {"L$0"})
public final class CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12150h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12151i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f12152j;

    /* renamed from: k  reason: collision with root package name */
    public int f12153k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, Continuation<? super CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1> continuation) {
        super(continuation);
        this.f12152j = customerAddressesRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12151i = obj;
        this.f12153k |= Integer.MIN_VALUE;
        return this.f12152j.getCustomerAddressesFromFallback(0, this);
    }
}
