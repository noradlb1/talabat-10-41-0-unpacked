package com.talabat.restaurants.v2.ui.viewmodels;

import datamodels.Restaurant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J%\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/VendorListGaWrapper;", "", "vendorList", "", "Ldatamodels/Restaurant;", "swimlaneGa", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/List;Ljava/util/HashMap;)V", "getSwimlaneGa", "()Ljava/util/HashMap;", "getVendorList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListGaWrapper {
    @NotNull
    private final HashMap<String, String> swimlaneGa;
    @NotNull
    private final List<Restaurant> vendorList;

    public VendorListGaWrapper(@NotNull List<? extends Restaurant> list, @NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(list, "vendorList");
        Intrinsics.checkNotNullParameter(hashMap, "swimlaneGa");
        this.vendorList = list;
        this.swimlaneGa = hashMap;
    }

    public static /* synthetic */ VendorListGaWrapper copy$default(VendorListGaWrapper vendorListGaWrapper, List<Restaurant> list, HashMap<String, String> hashMap, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = vendorListGaWrapper.vendorList;
        }
        if ((i11 & 2) != 0) {
            hashMap = vendorListGaWrapper.swimlaneGa;
        }
        return vendorListGaWrapper.copy(list, hashMap);
    }

    @NotNull
    public final List<Restaurant> component1() {
        return this.vendorList;
    }

    @NotNull
    public final HashMap<String, String> component2() {
        return this.swimlaneGa;
    }

    @NotNull
    public final VendorListGaWrapper copy(@NotNull List<? extends Restaurant> list, @NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(list, "vendorList");
        Intrinsics.checkNotNullParameter(hashMap, "swimlaneGa");
        return new VendorListGaWrapper(list, hashMap);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorListGaWrapper)) {
            return false;
        }
        VendorListGaWrapper vendorListGaWrapper = (VendorListGaWrapper) obj;
        return Intrinsics.areEqual((Object) this.vendorList, (Object) vendorListGaWrapper.vendorList) && Intrinsics.areEqual((Object) this.swimlaneGa, (Object) vendorListGaWrapper.swimlaneGa);
    }

    @NotNull
    public final HashMap<String, String> getSwimlaneGa() {
        return this.swimlaneGa;
    }

    @NotNull
    public final List<Restaurant> getVendorList() {
        return this.vendorList;
    }

    public int hashCode() {
        return (this.vendorList.hashCode() * 31) + this.swimlaneGa.hashCode();
    }

    @NotNull
    public String toString() {
        List<Restaurant> list = this.vendorList;
        HashMap<String, String> hashMap = this.swimlaneGa;
        return "VendorListGaWrapper(vendorList=" + list + ", swimlaneGa=" + hashMap + ")";
    }
}
