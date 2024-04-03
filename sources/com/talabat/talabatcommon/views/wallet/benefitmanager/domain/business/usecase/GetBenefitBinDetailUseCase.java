package com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase;

import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.application.usecase.GetBenefitBinDetailFeatureFlagUseCase;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.repository.BenefitManagerRepository;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/business/usecase/GetBenefitBinDetailUseCase;", "", "benefitManagerRepository", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/repository/BenefitManagerRepository;", "getBenefitBinDetailFeatureFlagUseCase", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/application/usecase/GetBenefitBinDetailFeatureFlagUseCase;", "checkoutPaymentManagerRepository", "Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/repository/BenefitManagerRepository;Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/application/usecase/GetBenefitBinDetailFeatureFlagUseCase;Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "bins", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBenefitBinDetailUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BenefitManagerRepository benefitManagerRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final CheckoutPaymentManagerRepository checkoutPaymentManagerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final GetBenefitBinDetailFeatureFlagUseCase getBenefitBinDetailFeatureFlagUseCase;

    public GetBenefitBinDetailUseCase(@NotNull BenefitManagerRepository benefitManagerRepository2, @NotNull GetBenefitBinDetailFeatureFlagUseCase getBenefitBinDetailFeatureFlagUseCase2, @NotNull CheckoutPaymentManagerRepository checkoutPaymentManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(benefitManagerRepository2, "benefitManagerRepository");
        Intrinsics.checkNotNullParameter(getBenefitBinDetailFeatureFlagUseCase2, "getBenefitBinDetailFeatureFlagUseCase");
        Intrinsics.checkNotNullParameter(checkoutPaymentManagerRepository2, "checkoutPaymentManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.benefitManagerRepository = benefitManagerRepository2;
        this.getBenefitBinDetailFeatureFlagUseCase = getBenefitBinDetailFeatureFlagUseCase2;
        this.checkoutPaymentManagerRepository = checkoutPaymentManagerRepository2;
        this.dispatcher = coroutineDispatcher;
    }

    @Nullable
    public final Object invoke(@Nullable String str, @NotNull Continuation<? super BenefitBinsDetail> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetBenefitBinDetailUseCase$invoke$2(this, str, (Continuation<? super GetBenefitBinDetailUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetBenefitBinDetailUseCase(BenefitManagerRepository benefitManagerRepository2, GetBenefitBinDetailFeatureFlagUseCase getBenefitBinDetailFeatureFlagUseCase2, CheckoutPaymentManagerRepository checkoutPaymentManagerRepository2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(benefitManagerRepository2, getBenefitBinDetailFeatureFlagUseCase2, checkoutPaymentManagerRepository2, (i11 & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
