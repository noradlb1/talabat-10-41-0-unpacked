package com.talabat.offering.data.repo;

import com.talabat.offering.data.remote.dtos.SendMobileOTPDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.offering.data.repo.OfferCollectionRepoImpl", f = "OfferCollectionRepoImpl.kt", i = {}, l = {37}, m = "sendMobileOTP", n = {}, s = {})
public final class OfferCollectionRepoImpl$sendMobileOTP$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61110h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61111i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionRepoImpl f61112j;

    /* renamed from: k  reason: collision with root package name */
    public int f61113k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionRepoImpl$sendMobileOTP$1(OfferCollectionRepoImpl offerCollectionRepoImpl, Continuation<? super OfferCollectionRepoImpl$sendMobileOTP$1> continuation) {
        super(continuation);
        this.f61112j = offerCollectionRepoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61111i = obj;
        this.f61113k |= Integer.MIN_VALUE;
        return this.f61112j.sendMobileOTP((SendMobileOTPDto) null, this);
    }
}
