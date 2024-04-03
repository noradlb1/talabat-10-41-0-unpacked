package com.talabat.offering.domain.usecases.business;

import com.talabat.configuration.ConfigurationLocalRepository;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/GetUserIsOfferCollectionSubscribedUseCase;", "", "offerCollectionRepo", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/offering/domain/repo/OfferCollectionRepo;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "", "productId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetUserIsOfferCollectionSubscribedUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final OfferCollectionRepo offerCollectionRepo;

    public GetUserIsOfferCollectionSubscribedUseCase(@NotNull OfferCollectionRepo offerCollectionRepo2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(offerCollectionRepo2, "offerCollectionRepo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.offerCollectionRepo = offerCollectionRepo2;
        this.dispatcher = coroutineDispatcher;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetUserIsOfferCollectionSubscribedUseCase$invoke$2(this, str, (Continuation<? super GetUserIsOfferCollectionSubscribedUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserIsOfferCollectionSubscribedUseCase(OfferCollectionRepo offerCollectionRepo2, CoroutineDispatcher coroutineDispatcher, ConfigurationLocalRepository configurationLocalRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offerCollectionRepo2, (i11 & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher, configurationLocalRepository2);
    }
}
