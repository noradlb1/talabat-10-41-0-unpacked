package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJC\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019JC\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001eJC\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001eJ2\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0#J \u0010%\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\rJ$\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\rJ;\u0010(\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\nJ \u0010+\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ(\u0010,\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/talabat/darkstores/data/tracking/SearchTracker;", "", "baseTracker", "Lcom/talabat/darkstores/data/tracking/BaseTracker;", "screenTrackingProvider", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;", "productTrackingProvider", "Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider;", "(Lcom/talabat/darkstores/data/tracking/BaseTracker;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider;Lcom/talabat/darkstores/data/tracking/ProductTrackingProvider;)V", "onCategorySearchBarClicked", "", "onSearchCategoryClicked", "categoryId", "", "categoryPosition", "", "categoryName", "prepareQuantityChangedParams", "Lkotlin/Triple;", "Landroid/os/Bundle;", "productTrackingData", "Lcom/talabat/darkstores/data/tracking/ProductTrackingData;", "index", "query", "requestId", "(Lcom/talabat/darkstores/data/tracking/ProductTrackingData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Triple;", "productAdded", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "section", "(Lcom/talabat/darkstores/data/tracking/ProductTrackingData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;Ljava/lang/String;)V", "productRemoved", "searchCategoryLoaded", "count", "categoriesIds", "", "categoriesNames", "searchClosed", "searchError", "message", "searchItemClicked", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;)V", "searchLoaded", "searchResultsLoaded", "trackProductOpened", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchTracker {
    @NotNull
    @Deprecated
    public static final String ADDED = "add_to_cart";
    @NotNull
    @Deprecated
    public static final String CATEGORY_ID = "categoryId";
    @NotNull
    @Deprecated
    public static final String CATEGORY_ID_RESULTS = "categoryIdResults";
    @NotNull
    @Deprecated
    public static final String CATEGORY_NAME = "categoryName";
    @NotNull
    @Deprecated
    public static final String CATEGORY_NAME_RESULTS = "categoryNameResults";
    @NotNull
    @Deprecated
    public static final String CATEGORY_POSITION = "categoryPosition";
    @NotNull
    @Deprecated
    public static final String CATEGORY_RESULTS_NUMBER = "categoryResultsNumber";
    @NotNull
    @Deprecated
    public static final String CATEGORY_SEARCH_BAR_CLICKED = "category_search_bar_clicked";
    @NotNull
    @Deprecated
    public static final String CATEGORY_SEARCH_CLICKED = "category_search_results_clicked";
    @NotNull
    @Deprecated
    public static final String CATEGORY_SEARCH_RESULTS_LOADED = "category_search_results_loaded";
    @NotNull
    @Deprecated
    public static final String CLOSED = "search_details_closed";
    @NotNull
    @Deprecated
    public static final String COUNT = "itemsNumber";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DETAILS_LOADED = "search_details_loaded";
    @NotNull
    @Deprecated
    public static final String ERROR = "search_error_shown";
    @NotNull
    @Deprecated
    public static final String ERROR_MESSAGE = "errorMessage";
    @NotNull
    @Deprecated
    public static final String INDEX = "productIndex";
    @NotNull
    @Deprecated
    public static final String ITEM_CLICKED = "search_clicked";
    @NotNull
    @Deprecated
    public static final String PRODUCT_OPENED = "product_choice_opened";
    @NotNull
    @Deprecated
    public static final String QUERY = "searchTerm";
    @NotNull
    @Deprecated
    public static final String REMOVED = "remove_from_cart";
    @NotNull
    @Deprecated
    public static final String REQUEST_ID = "searchRequestId";
    @NotNull
    @Deprecated
    public static final String RESULTS_LOADED = "search_results_loaded";
    @NotNull
    @Deprecated
    public static final String SECTION = "searchSection";
    @NotNull
    private final BaseTracker baseTracker;
    @NotNull
    private final ProductTrackingProvider productTrackingProvider;
    @NotNull
    private final ScreenTrackingProvider screenTrackingProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/SearchTracker$Companion;", "", "()V", "ADDED", "", "CATEGORY_ID", "CATEGORY_ID_RESULTS", "CATEGORY_NAME", "CATEGORY_NAME_RESULTS", "CATEGORY_POSITION", "CATEGORY_RESULTS_NUMBER", "CATEGORY_SEARCH_BAR_CLICKED", "CATEGORY_SEARCH_CLICKED", "CATEGORY_SEARCH_RESULTS_LOADED", "CLOSED", "COUNT", "DETAILS_LOADED", "ERROR", "ERROR_MESSAGE", "INDEX", "ITEM_CLICKED", "PRODUCT_OPENED", "QUERY", "REMOVED", "REQUEST_ID", "RESULTS_LOADED", "SECTION", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SearchTracker(@NotNull BaseTracker baseTracker2, @NotNull ScreenTrackingProvider screenTrackingProvider2, @NotNull ProductTrackingProvider productTrackingProvider2) {
        Intrinsics.checkNotNullParameter(baseTracker2, "baseTracker");
        Intrinsics.checkNotNullParameter(screenTrackingProvider2, "screenTrackingProvider");
        Intrinsics.checkNotNullParameter(productTrackingProvider2, "productTrackingProvider");
        this.baseTracker = baseTracker2;
        this.screenTrackingProvider = screenTrackingProvider2;
        this.productTrackingProvider = productTrackingProvider2;
    }

    private final Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams(ProductTrackingData productTrackingData, Integer num, String str, String str2) {
        return new Triple<>(this.productTrackingProvider.prepareProductParams(productTrackingData), BundleKt.bundleOf(TuplesKt.to("productIndex", BaseTrackerKt.orDefault$default(num, (String) null, 1, (Object) null)), TuplesKt.to("searchTerm", str), TuplesKt.to("searchRequestId", BaseTrackerKt.orDefault$default(str2, (String) null, 1, (Object) null))), this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.SEARCH_RESULTS, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS));
    }

    public static /* synthetic */ void productAdded$default(SearchTracker searchTracker, ProductTrackingData productTrackingData, Integer num, String str, String str2, ScreenTrackingProvider.EventOrigin eventOrigin, String str3, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str3 = null;
        }
        searchTracker.productAdded(productTrackingData, num, str, str2, eventOrigin, str3);
    }

    public static /* synthetic */ void productRemoved$default(SearchTracker searchTracker, ProductTrackingData productTrackingData, Integer num, String str, String str2, ScreenTrackingProvider.EventOrigin eventOrigin, String str3, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str3 = null;
        }
        searchTracker.productRemoved(productTrackingData, num, str, str2, eventOrigin, str3);
    }

    public static /* synthetic */ void searchError$default(SearchTracker searchTracker, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        searchTracker.searchError(str, str2, str3);
    }

    public final void onCategorySearchBarClicked() {
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.ALL_CATEGORIES, ScreenTrackingProvider.ScreenName.ALL_CATEGORIES, ScreenTrackingProvider.ScreenType.SHOP_DETAILS);
        this.baseTracker.dispatch(CATEGORY_SEARCH_BAR_CLICKED, screenParams);
    }

    public final void onSearchCategoryClicked(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("categoryId", str), TuplesKt.to(CATEGORY_POSITION, Integer.valueOf(i11)), TuplesKt.to("categoryName", str2));
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.ALL_CATEGORIES, ScreenTrackingProvider.ScreenName.ALL_CATEGORIES, ScreenTrackingProvider.ScreenType.SHOP_DETAILS);
        this.baseTracker.dispatch(CATEGORY_SEARCH_CLICKED, bundleOf, screenParams);
    }

    public final void productAdded(@NotNull ProductTrackingData productTrackingData, @Nullable Integer num, @NotNull String str, @Nullable String str2, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        searchItemClicked(num, str, str2, str3, eventOrigin);
        Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams = prepareQuantityChangedParams(productTrackingData, num, str, str2);
        this.baseTracker.dispatch("add_to_cart", prepareQuantityChangedParams.component2(), prepareQuantityChangedParams.component1(), prepareQuantityChangedParams.component3());
    }

    public final void productRemoved(@NotNull ProductTrackingData productTrackingData, @Nullable Integer num, @NotNull String str, @Nullable String str2, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        searchItemClicked(num, str, str2, str3, eventOrigin);
        Triple<Bundle, Bundle, Bundle> prepareQuantityChangedParams = prepareQuantityChangedParams(productTrackingData, num, str, str2);
        this.baseTracker.dispatch("remove_from_cart", prepareQuantityChangedParams.component2(), prepareQuantityChangedParams.component1(), prepareQuantityChangedParams.component3());
    }

    public final void searchCategoryLoaded(int i11, @NotNull String str, @NotNull List<String> list, @NotNull List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(list, "categoriesIds");
        Intrinsics.checkNotNullParameter(list2, "categoriesNames");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(CATEGORY_RESULTS_NUMBER, Integer.valueOf(i11)), TuplesKt.to("searchTerm", str), TuplesKt.to(CATEGORY_ID_RESULTS, list), TuplesKt.to(CATEGORY_NAME_RESULTS, list2));
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.ALL_CATEGORIES, ScreenTrackingProvider.ScreenName.ALL_CATEGORIES, ScreenTrackingProvider.ScreenType.SHOP_DETAILS);
        this.baseTracker.dispatch(CATEGORY_SEARCH_RESULTS_LOADED, bundleOf, screenParams);
    }

    public final void searchClosed(int i11, @Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "query");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("itemsNumber", Integer.valueOf(i11)), TuplesKt.to("searchRequestId", BaseTrackerKt.orDefault$default(str, (String) null, 1, (Object) null)), TuplesKt.to("searchTerm", str2));
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.LANDING, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS);
        this.baseTracker.dispatch(CLOSED, bundleOf, screenParams);
    }

    public final void searchError(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "query");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("errorMessage", BaseTrackerKt.orDefault$default(str3, (String) null, 1, (Object) null)), TuplesKt.to("searchTerm", str), TuplesKt.to("searchRequestId", BaseTrackerKt.orDefault$default(str2, (String) null, 1, (Object) null)));
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.SEARCH, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_DETAILS);
        this.baseTracker.dispatch(ERROR, bundleOf, screenParams);
    }

    public final void searchItemClicked(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin) {
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("productIndex", BaseTrackerKt.orDefault$default(num, (String) null, 1, (Object) null)), TuplesKt.to("searchTerm", BaseTrackerKt.orDefault$default(str, (String) null, 1, (Object) null)), TuplesKt.to("searchRequestId", BaseTrackerKt.orDefault$default(str2, (String) null, 1, (Object) null)), TuplesKt.to(SECTION, BaseTrackerKt.orDefault$default(str3, (String) null, 1, (Object) null)));
        Bundle screenParams = this.screenTrackingProvider.screenParams(eventOrigin, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS);
        this.baseTracker.dispatch(ITEM_CLICKED, bundleOf, screenParams);
    }

    public final void searchLoaded() {
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.LANDING, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_DETAILS);
        this.baseTracker.dispatch(DETAILS_LOADED, screenParams);
    }

    public final void searchResultsLoaded(int i11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("itemsNumber", Integer.valueOf(i11)), TuplesKt.to("searchTerm", str), TuplesKt.to("searchRequestId", BaseTrackerKt.orDefault$default(str2, (String) null, 1, (Object) null)));
        Bundle screenParams = this.screenTrackingProvider.screenParams(ScreenTrackingProvider.EventOrigin.SEARCH, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS);
        this.baseTracker.dispatch(RESULTS_LOADED, bundleOf, screenParams);
    }

    public final void trackProductOpened(@NotNull ProductTrackingData productTrackingData, int i11, @Nullable String str, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin) {
        Intrinsics.checkNotNullParameter(productTrackingData, "productTrackingData");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("productIndex", Integer.valueOf(i11)), TuplesKt.to("searchTerm", BaseTrackerKt.orDefault$default(str, (String) null, 1, (Object) null)));
        Bundle screenParams = this.screenTrackingProvider.screenParams(eventOrigin, ScreenTrackingProvider.ScreenName.PRODUCT_DETAILS, ScreenTrackingProvider.ScreenType.PRODUCT_DETAILS);
        Bundle prepareProductParams = this.productTrackingProvider.prepareProductParams(productTrackingData);
        this.baseTracker.dispatch("product_choice_opened", bundleOf, screenParams, prepareProductParams);
    }
}
