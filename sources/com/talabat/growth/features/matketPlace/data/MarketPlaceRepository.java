package com.talabat.growth.features.matketPlace.data;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.MarketPlaceRedeemBurnOptionRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/growth/features/matketPlace/data/MarketPlaceRepository;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepository;", "getBurnOptionDetails", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "burnOptionItemId", "", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MarketPlaceRepository extends MarketPlaceRedeemBurnOptionRepository {
    @Nullable
    Object getBurnOptionDetails(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull Continuation<? super Either<? extends Failure, BurnItemDisplayModel>> continuation);
}
