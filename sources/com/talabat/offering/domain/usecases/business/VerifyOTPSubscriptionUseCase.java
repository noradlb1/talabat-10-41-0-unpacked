package com.talabat.offering.domain.usecases.business;

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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/VerifyOTPSubscriptionUseCase;", "", "offerCollectionRepo", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/offering/domain/repo/OfferCollectionRepo;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lcom/talabat/offering/domain/entities/OTPData;", "requestId", "", "otpCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyOTPSubscriptionUseCase {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final OfferCollectionRepo offerCollectionRepo;

    public VerifyOTPSubscriptionUseCase(@NotNull OfferCollectionRepo offerCollectionRepo2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(offerCollectionRepo2, "offerCollectionRepo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.offerCollectionRepo = offerCollectionRepo2;
        this.dispatcher = coroutineDispatcher;
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super OTPData> continuation) {
        return BuildersKt.withContext(this.dispatcher, new VerifyOTPSubscriptionUseCase$invoke$2(str2, this, str, (Continuation<? super VerifyOTPSubscriptionUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerifyOTPSubscriptionUseCase(OfferCollectionRepo offerCollectionRepo2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(offerCollectionRepo2, (i11 & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
