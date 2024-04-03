package com.talabat.offering.domain.usecases.business;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.domain.entities.OTPData;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/SendMobileOTPUseCase;", "", "offerCollectionRepo", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/offering/domain/repo/OfferCollectionRepo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lcom/talabat/offering/domain/entities/OTPData;", "mobileNumber", "", "productId", "requestId", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendMobileOTPUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final OfferCollectionRepo offerCollectionRepo;

    public SendMobileOTPUseCase(@NotNull OfferCollectionRepo offerCollectionRepo2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(offerCollectionRepo2, "offerCollectionRepo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.offerCollectionRepo = offerCollectionRepo2;
        this.dispatcher = coroutineDispatcher;
    }

    public static /* synthetic */ Object invoke$default(SendMobileOTPUseCase sendMobileOTPUseCase, String str, String str2, String str3, ConfigurationLocalRepository configurationLocalRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return sendMobileOTPUseCase.invoke(str, str2, str3, configurationLocalRepository, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull Continuation<? super OTPData> continuation) {
        return BuildersKt.withContext(this.dispatcher, new SendMobileOTPUseCase$invoke$2(str, configurationLocalRepository, str2, str3, this, (Continuation<? super SendMobileOTPUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendMobileOTPUseCase(OfferCollectionRepo offerCollectionRepo2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offerCollectionRepo2, (i11 & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
