package com.talabat.flutter.groceryhome.domain.repository;

import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import datamodels.Restaurant;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/talabat/flutter/groceryhome/domain/repository/GroceryHomeVendorRepository;", "", "getClosestDarkstoreInfo", "Lio/reactivex/Single;", "Ldatamodels/Restaurant;", "location", "Lcom/talabat/flutter/groceryhome/domain/model/UserLocation;", "getMigratedVendorInfo", "branchId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryHomeVendorRepository {
    @NotNull
    Single<Restaurant> getClosestDarkstoreInfo(@NotNull UserLocation userLocation);

    @NotNull
    Single<Restaurant> getMigratedVendorInfo(@NotNull String str, @NotNull UserLocation userLocation);
}
