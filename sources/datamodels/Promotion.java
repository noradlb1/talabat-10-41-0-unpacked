package datamodels;

import buisnessmodels.TalabatFormatter;

public class Promotion {
    public static final int ADDED_TO_CART = 2;
    public static final int ADD_MORE_ITEMS = 3;
    public static final int AVAILABLE = 1;
    public static final int HASPROMOTIONALITEM = 0;
    public boolean allowHotDeals;
    public BenefitItem[] benefitItems;
    public boolean bestOffer;
    public float conditionAmount;

    /* renamed from: id  reason: collision with root package name */
    public int f13866id;
    public boolean isAvailable;
    public boolean isBenefitListOfItems;
    public boolean isDefault;
    public boolean isSelected;
    public String marketingTitle;
    public String message;
    public BenefitItem selectedBenefitItem;

    public String getFormattedQualifyingAmount(float f11) {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.conditionAmount - f11);
    }

    public int getHintType() {
        if (this.isSelected) {
            return 2;
        }
        if (this.isAvailable) {
            return 1;
        }
        return 3;
    }
}
