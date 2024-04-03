package library.talabat.mvp.homemap.domain.impl;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.domain.address.Address;
import java.util.ArrayList;
import k10.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.address.DistanceSortedAddress;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.homemap.domain.AddressSortHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Llibrary/talabat/mvp/homemap/domain/impl/AddressSortHelperImpl;", "Llibrary/talabat/mvp/homemap/domain/AddressSortHelper;", "homeMapUtils", "Llibrary/talabat/mvp/homemap/HomeMapUtils;", "(Llibrary/talabat/mvp/homemap/HomeMapUtils;)V", "getFirstAddressSortedWithLocationOrNull", "Lcom/talabat/domain/address/Address;", "latLng", "Lkotlin/Pair;", "", "customerAddresses", "Ljava/util/ArrayList;", "sortDistance", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl implements AddressSortHelper {
    /* access modifiers changed from: private */
    @NotNull
    public final HomeMapUtils homeMapUtils;

    public AddressSortHelperImpl() {
        this((HomeMapUtils) null, 1, (DefaultConstructorMarker) null);
    }

    public AddressSortHelperImpl(@NotNull HomeMapUtils homeMapUtils2) {
        Intrinsics.checkNotNullParameter(homeMapUtils2, "homeMapUtils");
        this.homeMapUtils = homeMapUtils2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getFirstAddressSortedWithLocationOrNull$lambda-0  reason: not valid java name */
    public static final int m7895getFirstAddressSortedWithLocationOrNull$lambda0(DistanceSortedAddress distanceSortedAddress, DistanceSortedAddress distanceSortedAddress2) {
        return Double.compare(distanceSortedAddress.distance, distanceSortedAddress2.distance);
    }

    @Nullable
    public Address getFirstAddressSortedWithLocationOrNull(@NotNull Pair<Double, Double> pair, @NotNull ArrayList<Address> arrayList, int i11) {
        Intrinsics.checkNotNullParameter(pair, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(arrayList, "customerAddresses");
        return (Address) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(arrayList), AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$1.INSTANCE), new AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$2(this, pair)), new AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$3(i11)), AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$4.INSTANCE), new a()), AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$6.INSTANCE));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressSortHelperImpl(HomeMapUtils homeMapUtils2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? HomeMapUtils.INSTANCE : homeMapUtils2);
    }
}
