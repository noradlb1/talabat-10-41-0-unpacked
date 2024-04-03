package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import datamodels.Restaurant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016J\u0017\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000eJ\f\u0010\u000f\u001a\u00020\t*\u00020\u0003H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/ShopAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "restaurant", "Ldatamodels/Restaurant;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "(Ldatamodels/Restaurant;Ltracking/gtm/TalabatGTM$Companion;)V", "getAttributes", "", "", "", "getShopStatus", "statusType", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "getOfferType", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopAttributes implements TrackingAttributes {
    @Nullable
    private final Restaurant restaurant;
    @NotNull
    private final TalabatGTM.Companion talabatGTM;

    public ShopAttributes(@Nullable Restaurant restaurant2, @NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "talabatGTM");
        this.restaurant = restaurant2;
        this.talabatGTM = companion;
    }

    private final String getOfferType(Restaurant restaurant2) {
        ArrayList arrayList = new ArrayList();
        if (restaurant2.isDiscountAvaialble) {
            arrayList.add("discount");
        }
        if (restaurant2.isPromotionAvailable) {
            arrayList.add("promotion");
        }
        if (restaurant2.upsellId != 0) {
            String str = restaurant2.upsellName;
            Intrinsics.checkNotNullExpressionValue(str, "upsellName");
            arrayList.add(str);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String getShopStatus(Integer num) {
        if (num != null && num.intValue() == 0) {
            return "open";
        }
        if (num != null && num.intValue() == 1) {
            return "closed";
        }
        if (num != null && num.intValue() == 2) {
            return SDKCoreEvent.ForegroundStatus.VALUE_BUSY;
        }
        if (num != null && num.intValue() == 4) {
            return "prayer";
        }
        if (num != null && num.intValue() == 5) {
            return "pre-order";
        }
        return "N/A";
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0247  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> getAttributes() {
        /*
            r7 = this;
            r0 = 22
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            datamodels.Restaurant r1 = r7.restaurant
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r1 = r1.areaId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            java.lang.Number r1 = r7.or0(r1)
            java.lang.String r3 = "shopArea"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r3, r1)
            r3 = 0
            r0[r3] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = r1.getShopType()
            goto L_0x0028
        L_0x0027:
            r1 = r2
        L_0x0028:
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r4 = "shopCategorySelected"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r4, r1)
            r4 = 1
            r0[r4] = r1
            java.lang.String r1 = com.talabat.helpers.GlobalDataModel.ShopClickOrigin
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r5 = "shopClickOrigin"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 2
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x004f
            boolean r1 = r1.isUpSelling
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0050
        L_0x004f:
            r1 = r2
        L_0x0050:
            boolean r1 = r7.orFalse(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r5 = "shopCokeUpsell"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 3
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0074
            android.location.Location r1 = r1.getRestaurantLocation()
            if (r1 == 0) goto L_0x0074
            double r5 = r1.getLatitude()
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            goto L_0x0075
        L_0x0074:
            r1 = r2
        L_0x0075:
            java.lang.Number r1 = r7.or0(r1)
            datamodels.Restaurant r5 = r7.restaurant
            if (r5 == 0) goto L_0x008c
            android.location.Location r5 = r5.getRestaurantLocation()
            if (r5 == 0) goto L_0x008c
            double r5 = r5.getLongitude()
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            goto L_0x008d
        L_0x008c:
            r5 = r2
        L_0x008d:
            java.lang.Number r5 = r7.or0(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.String r1 = ","
            r6.append(r1)
            r6.append(r5)
            java.lang.String r1 = r6.toString()
            java.lang.String r5 = "shopCoordinates"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 4
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x00b9
            float r1 = r1.deliveryCharges
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x00ba
        L_0x00b9:
            r1 = r2
        L_0x00ba:
            java.lang.Number r1 = r7.or0(r1)
            java.lang.String r5 = "shopDeliveryFee"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 5
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = r1.deliveryTime
            goto L_0x00cf
        L_0x00ce:
            r1 = r2
        L_0x00cf:
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r5 = "shopDeliveryTime"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 6
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x00e7
            int r1 = r1.branchId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x00e8
        L_0x00e7:
            r1 = r2
        L_0x00e8:
            java.lang.Number r1 = r7.or0(r1)
            java.lang.String r5 = "shopId"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 7
            r0[r5] = r1
            tracking.gtm.TalabatGTM$Companion r1 = r7.talabatGTM
            datamodels.Restaurant r5 = r7.restaurant
            java.lang.String r1 = r1.listingType(r5)
            java.lang.String r5 = "shopListType"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 8
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x011a
            boolean r5 = r1.hasCusine()
            if (r5 == 0) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r1 = r2
        L_0x0113:
            if (r1 == 0) goto L_0x011a
            java.lang.String r1 = r1.GACuisineString()
            goto L_0x011b
        L_0x011a:
            r1 = r2
        L_0x011b:
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r5 = "shopMainCuisine"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 9
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0130
            java.lang.String r1 = r1.branchName
            goto L_0x0131
        L_0x0130:
            r1 = r2
        L_0x0131:
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r5 = "shopName"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 10
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = r7.getOfferType(r1)
            goto L_0x0149
        L_0x0148:
            r1 = r2
        L_0x0149:
            java.lang.String r1 = r7.orNA(r1)
            java.lang.String r5 = "shopOfferType"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 11
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0161
            int r1 = r1.statusType
            if (r1 != 0) goto L_0x0161
            r1 = r4
            goto L_0x0162
        L_0x0161:
            r1 = r3
        L_0x0162:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r5 = "shopOpen"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 12
            r0[r5] = r1
            tracking.gtm.TalabatGTM$Companion r1 = r7.talabatGTM
            datamodels.Restaurant r5 = r7.restaurant
            java.lang.String r1 = r1.getPaymentMethods(r5)
            java.lang.String r5 = "shopPaymentMethods"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 13
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x018d
            int r1 = r1.itemPosition
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x018e
        L_0x018d:
            r1 = r2
        L_0x018e:
            java.lang.Number r1 = r7.or0(r1)
            java.lang.String r5 = "shopPosition"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 14
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x01a7
            boolean r1 = r1.isRecommendation
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x01a8
        L_0x01a7:
            r1 = r2
        L_0x01a8:
            boolean r1 = r7.orFalse(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r5 = "shopRecommended"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 15
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x01c7
            float r1 = r1.getRating()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x01c8
        L_0x01c7:
            r1 = r2
        L_0x01c8:
            java.lang.Number r1 = r7.or0(r1)
            java.lang.String r5 = "shopRatingQuality"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 16
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x01e1
            boolean r1 = r1.isSponsered
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x01e2
        L_0x01e1:
            r1 = r2
        L_0x01e2:
            boolean r1 = r7.orFalse(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r5 = "shopSponsoring"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 17
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x01ff
            int r1 = r1.statusType
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0200
        L_0x01ff:
            r1 = r2
        L_0x0200:
            java.lang.String r1 = r7.getShopStatus(r1)
            java.lang.String r5 = "shopStatus"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 18
            r0[r5] = r1
            tracking.gtm.TalabatGTM$Companion r1 = r7.talabatGTM
            datamodels.Restaurant r5 = r7.restaurant
            java.lang.String r1 = r1.listingType(r5)
            java.lang.String r5 = "shopType"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 19
            r0[r5] = r1
            datamodels.CartMenuItem r1 = com.talabat.helpers.GlobalDataModel.SELECTED.cartMenuItem
            if (r1 == 0) goto L_0x0227
            java.lang.String r1 = r1.thumbnail
            goto L_0x0228
        L_0x0227:
            r1 = r2
        L_0x0228:
            if (r1 == 0) goto L_0x0233
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0231
            goto L_0x0233
        L_0x0231:
            r1 = r3
            goto L_0x0234
        L_0x0233:
            r1 = r4
        L_0x0234:
            r1 = r1 ^ r4
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r5 = "shopWithImages"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 20
            r0[r5] = r1
            datamodels.Restaurant r1 = r7.restaurant
            if (r1 == 0) goto L_0x0258
            boolean r2 = r1.isDiscountAvaialble
            if (r2 != 0) goto L_0x0253
            boolean r2 = r1.isPromotionAvailable
            if (r2 != 0) goto L_0x0253
            int r1 = r1.upsellId
            if (r1 == 0) goto L_0x0254
        L_0x0253:
            r3 = r4
        L_0x0254:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
        L_0x0258:
            boolean r1 = r7.orFalse(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = "shopWithOffer"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
            r2 = 21
            r0[r2] = r1
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.mapOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.data.tracking.events.attributes.ShopAttributes.getAttributes():java.util.Map");
    }

    @NotNull
    public Number or0(@Nullable Number number) {
        return TrackingAttributes.DefaultImpls.or0(this, number);
    }

    public boolean orFalse(@Nullable Boolean bool) {
        return TrackingAttributes.DefaultImpls.orFalse(this, bool);
    }

    @NotNull
    public String orNA(@Nullable String str) {
        return TrackingAttributes.DefaultImpls.orNA(this, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopAttributes(Restaurant restaurant2, TalabatGTM.Companion companion, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(restaurant2, (i11 & 2) != 0 ? TalabatGTM.Companion : companion);
    }
}
