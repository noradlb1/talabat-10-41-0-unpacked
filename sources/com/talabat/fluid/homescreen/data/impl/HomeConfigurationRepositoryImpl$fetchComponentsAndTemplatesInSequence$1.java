package com.talabat.fluid.homescreen.data.impl;

import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl", f = "HomeConfigurationRepositoryImpl.kt", i = {0}, l = {89}, m = "fetchComponentsAndTemplatesInSequence", n = {"this"}, s = {"L$0"})
public final class HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59685h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59686i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59687j;

    /* renamed from: k  reason: collision with root package name */
    public int f59688k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInSequence$1> continuation) {
        super(continuation);
        this.f59687j = homeConfigurationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59686i = obj;
        this.f59688k |= Integer.MIN_VALUE;
        return this.f59687j.fetchComponentsAndTemplatesInSequence((FluidHomeComponentRequestParams) null, this);
    }
}
