package com.talabat;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/HomeScreenMap$getPlaceSelectionListener$1", "Lcom/google/android/libraries/places/widget/listener/PlaceSelectionListener;", "onError", "", "status", "Lcom/google/android/gms/common/api/Status;", "onPlaceSelected", "place", "Lcom/google/android/libraries/places/api/model/Place;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap$getPlaceSelectionListener$1 implements PlaceSelectionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f54206b;

    public HomeScreenMap$getPlaceSelectionListener$1(HomeScreenMap homeScreenMap) {
        this.f54206b = homeScreenMap;
    }

    public void onError(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
    }

    public void onPlaceSelected(@NotNull Place place) {
        Intrinsics.checkNotNullParameter(place, "place");
        this.f54206b.googleAutoCompleteWidget(place);
    }
}
