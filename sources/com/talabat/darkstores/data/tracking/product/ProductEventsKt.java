package com.talabat.darkstores.data.tracking.product;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\"\u001a\u00020\u0001H\u0002\u001a(\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u001c\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010+\u001a\u0004\u0018\u00010,H\u0002\u001a\u001a\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010/0.*\u000200H\u0002\u001a8\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00010\u00010.*\u0002022\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"ADD_TO_CART_CLICKED", "", "ADD_TO_CART_CLICKED_BRAZE", "CART_CLEARED_BRAZE", "CATEGORY", "CHAIN_ID", "CUISINE_NAMES", "DARKSTORES", "DEAL", "FB_CONTENT", "FB_CONTENT_ID", "FB_CONTENT_TYPE", "ITEM_CATEGORY", "ITEM_IDS", "KEY_AGE_VERIFICATION_REQUIRED", "KEY_CATEGORY_ID", "KEY_HAS_PROMOTION", "KEY_IS_FAVORITE", "KEY_NMR_AD_ID", "KEY_PRODUCT_DESCRIPTION", "KEY_PRODUCT_NAME", "KEY_PRODUCT_PRICE", "KEY_PRODUCT_SKU", "KEY_PRODUCT_UNIT_SALE_PRICE", "KEY_SHOP_SPONSORING", "NUMBER_OF_ITEMS", "OWN_DELIVERY", "PDP_EXTENDED_INFO_SHOWN", "PRODUCT_OPENED", "RATING_QUANTITY", "RATING_SCORE", "REMOVE_FROM_CART", "VENDOR_ID", "VENDOR_NAME", "getFBContentType", "getFbContent", "vendorId", "id", "quantity", "totalPrice", "hasPromotion", "", "offerText", "campaignTrigger", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "getTrackingData", "", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "Ldatamodels/Restaurant;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProductEventsKt {
    @NotNull
    private static final String ADD_TO_CART_CLICKED = "add_to_cart";
    @NotNull
    private static final String ADD_TO_CART_CLICKED_BRAZE = "app_add_to_basket";
    @NotNull
    private static final String CART_CLEARED_BRAZE = "app_clear_basket";
    @NotNull
    private static final String CATEGORY = "category";
    @NotNull
    private static final String CHAIN_ID = "chain_id";
    @NotNull
    private static final String CUISINE_NAMES = "cuisine_names";
    @NotNull
    private static final String DARKSTORES = "darkstores";
    @NotNull
    private static final String DEAL = "deal";
    @NotNull
    private static final String FB_CONTENT = "fb_content";
    @NotNull
    private static final String FB_CONTENT_ID = "fb_content_id";
    @NotNull
    private static final String FB_CONTENT_TYPE = "fb_content_type";
    @NotNull
    private static final String ITEM_CATEGORY = "item_category";
    @NotNull
    private static final String ITEM_IDS = "item_ids";
    @NotNull
    private static final String KEY_AGE_VERIFICATION_REQUIRED = "ageVerificationRequired";
    @NotNull
    private static final String KEY_CATEGORY_ID = "categoryId";
    @NotNull
    private static final String KEY_HAS_PROMOTION = "hasPromotion";
    @NotNull
    private static final String KEY_IS_FAVORITE = "isFavorite";
    @NotNull
    private static final String KEY_NMR_AD_ID = "nmrAdId";
    @NotNull
    private static final String KEY_PRODUCT_DESCRIPTION = "productDetails";
    @NotNull
    private static final String KEY_PRODUCT_NAME = "productName";
    @NotNull
    private static final String KEY_PRODUCT_PRICE = "productUnitPrice";
    @NotNull
    private static final String KEY_PRODUCT_SKU = "productSKU";
    @NotNull
    private static final String KEY_PRODUCT_UNIT_SALE_PRICE = "productUnitSalePrice";
    @NotNull
    private static final String KEY_SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    private static final String NUMBER_OF_ITEMS = "number_items";
    @NotNull
    private static final String OWN_DELIVERY = "own_delivery";
    @NotNull
    private static final String PDP_EXTENDED_INFO_SHOWN = "pdp_extended_info_shown";
    @NotNull
    private static final String PRODUCT_OPENED = "product_choice_opened";
    @NotNull
    private static final String RATING_QUANTITY = "rating_quantity";
    @NotNull
    private static final String RATING_SCORE = "rating_score";
    @NotNull
    private static final String REMOVE_FROM_CART = "remove_from_cart";
    @NotNull
    private static final String VENDOR_ID = "vendor_id";
    @NotNull
    private static final String VENDOR_NAME = "vendor_name";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Campaign.CampaignType.values().length];
            iArr[Campaign.CampaignType.Strikethrough.ordinal()] = 1;
            iArr[Campaign.CampaignType.SameItemBundle.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final String getFBContentType() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) "product");
        jSONArray.put((Object) "local_service_business");
        String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONArrayInstrumentation, "contentType.toString()");
        return jSONArrayInstrumentation;
    }

    private static final String getFbContent(String str, String str2, String str3, String str4) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) str);
        jSONObject.put(FirebaseAnalytics.Param.QUANTITY, 1);
        jSONArray.put((Object) jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", (Object) str2 + JavaConstant.Dynamic.DEFAULT_NAME + str);
        jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, (Object) str3);
        jSONObject2.put("item_price", (Object) str4);
        jSONArray.put((Object) jSONObject2);
        String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONArrayInstrumentation, "jsonFacebookContentArr.toString()");
        return jSONArrayInstrumentation;
    }

    /* access modifiers changed from: private */
    public static final Map<String, Object> getTrackingData(Product product) {
        String str;
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to(KEY_PRODUCT_SKU, product.getSku());
        pairArr[1] = TuplesKt.to("isFavorite", String.valueOf(product.isFavorite()));
        String categoryId = product.getCategoryId();
        pairArr[2] = TuplesKt.to("categoryId", "category," + categoryId);
        pairArr[3] = TuplesKt.to("shopSponsoring", product.isSponsored() ? "True:nmr_NA__NA" : "False:nmr_NA__NA");
        Tracking tracking2 = product.getTracking();
        if (tracking2 == null || (str = tracking2.getNmrAdId()) == null) {
            str = "NA";
        }
        pairArr[4] = TuplesKt.to("nmrAdId", str);
        pairArr[5] = TuplesKt.to("productName", product.getName());
        pairArr[6] = TuplesKt.to("productDetails", product.getDescription());
        Float previousPrice = product.getPreviousPrice();
        pairArr[7] = TuplesKt.to("productUnitPrice", Float.valueOf(previousPrice != null ? previousPrice.floatValue() : product.getPrice()));
        pairArr[8] = TuplesKt.to("productUnitSalePrice", Float.valueOf(product.getPrice()));
        pairArr[9] = TuplesKt.to("ageVerificationRequired", Integer.valueOf(product.getAgeLimit()));
        pairArr[10] = TuplesKt.to(KEY_HAS_PROMOTION, Boolean.valueOf(hasPromotion(product.getOfferText(), product.getCampaignTrigger())));
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean hasPromotion(java.lang.String r3, com.talabat.feature.darkstorescart.data.model.CampaignTrigger r4) {
        /*
            r0 = 0
            r1 = 1
            if (r3 == 0) goto L_0x0011
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x000c
            r3 = r1
            goto L_0x000d
        L_0x000c:
            r3 = r0
        L_0x000d:
            if (r3 != r1) goto L_0x0011
            r3 = r1
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x0016
        L_0x0014:
            r0 = r1
            goto L_0x0052
        L_0x0016:
            if (r4 == 0) goto L_0x0052
            com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r3 = r4.getCampaignType()
            int[] r2 = com.talabat.darkstores.data.tracking.product.ProductEventsKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r2[r3]
            if (r3 == r1) goto L_0x0048
            r2 = 2
            if (r3 == r2) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            com.talabat.feature.darkstorescart.data.model.Campaign$Type r3 = r4.getDiscountType()
            com.talabat.feature.darkstorescart.data.model.Campaign$Type r2 = com.talabat.feature.darkstorescart.data.model.Campaign.Type.PERCENTAGE
            if (r3 != r2) goto L_0x0052
            float r3 = r4.getDiscountValue()
            r2 = 1120403456(0x42c80000, float:100.0)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x003e
            r3 = r1
            goto L_0x003f
        L_0x003e:
            r3 = r0
        L_0x003f:
            if (r3 == 0) goto L_0x0052
            boolean r3 = r4.isAutoAddable()
            if (r3 == 0) goto L_0x0052
            goto L_0x0014
        L_0x0048:
            float r3 = r4.getDiscountValue()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0052
            goto L_0x0014
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.tracking.product.ProductEventsKt.hasPromotion(java.lang.String, com.talabat.feature.darkstorescart.data.model.CampaignTrigger):boolean");
    }

    /* access modifiers changed from: private */
    public static final Map<String, String> getTrackingData(Restaurant restaurant, String str, String str2, String str3) {
        Pair[] pairArr = new Pair[14];
        boolean z11 = false;
        pairArr[0] = TuplesKt.to("vendor_name", restaurant.getName());
        pairArr[1] = TuplesKt.to("vendor_id", String.valueOf(restaurant.branchId));
        pairArr[2] = TuplesKt.to("chain_id", String.valueOf(restaurant.getId()));
        if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
            z11 = true;
        }
        pairArr[3] = TuplesKt.to("deal", String.valueOf(z11));
        pairArr[4] = TuplesKt.to("rating_score", String.valueOf(restaurant.rating));
        pairArr[5] = TuplesKt.to("rating_quantity", restaurant.totalRating.toString());
        pairArr[6] = TuplesKt.to("cuisine_names", restaurant.getCuisinesJson());
        pairArr[7] = TuplesKt.to("own_delivery", String.valueOf(!restaurant.isTalabatGo));
        pairArr[8] = TuplesKt.to(ITEM_IDS, str + JavaConstant.Dynamic.DEFAULT_NAME + restaurant.branchId);
        pairArr[9] = TuplesKt.to(NUMBER_OF_ITEMS, str2);
        pairArr[10] = TuplesKt.to("item_category", String.valueOf(restaurant.branchId));
        pairArr[11] = TuplesKt.to("fb_content_id", String.valueOf(restaurant.branchId));
        pairArr[12] = TuplesKt.to("fb_content", getFbContent(String.valueOf(restaurant.branchId), str, str2, str3));
        pairArr[13] = TuplesKt.to("fb_content_type", getFBContentType());
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
