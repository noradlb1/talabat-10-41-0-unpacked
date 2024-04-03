package com.talabat.darkstores.data.tracking.bottomsheet.tracker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoresBottomSheetName;", "", "bottomSheetName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getBottomSheetName", "()Ljava/lang/String;", "DELIVERY_FEE_TIERS", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DarkStoresBottomSheetName {
    DELIVERY_FEE_TIERS("delivery fee tiers");
    
    @NotNull
    private final String bottomSheetName;

    private DarkStoresBottomSheetName(String str) {
        this.bottomSheetName = str;
    }

    @NotNull
    public final String getBottomSheetName() {
        return this.bottomSheetName;
    }
}
