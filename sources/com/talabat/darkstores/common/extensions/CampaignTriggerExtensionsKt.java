package com.talabat.darkstores.common.extensions;

import android.content.res.Resources;
import com.talabat.darkstores.common.helpers.ProductCampaignTagHelper;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.localization.R;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"handleFreeItemCampaign", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "resources", "Landroid/content/res/Resources;", "isRtl", "", "handleStrikethroughCampaign", "toLabel", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CampaignTriggerExtensionsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Campaign.CampaignType.values().length];
            iArr[Campaign.CampaignType.SameItemBundle.ordinal()] = 1;
            iArr[Campaign.CampaignType.Strikethrough.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final String handleFreeItemCampaign(CampaignTrigger campaignTrigger, Resources resources, boolean z11) {
        boolean z12;
        if (campaignTrigger.getDiscountValue() <= 0.0f) {
            return "";
        }
        Campaign.Type discountType = campaignTrigger.getDiscountType();
        Campaign.Type type = Campaign.Type.PERCENTAGE;
        if (discountType == type) {
            if (campaignTrigger.getDiscountValue() == 100.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 && campaignTrigger.isAutoAddable()) {
                String string = resources.getString(R.string.ds_promo_tag_qty, new Object[]{Integer.valueOf(campaignTrigger.getTriggerQty()), Integer.valueOf(campaignTrigger.getBenefitQty())});
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …     benefitQty\n        )");
                return string;
            }
        }
        if (campaignTrigger.getDiscountType() != type || campaignTrigger.getDiscountValue() >= 100.0f) {
            return "";
        }
        String string2 = resources.getString(R.string.grocery_same_item_bundle_percentage_discount, new Object[]{String.valueOf(campaignTrigger.getTriggerQty()), NumberFormat.getPercentInstance(Locale.ENGLISH).format(Float.valueOf(((campaignTrigger.getDiscountValue() * ((float) campaignTrigger.getBenefitQty())) / ((float) campaignTrigger.getTriggerQty())) / ((float) 100)))});
        Intrinsics.checkNotNullExpressionValue(string2, "{\n        val discountPe…AGE_BASE)\n        )\n    }");
        return string2;
    }

    private static final String handleStrikethroughCampaign(CampaignTrigger campaignTrigger, Resources resources) {
        String str;
        if (campaignTrigger.getDiscountValue() > 0.0f) {
            str = resources.getString(R.string.product_details_saved, new Object[]{ProductCampaignTagHelper.INSTANCE.getDiscountValue(campaignTrigger)});
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (discountValue > 0) {…)\n        )\n    } else \"\"");
        return str;
    }

    @NotNull
    public static final String toLabel(@NotNull CampaignTrigger campaignTrigger, @NotNull Resources resources, boolean z11) {
        Intrinsics.checkNotNullParameter(campaignTrigger, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        int i11 = WhenMappings.$EnumSwitchMapping$0[campaignTrigger.getCampaignType().ordinal()];
        if (i11 == 1) {
            return handleFreeItemCampaign(campaignTrigger, resources, z11);
        }
        if (i11 != 2) {
            return "";
        }
        return handleStrikethroughCampaign(campaignTrigger, resources);
    }
}
