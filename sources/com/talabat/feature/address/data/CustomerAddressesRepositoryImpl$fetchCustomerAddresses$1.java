package com.talabat.feature.address.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.address.data.CustomerAddressesRepositoryImpl", f = "CustomerAddressesRepositoryImpl.kt", i = {0, 0, 1, 1}, l = {97, 108}, m = "fetchCustomerAddresses", n = {"this", "countryId", "this", "apiExecution"}, s = {"L$0", "I$0", "L$0", "L$1"})
public final class CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58359h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58360i;

    /* renamed from: j  reason: collision with root package name */
    public int f58361j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f58362k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f58363l;

    /* renamed from: m  reason: collision with root package name */
    public int f58364m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, Continuation<? super CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1> continuation) {
        super(continuation);
        this.f58363l = customerAddressesRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58362k = obj;
        this.f58364m |= Integer.MIN_VALUE;
        return this.f58363l.fetchCustomerAddresses(0, this);
    }
}
