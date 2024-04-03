package com.talabat.darkstores.feature.product.usecase;

import com.talabat.darkstores.data.swimlanes.SwimlanesProductRepository;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import ij.h;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/product/usecase/GetSwimlaneProductUseCase;", "", "swimlanesProductRepository", "Lcom/talabat/darkstores/data/swimlanes/SwimlanesProductRepository;", "applyDiscountsAndCampaigns", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "(Lcom/talabat/darkstores/data/swimlanes/SwimlanesProductRepository;Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "swimlaneId", "", "productId", "productSku", "pageNumber", "", "filterCategoryId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSwimlaneProductUseCase {
    @NotNull
    private final ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaigns;
    @NotNull
    private final SwimlanesProductRepository swimlanesProductRepository;

    @Inject
    public GetSwimlaneProductUseCase(@NotNull SwimlanesProductRepository swimlanesProductRepository2, @NotNull ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        Intrinsics.checkNotNullParameter(swimlanesProductRepository2, "swimlanesProductRepository");
        Intrinsics.checkNotNullParameter(applyDiscountsAndCampaignsUseCase, "applyDiscountsAndCampaigns");
        this.swimlanesProductRepository = swimlanesProductRepository2;
        this.applyDiscountsAndCampaigns = applyDiscountsAndCampaignsUseCase;
    }

    @NotNull
    public final Single<MissionControlProducts> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(str3, "productSku");
        Single<R> flatMap = this.swimlanesProductRepository.getSwimlaneProducts(str, str2, str3, i11, str4).flatMap(new h(this.applyDiscountsAndCampaigns));
        Intrinsics.checkNotNullExpressionValue(flatMap, "swimlanesProductReposito…untsAndCampaigns::invoke)");
        return flatMap;
    }
}
