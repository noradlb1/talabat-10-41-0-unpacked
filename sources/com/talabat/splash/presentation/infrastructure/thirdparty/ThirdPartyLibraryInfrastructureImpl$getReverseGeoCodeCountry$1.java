package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.location.Location;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl", f = "ThirdPartyLibraryInfrastructureImpl.kt", i = {0}, l = {34}, m = "getReverseGeoCodeCountry", n = {"this"}, s = {"L$0"})
public final class ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61510h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61511i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ThirdPartyLibraryInfrastructureImpl f61512j;

    /* renamed from: k  reason: collision with root package name */
    public int f61513k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1(ThirdPartyLibraryInfrastructureImpl thirdPartyLibraryInfrastructureImpl, Continuation<? super ThirdPartyLibraryInfrastructureImpl$getReverseGeoCodeCountry$1> continuation) {
        super(continuation);
        this.f61512j = thirdPartyLibraryInfrastructureImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61511i = obj;
        this.f61513k |= Integer.MIN_VALUE;
        return this.f61512j.getReverseGeoCodeCountry((Location) null, this);
    }
}
