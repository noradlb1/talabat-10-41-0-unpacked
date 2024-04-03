package tracking.gtm;

import datamodels.Restaurant;
import datamodels.TypesAliasesKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"NOT_SPONSORED", "", "SPONSORED_PREFIX", "clearSponsoringData", "", "Ldatamodels/Restaurant;", "itemVariant", "sponsoringData", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RestaurantsEventsKt {
    @NotNull
    public static final String NOT_SPONSORED = "false";
    @NotNull
    public static final String SPONSORED_PREFIX = "True: ";

    public static final void clearSponsoringData(@Nullable Restaurant restaurant) {
        if (restaurant != null) {
            restaurant.isSponsered = false;
        }
        if (restaurant != null) {
            restaurant.premiumType = null;
        }
    }

    @NotNull
    public static final String itemVariant(@Nullable Restaurant restaurant) {
        String sponsoringData = sponsoringData(restaurant);
        boolean z11 = false;
        if (restaurant != null && restaurant.isTStar) {
            z11 = true;
        }
        if (!z11) {
            return sponsoringData;
        }
        String str = restaurant.tStarLabel;
        if (str == null) {
            str = "";
        }
        return sponsoringData + TypesAliasesKt.separator + str;
    }

    @NotNull
    public static final String sponsoringData(@Nullable Restaurant restaurant) {
        Restaurant.PremiumType premiumType;
        boolean z11;
        boolean z12;
        if (!(restaurant == null || (premiumType = restaurant.premiumType) == null)) {
            String str = premiumType.type;
            boolean z13 = false;
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                String str2 = premiumType.category;
                if (str2 == null || str2.length() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    z13 = true;
                }
            }
            if (z13) {
                premiumType = null;
            }
            if (premiumType != null) {
                String str3 = "True: " + premiumType.category + "__" + premiumType.type;
                if (str3 != null) {
                    return str3;
                }
            }
        }
        return "false";
    }
}
