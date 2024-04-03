package com.talabat.fluid.homescreen.data.impl;

import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl", f = "HomeConfigurationRepositoryImpl.kt", i = {0, 0}, l = {147}, m = "getComponents", n = {"this", "requestParams"}, s = {"L$0", "L$1"})
public final class HomeConfigurationRepositoryImpl$getComponents$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59689h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59690i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59691j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59692k;

    /* renamed from: l  reason: collision with root package name */
    public int f59693l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$getComponents$1(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, Continuation<? super HomeConfigurationRepositoryImpl$getComponents$1> continuation) {
        super(continuation);
        this.f59692k = homeConfigurationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59691j = obj;
        this.f59693l |= Integer.MIN_VALUE;
        return this.f59692k.getComponents((FluidHomeComponentRequestParams) null, this);
    }
}
