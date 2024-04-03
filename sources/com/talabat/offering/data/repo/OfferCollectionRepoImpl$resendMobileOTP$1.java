package com.talabat.offering.data.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.offering.data.repo.OfferCollectionRepoImpl", f = "OfferCollectionRepoImpl.kt", i = {}, l = {40}, m = "resendMobileOTP", n = {}, s = {})
public final class OfferCollectionRepoImpl$resendMobileOTP$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61106h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61107i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionRepoImpl f61108j;

    /* renamed from: k  reason: collision with root package name */
    public int f61109k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionRepoImpl$resendMobileOTP$1(OfferCollectionRepoImpl offerCollectionRepoImpl, Continuation<? super OfferCollectionRepoImpl$resendMobileOTP$1> continuation) {
        super(continuation);
        this.f61108j = offerCollectionRepoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61107i = obj;
        this.f61109k |= Integer.MIN_VALUE;
        return this.f61108j.resendMobileOTP((String) null, this);
    }
}
