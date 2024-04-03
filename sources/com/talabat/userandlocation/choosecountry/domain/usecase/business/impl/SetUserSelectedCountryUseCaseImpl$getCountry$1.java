package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl", f = "SetUserSelectedCountryUseCaseImpl.kt", i = {0}, l = {96}, m = "getCountry", n = {"selectedCountryId"}, s = {"I$0"})
public final class SetUserSelectedCountryUseCaseImpl$getCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public int f12222h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SetUserSelectedCountryUseCaseImpl f12224j;

    /* renamed from: k  reason: collision with root package name */
    public int f12225k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetUserSelectedCountryUseCaseImpl$getCountry$1(SetUserSelectedCountryUseCaseImpl setUserSelectedCountryUseCaseImpl, Continuation<? super SetUserSelectedCountryUseCaseImpl$getCountry$1> continuation) {
        super(continuation);
        this.f12224j = setUserSelectedCountryUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12223i = obj;
        this.f12225k |= Integer.MIN_VALUE;
        return this.f12224j.getCountry(0, this);
    }
}
