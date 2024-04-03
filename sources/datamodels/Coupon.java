package datamodels;

import buisnessmodels.TalabatFormatter;

public class Coupon {
    public static final int ADDED_TO_CART = 2;
    public static final int ADD_MORE_ITEMS = 3;
    public static final int AVAILABLE = 1;
    public static final int COUPON_PRESLECTED = 5;
    public static final int ENFORCEMINIMUMORDER = 4;
    public static final int HASNONCOMBINATIONALITEM = 0;
    public boolean allowHotDeals;
    public float benefitDiscountAmount;
    public float benefitMaxOrderDiscount;
    private int benefitType;
    public boolean bestCoupon;
    public boolean bestOffer;
    public float conditionAmount;
    private String description;
    public float discount;
    public float discountPercentage;
    public float eca;
    public boolean enforceMinOrderAmt;
    public boolean forceDisable;

    /* renamed from: id  reason: collision with root package name */
    public int f13847id;
    public boolean isAvailable;
    public boolean isDefault;
    public boolean isSelected;
    public String marketingTitle;
    private String message;

    public String getFormattedQualifyingAmount(float f11) {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.conditionAmount - f11);
    }

    public int getHintType(boolean z11, boolean z12) {
        if (z11) {
            return 0;
        }
        if (this.enforceMinOrderAmt && !this.isAvailable) {
            return 4;
        }
        if (this.isSelected) {
            return 2;
        }
        if (!this.isAvailable) {
            return 3;
        }
        if (z12) {
            return 5;
        }
        return 1;
    }

    public String logValues() {
        return this.f13847id + "," + this.marketingTitle + "," + this.discount;
    }
}
