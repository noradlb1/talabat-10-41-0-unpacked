package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/data/tracking/HomeTracker;", "", "baseTracker", "Lcom/talabat/darkstores/data/tracking/BaseTracker;", "screenTrackingProvider", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;", "(Lcom/talabat/darkstores/data/tracking/BaseTracker;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;)V", "growthWidgetShown", "", "message", "", "searchBarClicked", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeTracker {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DARKSTORE_PAGE_TYPE = "darkstore";
    @NotNull
    @Deprecated
    public static final String GROWTH_WIDGET_TYPE = "tmart_growth_widget";
    @NotNull
    @Deprecated
    public static final String LISTING_PAGE_TYPE = "listingPageType";
    @NotNull
    @Deprecated
    public static final String SEARCH_BAR_CLICKED = "search_bar_clicked";
    @NotNull
    @Deprecated
    public static final String WIDGET_NAME = "widgetName";
    @NotNull
    @Deprecated
    public static final String WIDGET_SHOWN = "widget_shown";
    @NotNull
    @Deprecated
    public static final String WIDGET_TYPE = "widgetType";
    @NotNull
    private final BaseTracker baseTracker;
    @NotNull
    private final ScreenTrackingProvider screenTrackingProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/HomeTracker$Companion;", "", "()V", "DARKSTORE_PAGE_TYPE", "", "GROWTH_WIDGET_TYPE", "LISTING_PAGE_TYPE", "SEARCH_BAR_CLICKED", "WIDGET_NAME", "WIDGET_SHOWN", "WIDGET_TYPE", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public HomeTracker(@NotNull BaseTracker baseTracker2, @NotNull ScreenTrackingProvider screenTrackingProvider2) {
        Intrinsics.checkNotNullParameter(baseTracker2, "baseTracker");
        Intrinsics.checkNotNullParameter(screenTrackingProvider2, "screenTrackingProvider");
        this.baseTracker = baseTracker2;
        this.screenTrackingProvider = screenTrackingProvider2;
    }

    public final void growthWidgetShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.LANDING, ScreenTrackingProvider.ScreenName.VOUCHER_REMINDER, ScreenTrackingProvider.ScreenType.SHOP_DETAILS);
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("listingPageType", "darkstore"), TuplesKt.to("widgetType", "tmart_growth_widget"), TuplesKt.to("widgetName", str));
        this.baseTracker.dispatch("widget_shown", screenParams, bundleOf);
    }

    public final void searchBarClicked() {
        ScreenTrackingProvider screenTrackingProvider2 = this.screenTrackingProvider;
        ScreenTrackingProvider.ScreenType screenType = ScreenTrackingProvider.ScreenType.LANDING;
        Bundle screenParams = screenTrackingProvider2.screenParams(ScreenTrackingProvider.EventOrigin.LANDING, ScreenTrackingProvider.ScreenName.LANDING, screenType);
        this.baseTracker.dispatch("search_bar_clicked", screenParams);
    }
}
