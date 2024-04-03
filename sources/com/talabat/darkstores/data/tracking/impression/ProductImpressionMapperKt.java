package com.talabat.darkstores.data.tracking.impression;

import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.impressiontracking.items.TrackableImpressionItem;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a.\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"CATEGORY", "", "FEATURE_NAME", "KEY_CATEGORY_ID", "KEY_EVENT_NAME", "KEY_EVENT_ORIGIN", "KEY_FEATURE_NAME", "KEY_IMPRESSION_LIST_NAME", "KEY_NMR_AD_ID", "KEY_PRODUCT_INDEX", "KEY_PRODUCT_NAME", "KEY_PRODUCT_SKU", "KEY_SCREEN_NAME", "KEY_SCREEN_TYPE", "KEY_SEARCH_REQUEST_ID", "KEY_SEARCH_TERM", "KEY_SHOP_SPONSORING", "PRODUCT_IMPRESSION_EVENT_NAME", "toImpressionItem", "Lcom/talabat/impressiontracking/items/TrackableImpressionItem;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "index", "", "trackingName", "additionalAttributes", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProductImpressionMapperKt {
    @NotNull
    private static final String CATEGORY = "category";
    @NotNull
    private static final String FEATURE_NAME = "darkstores";
    @NotNull
    private static final String KEY_CATEGORY_ID = "categoryId";
    @NotNull
    private static final String KEY_EVENT_NAME = "eventName";
    @NotNull
    private static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String KEY_FEATURE_NAME = "featureName";
    @NotNull
    public static final String KEY_IMPRESSION_LIST_NAME = "impressionListName";
    @NotNull
    private static final String KEY_NMR_AD_ID = "nmrAdId";
    @NotNull
    private static final String KEY_PRODUCT_INDEX = "productIndex";
    @NotNull
    private static final String KEY_PRODUCT_NAME = "productName";
    @NotNull
    private static final String KEY_PRODUCT_SKU = "productSKU";
    @NotNull
    public static final String KEY_SCREEN_NAME = "screenName";
    @NotNull
    public static final String KEY_SCREEN_TYPE = "screenType";
    @NotNull
    public static final String KEY_SEARCH_REQUEST_ID = "searchRequestId";
    @NotNull
    public static final String KEY_SEARCH_TERM = "searchTerm";
    @NotNull
    private static final String KEY_SHOP_SPONSORING = "shopSponsoring";
    @NotNull
    private static final String PRODUCT_IMPRESSION_EVENT_NAME = "product_impressions_loaded";

    @NotNull
    public static final TrackableImpressionItem toImpressionItem(@NotNull Product product, int i11, @NotNull String str, @NotNull Map<String, String> map) {
        boolean z11;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(str, "trackingName");
        Intrinsics.checkNotNullParameter(map, "additionalAttributes");
        String valueOf = String.valueOf(product.isSponsored());
        if (valueOf.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            char charAt = valueOf.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                str3 = CharsKt__CharJVMKt.titlecase(charAt, locale);
            } else {
                str3 = String.valueOf(charAt);
            }
            sb2.append(str3);
            String substring = valueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb2.append(substring);
            valueOf = sb2.toString();
        }
        String id2 = product.getId();
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("eventName", PRODUCT_IMPRESSION_EVENT_NAME);
        pairArr[1] = TuplesKt.to("featureName", "darkstores");
        pairArr[2] = TuplesKt.to(KEY_PRODUCT_SKU, product.getSku());
        pairArr[3] = TuplesKt.to("productName", product.getName());
        pairArr[4] = TuplesKt.to("categoryId", "category," + product.getCategoryId());
        pairArr[5] = TuplesKt.to("productIndex", String.valueOf(i11));
        Tracking tracking2 = product.getTracking();
        if (tracking2 == null || (str2 = tracking2.getNmrAdId()) == null) {
            str2 = "NA";
        }
        pairArr[6] = TuplesKt.to("nmrAdId", str2);
        pairArr[7] = TuplesKt.to("eventOrigin", "nmr_" + str);
        pairArr[8] = TuplesKt.to("shopSponsoring", valueOf + ":nmr_NA__NA");
        return new TrackableImpressionItem(id2, MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pairArr), (Map) map));
    }
}
