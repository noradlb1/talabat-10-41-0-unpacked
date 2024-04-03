package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl", f = "RequestAreasToCacheUseCaseImpl.kt", i = {0}, l = {23}, m = "requestAreasToCache", n = {"this"}, s = {"L$0"})
public final class RequestAreasToCacheUseCaseImpl$requestAreasToCache$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12218h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12219i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RequestAreasToCacheUseCaseImpl f12220j;

    /* renamed from: k  reason: collision with root package name */
    public int f12221k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestAreasToCacheUseCaseImpl$requestAreasToCache$1(RequestAreasToCacheUseCaseImpl requestAreasToCacheUseCaseImpl, Continuation<? super RequestAreasToCacheUseCaseImpl$requestAreasToCache$1> continuation) {
        super(continuation);
        this.f12220j = requestAreasToCacheUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12219i = obj;
        this.f12221k |= Integer.MIN_VALUE;
        return this.f12220j.requestAreasToCache(0, this);
    }
}
