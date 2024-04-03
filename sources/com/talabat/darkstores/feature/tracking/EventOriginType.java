package com.talabat.darkstores.feature.tracking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "", "trackingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingName", "()Ljava/lang/String;", "Details", "Category", "Search", "VendorLanding", "Swimlane", "VoucherSwimlane", "Cart", "Banner", "CategoryShelfView", "None", "CategorySectionVlp", "Lifestyle", "Reorder", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EventOriginType {
    Details("item_details"),
    Category("category"),
    Search("vendor_search"),
    VendorLanding("vendor_landing"),
    Swimlane("swimlane"),
    VoucherSwimlane("voucher_swimlane"),
    Cart("cart"),
    Banner("banner"),
    CategoryShelfView("category_shelf_view"),
    None("N/A"),
    CategorySectionVlp("category_section_vlp"),
    Lifestyle("lifestyle"),
    Reorder(ScreenNames.SCREEN_TYPE_REORDER);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String trackingName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/EventOriginType$Companion;", "", "()V", "fromTrackingName", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "name", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final EventOriginType fromTrackingName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            for (EventOriginType eventOriginType : EventOriginType.values()) {
                if (Intrinsics.areEqual((Object) eventOriginType.getTrackingName(), (Object) str)) {
                    return eventOriginType;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private EventOriginType(String str) {
        this.trackingName = str;
    }

    @NotNull
    public final String getTrackingName() {
        return this.trackingName;
    }
}
