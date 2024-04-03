package com.talabat.riderinfo.data.datasource.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl", f = "RiderInfoRepositoryImpl.kt", i = {}, l = {13}, m = "getRiderInfo", n = {}, s = {})
public final class RiderInfoRepositoryImpl$getRiderInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61288h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RiderInfoRepositoryImpl f61289i;

    /* renamed from: j  reason: collision with root package name */
    public int f61290j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderInfoRepositoryImpl$getRiderInfo$1(RiderInfoRepositoryImpl riderInfoRepositoryImpl, Continuation<? super RiderInfoRepositoryImpl$getRiderInfo$1> continuation) {
        super(continuation);
        this.f61289i = riderInfoRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61288h = obj;
        this.f61290j |= Integer.MIN_VALUE;
        return this.f61289i.getRiderInfo((String) null, this);
    }
}
