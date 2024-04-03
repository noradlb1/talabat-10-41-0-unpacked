package com.talabat.talabatlife.ui.vendorList.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "", "()V", "areas", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "getAreas", "()Ljava/util/List;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorAreasDisplayModel {
    @NotNull
    private final List<VendorLocationFilterDisplayModel> areas = new ArrayList();

    @NotNull
    public final List<VendorLocationFilterDisplayModel> getAreas() {
        return this.areas;
    }
}
