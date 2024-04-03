package k10;

import java.util.Comparator;
import library.talabat.mvp.address.DistanceSortedAddress;
import library.talabat.mvp.homemap.domain.impl.AddressSortHelperImpl;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return AddressSortHelperImpl.m7895getFirstAddressSortedWithLocationOrNull$lambda0((DistanceSortedAddress) obj, (DistanceSortedAddress) obj2);
    }
}
