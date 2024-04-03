package com.talabat.offering.domain.usecases.business;

import com.talabat.offering.domain.entities.OfferCollection;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/GetOfferCollectionUseCase;", "", "offerCollectionRepo", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/offering/domain/repo/OfferCollectionRepo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lcom/talabat/offering/domain/entities/OfferCollection;", "collectionId", "", "lat", "", "lon", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOfferCollectionUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final OfferCollectionRepo offerCollectionRepo;

    public GetOfferCollectionUseCase(@NotNull OfferCollectionRepo offerCollectionRepo2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(offerCollectionRepo2, "offerCollectionRepo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.offerCollectionRepo = offerCollectionRepo2;
        this.dispatcher = coroutineDispatcher;
    }

    @Nullable
    public final Object invoke(int i11, double d11, double d12, @NotNull Continuation<? super OfferCollection> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetOfferCollectionUseCase$invoke$2(this, i11, d11, d12, (Continuation<? super GetOfferCollectionUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetOfferCollectionUseCase(OfferCollectionRepo offerCollectionRepo2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offerCollectionRepo2, (i11 & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
