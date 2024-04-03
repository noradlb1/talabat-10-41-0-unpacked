package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl", f = "SetUserSelectedCountryUseCaseImpl.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {62, 63, 71}, m = "setSelectedCountry", n = {"this", "selectedCountry", "fromLocationWelcome", "this", "selectedCountry", "appInfoApiCall", "fromLocationWelcome"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
public final class SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12231h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12232i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12233j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12234k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f12235l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SetUserSelectedCountryUseCaseImpl f12236m;

    /* renamed from: n  reason: collision with root package name */
    public int f12237n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1(SetUserSelectedCountryUseCaseImpl setUserSelectedCountryUseCaseImpl, Continuation<? super SetUserSelectedCountryUseCaseImpl$setSelectedCountry$1> continuation) {
        super(continuation);
        this.f12236m = setUserSelectedCountryUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12235l = obj;
        this.f12237n |= Integer.MIN_VALUE;
        return this.f12236m.setSelectedCountry(false, (CountryVO) null, this);
    }
}
