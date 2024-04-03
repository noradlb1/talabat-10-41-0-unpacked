package com.talabat.darkstores.data.tracking.product;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.darkstorescart.data.model.Product;
import datamodels.Restaurant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AdjustTokens;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0016J\t\u0010 \u001a\u00020\u000fHÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/darkstores/data/tracking/product/AddToCartClickedEventAdjust;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorType", "Lcom/talabat/darkstores/data/tracking/product/VendorType;", "restaurant", "Ldatamodels/Restaurant;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "count", "", "(Lcom/talabat/darkstores/data/tracking/product/VendorType;Ldatamodels/Restaurant;Lcom/talabat/feature/darkstorescart/data/model/Product;I)V", "getVendorType", "()Lcom/talabat/darkstores/data/tracking/product/VendorType;", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddToCartClickedEventAdjust extends TalabatEvent {
    private final int count;
    @NotNull
    private final Product product;
    @NotNull
    private final Restaurant restaurant;
    @NotNull
    private final VendorType vendorType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VendorType.values().length];
            iArr[VendorType.TMART.ordinal()] = 1;
            iArr[VendorType.NFV.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AddToCartClickedEventAdjust(@NotNull VendorType vendorType2, @NotNull Restaurant restaurant2, @NotNull Product product2, int i11) {
        Intrinsics.checkNotNullParameter(vendorType2, LogWriteConstants.VENDOR_TYPE);
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(product2, "product");
        this.vendorType = vendorType2;
        this.restaurant = restaurant2;
        this.product = product2;
        this.count = i11;
    }

    private final Restaurant component2() {
        return this.restaurant;
    }

    private final Product component3() {
        return this.product;
    }

    private final int component4() {
        return this.count;
    }

    public static /* synthetic */ AddToCartClickedEventAdjust copy$default(AddToCartClickedEventAdjust addToCartClickedEventAdjust, VendorType vendorType2, Restaurant restaurant2, Product product2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            vendorType2 = addToCartClickedEventAdjust.vendorType;
        }
        if ((i12 & 2) != 0) {
            restaurant2 = addToCartClickedEventAdjust.restaurant;
        }
        if ((i12 & 4) != 0) {
            product2 = addToCartClickedEventAdjust.product;
        }
        if ((i12 & 8) != 0) {
            i11 = addToCartClickedEventAdjust.count;
        }
        return addToCartClickedEventAdjust.copy(vendorType2, restaurant2, product2, i11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ProductEventsKt.getTrackingData(this.restaurant, this.product.getId(), String.valueOf(this.count), String.valueOf(this.product.getPrice()));
    }

    @NotNull
    public final VendorType component1() {
        return this.vendorType;
    }

    @NotNull
    public final AddToCartClickedEventAdjust copy(@NotNull VendorType vendorType2, @NotNull Restaurant restaurant2, @NotNull Product product2, int i11) {
        Intrinsics.checkNotNullParameter(vendorType2, LogWriteConstants.VENDOR_TYPE);
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(product2, "product");
        return new AddToCartClickedEventAdjust(vendorType2, restaurant2, product2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddToCartClickedEventAdjust)) {
            return false;
        }
        AddToCartClickedEventAdjust addToCartClickedEventAdjust = (AddToCartClickedEventAdjust) obj;
        return this.vendorType == addToCartClickedEventAdjust.vendorType && Intrinsics.areEqual((Object) this.restaurant, (Object) addToCartClickedEventAdjust.restaurant) && Intrinsics.areEqual((Object) this.product, (Object) addToCartClickedEventAdjust.product) && this.count == addToCartClickedEventAdjust.count;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @NotNull
    public final VendorType getVendorType() {
        return this.vendorType;
    }

    public int hashCode() {
        return (((((this.vendorType.hashCode() * 31) + this.restaurant.hashCode()) * 31) + this.product.hashCode()) * 31) + this.count;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.vendorType.ordinal()];
        if (i11 == 1) {
            String addToCartTMart = AdjustTokens.addToCartTMart();
            Intrinsics.checkNotNullExpressionValue(addToCartTMart, "addToCartTMart()");
            return addToCartTMart;
        } else if (i11 != 2) {
            String addToCart = AdjustTokens.addToCart();
            Intrinsics.checkNotNullExpressionValue(addToCart, "addToCart()");
            return addToCart;
        } else {
            String addToCartNfv = AdjustTokens.addToCartNfv();
            Intrinsics.checkNotNullExpressionValue(addToCartNfv, "addToCartNfv()");
            return addToCartNfv;
        }
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.ADJUST);
    }

    @NotNull
    public String toString() {
        VendorType vendorType2 = this.vendorType;
        Restaurant restaurant2 = this.restaurant;
        Product product2 = this.product;
        int i11 = this.count;
        return "AddToCartClickedEventAdjust(vendorType=" + vendorType2 + ", restaurant=" + restaurant2 + ", product=" + product2 + ", count=" + i11 + ")";
    }
}
