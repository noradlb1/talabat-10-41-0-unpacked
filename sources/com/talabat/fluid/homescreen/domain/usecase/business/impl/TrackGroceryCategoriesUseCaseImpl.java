package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackGroceryCategoriesUseCase;
import com.talabat.fluid.homescreen.presentation.displaymodel.Component;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import datamodels.CustomerInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\u001c\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001dH\u0016J\u001c\u0010\u001f\u001a\u00020\u00162\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001dH\u0016J\u001e\u0010 \u001a\u0004\u0018\u00010!*\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\"0\u001dj\u0002`#H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackGroceryCategoriesUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "getLocationData", "()Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "trackedItems", "", "", "userId", "", "getUserId", "()Ljava/lang/String;", "onCategoriesSwiped", "", "itemImpressionIndexes", "", "items", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "trackCategoriesTitleClicked", "params", "", "trackCategoriesViewStoreClicked", "trackCategoryItemClicked", "getComponentOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackGroceryCategoriesUseCaseImpl implements TrackGroceryCategoriesUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final Set<Integer> trackedItems = new LinkedHashSet();

    public TrackGroceryCategoriesUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    private final Component getComponentOrNull(Map<String, ? extends Object> map) {
        Component.Companion companion = Component.Companion;
        Object obj = map.get(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        return companion.from(str);
    }

    private final LocationDataFactory.LocationData getLocationData() {
        return this.locationDataFactory.createLocationData(this.customerProvider.invoke().getSelectedCustomerAddress());
    }

    private final String getUserId() {
        CustomerInfo customerInfo = this.customerProvider.invoke().getCustomerInfo();
        if (customerInfo != null) {
            return customerInfo.encgid;
        }
        return null;
    }

    public void onCategoriesSwiped(@NotNull List<Integer> list, @NotNull List<? extends Cell> list2) {
        Intrinsics.checkNotNullParameter(list, "itemImpressionIndexes");
        Intrinsics.checkNotNullParameter(list2, FirebaseAnalytics.Param.ITEMS);
        IntRange intRange = new IntRange(list.get(0).intValue(), list.get(1).intValue());
        ArrayList<Number> arrayList = new ArrayList<>();
        for (Object next : intRange) {
            if (!this.trackedItems.contains(Integer.valueOf(((Number) next).intValue()))) {
                arrayList.add(next);
            }
        }
        for (Number intValue : arrayList) {
            int intValue2 = intValue.intValue();
            Map<String, Object> metadata = ((Cell) list2.get(intValue2)).getData().getMetadata();
            if (getComponentOrNull(metadata) == Component.GROCERY_WIDGET_CATEGORY_ITEM) {
                HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
                String userId = getUserId();
                LocationDataFactory.LocationData locationData = getLocationData();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(metadata.size()));
                for (Map.Entry entry : metadata.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue().toString());
                }
                homeScreenTracker2.trackGroceryCategoriesSwiped(userId, locationData, linkedHashMap);
            }
            this.trackedItems.add(Integer.valueOf(intValue2));
        }
    }

    public void trackCategoriesTitleClicked(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.homeScreenTracker.trackShopClicked(getUserId(), getLocationData(), MapsKt__MapsKt.toMutableMap(map));
    }

    public void trackCategoriesViewStoreClicked(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.homeScreenTracker.trackShopClicked(getUserId(), getLocationData(), map);
    }

    public void trackCategoryItemClicked(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.homeScreenTracker.trackGroceryCategoryClicked(getUserId(), getLocationData(), map);
    }
}
