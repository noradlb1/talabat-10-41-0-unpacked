package datamodels.mappers;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import datamodels.Coupon;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Ldatamodels/mappers/AutoApplyDiscountMapper;", "", "()V", "getBestMenuDiscountValue", "", "Ldatamodels/Coupon;", "autoApplyDiscounts", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "coupons", "cartTotal", "", "([Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;[Ldatamodels/Coupon;F)[Ldatamodels/Coupon;", "toCoupon", "Ldatamodels/mappers/AutoApplyDiscountCoupon;", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoApplyDiscountMapper {
    private final AutoApplyDiscountCoupon toCoupon(AutoApplyDiscount autoApplyDiscount) {
        AutoApplyDiscountCoupon autoApplyDiscountCoupon = new AutoApplyDiscountCoupon();
        autoApplyDiscountCoupon.isSelected = autoApplyDiscount.isSelected();
        autoApplyDiscountCoupon.isAvailable = autoApplyDiscount.isAvailable();
        autoApplyDiscountCoupon.discountPercentage = autoApplyDiscount.getDiscountPercentage();
        autoApplyDiscountCoupon.marketingTitle = autoApplyDiscount.getMarketingTitle();
        autoApplyDiscountCoupon.conditionAmount = autoApplyDiscount.getConditionAmount();
        autoApplyDiscountCoupon.discount = autoApplyDiscount.getDiscount();
        String discriminator = autoApplyDiscount.getDiscriminator();
        String str = "";
        if (discriminator == null) {
            discriminator = str;
        }
        autoApplyDiscountCoupon.aadDiscriminator = discriminator;
        String campaignId = autoApplyDiscount.getCampaignId();
        if (campaignId != null) {
            str = campaignId;
        }
        autoApplyDiscountCoupon.aadCampaignId = str;
        return autoApplyDiscountCoupon;
    }

    @Nullable
    public final Coupon[] getBestMenuDiscountValue(@Nullable AutoApplyDiscount[] autoApplyDiscountArr, @Nullable Coupon[] couponArr, float f11) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z11;
        boolean z12;
        if (couponArr != null) {
            arrayList = new ArrayList();
            for (Coupon coupon : couponArr) {
                if (coupon.conditionAmount <= f11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    arrayList.add(coupon);
                }
            }
        } else {
            arrayList = null;
        }
        if (autoApplyDiscountArr != null) {
            ArrayList<AutoApplyDiscount> arrayList3 = new ArrayList<>();
            for (AutoApplyDiscount autoApplyDiscount : autoApplyDiscountArr) {
                if (autoApplyDiscount.getConditionAmount() <= f11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList3.add(autoApplyDiscount);
                }
            }
            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
            for (AutoApplyDiscount coupon2 : arrayList3) {
                arrayList2.add(toCoupon(coupon2));
            }
        } else {
            arrayList2 = null;
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (arrayList != null) {
            arrayList4.addAll(arrayList);
        }
        if (arrayList4.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList4, new AutoApplyDiscountMapper$getBestMenuDiscountValue$lambda7$$inlined$sortByDescending$1());
        }
        Coupon coupon3 = (Coupon) CollectionsKt___CollectionsKt.firstOrNull(arrayList4);
        if (coupon3 == null) {
            return null;
        }
        return new Coupon[]{coupon3};
    }
}
