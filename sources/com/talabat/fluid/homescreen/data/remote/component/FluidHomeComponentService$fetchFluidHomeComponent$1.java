package com.talabat.fluid.homescreen.data.remote.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService", f = "FluidHomeComponentService.kt", i = {0}, l = {32}, m = "fetchFluidHomeComponent", n = {"this"}, s = {"L$0"})
public final class FluidHomeComponentService$fetchFluidHomeComponent$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59698h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59699i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeComponentService f59700j;

    /* renamed from: k  reason: collision with root package name */
    public int f59701k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeComponentService$fetchFluidHomeComponent$1(FluidHomeComponentService fluidHomeComponentService, Continuation<? super FluidHomeComponentService$fetchFluidHomeComponent$1> continuation) {
        super(continuation);
        this.f59700j = fluidHomeComponentService;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59699i = obj;
        this.f59701k |= Integer.MIN_VALUE;
        return this.f59700j.fetchFluidHomeComponent((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0d, 0.0d, 0, this);
    }
}
