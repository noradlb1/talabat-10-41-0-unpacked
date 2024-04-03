package com.talabat.user.address.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl", f = "CustomerAddressesRepositoryImpl.kt", i = {0}, l = {82}, m = "fetchAndCachAddressToPrefs", n = {"this"}, s = {"L$0"})
public final class CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12140h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12141i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f12142j;

    /* renamed from: k  reason: collision with root package name */
    public int f12143k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, Continuation<? super CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1> continuation) {
        super(continuation);
        this.f12142j = customerAddressesRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12141i = obj;
        this.f12143k |= Integer.MIN_VALUE;
        return this.f12142j.fetchAndCachAddressToPrefs(0, this);
    }
}
