package com.talabat.collectiondetails.data;

import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/collectiondetails/data/CollectionsDataSource;", "", "applyFilteringAndSorting", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "collectionId", "", "cuisineIds", "filterIds", "sorting", "", "getAllVendorsForCollection", "getVendorTagsForCollection", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CollectionsDataSource {
    @NotNull
    Single<List<Restaurant>> applyFilteringAndSorting(int i11, @Nullable List<Integer> list, @Nullable List<Integer> list2, @Nullable String str);

    @NotNull
    Single<List<Restaurant>> getAllVendorsForCollection(int i11);

    @NotNull
    Single<VendorTagsResponse> getVendorTagsForCollection(int i11);
}
