package com.talabat.gem.adapters.data;

import JsonModels.Response.GEMResponse.GemOfferResponse;
import buisnessmodels.TalabatFormatter;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.entities.Rating;
import com.talabat.localization.R;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import datamodels.Cuisine;
import datamodels.Gem;
import datamodels.GemOfferItemsModel;
import datamodels.Restaurant;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002\u001a\u001c\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002\u001a\u001c\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u001c\u001a\n\u0010\u001d\u001a\u00020\u001e*\u00020\u001f\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\u0005H\u0002\u001a\u0012\u0010\"\u001a\u00020\u0019*\u00020\u00152\u0006\u0010#\u001a\u00020\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"PRICE_HIGH", "", "PRICE_LOW", "PRICE_MEDIUM", "RATING_AMAZING", "", "RATING_FAIR", "RATING_GOOD", "RATING_VERY_GOOD", "VERTICAL_GROCERY", "formatDecimal", "", "amount", "(Ljava/lang/Float;)Ljava/lang/Double;", "formatDeliveryCoast", "", "(Ljava/lang/Float;)Ljava/lang/String;", "isAvailableVendor", "", "pair", "Lkotlin/Pair;", "Ldatamodels/Restaurant;", "isFoodVendor", "it", "toGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "toGemOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "LJsonModels/Response/GEMResponse/GemOfferResponse;", "toGemTier", "Lcom/talabat/gem/domain/entities/GemTier;", "Ldatamodels/Gem;", "toRating", "Lcom/talabat/gem/domain/entities/Rating;", "withReservationCode", "reservationCode", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemMappersKt {
    private static final int PRICE_HIGH = 3;
    private static final int PRICE_LOW = 1;
    private static final int PRICE_MEDIUM = 2;
    private static final float RATING_AMAZING = 4.7f;
    private static final float RATING_FAIR = 1.0f;
    private static final float RATING_GOOD = 2.7f;
    private static final float RATING_VERY_GOOD = 3.7f;
    private static final int VERTICAL_GROCERY = 1;

    @Nullable
    public static final Double formatDecimal(@Nullable Float f11) {
        float f12;
        TalabatFormatter instance = TalabatFormatter.getInstance();
        if (f11 != null) {
            f12 = f11.floatValue();
        } else {
            f12 = 0.0f;
        }
        String formattedCurrency = instance.getFormattedCurrency(f12, false);
        if (TalabatFormatter.getInstance().shouldCommaDecimalPatternApply()) {
            try {
                Number parse = NumberFormat.getInstance(new Locale("en")).parse(formattedCurrency);
                if (parse != null) {
                    return Double.valueOf(parse.doubleValue());
                }
                return null;
            } catch (ParseException unused) {
                return null;
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(formattedCurrency, "this");
            return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(formattedCurrency);
        }
    }

    @NotNull
    public static final String formatDeliveryCoast(@Nullable Float f11) {
        boolean z11;
        float f12 = 0.0f;
        if (f11 == null) {
            z11 = true;
        } else {
            z11 = Intrinsics.areEqual(f11, 0.0f);
        }
        if (z11) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.free_delivery, (String) null, 1, (Object) null);
        }
        TalabatFormatter instance = TalabatFormatter.getInstance();
        if (f11 != null) {
            f12 = f11.floatValue();
        }
        String formattedCurrency = instance.getFormattedCurrency(f12, true);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance()\n          …rency(amount ?: 0f, true)");
        return formattedCurrency;
    }

    private static final boolean isAvailableVendor(Pair<? extends Restaurant, String> pair) {
        return ((Restaurant) pair.getFirst()).statusType == 0 || ((Restaurant) pair.getFirst()).statusType == 5;
    }

    private static final boolean isFoodVendor(Pair<? extends Restaurant, String> pair) {
        return ((Restaurant) pair.getFirst()).shopType != 1 && !((Restaurant) pair.getFirst()).isGlrEnabled && !((Restaurant) pair.getFirst()).isDarkStore;
    }

    @NotNull
    public static final GemOffer toGemOffer(@NotNull GemOfferResponse gemOfferResponse) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z11;
        Intrinsics.checkNotNullParameter(gemOfferResponse, "<this>");
        String str = gemOfferResponse.offerId;
        String str2 = gemOfferResponse.brandingMessage;
        String str3 = gemOfferResponse.collectionTitle;
        String str4 = gemOfferResponse.collectionSubtitle;
        Gem[] gemArr = gemOfferResponse.gemTiers;
        if (gemArr != null) {
            arrayList = new ArrayList(gemArr.length);
            for (Gem gem : gemArr) {
                Intrinsics.checkNotNullExpressionValue(gem, "it");
                arrayList.add(toGemTier(gem));
            }
        } else {
            arrayList = null;
        }
        long time = new Date().getTime() + ((long) gemOfferResponse.remDuration);
        GemOfferItemsModel[] gemOfferItemsDetails = gemOfferResponse.getGemOfferItemsDetails();
        if (gemOfferItemsDetails != null) {
            ArrayList<GemOfferItemsModel> arrayList3 = new ArrayList<>();
            for (GemOfferItemsModel gemOfferItemsModel : gemOfferItemsDetails) {
                if (gemOfferItemsModel.getRestaurant() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList3.add(gemOfferItemsModel);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (GemOfferItemsModel gemOfferItemsModel2 : arrayList3) {
                Restaurant restaurant = gemOfferItemsModel2.getRestaurant();
                Intrinsics.checkNotNull(restaurant);
                Pair pair = TuplesKt.to(restaurant, String.valueOf(gemOfferItemsModel2.reservationCode));
                if (pair != null) {
                    arrayList4.add(pair);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object next : arrayList4) {
                if (isFoodVendor((Pair) next)) {
                    arrayList5.add(next);
                }
            }
            ArrayList<Pair> arrayList6 = new ArrayList<>();
            for (Object next2 : arrayList5) {
                if (isAvailableVendor((Pair) next2)) {
                    arrayList6.add(next2);
                }
            }
            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10));
            for (Pair gemRestaurant : arrayList6) {
                arrayList2.add(toGemRestaurant(gemRestaurant));
            }
        } else {
            arrayList2 = null;
        }
        return new GemOffer(str, (Double) null, arrayList, arrayList2, Long.valueOf(time), str2, str3, str4, 2, (DefaultConstructorMarker) null);
    }

    private static final GemRestaurant toGemRestaurant(Pair<? extends Restaurant, String> pair) {
        return withReservationCode((Restaurant) pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final GemTier toGemTier(@NotNull Gem gem) {
        Intrinsics.checkNotNullParameter(gem, "<this>");
        String color = gem.getColor();
        return new GemTier(formatDecimal(Float.valueOf(gem.conditionAmount - gem.getDiscount())), formatDecimal(Float.valueOf(gem.conditionAmount)), TalabatFormatter.getInstance().getCurrencySymbol(), color, Float.valueOf(gem.getDiscount()));
    }

    private static final Rating toRating(float f11) {
        if (f11 >= 4.7f) {
            return Rating.AMAZING;
        }
        if (f11 >= 3.7f) {
            return Rating.VERY_GOOD;
        }
        if (f11 >= 2.7f) {
            return Rating.GOOD;
        }
        if (f11 >= 1.0f) {
            return Rating.OK;
        }
        return null;
    }

    @NotNull
    public static final GemRestaurant withReservationCode(@NotNull Restaurant restaurant, @NotNull String str) {
        int i11;
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant2, "<this>");
        Intrinsics.checkNotNullParameter(str, "reservationCode");
        int i12 = restaurant2.f13872id;
        int i13 = restaurant2.branchId;
        boolean z11 = restaurant2.isNewRestaurant;
        Double formatDecimal = formatDecimal(Float.valueOf(restaurant2.deliveryCharges));
        String str2 = restaurant2.deliveryTime;
        String str3 = restaurant2.deliveryTimeInteger;
        Intrinsics.checkNotNullExpressionValue(str3, "deliveryTimeInteger");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
        String str4 = restaurant2.f13873name;
        Cuisine[] cuisineArr = restaurant2.cuisines;
        Intrinsics.checkNotNullExpressionValue(cuisineArr, "cuisines");
        String joinToString$default = ArraysKt___ArraysKt.joinToString$default((Object[]) cuisineArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) GemMappersKt$withReservationCode$1.INSTANCE, 31, (Object) null);
        String logo = restaurant.getLogo();
        Rating rating = toRating(restaurant2.rating);
        float f11 = restaurant2.rating;
        try {
            String str5 = restaurant2.totalRatingNonformatted;
            Intrinsics.checkNotNullExpressionValue(str5, "totalRatingNonformatted");
            i11 = Integer.parseInt(str5);
        } catch (NumberFormatException unused) {
            i11 = 0;
        }
        Double formatDecimal2 = formatDecimal(Float.valueOf(restaurant2.minimumAmount));
        int i14 = restaurant2.shopType;
        float f12 = restaurant2.deliveryCharges;
        return new GemRestaurant(Integer.valueOf(i12), str4, logo, Boolean.valueOf(z11), joinToString$default, rating, Float.valueOf(f11), i11, str2, intOrNull, formatDecimal, str, restaurant, Integer.valueOf(i13), formatDecimal2, Integer.valueOf(i14), Float.valueOf(f12), formatDeliveryCoast(Float.valueOf(f12)));
    }
}
