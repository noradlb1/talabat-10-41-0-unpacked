package com.talabat.collectiondetails.data;

import androidx.annotation.VisibleForTesting;
import com.talabat.collectiondetails.data.CollectionsApi;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tf.a;
import tf.b;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJF\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/collectiondetails/data/CollectionsDataSourceImplementation;", "Lcom/talabat/collectiondetails/data/CollectionsDataSource;", "collectionsApi", "Lcom/talabat/collectiondetails/data/CollectionsApi;", "lat", "", "lon", "isNavigatedFromHomeCollection", "", "(Lcom/talabat/collectiondetails/data/CollectionsApi;Ljava/lang/String;Ljava/lang/String;Z)V", "applyFilteringAndSorting", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "collectionId", "", "cuisineIds", "filterIds", "sorting", "getAllVendorsForCollection", "getDeviceEntryPoint", "getVendorTagsForCollection", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "toRestaurantList", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsDataSourceImplementation implements CollectionsDataSource {
    @NotNull
    private final CollectionsApi collectionsApi;
    private final boolean isNavigatedFromHomeCollection;
    @NotNull
    private final String lat;
    @NotNull
    private final String lon;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CollectionsDataSourceImplementation(@NotNull CollectionsApi collectionsApi2, @NotNull String str, @NotNull String str2) {
        this(collectionsApi2, str, str2, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(collectionsApi2, "collectionsApi");
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
    }

    @JvmOverloads
    public CollectionsDataSourceImplementation(@NotNull CollectionsApi collectionsApi2, @NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(collectionsApi2, "collectionsApi");
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
        this.collectionsApi = collectionsApi2;
        this.lat = str;
        this.lon = str2;
        this.isNavigatedFromHomeCollection = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CollectionsDataSourceImplementation(@NotNull String str, @NotNull String str2) {
        this((CollectionsApi) null, str, str2, false, 9, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
    }

    /* access modifiers changed from: private */
    /* renamed from: applyFilteringAndSorting$lambda-1  reason: not valid java name */
    public static final List m9539applyFilteringAndSorting$lambda1(CollectionsDataSourceImplementation collectionsDataSourceImplementation, RestuarntListResponse restuarntListResponse) {
        Intrinsics.checkNotNullParameter(collectionsDataSourceImplementation, "this$0");
        Intrinsics.checkNotNullParameter(restuarntListResponse, "it");
        return collectionsDataSourceImplementation.toRestaurantList(restuarntListResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllVendorsForCollection$lambda-0  reason: not valid java name */
    public static final List m9540getAllVendorsForCollection$lambda0(CollectionsDataSourceImplementation collectionsDataSourceImplementation, RestuarntListResponse restuarntListResponse) {
        Intrinsics.checkNotNullParameter(collectionsDataSourceImplementation, "this$0");
        Intrinsics.checkNotNullParameter(restuarntListResponse, "it");
        return collectionsDataSourceImplementation.toRestaurantList(restuarntListResponse);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = kotlin.collections.ArraysKt___ArraysKt.toList((T[]) (r1 = r1.restaurants));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<datamodels.Restaurant> toRestaurantList(library.talabat.com.talabatlib.RestuarntListResponse r1) {
        /*
            r0 = this;
            JsonModels.RestaurantListJM r1 = r1.result
            if (r1 == 0) goto L_0x000e
            datamodels.Restaurant[] r1 = r1.restaurants
            if (r1 == 0) goto L_0x000e
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysKt.toList((T[]) r1)
            if (r1 != 0) goto L_0x0012
        L_0x000e:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.data.CollectionsDataSourceImplementation.toRestaurantList(library.talabat.com.talabatlib.RestuarntListResponse):java.util.List");
    }

    @NotNull
    public Single<List<Restaurant>> applyFilteringAndSorting(int i11, @Nullable List<Integer> list, @Nullable List<Integer> list2, @Nullable String str) {
        Single<List<Restaurant>> map = CollectionsApi.DefaultImpls.getCollectionVendors$default(this.collectionsApi, i11, this.lat, this.lon, (Integer) null, (Integer) null, list2, list, str, getDeviceEntryPoint(this.isNavigatedFromHomeCollection), (String) null, 512, (Object) null).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "collectionsApi.getCollec…estaurantList()\n        }");
        return map;
    }

    @NotNull
    public Single<List<Restaurant>> getAllVendorsForCollection(int i11) {
        Single<List<Restaurant>> map = CollectionsApi.DefaultImpls.getCollectionVendors$default(this.collectionsApi, i11, this.lat, this.lon, (Integer) null, (Integer) null, (List) null, (List) null, (String) null, getDeviceEntryPoint(this.isNavigatedFromHomeCollection), (String) null, 512, (Object) null).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "collectionsApi.getCollec…estaurantList()\n        }");
        return map;
    }

    @NotNull
    @VisibleForTesting
    public final String getDeviceEntryPoint(boolean z11) {
        return z11 ? "home" : "shop_list";
    }

    @NotNull
    public Single<VendorTagsResponse> getVendorTagsForCollection(int i11) {
        return this.collectionsApi.getCollectionVendorTags(i11, this.lat, this.lon);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionsDataSourceImplementation(CollectionsApi collectionsApi2, String str, String str2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsApiFactory.INSTANCE.getCollectionsApi() : collectionsApi2, str, str2, (i11 & 8) != 0 ? false : z11);
    }
}
