package com.talabat.userandlocation.customerinfo.data.remote.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl", f = "CustomerInfoRemoteDataSourceImpl.kt", i = {}, l = {13}, m = "getCustomerInfo", n = {}, s = {})
public final class CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12332h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerInfoRemoteDataSourceImpl f12333i;

    /* renamed from: j  reason: collision with root package name */
    public int f12334j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1(CustomerInfoRemoteDataSourceImpl customerInfoRemoteDataSourceImpl, Continuation<? super CustomerInfoRemoteDataSourceImpl$getCustomerInfo$1> continuation) {
        super(continuation);
        this.f12333i = customerInfoRemoteDataSourceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12332h = obj;
        this.f12334j |= Integer.MIN_VALUE;
        return this.f12333i.getCustomerInfo(0, this);
    }
}
