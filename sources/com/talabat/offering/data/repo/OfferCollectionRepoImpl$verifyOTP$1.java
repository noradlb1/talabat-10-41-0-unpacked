package com.talabat.offering.data.repo;

import com.talabat.offering.data.remote.dtos.OTPCodeModelDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.offering.data.repo.OfferCollectionRepoImpl", f = "OfferCollectionRepoImpl.kt", i = {}, l = {44}, m = "verifyOTP", n = {}, s = {})
public final class OfferCollectionRepoImpl$verifyOTP$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61114h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61115i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionRepoImpl f61116j;

    /* renamed from: k  reason: collision with root package name */
    public int f61117k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionRepoImpl$verifyOTP$1(OfferCollectionRepoImpl offerCollectionRepoImpl, Continuation<? super OfferCollectionRepoImpl$verifyOTP$1> continuation) {
        super(continuation);
        this.f61116j = offerCollectionRepoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61115i = obj;
        this.f61117k |= Integer.MIN_VALUE;
        return this.f61116j.verifyOTP((String) null, (OTPCodeModelDto) null, this);
    }
}
