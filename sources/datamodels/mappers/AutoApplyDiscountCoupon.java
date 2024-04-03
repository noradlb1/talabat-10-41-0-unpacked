package datamodels.mappers;

import datamodels.Coupon;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ldatamodels/mappers/AutoApplyDiscountCoupon;", "Ldatamodels/Coupon;", "()V", "aadCampaignId", "", "aadDiscriminator", "logValues", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoApplyDiscountCoupon extends Coupon {
    @NotNull
    @JvmField
    public String aadCampaignId = "";
    @NotNull
    @JvmField
    public String aadDiscriminator = "";

    @NotNull
    public String logValues() {
        String str = this.aadCampaignId;
        String str2 = this.marketingTitle;
        float f11 = this.discount;
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + f11;
    }
}
