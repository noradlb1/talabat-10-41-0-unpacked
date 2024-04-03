package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSwimLaneUseCase;
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
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0018H\u0016J8\u0010\u001a\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackSwimLaneUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSwimLaneUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackedItems", "", "", "userId", "", "getLocationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "isNewTracking", "", "itemImpressionIndexes", "", "onSwimLaneClicked", "", "params", "", "onSwimLaneLoaded", "onSwimLaneSwiped", "items", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "resetTracking", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackSwimLaneUseCaseImpl implements TrackSwimLaneUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final Set<Integer> trackedItems;
    @Nullable
    private final String userId;

    public TrackSwimLaneUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        String str;
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
        CustomerInfo customerInfo = ((Customer) function0.invoke()).getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        this.userId = str;
        this.trackedItems = new LinkedHashSet();
    }

    private final LocationDataFactory.LocationData getLocationData() {
        return this.locationDataFactory.createLocationData(this.customerProvider.invoke().getSelectedCustomerAddress());
    }

    private final boolean isNewTracking(List<Integer> list) {
        return list.size() == 2;
    }

    public void onSwimLaneClicked(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.homeScreenTracker.trackSwimLaneItemClicked(this.userId, getLocationData(), map);
    }

    public void onSwimLaneLoaded(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.homeScreenTracker.trackSwimLaneLoaded(this.userId, getLocationData(), map);
    }

    public void onSwimLaneSwiped(@NotNull List<Integer> list, @NotNull Map<String, String> map, @NotNull List<? extends Cell> list2) {
        List list3;
        Intrinsics.checkNotNullParameter(list, "itemImpressionIndexes");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(list2, FirebaseAnalytics.Param.ITEMS);
        if (isNewTracking(list)) {
            IntRange intRange = new IntRange(list.get(0).intValue(), list.get(1).intValue());
            ArrayList<Number> arrayList = new ArrayList<>();
            for (Object next : intRange) {
                if (!this.trackedItems.contains(Integer.valueOf(((Number) next).intValue()))) {
                    arrayList.add(next);
                }
            }
            for (Number intValue : arrayList) {
                int intValue2 = intValue.intValue();
                Map mutableMap = MapsKt__MapsKt.toMutableMap(map);
                Map<String, Object> metadata = ((Cell) list2.get(intValue2)).getData().getMetadata();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(metadata.size()));
                for (Map.Entry entry : metadata.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue().toString());
                }
                mutableMap.putAll(linkedHashMap);
                this.homeScreenTracker.trackSwimLaneSwiped(getLocationData(), mutableMap);
                this.trackedItems.add(Integer.valueOf(intValue2));
            }
            return;
        }
        Map mutableMap2 = MapsKt__MapsKt.toMutableMap(map);
        String str = map.get("shopsIds");
        if (str == null || (list3 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        if (list.get(0).intValue() < list3.size()) {
            mutableMap2.put("shopsIds", list3.subList(0, list.get(0).intValue()).toString());
        }
        this.homeScreenTracker.trackSwimLaneSwiped(this.userId, getLocationData(), Util.toImmutableMap(mutableMap2));
    }

    public void resetTracking() {
        this.trackedItems.clear();
    }
}
