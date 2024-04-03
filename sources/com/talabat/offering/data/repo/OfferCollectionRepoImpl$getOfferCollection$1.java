package com.talabat.offering.data.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.offering.data.repo.OfferCollectionRepoImpl", f = "OfferCollectionRepoImpl.kt", i = {}, l = {21}, m = "getOfferCollection", n = {}, s = {})
public final class OfferCollectionRepoImpl$getOfferCollection$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61102h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61103i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionRepoImpl f61104j;

    /* renamed from: k  reason: collision with root package name */
    public int f61105k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionRepoImpl$getOfferCollection$1(OfferCollectionRepoImpl offerCollectionRepoImpl, Continuation<? super OfferCollectionRepoImpl$getOfferCollection$1> continuation) {
        super(continuation);
        this.f61104j = offerCollectionRepoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61103i = obj;
        this.f61105k |= Integer.MIN_VALUE;
        return this.f61104j.getOfferCollection(0, 0.0d, 0.0d, this);
    }
}
