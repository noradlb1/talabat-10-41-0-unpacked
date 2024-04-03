package com.talabat.feature.darkstores.domain.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.talabat.feature.tmart.growth.data.tracking.TMartGrowthTracker;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;", "", "()V", "screenParams", "Landroid/os/Bundle;", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "Companion", "EventOrigin", "ScreenName", "ScreenType", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTrackingProvider {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String EVENT_ORIGIN = "eventOrigin";
    @NotNull
    @Deprecated
    public static final String SCREEN_NAME = "screenName";
    @NotNull
    @Deprecated
    public static final String SCREEN_TYPE = "screenType";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$Companion;", "", "()V", "EVENT_ORIGIN", "", "SCREEN_NAME", "SCREEN_TYPE", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "", "trackingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingName", "()Ljava/lang/String;", "LANDING", "MISSION", "RECENT_SEARCH", "SEARCH", "SEARCH_RESULTS", "HOME", "ALL_CATEGORIES", "PAST_ORDERS", "VIEW_ALL", "CATEGORY_DETAILS_SORT", "Companion", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum EventOrigin {
        LANDING("vendor_landing"),
        MISSION("mission"),
        RECENT_SEARCH("recent_search"),
        SEARCH("vendor_search"),
        SEARCH_RESULTS("vendor_search_results"),
        HOME("home"),
        ALL_CATEGORIES("all_categories"),
        PAST_ORDERS("search_past_orders"),
        VIEW_ALL("view_all"),
        CATEGORY_DETAILS_SORT("category_details_sort");
        
        @NotNull
        public static final Companion Companion = null;
        @NotNull
        private final String trackingName;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin$Companion;", "", "()V", "fromTrackingName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "name", "", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final EventOrigin fromTrackingName(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                for (EventOrigin eventOrigin : EventOrigin.values()) {
                    if (Intrinsics.areEqual((Object) eventOrigin.getTrackingName(), (Object) str)) {
                        return eventOrigin;
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        private EventOrigin(String str) {
            this.trackingName = str;
        }

        @NotNull
        public final String getTrackingName() {
            return this.trackingName;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "", "trackingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingName", "()Ljava/lang/String;", "LANDING", "PRODUCT_DETAILS", "SEARCH", "SHOP_DETAILS", "VOUCHER_REMINDER", "ALL_CATEGORIES", "CART", "VENDOR_LANDING", "CATEGORY", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ScreenName {
        LANDING("vendor_landing"),
        PRODUCT_DETAILS("product_details"),
        SEARCH("vendor_search"),
        SHOP_DETAILS("shop_details"),
        VOUCHER_REMINDER(TMartGrowthTracker.SCREEN_NAME_REMINDER),
        ALL_CATEGORIES("all_categories"),
        CART("vendor_cart"),
        VENDOR_LANDING("vendor_landing"),
        CATEGORY("category");
        
        @NotNull
        private final String trackingName;

        private ScreenName(String str) {
            this.trackingName = str;
        }

        @NotNull
        public final String getTrackingName() {
            return this.trackingName;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "", "trackingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingName", "()Ljava/lang/String;", "LANDING", "PRODUCT_DETAILS", "SHOP_DETAILS", "SEARCH_DETAILS", "SEARCH_RESULTS", "CART", "VENDOR_LANDING", "CATEGORY", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ScreenType {
        LANDING("shop_details"),
        PRODUCT_DETAILS("product_details"),
        SHOP_DETAILS("shop_details"),
        SEARCH_DETAILS("vendor_search_details"),
        SEARCH_RESULTS("vendor_search_results"),
        CART("cart"),
        VENDOR_LANDING("vendor_landing"),
        CATEGORY("category_details");
        
        @NotNull
        private final String trackingName;

        private ScreenType(String str) {
            this.trackingName = str;
        }

        @NotNull
        public final String getTrackingName() {
            return this.trackingName;
        }
    }

    @NotNull
    public final Bundle screenParams(@NotNull EventOrigin eventOrigin, @NotNull ScreenName screenName, @NotNull ScreenType screenType) {
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        return BundleKt.bundleOf(TuplesKt.to("screenType", screenType.getTrackingName()), TuplesKt.to("screenName", screenName.getTrackingName()), TuplesKt.to("eventOrigin", eventOrigin.getTrackingName()));
    }
}
