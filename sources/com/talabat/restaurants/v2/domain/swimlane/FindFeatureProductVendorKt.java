package com.talabat.restaurants.v2.domain.swimlane;

import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"findNotClosedVendor", "Ldatamodels/Restaurant;", "vendorId", "", "sortedVendors", "", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FindFeatureProductVendorKt {
    @Nullable
    public static final Restaurant findNotClosedVendor(int i11, @NotNull List<? extends Restaurant> list) {
        Object obj;
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "sortedVendors");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z12 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Restaurant) next).statusType == 1) {
                z12 = true;
            }
            if (!z12) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((Restaurant) obj).branchId == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (Restaurant) obj;
    }
}
