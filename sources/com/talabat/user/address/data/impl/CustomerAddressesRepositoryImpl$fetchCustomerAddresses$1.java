package com.talabat.user.address.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl", f = "CustomerAddressesRepositoryImpl.kt", i = {0, 0, 1, 1}, l = {102, 113}, m = "fetchCustomerAddresses", n = {"this", "countryId", "this", "apiExecution"}, s = {"L$0", "I$0", "L$0", "L$1"})
public final class CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12144h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12145i;

    /* renamed from: j  reason: collision with root package name */
    public int f12146j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f12147k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f12148l;

    /* renamed from: m  reason: collision with root package name */
    public int f12149m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, Continuation<? super CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1> continuation) {
        super(continuation);
        this.f12148l = customerAddressesRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12147k = obj;
        this.f12149m |= Integer.MIN_VALUE;
        return this.f12148l.fetchCustomerAddresses(0, this);
    }
}
