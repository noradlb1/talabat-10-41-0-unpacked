package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl", f = "SetUserSelectedCountryUseCaseImpl.kt", i = {0, 0}, l = {51, 54}, m = "setUserSelectedCountry", n = {"this", "fromLocationWelcome"}, s = {"L$0", "Z$0"})
public final class SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12238h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12239i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f12240j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SetUserSelectedCountryUseCaseImpl f12241k;

    /* renamed from: l  reason: collision with root package name */
    public int f12242l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1(SetUserSelectedCountryUseCaseImpl setUserSelectedCountryUseCaseImpl, Continuation<? super SetUserSelectedCountryUseCaseImpl$setUserSelectedCountry$1> continuation) {
        super(continuation);
        this.f12241k = setUserSelectedCountryUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12240j = obj;
        this.f12242l |= Integer.MIN_VALUE;
        return this.f12241k.setUserSelectedCountry(0, false, false, this);
    }
}
