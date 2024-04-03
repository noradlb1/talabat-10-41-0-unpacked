package com.talabat.location.area.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.location.area.data.impl.AreaRepositoryImpl", f = "AreaRepositoryImpl.kt", i = {0, 0}, l = {10}, m = "getAreaFor", n = {"latitude", "longitude"}, s = {"D$0", "D$1"})
public final class AreaRepositoryImpl$getAreaFor$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public double f61022h;

    /* renamed from: i  reason: collision with root package name */
    public double f61023i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f61024j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AreaRepositoryImpl f61025k;

    /* renamed from: l  reason: collision with root package name */
    public int f61026l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AreaRepositoryImpl$getAreaFor$1(AreaRepositoryImpl areaRepositoryImpl, Continuation<? super AreaRepositoryImpl$getAreaFor$1> continuation) {
        super(continuation);
        this.f61025k = areaRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61024j = obj;
        this.f61026l |= Integer.MIN_VALUE;
        return this.f61025k.getAreaFor(0.0d, 0.0d, this);
    }
}
