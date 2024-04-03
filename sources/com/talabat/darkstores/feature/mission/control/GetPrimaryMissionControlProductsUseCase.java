package com.talabat.darkstores.feature.mission.control;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import ij.h;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/mission/control/GetPrimaryMissionControlProductsUseCase;", "", "missionControlProductRepository", "Lcom/talabat/darkstores/data/mission/control/MissionControlProductRepository;", "applyDiscountsAndCampaigns", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "(Lcom/talabat/darkstores/data/mission/control/MissionControlProductRepository;Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "missionCode", "", "pageNumber", "", "filterCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPrimaryMissionControlProductsUseCase {
    @NotNull
    private final ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaigns;
    @NotNull
    private final MissionControlProductRepository missionControlProductRepository;

    @Inject
    public GetPrimaryMissionControlProductsUseCase(@NotNull MissionControlProductRepository missionControlProductRepository2, @NotNull ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        Intrinsics.checkNotNullParameter(missionControlProductRepository2, "missionControlProductRepository");
        Intrinsics.checkNotNullParameter(applyDiscountsAndCampaignsUseCase, "applyDiscountsAndCampaigns");
        this.missionControlProductRepository = missionControlProductRepository2;
        this.applyDiscountsAndCampaigns = applyDiscountsAndCampaignsUseCase;
    }

    @NotNull
    public final Single<MissionControlProducts> invoke(@NotNull String str, int i11, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "missionCode");
        Single<R> flatMap = this.missionControlProductRepository.getMissionControlProducts(str, i11, str2).flatMap(new h(this.applyDiscountsAndCampaigns));
        Intrinsics.checkNotNullExpressionValue(flatMap, "missionControlProductRep…untsAndCampaigns::invoke)");
        return flatMap;
    }
}
