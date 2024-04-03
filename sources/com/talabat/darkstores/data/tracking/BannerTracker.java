package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ9\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/tracking/BannerTracker;", "", "baseTracker", "Lcom/talabat/darkstores/data/tracking/BaseTracker;", "screenTrackingProvider", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;", "productTrackingProvider", "Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider;", "(Lcom/talabat/darkstores/data/tracking/BaseTracker;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider;)V", "prepareQuantityChangedParams", "Lkotlin/Triple;", "Landroid/os/Bundle;", "productTrackingData", "Lcom/talabat/darkstores/data/tracking/ProductTrackingData;", "index", "", "bannerCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;", "(Lcom/talabat/darkstores/data/tracking/ProductTrackingData;Ljava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;)Lkotlin/Triple;", "productAdded", "", "(Lcom/talabat/darkstores/data/tracking/ProductTrackingData;Ljava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;)V", "productRemoved", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerTracker {
    @NotNull
    @Deprecated
    public static final String ADDED = "add_cart_clicked";
    @NotNull
    @Deprecated
    public static final String CATEGORY_ID = "categoryId";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String INDEX = "productIndex";
    @NotNull
    @Deprecated
    public static final String REMOVED = "remove_from_cart";
    @NotNull
    private final BaseTracker baseTracker;
    @NotNull
    private final ProductTrackingProvider productTrackingProvider;
    @NotNull
    private final ScreenTrackingProvider screenTrackingProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/BannerTracker$Companion;", "", "()V", "ADDED", "", "CATEGORY_ID", "INDEX", "REMOVED", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public BannerTracker(@NotNull BaseTracker baseTracker2, @NotNull ScreenTrackingProvider screenTrackingProvider2, @NotNull ProductTrackingProvider productTrackingProvider2) {
        Intrinsics.checkNotNullParameter(baseTracker2, "baseTracker");
        Intrinsics.checkNotNullParameter(screenTrackingProvider2, "screenTrackingProvider");
        Intrinsics.checkNotNullParameter(productTrackingProvider2, "productTrackingProvider");
        this.baseTracker = baseTracker2;
        this.screenTrackingProvider = screenTrackingProvider2;
        this.productTrackingProvider = productTrackingProvider2;
    }

    private final Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams(ProductTrackingData productTrackingData, Integer num, TrackingCategoryId.Banner banner) {
        return new Triple<>(this.productTrackingProvider.prepareProductParams(productTrackingData), BundleKt.bundleOf(TuplesKt.to("productIndex", BaseTrackerKt.orDefault$default(num, (String) null, 1, (Object) null)), TuplesKt.to("categoryId", banner.getTrackingName())), this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.SEARCH_RESULTS, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS));
    }

    public final void productAdded(@NotNull ProductTrackingData productTrackingData, @Nullable Integer num, @NotNull TrackingCategoryId.Banner banner) {
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Intrinsics.checkNotNullParameter(banner, "bannerCategoryId");
        Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams = prepareQuantityChangedParams(productTrackingData, num, banner);
        this.baseTracker.dispatch(ADDED, prepareQuantityChangedParams.component2(), prepareQuantityChangedParams.component1(), prepareQuantityChangedParams.component3());
    }

    public final void productRemoved(@NotNull ProductTrackingData productTrackingData, @Nullable Integer num, @NotNull TrackingCategoryId.Banner banner) {
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Intrinsics.checkNotNullParameter(banner, "bannerCategoryId");
        Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams = prepareQuantityChangedParams(productTrackingData, num, banner);
        this.baseTracker.dispatch("remove_from_cart", prepareQuantityChangedParams.component2(), prepareQuantityChangedParams.component1(), prepareQuantityChangedParams.component3());
    }
}
