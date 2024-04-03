package com.talabat.userandlocation;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0005"}, d2 = {"toGoogle", "Lcom/google/android/gms/maps/model/LatLng;", "Lcom/talabat/maps/domain/model/LatLng;", "", "toGoogleNullable", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LatLngRefactorHelperKt {
    @NotNull
    public static final LatLng toGoogle(@NotNull com.talabat.maps.domain.model.LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "<this>");
        return new LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    @Nullable
    public static final LatLng toGoogleNullable(@Nullable com.talabat.maps.domain.model.LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    @NotNull
    public static final List<LatLng> toGoogle(@NotNull List<? extends com.talabat.maps.domain.model.LatLng> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<com.talabat.maps.domain.model.LatLng> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (com.talabat.maps.domain.model.LatLng latLng : iterable) {
            arrayList.add(new LatLng(latLng.getLatitude(), latLng.getLongitude()));
        }
        return arrayList;
    }
}
