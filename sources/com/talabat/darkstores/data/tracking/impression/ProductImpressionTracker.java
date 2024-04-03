package com.talabat.darkstores.data.tracking.impression;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.talabat.darkstores.data.tracking.BaseTrackerKt;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.TrackingUtilKt;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryItem;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryProduct;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import com.talabat.darkstores.model.Banner;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import com.talabat.impressiontracking.items.NonTrackableImpressionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0011J,\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ0\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\rJ$\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ,\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001a2\u0006\u0010\u001c\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020,J(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a*\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002J4\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a*\b\u0012\u0004\u0012\u00020!0\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "", "bannerImpressionMapper", "Lcom/talabat/darkstores/data/tracking/impression/BannerImpressionMapper;", "talabatImpressionTracker", "Lcom/talabat/impressiontracking/TalabatImpressionTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "(Lcom/talabat/darkstores/data/tracking/impression/BannerImpressionMapper;Lcom/talabat/impressiontracking/TalabatImpressionTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;)V", "impressionAdditionalParameters", "", "", "query", "lastSearchRequestId", "reCalculate", "", "register", "viewGroup", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "unregister", "updateBannerItems", "heroBannerImpressionData", "", "Lcom/talabat/darkstores/model/Banner;", "screenName", "eventOrigin", "bannerType", "updateSearchItems", "searchImpressionData", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "trackingName", "updateSubcategoryItems", "subcategoryItems", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "updateSwimlaneItems", "homeRecyclerViewItems", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "toImpressionData", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductImpressionTracker {
    @NotNull
    private final BannerImpressionMapper bannerImpressionMapper;
    @NotNull
    private final LocationTrackingProvider locationTrackingProvider;
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatImpressionTracker talabatImpressionTracker;

    @Inject
    public ProductImpressionTracker(@NotNull BannerImpressionMapper bannerImpressionMapper2, @NotNull TalabatImpressionTracker talabatImpressionTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2, @NotNull LocationTrackingProvider locationTrackingProvider2) {
        Intrinsics.checkNotNullParameter(bannerImpressionMapper2, "bannerImpressionMapper");
        Intrinsics.checkNotNullParameter(talabatImpressionTracker2, "talabatImpressionTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider2, "locationTrackingProvider");
        this.bannerImpressionMapper = bannerImpressionMapper2;
        this.talabatImpressionTracker = talabatImpressionTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
        this.locationTrackingProvider = locationTrackingProvider2;
    }

    private final Map<String, String> impressionAdditionalParameters(String str, String str2) {
        Pair[] pairArr = new Pair[4];
        if (str2 == null) {
            str2 = "NA";
        }
        pairArr[0] = TuplesKt.to("searchRequestId", str2);
        pairArr[1] = TuplesKt.to(ProductImpressionMapperKt.KEY_IMPRESSION_LIST_NAME, "search");
        pairArr[2] = TuplesKt.to("screenName", ScreenTrackingProvider.ScreenName.SEARCH.getTrackingName());
        pairArr[3] = TuplesKt.to("screenType", ScreenTrackingProvider.ScreenType.SEARCH_RESULTS.getTrackingName());
        Map<String, String> mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str != null) {
            mutableMapOf.put("searchTerm", BaseTrackerKt.orDefault$default(str, (String) null, 1, (Object) null));
        }
        return mutableMapOf;
    }

    private final List<Object> toImpressionData(List<? extends SubcategoryItem> list, String str, String str2) {
        Object obj;
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SubcategoryItem subcategoryItem = (SubcategoryItem) next;
            if (subcategoryItem instanceof SubcategoryProduct) {
                obj = ProductImpressionMapperKt.toImpressionItem(((SubcategoryProduct) subcategoryItem).getProduct(), i11, str2, MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(TuplesKt.to(ProductImpressionMapperKt.KEY_IMPRESSION_LIST_NAME, "category"), TuplesKt.to("screenName", str), TuplesKt.to("screenType", str)), (Map) TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams())));
            } else {
                obj = NonTrackableImpressionItem.INSTANCE;
            }
            arrayList.add(obj);
            i11 = i12;
        }
        return arrayList;
    }

    public final void reCalculate() {
        this.talabatImpressionTracker.reCalculate();
    }

    public final void register(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.talabatImpressionTracker.register(viewGroup, lifecycleOwner);
    }

    public final void unregister() {
        this.talabatImpressionTracker.unregister();
    }

    public final void updateBannerItems(@NotNull List<Banner> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(list, "heroBannerImpressionData");
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "bannerType");
        this.talabatImpressionTracker.updateItems(this.bannerImpressionMapper.apply(new BannerData(list, str, str2, str3)));
    }

    public final void updateSearchItems(@NotNull List<? extends SearchPagingItem> list, @Nullable String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(list, "searchImpressionData");
        Intrinsics.checkNotNullParameter(str3, "trackingName");
        this.talabatImpressionTracker.updateItems(toImpressionData(list, str, str2, str3));
    }

    public final void updateSubcategoryItems(@NotNull List<? extends SubcategoryItem> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "subcategoryItems");
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.talabatImpressionTracker.updateItems(toImpressionData(list, str, str2));
    }

    /* JADX WARNING: type inference failed for: r4v11, types: [java.util.Collection, java.util.ArrayList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSwimlaneItems(@org.jetbrains.annotations.NotNull java.util.List<? extends com.talabat.darkstores.feature.home.HomeRecyclerViewItem> r10, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.ScreenName r11, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.ScreenType r12, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.EventOrigin r13) {
        /*
            r9 = this;
            java.lang.String r0 = "homeRecyclerViewItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "screenName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r1 = "screenType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r2 = "eventOrigin"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            r2 = 5
            kotlin.Pair[] r2 = new kotlin.Pair[r2]
            java.lang.String r11 = r11.getTrackingName()
            kotlin.Pair r11 = kotlin.TuplesKt.to(r0, r11)
            r0 = 0
            r2[r0] = r11
            java.lang.String r11 = r12.getTrackingName()
            kotlin.Pair r11 = kotlin.TuplesKt.to(r1, r11)
            r12 = 1
            r2[r12] = r11
            java.lang.String r11 = "swimlaneStrategyList"
            java.lang.String r1 = "N/A"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r1)
            r1 = 2
            r2[r1] = r11
            java.lang.String r11 = "impressionListName"
            java.lang.String r1 = "swimlane"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r1)
            r1 = 3
            r2[r1] = r11
            java.lang.String r11 = "shopSponsoringPlacement"
            java.lang.String r1 = "storefront:swimlane"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r1)
            r1 = 4
            r2[r1] = r11
            java.util.Map r11 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r2)
            com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider r1 = r9.storeInfoTrackingProvider
            android.os.Bundle r1 = r1.getStoreInfoParams()
            java.util.Map r1 = com.talabat.darkstores.data.tracking.TrackingUtilKt.toMapOfStrings(r1)
            r11.putAll(r1)
            com.talabat.darkstores.data.tracking.LocationTrackingProvider r1 = r9.locationTrackingProvider
            android.os.Bundle r1 = r1.getLocationParams()
            java.util.Map r1 = com.talabat.darkstores.data.tracking.TrackingUtilKt.toMapOfStrings(r1)
            r11.putAll(r1)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r10, r2)
            r1.<init>(r3)
            java.util.Iterator r10 = r10.iterator()
        L_0x0081:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x0102
            java.lang.Object r3 = r10.next()
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem r3 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem) r3
            boolean r4 = r3 instanceof com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SwimlaneItem
            if (r4 == 0) goto L_0x00fc
            com.talabat.darkstores.feature.home.HomeRecyclerViewItem$SwimlaneItem r3 = (com.talabat.darkstores.feature.home.HomeRecyclerViewItem.SwimlaneItem) r3
            com.talabat.darkstores.feature.home.SwimlaneViewHolderData r4 = r3.getItem()
            com.talabat.darkstores.model.Swimlane r4 = r4.getSwimlane()
            java.lang.String r4 = r4.getRequestId()
            r5 = 0
            java.lang.String r4 = com.talabat.darkstores.data.tracking.BaseTrackerKt.orDefault$default((java.lang.String) r4, (java.lang.String) r5, (int) r12, (java.lang.Object) r5)
            java.lang.String r6 = "swimlaneRequestId"
            r11.put(r6, r4)
            com.talabat.darkstores.feature.home.SwimlaneViewHolderData r4 = r3.getItem()
            com.talabat.darkstores.model.Swimlane r4 = r4.getSwimlane()
            java.lang.String r4 = r4.getSwimlaneId()
            java.lang.String r4 = com.talabat.darkstores.data.tracking.BaseTrackerKt.orDefault$default((java.lang.String) r4, (java.lang.String) r5, (int) r12, (java.lang.Object) r5)
            java.lang.String r5 = "swimlaneStrategy"
            r11.put(r5, r4)
            com.talabat.darkstores.feature.home.SwimlaneViewHolderData r3 = r3.getItem()
            com.talabat.darkstores.model.Swimlane r3 = r3.getSwimlane()
            java.util.List r3 = r3.getProducts()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, r2)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
            r5 = r0
        L_0x00dc:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00fe
            java.lang.Object r6 = r3.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x00ed
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x00ed:
            com.talabat.feature.darkstorescart.data.model.Product r6 = (com.talabat.feature.darkstorescart.data.model.Product) r6
            java.lang.String r8 = r13.getTrackingName()
            com.talabat.impressiontracking.items.TrackableImpressionItem r5 = com.talabat.darkstores.data.tracking.impression.ProductImpressionMapperKt.toImpressionItem(r6, r5, r8, r11)
            r4.add(r5)
            r5 = r7
            goto L_0x00dc
        L_0x00fc:
            com.talabat.impressiontracking.items.NonTrackableImpressionItem r4 = com.talabat.impressiontracking.items.NonTrackableImpressionItem.INSTANCE
        L_0x00fe:
            r1.add(r4)
            goto L_0x0081
        L_0x0102:
            com.talabat.impressiontracking.TalabatImpressionTracker r10 = r9.talabatImpressionTracker
            r10.updateItems(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker.updateSwimlaneItems(java.util.List, com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$ScreenName, com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$ScreenType, com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$EventOrigin):void");
    }

    private final List<Object> toImpressionData(List<? extends SearchPagingItem> list, String str, String str2, String str3) {
        Object obj;
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SearchPagingItem searchPagingItem = (SearchPagingItem) next;
            if (searchPagingItem instanceof SearchPagingItem.Categories) {
                obj = NonTrackableImpressionItem.INSTANCE;
            } else if (searchPagingItem instanceof SearchPagingItem.Product) {
                obj = ProductImpressionMapperKt.toImpressionItem(((SearchPagingItem.Product) searchPagingItem).getProduct(), i11, str3, MapsKt__MapsKt.plus(impressionAdditionalParameters(str, str2), TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams())));
            } else if (searchPagingItem instanceof SearchPagingItem.TotalCount) {
                obj = NonTrackableImpressionItem.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
            i11 = i12;
        }
        return arrayList;
    }
}
