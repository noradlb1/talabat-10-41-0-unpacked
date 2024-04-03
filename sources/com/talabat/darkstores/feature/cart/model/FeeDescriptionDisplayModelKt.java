package com.talabat.darkstores.feature.cart.model;

import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isValidForDisplay", "", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FeeDescriptionDisplayModelKt {
    public static final boolean isValidForDisplay(@Nullable FeeDescription feeDescription) {
        boolean z11;
        boolean z12;
        if (feeDescription == null) {
            return false;
        }
        String name2 = feeDescription.getName();
        if (name2 == null || StringsKt__StringsJVMKt.isBlank(name2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        String description = feeDescription.getDescription();
        if (description == null || StringsKt__StringsJVMKt.isBlank(description)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return true;
        }
        return false;
    }
}
