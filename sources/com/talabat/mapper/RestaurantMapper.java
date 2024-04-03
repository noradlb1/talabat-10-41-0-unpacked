package com.talabat.mapper;

import com.talabat.homescreen.adapter.model.banner.BannerAdItem;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/mapper/RestaurantMapper;", "", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/mapper/RestaurantMapper$Companion;", "", "()V", "mapToRestaurant", "Ldatamodels/Restaurant;", "bannerAdItem", "Lcom/talabat/homescreen/adapter/model/banner/BannerAdItem;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Restaurant mapToRestaurant(@NotNull BannerAdItem bannerAdItem) {
            int i11;
            int i12;
            boolean z11;
            Intrinsics.checkNotNullParameter(bannerAdItem, "bannerAdItem");
            Restaurant restaurant = new Restaurant();
            String chainId = bannerAdItem.getChainId();
            int i13 = -1;
            if (chainId != null) {
                i11 = Integer.parseInt(chainId);
            } else {
                i11 = -1;
            }
            restaurant.f13872id = i11;
            restaurant.f13873name = bannerAdItem.getChainName();
            String vendorId = bannerAdItem.getVendorId();
            if (vendorId != null) {
                i12 = Integer.parseInt(vendorId);
            } else {
                i12 = -1;
            }
            restaurant.branchId = i12;
            restaurant.branchName = bannerAdItem.getVendorName();
            String verticalId = bannerAdItem.getVerticalId();
            if (verticalId != null) {
                i13 = Integer.parseInt(verticalId);
            }
            restaurant.shopType = i13;
            Boolean isDarkStore = bannerAdItem.isDarkStore();
            boolean z12 = false;
            if (isDarkStore != null) {
                z11 = isDarkStore.booleanValue();
            } else {
                z11 = false;
            }
            restaurant.isDarkStore = z11;
            Boolean isGrlEnabled = bannerAdItem.isGrlEnabled();
            if (isGrlEnabled != null) {
                z12 = isGrlEnabled.booleanValue();
            }
            restaurant.isGlrEnabled = z12;
            return restaurant;
        }
    }
}
