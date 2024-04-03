package tracking.gtm;

import buisnessmodels.Cart;
import datamodels.Restaurant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"getSurchargeValue", "", "toAnalyticString", "toItemCategory", "Ldatamodels/Restaurant;", "toOfferType", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatGTMKt {
    /* access modifiers changed from: private */
    public static final String getSurchargeValue() {
        float serviceFee = Cart.getInstance().getServiceFee();
        float smallOrderFee = Cart.getInstance().getSmallOrderFee();
        return "0:" + serviceFee + "; 1:" + smallOrderFee;
    }

    /* access modifiers changed from: private */
    public static final String toAnalyticString(String str) {
        return str == null || str.length() == 0 ? "N/A" : str;
    }

    /* access modifiers changed from: private */
    public static final String toItemCategory(Restaurant restaurant) {
        String str = restaurant.deliveryTimeInteger;
        float f11 = restaurant.deliveryCharges;
        String offerType = toOfferType(restaurant);
        float rating = restaurant.getRating();
        return str + "/" + f11 + "/" + offerType + "/" + rating;
    }

    private static final String toOfferType(Restaurant restaurant) {
        String str;
        boolean z11 = restaurant.isPromotionAvailable;
        if (restaurant.isDiscountAvaialble()) {
            str = "," + restaurant.discountDiscription;
        } else {
            str = "";
        }
        return "promotion_" + (z11 ? 1 : 0) + str;
    }
}
