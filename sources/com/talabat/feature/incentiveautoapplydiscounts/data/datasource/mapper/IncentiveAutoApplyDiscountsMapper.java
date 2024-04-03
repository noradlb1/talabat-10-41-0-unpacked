package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper;

import com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/mapper/IncentiveAutoApplyDiscountsMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountItemResponse;", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "()V", "apply", "source", "orFalse", "", "(Ljava/lang/Boolean;)Z", "orZero", "", "(Ljava/lang/Float;)F", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncentiveAutoApplyDiscountsMapper implements ModelMapper<AutoApplyDiscountItemResponse, AutoApplyDiscount> {
    private final boolean orFalse(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final float orZero(Float f11) {
        if (f11 != null) {
            return f11.floatValue();
        }
        return 0.0f;
    }

    @NotNull
    public AutoApplyDiscount apply(@NotNull AutoApplyDiscountItemResponse autoApplyDiscountItemResponse) {
        String str;
        Intrinsics.checkNotNullParameter(autoApplyDiscountItemResponse, "source");
        boolean orFalse = orFalse(autoApplyDiscountItemResponse.isSelected());
        boolean orFalse2 = orFalse(autoApplyDiscountItemResponse.isAvailable());
        float orZero = orZero(autoApplyDiscountItemResponse.getDiscountPercentage());
        boolean orFalse3 = orFalse(autoApplyDiscountItemResponse.getEnforceMinOrderAmount());
        String campaignId = autoApplyDiscountItemResponse.getCampaignId();
        String str2 = campaignId == null ? "" : campaignId;
        float orZero2 = orZero(autoApplyDiscountItemResponse.getDiscount());
        float orZero3 = orZero(autoApplyDiscountItemResponse.getConditionAmount());
        String discriminator = autoApplyDiscountItemResponse.getDiscriminator();
        if (discriminator == null) {
            str = "";
        } else {
            str = discriminator;
        }
        String marketingTitle = autoApplyDiscountItemResponse.getMarketingTitle();
        if (marketingTitle == null) {
            marketingTitle = "";
        }
        return new AutoApplyDiscount(orFalse, orFalse2, orZero, orFalse3, str2, orZero2, orZero3, str, marketingTitle);
    }
}
