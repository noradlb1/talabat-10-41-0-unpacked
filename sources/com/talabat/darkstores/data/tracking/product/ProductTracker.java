package com.talabat.darkstores.data.tracking.product;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.tracking.BaseTrackerKt;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;
import tracking.deeplink.DeepLinkParser;
import tracking.deeplink.DeepLinkResult;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\nJ\u0001\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002J,\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u0011JX\u0010+\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010,\u001a\u00020)2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u000101J}\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020\u0011*\u0004\u0018\u00010\u0011H\u0002J\u0018\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010 *\u000206H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "addToCartClicked", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "", "listPosition", "screenName", "", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "shelfViewTitle", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneRequestId", "swimlaneStrategy", "cartId", "searchRequestId", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Ljava/lang/String;Lcom/talabat/darkstores/feature/tracking/EventOriginType;Ljava/lang/String;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cartCleared", "getAdditionalParams", "", "restaurant", "Ldatamodels/Restaurant;", "count", "(Ldatamodels/Restaurant;Ljava/lang/String;Lcom/talabat/darkstores/feature/tracking/EventOriginType;Ljava/lang/String;ILjava/lang/Integer;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "getCurrentTime", "getProductCount", "productExtendInfoShown", "isProductExtendedInfo", "", "extendedInfo", "productOpened", "isFavorite", "deeplinkUri", "eventOrigin", "searchTerm", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "removeFromCartClicked", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Ljava/lang/String;Lcom/talabat/darkstores/feature/tracking/EventOriginType;Ljava/lang/String;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "orDefault", "toMap", "Landroid/os/Bundle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTracker {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public ProductTracker(@NotNull TalabatTracker talabatTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2, @NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.talabatTracker = talabatTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
        this.configurationParameters = configurationParameters2;
    }

    public static /* synthetic */ void addToCartClicked$default(ProductTracker productTracker, Product product, int i11, Integer num, String str, EventOriginType eventOriginType, String str2, SwimlaneTrackingData swimlaneTrackingData, TrackingCategoryId trackingCategoryId, String str3, String str4, String str5, String str6, int i12, Object obj) {
        String str7;
        SwimlaneTrackingData swimlaneTrackingData2;
        TrackingCategoryId trackingCategoryId2;
        String str8;
        String str9;
        String str10;
        String str11;
        int i13 = i12;
        if ((i13 & 32) != 0) {
            str7 = "";
        } else {
            str7 = str2;
        }
        if ((i13 & 64) != 0) {
            swimlaneTrackingData2 = null;
        } else {
            swimlaneTrackingData2 = swimlaneTrackingData;
        }
        if ((i13 & 128) != 0) {
            trackingCategoryId2 = null;
        } else {
            trackingCategoryId2 = trackingCategoryId;
        }
        if ((i13 & 256) != 0) {
            str8 = null;
        } else {
            str8 = str3;
        }
        if ((i13 & 512) != 0) {
            str9 = null;
        } else {
            str9 = str4;
        }
        if ((i13 & 1024) != 0) {
            str10 = null;
        } else {
            str10 = str5;
        }
        if ((i13 & 2048) != 0) {
            str11 = null;
        } else {
            str11 = str6;
        }
        productTracker.addToCartClicked(product, i11, num, str, eventOriginType, str7, swimlaneTrackingData2, trackingCategoryId2, str8, str9, str10, str11);
    }

    private final Map<String, Object> getAdditionalParams(Restaurant restaurant, String str, EventOriginType eventOriginType, String str2, int i11, Integer num, SwimlaneTrackingData swimlaneTrackingData, TrackingCategoryId trackingCategoryId, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8;
        Integer swimlaneLength;
        String swimlaneTitle;
        Pair[] pairArr = new Pair[16];
        boolean z11 = false;
        pairArr[0] = TuplesKt.to("screenName", orDefault(str));
        pairArr[1] = TuplesKt.to("eventOrigin", eventOriginType.getTrackingName());
        pairArr[2] = TuplesKt.to("shopFilteringSelected", str2);
        pairArr[3] = TuplesKt.to("userTimeStamp", getCurrentTime());
        pairArr[4] = TuplesKt.to("currencyCode", TalabatAdjust.getSelectedCurrencyCode());
        pairArr[5] = TuplesKt.to("productMandatoryChoicePreselected", "false");
        pairArr[6] = TuplesKt.to("productMandatoryChoiceQuantity", "0");
        pairArr[7] = TuplesKt.to("productOptionalChoiceQuantity", "0");
        pairArr[8] = TuplesKt.to(ProductTrackingProvider.QUANTITY, Integer.valueOf(i11));
        String str9 = null;
        pairArr[9] = TuplesKt.to("productIndex", BaseTrackerKt.orDefault$default(num, (String) null, 1, (Object) null));
        pairArr[10] = TuplesKt.to("listingPageType", "darkstores");
        if (restaurant != null) {
            str6 = restaurant.getRestaurantType();
        } else {
            str6 = null;
        }
        pairArr[11] = TuplesKt.to("deliveryProvider", orDefault(str6));
        if (restaurant != null) {
            str7 = restaurant.getPaymentMethods();
        } else {
            str7 = null;
        }
        pairArr[12] = TuplesKt.to("shopPaymentMethods", orDefault(str7));
        pairArr[13] = TuplesKt.to("shopClickOrigin", orDefault(GlobalDataModel.ShopClickOrigin));
        if (trackingCategoryId != null) {
            str8 = trackingCategoryId.getTrackingName();
        } else {
            str8 = null;
        }
        pairArr[14] = TuplesKt.to("categoryId", orDefault(str8));
        pairArr[15] = TuplesKt.to("searchRequestId", orDefault(str5));
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (!(swimlaneTrackingData == null || (swimlaneTitle = swimlaneTrackingData.getSwimlaneTitle()) == null)) {
            if (swimlaneTitle.length() > 0) {
                z11 = true;
            }
            if (z11) {
                str9 = swimlaneTitle;
            }
            if (str9 != null) {
                mutableMapOf.put("swimlaneTitle", str9);
            }
        }
        if (!(swimlaneTrackingData == null || (swimlaneLength = swimlaneTrackingData.getSwimlaneLength()) == null)) {
            mutableMapOf.put("swimlaneLength", Integer.valueOf(swimlaneLength.intValue()));
        }
        if (str3 != null) {
            mutableMapOf.put("swimlaneRequestId", str3);
        }
        if (str4 != null) {
            mutableMapOf.put("swimlaneStrategy", str4);
        }
        return MapsKt__MapsKt.toMap(mutableMapOf);
    }

    private final String getCurrentTime() {
        if (Build.VERSION.SDK_INT >= 26) {
            String format = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z", Locale.ENGLISH));
            Intrinsics.checkNotNullExpressionValue(format, "{\n            val format…rmat(formatter)\n        }");
            return format;
        }
        String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z", Locale.ENGLISH).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format2, "{\n            val format….format(Date())\n        }");
        return format2;
    }

    private final int getProductCount(int i11) {
        if (i11 > 0) {
            return i11;
        }
        return 1;
    }

    private final String orDefault(String str) {
        if (!(true ^ (str == null || str.length() == 0))) {
            str = null;
        }
        return str == null ? "N/A" : str;
    }

    public static /* synthetic */ void productExtendInfoShown$default(ProductTracker productTracker, Product product, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            str2 = "";
        }
        productTracker.productExtendInfoShown(product, str, z11, str2);
    }

    public static /* synthetic */ void removeFromCartClicked$default(ProductTracker productTracker, Product product, int i11, Integer num, String str, EventOriginType eventOriginType, String str2, SwimlaneTrackingData swimlaneTrackingData, TrackingCategoryId trackingCategoryId, String str3, String str4, String str5, int i12, Object obj) {
        String str6;
        SwimlaneTrackingData swimlaneTrackingData2;
        TrackingCategoryId trackingCategoryId2;
        String str7;
        String str8;
        String str9;
        int i13 = i12;
        if ((i13 & 32) != 0) {
            str6 = "";
        } else {
            str6 = str2;
        }
        if ((i13 & 64) != 0) {
            swimlaneTrackingData2 = null;
        } else {
            swimlaneTrackingData2 = swimlaneTrackingData;
        }
        if ((i13 & 128) != 0) {
            trackingCategoryId2 = null;
        } else {
            trackingCategoryId2 = trackingCategoryId;
        }
        if ((i13 & 256) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i13 & 512) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i13 & 1024) != 0) {
            str9 = null;
        } else {
            str9 = str5;
        }
        productTracker.removeFromCartClicked(product, i11, num, str, eventOriginType, str6, swimlaneTrackingData2, trackingCategoryId2, str7, str8, str9);
    }

    private final Map<String, Object> toMap(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void addToCartClicked(@NotNull Product product, int i11, @Nullable Integer num, @Nullable String str, @NotNull EventOriginType eventOriginType, @NotNull String str2, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable TrackingCategoryId trackingCategoryId, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product2, "product");
        EventOriginType eventOriginType2 = eventOriginType;
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "shelfViewTitle");
        this.talabatTracker.track(new AddToCartClickedEvent(product2, toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), getAdditionalParams(this.configurationParameters.getRestaurant(), str, eventOriginType2, str7, getProductCount(i11), num, swimlaneTrackingData, trackingCategoryId, str3, str4, str6)));
        this.talabatTracker.track(new AddToCartClickedEventBraze(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("cart_id", orDefault(str5)))));
        int productCount = getProductCount(i11);
        Restaurant restaurant = this.configurationParameters.getRestaurant();
        if (restaurant.isTMart()) {
            this.talabatTracker.track(new AddToCartClickedEventAdjust(VendorType.TMART, restaurant, product2, productCount));
        } else {
            this.talabatTracker.track(new AddToCartClickedEventAdjust(VendorType.NFV, restaurant, product2, productCount));
        }
        this.talabatTracker.track(new AddToCartClickedEventAdjust(VendorType.RESTAURANT, restaurant, product2, productCount));
    }

    public final void cartCleared() {
        this.talabatTracker.track(new CartClearedEventBraze());
    }

    public final void productExtendInfoShown(@NotNull Product product, @Nullable String str, boolean z11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(str2, "extendedInfo");
        this.talabatTracker.track(new ProductExtendedInfoShownEvent(product, toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenName", orDefault(str)), TuplesKt.to("isExtendedPdp", Boolean.valueOf(z11)), TuplesKt.to("extendedInfoList", str2))));
    }

    public final void productOpened(@NotNull Product product, boolean z11, @Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(str2, "deeplinkUri");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        boolean z12 = false;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ProductTrackingProvider.FAVOURITE, String.valueOf(z11)), TuplesKt.to("screenName", orDefault(str)), TuplesKt.to("eventOrigin", orDefault(str3)), TuplesKt.to("searchRequestId", orDefault(str5)), TuplesKt.to("searchTerm", orDefault(str6)));
        if (str2.length() > 0) {
            z12 = true;
        }
        if (z12) {
            DeepLinkResult parse = DeepLinkParser.parse(Uri.parse(str2).getQuery());
            mutableMapOf.put("source", orDefault(parse.source));
            mutableMapOf.put("campaign", orDefault(parse.campaign));
            mutableMapOf.put("medium", orDefault(parse.medium));
            mutableMapOf.put("gclid", orDefault(parse.getGclId()));
            mutableMapOf.put("deeplink", str2);
        }
        if (productClickTrackingAttribute != null) {
            mutableMapOf.put("shopSponsoringPlacement", productClickTrackingAttribute.getShopSponsoringPlacement());
            String swimlaneStrategy = productClickTrackingAttribute.getSwimlaneStrategy();
            if (swimlaneStrategy != null) {
                mutableMapOf.put("swimlaneStrategy", swimlaneStrategy);
            }
            mutableMapOf.put("swimlaneTitle", productClickTrackingAttribute.getSwimlaneTitle());
            mutableMapOf.put("swimlaneLength", String.valueOf(productClickTrackingAttribute.getSwimlaneLength()));
        }
        if (str4 != null) {
            mutableMapOf.put("swimlaneRequestId", str4);
        }
        this.talabatTracker.track(new ProductOpenedEvent(product, toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), mutableMapOf));
    }

    public final void removeFromCartClicked(@NotNull Product product, int i11, @Nullable Integer num, @Nullable String str, @NotNull EventOriginType eventOriginType, @NotNull String str2, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable TrackingCategoryId trackingCategoryId, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product2, "product");
        EventOriginType eventOriginType2 = eventOriginType;
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "shelfViewTitle");
        this.talabatTracker.track(new RemoveFromCartClickedEvent(product2, toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), getAdditionalParams(this.configurationParameters.getRestaurant(), str, eventOriginType2, str6, getProductCount(i11), num, swimlaneTrackingData, trackingCategoryId, str3, str5, str4)));
    }
}
