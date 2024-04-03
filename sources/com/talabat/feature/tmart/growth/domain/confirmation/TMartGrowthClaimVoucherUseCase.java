package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/confirmation/TMartGrowthClaimVoucherUseCase;", "", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "(Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;)V", "claim", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshVoucher", "", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimVoucherUseCase {
    @NotNull
    private final ITMartGrowthRepository repository;

    @Inject
    public TMartGrowthClaimVoucherUseCase(@NotNull ITMartGrowthRepository iTMartGrowthRepository) {
        Intrinsics.checkNotNullParameter(iTMartGrowthRepository, "repository");
        this.repository = iTMartGrowthRepository;
    }

    @Nullable
    public final Object claim(@NotNull Continuation<? super TMartGrowthClaimConfirmation> continuation) {
        return this.repository.claimVoucher(continuation);
    }

    public final void refreshVoucher() {
        this.repository.refreshVoucher();
    }
}
