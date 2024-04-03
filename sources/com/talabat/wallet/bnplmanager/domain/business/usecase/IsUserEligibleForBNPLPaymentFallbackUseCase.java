package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingExperimentsKeys;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/IsUserEligibleForBNPLPaymentFallbackUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "selectedPaymentMethod", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBnplPaymentFallbackExperimentEnabled", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserEligibleForBNPLPaymentFallbackUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag talabatFeatureFlag;

    public IsUserEligibleForBNPLPaymentFallbackUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public final boolean isBnplPaymentFallbackExperimentEnabled() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(OrderingExperimentsKeys.EXP_LENDING_BNPL_PAYMENT_FALLBACK, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    @Nullable
    public final Object invoke(int i11, @NotNull Continuation<? super BNPLPaymentFallbackEligibleStatus> continuation) {
        return BuildersKt.withContext(this.dispatcher, new IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2(this, i11, (Continuation<? super IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2>) null), continuation);
    }
}
