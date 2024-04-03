package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.talabat.darkstores.data.ConfigurationParameters;
import datamodels.Restaurant;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "storeInfo", "Ldatamodels/Restaurant;", "storeInfoParams", "Landroid/os/Bundle;", "getStoreInfoParams", "()Landroid/os/Bundle;", "getTrackingShopType", "", "Companion", "StoreStatus", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StoreInfoTrackingProvider {
    @NotNull
    @Deprecated
    public static final String CHAIN_ID = "chainId";
    @NotNull
    @Deprecated
    public static final String CHAIN_NAME = "chainName";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String SHOP_AREA = "shopArea";
    @NotNull
    @Deprecated
    public static final String SHOP_CUISINE = "shopMainCuisine";
    @NotNull
    @Deprecated
    public static final String SHOP_DELIVERY_FEE = "shopDeliveryFee";
    @NotNull
    @Deprecated
    public static final String SHOP_ID = "shopId";
    @NotNull
    @Deprecated
    public static final String SHOP_NAME = "shopName";
    @NotNull
    @Deprecated
    public static final String SHOP_STATUS = "shopStatus";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE = "shopType";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_COSMETIC = "cosmetic";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_DARKSTORE = "darkstores";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_ELECTRONICS = "electronics";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_FLOWERS = "flowers";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_GROCERY = "groceries";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_PET_SHOP = "petShop";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_PHARMACY = "pharmacy";
    @NotNull
    @Deprecated
    public static final String SHOP_TYPE_RESTAURANT = "restaurants";
    @NotNull
    private final Restaurant storeInfo;
    @NotNull
    private final Bundle storeInfoParams;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider$Companion;", "", "()V", "CHAIN_ID", "", "CHAIN_NAME", "SHOP_AREA", "SHOP_CUISINE", "SHOP_DELIVERY_FEE", "SHOP_ID", "SHOP_NAME", "SHOP_STATUS", "SHOP_TYPE", "SHOP_TYPE_COSMETIC", "SHOP_TYPE_DARKSTORE", "SHOP_TYPE_ELECTRONICS", "SHOP_TYPE_FLOWERS", "SHOP_TYPE_GROCERY", "SHOP_TYPE_PET_SHOP", "SHOP_TYPE_PHARMACY", "SHOP_TYPE_RESTAURANT", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider$StoreStatus;", "", "status", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "OPEN", "CLOSED", "BUSY", "PRAYER", "PREORDER", "OTHER", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum StoreStatus {
        OPEN("open"),
        CLOSED("closed"),
        BUSY(SDKCoreEvent.ForegroundStatus.VALUE_BUSY),
        PRAYER("prayer"),
        PREORDER("pre-order"),
        OTHER("N/A");
        
        @NotNull
        public static final Companion Companion = null;
        @NotNull
        private final String status;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider$StoreStatus$Companion;", "", "()V", "fromType", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider$StoreStatus;", "statusType", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final StoreStatus fromType(int i11) {
                if (i11 == 0) {
                    return StoreStatus.OPEN;
                }
                if (i11 == 1) {
                    return StoreStatus.CLOSED;
                }
                if (i11 == 2) {
                    return StoreStatus.BUSY;
                }
                if (i11 == 4) {
                    return StoreStatus.PRAYER;
                }
                if (i11 != 5) {
                    return StoreStatus.OTHER;
                }
                return StoreStatus.PREORDER;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        private StoreStatus(String str) {
            this.status = str;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }
    }

    @Inject
    public StoreInfoTrackingProvider(@NotNull ConfigurationParameters configurationParameters) {
        Intrinsics.checkNotNullParameter(configurationParameters, "configurationParameters");
        Restaurant restaurant = configurationParameters.getRestaurant();
        this.storeInfo = restaurant;
        this.storeInfoParams = BundleKt.bundleOf(TuplesKt.to("chainId", BaseTrackerKt.orDefault$default(Integer.valueOf(restaurant.f13872id), (String) null, 1, (Object) null)), TuplesKt.to("chainName", BaseTrackerKt.orDefault$default(restaurant.f13873name, (String) null, 1, (Object) null)), TuplesKt.to("shopMainCuisine", BaseTrackerKt.orDefault$default(restaurant.GACuisineString(), (String) null, 1, (Object) null)), TuplesKt.to("shopDeliveryFee", BaseTrackerKt.orDefault$default(Float.valueOf(restaurant.deliveryCharges), (String) null, 1, (Object) null)), TuplesKt.to("shopId", BaseTrackerKt.orDefault$default(Integer.valueOf(restaurant.branchId), (String) null, 1, (Object) null)), TuplesKt.to("shopName", BaseTrackerKt.orDefault$default(restaurant.branchName, (String) null, 1, (Object) null)), TuplesKt.to("shopArea", BaseTrackerKt.orDefault$default(restaurant.areaName, (String) null, 1, (Object) null)), TuplesKt.to("shopStatus", StoreStatus.Companion.fromType(restaurant.statusType).getStatus()), TuplesKt.to("shopType", getTrackingShopType(restaurant)));
    }

    private final String getTrackingShopType(Restaurant restaurant) {
        if (restaurant.isDarkStore) {
            return "darkstores";
        }
        int i11 = restaurant.shopType;
        if (i11 == 6) {
            return SHOP_TYPE_COSMETIC;
        }
        if (i11 == 4) {
            return SHOP_TYPE_ELECTRONICS;
        }
        if (i11 == 3) {
            return SHOP_TYPE_FLOWERS;
        }
        if (i11 == 1) {
            return "groceries";
        }
        if (i11 == 5) {
            return SHOP_TYPE_PET_SHOP;
        }
        if (i11 == 2) {
            return SHOP_TYPE_PHARMACY;
        }
        if (i11 == 0) {
            return SHOP_TYPE_RESTAURANT;
        }
        return "N/A";
    }

    @NotNull
    public final Bundle getStoreInfoParams() {
        return this.storeInfoParams;
    }
}
