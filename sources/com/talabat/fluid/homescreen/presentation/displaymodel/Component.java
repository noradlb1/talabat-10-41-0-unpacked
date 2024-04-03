package com.talabat.fluid.homescreen.presentation.displaymodel;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0001\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HERO", "LOGIN", "ACTIVE_ORDERS", "ENTRY_POINT", "GEM", "SECONDARY_BANNER", "T_MART", "COLLECTION_ITEM", "COLLECTION_CONTAINER", "ENTRYPOINT_CONTAINER", "VOUCHER_CODE_ENTRY", "SWIM_LANE_CONTAINER", "SWIM_LANE_ITEM", "PICKUP", "BANNER", "AUTO_ROTATING_BANNER", "HERO_CAROUSEL", "GROCERY_WIDGET_CATEGORIES_COLLECTION", "GROCERY_WIDGET_TITLE_ITEM", "GROCERY_WIDGET_CATEGORY_ITEM", "GROCERY_WIDGET_VIEW_STORE_ITEM", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum Component {
    HERO("hero"),
    LOGIN(FirebaseAnalytics.Event.LOGIN),
    ACTIVE_ORDERS("activeorders"),
    ENTRY_POINT("entry_point"),
    GEM("gems"),
    SECONDARY_BANNER("secondary_banner"),
    T_MART("tmart"),
    COLLECTION_ITEM("collection_item"),
    COLLECTION_CONTAINER("collection_container"),
    ENTRYPOINT_CONTAINER("entrypoint_container"),
    VOUCHER_CODE_ENTRY("voucher_code_entry"),
    SWIM_LANE_CONTAINER("swimlane_container"),
    SWIM_LANE_ITEM("swimlane_item"),
    PICKUP("pickup"),
    BANNER("banner"),
    AUTO_ROTATING_BANNER("auto_rotating_banner"),
    HERO_CAROUSEL("hero_carousel"),
    GROCERY_WIDGET_CATEGORIES_COLLECTION("grocery_widget_categories_collection"),
    GROCERY_WIDGET_TITLE_ITEM("grocery_widget_title_item"),
    GROCERY_WIDGET_CATEGORY_ITEM("grocery_widget_category_item"),
    GROCERY_WIDGET_VIEW_STORE_ITEM("grocery_widget_view_store_item");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component$Companion;", "", "()V", "from", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "value", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Component from(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (Component component : Component.values()) {
                if (Intrinsics.areEqual((Object) component.getValue(), (Object) str)) {
                    return component;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Component(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
