package com.talabat.offering.data.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.offering.data.repo.OfferCollectionRepoImpl", f = "OfferCollectionRepoImpl.kt", i = {}, l = {29}, m = "getIsOfferCollectionSubscribed", n = {}, s = {})
public final class OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61098h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61099i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionRepoImpl f61100j;

    /* renamed from: k  reason: collision with root package name */
    public int f61101k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1(OfferCollectionRepoImpl offerCollectionRepoImpl, Continuation<? super OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1> continuation) {
        super(continuation);
        this.f61100j = offerCollectionRepoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61099i = obj;
        this.f61101k |= Integer.MIN_VALUE;
        return this.f61100j.getIsOfferCollectionSubscribed((String) null, 0, this);
    }
}
