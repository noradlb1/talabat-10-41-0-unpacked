package com.talabat.darkstores.common.helpers;

import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/common/helpers/ProductCampaignTagHelper;", "", "()V", "getDiscountValue", "", "trigger", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductCampaignTagHelper {
    @NotNull
    public static final ProductCampaignTagHelper INSTANCE = new ProductCampaignTagHelper();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Campaign.Type.values().length];
            iArr[Campaign.Type.PERCENTAGE.ordinal()] = 1;
            iArr[Campaign.Type.ABSOLUTE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ProductCampaignTagHelper() {
    }

    @NotNull
    public final String getDiscountValue(@NotNull CampaignTrigger campaignTrigger) {
        Intrinsics.checkNotNullParameter(campaignTrigger, "trigger");
        if (campaignTrigger.getDiscountValue() <= 0.0f) {
            return "";
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[campaignTrigger.getDiscountType().ordinal()];
        if (i11 == 1) {
            String format = NumberFormat.getPercentInstance().format(Float.valueOf(campaignTrigger.getDiscountValue() / ((float) 100)));
            Intrinsics.checkNotNullExpressionValue(format, "getPercentInstance()\n   …tValue / PERCENTAGE_BASE)");
            return format;
        } else if (i11 == 2) {
            return FloatExtensionsKt.formatCurrency(campaignTrigger.getDiscountValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
