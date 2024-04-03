package com.talabat.flutter.groceryhome.data.repository;

import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.MenuItemResponse;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import com.talabat.flutter.groceryhome.domain.repository.GroceryHomeVendorRepository;
import com.talabat.helpers.AppUrls;
import datamodels.Restaurant;
import gq.a;
import gq.b;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;
import service.ApiHandler;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/flutter/groceryhome/data/repository/GroceryHomeVendorRepositoryImpl;", "Lcom/talabat/flutter/groceryhome/domain/repository/GroceryHomeVendorRepository;", "apiHandler", "Lservice/ApiHandler;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lservice/ApiHandler;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "getClosestDarkstoreInfo", "Lio/reactivex/Single;", "Ldatamodels/Restaurant;", "location", "Lcom/talabat/flutter/groceryhome/domain/model/UserLocation;", "getMigratedVendorInfo", "branchId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeVendorRepositoryImpl implements GroceryHomeVendorRepository {
    @NotNull
    private final ApiHandler apiHandler;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public GroceryHomeVendorRepositoryImpl(@NotNull ApiHandler apiHandler2, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(apiHandler2, "apiHandler");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.apiHandler = apiHandler2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getClosestDarkstoreInfo$lambda-0  reason: not valid java name */
    public static final Restaurant m10469getClosestDarkstoreInfo$lambda0(DarkStoresEntryPointResponse darkStoresEntryPointResponse) {
        Intrinsics.checkNotNullParameter(darkStoresEntryPointResponse, "response");
        Restaurant result = darkStoresEntryPointResponse.getResult();
        Intrinsics.checkNotNull(result);
        return result;
    }

    /* access modifiers changed from: private */
    /* renamed from: getMigratedVendorInfo$lambda-1  reason: not valid java name */
    public static final Restaurant m10470getMigratedVendorInfo$lambda1(MenuItemResponse menuItemResponse) {
        Intrinsics.checkNotNullParameter(menuItemResponse, "response");
        return menuItemResponse.result.restaurant;
    }

    @NotNull
    public Single<Restaurant> getClosestDarkstoreInfo(@NotNull UserLocation userLocation) {
        Intrinsics.checkNotNullParameter(userLocation, "location");
        Single<R> subscribeOn = this.apiHandler.getServices().getDarkStoresInfo(CreateApiUrl.createWithParameters(AppUrls.DARKSTORES_URL, new String[]{"{areaId}", userLocation.getAreaId(), "{latitude}", userLocation.getLatitude(), "{longitude}", userLocation.getLongitude()})).firstOrError().map(new b()).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "apiHandler.services\n    …rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public Single<Restaurant> getMigratedVendorInfo(@NotNull String str, @NotNull UserLocation userLocation) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(userLocation, "location");
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel(userLocation.getAreaId(), userLocation.getLatitude(), userLocation.getLongitude(), userLocation.getCountryId());
        String str2 = AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION;
        Intrinsics.checkNotNullExpressionValue(str2, "SPLIT_RESTAURANT_INFO_WITH_LOCATION");
        Single<R> subscribeOn = this.apiHandler.getServices().getRestaurantInfoWithLocation(StringsKt__StringsJVMKt.replace$default(str2, "{branchId}", str, false, 4, (Object) null), restaurantInfoRequestModel).firstOrError().map(new a()).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "apiHandler.services\n    …rxSchedulersFactory.io())");
        return subscribeOn;
    }
}
