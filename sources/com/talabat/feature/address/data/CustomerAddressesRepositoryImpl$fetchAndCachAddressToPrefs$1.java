package com.talabat.feature.address.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.address.data.CustomerAddressesRepositoryImpl", f = "CustomerAddressesRepositoryImpl.kt", i = {0}, l = {89}, m = "fetchAndCachAddressToPrefs", n = {"this"}, s = {"L$0"})
public final class CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58355h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58356i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f58357j;

    /* renamed from: k  reason: collision with root package name */
    public int f58358k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, Continuation<? super CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1> continuation) {
        super(continuation);
        this.f58357j = customerAddressesRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58356i = obj;
        this.f58358k |= Integer.MIN_VALUE;
        return this.f58357j.fetchAndCachAddressToPrefs(0, this);
    }
}
