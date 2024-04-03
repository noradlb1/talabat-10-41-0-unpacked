package com.talabat.growth.ui.loyalty.burn.burnOptions;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptions/LoyaltyBurnOptionsCardWidthHelper;", "", "()V", "getCardWidth", "", "viewMode", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;", "size", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyBurnOptionsCardWidthHelper {
    @NotNull
    public static final LoyaltyBurnOptionsCardWidthHelper INSTANCE = new LoyaltyBurnOptionsCardWidthHelper();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BurnItemCategoryViewType.values().length];
            iArr[BurnItemCategoryViewType.SWIM_LANE_HALF_WIDTH_CARDS.ordinal()] = 1;
            iArr[BurnItemCategoryViewType.SWIM_LANE_FULL_WIDTH_CARDS.ordinal()] = 2;
            iArr[BurnItemCategoryViewType.HERO_CARD.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LoyaltyBurnOptionsCardWidthHelper() {
    }

    public final float getCardWidth(@NotNull BurnItemCategoryViewType burnItemCategoryViewType, int i11) {
        Intrinsics.checkNotNullParameter(burnItemCategoryViewType, "viewMode");
        int i12 = WhenMappings.$EnumSwitchMapping$0[burnItemCategoryViewType.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 == 3) {
                    return 1.0f;
                }
                throw new NoWhenBranchMatchedException();
            } else if (i11 == 1) {
                return 1.0f;
            } else {
                return 0.86f;
            }
        } else if (i11 <= 2) {
            return 0.48f;
        } else {
            return 0.43f;
        }
    }
}
